/*
 * MediaLibs Core.
 * Copyright (C) 2018 Nicolas GILLE
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.nicolasgille.medialibs.core.advert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdvertRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdvertRepository advertRepository;

    private final String content =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris congue eleifend purus, " +
            "non pretium justo cursus eget. Duis ut tincidunt nisi, et commodo libero. Cras leo massa, viverra at " +
            "imperdiet sit amet, gravida at magna. Nunc vel risus a lectus laoreet feugiat vel sed massa. " +
            "Nunc efficitur urna nec aliquet molestie. Nam convallis turpis ut turpis vehicula semper. " +
            "Mauris nec ornare augue. Etiam ut nisl at est aliquam pretium non et justo. Sed id euismod erat. " +
            "Integer non augue quis ex imperdiet sollicitudin ullamcorper a quam.";
    private final String title = "Title";
    private Advert advert;

    @Before
    public void setUp() {
        advert = new Advert();
        advert.setTitle(title);
        advert.setContent(content);
        advert.setAdvertDate(new GregorianCalendar());

        entityManager.persist(advert);
    }

    @After
    public void tearDown() {
        entityManager.remove(advert);
    }

    @Test
    public void whenFindByEmail_thenGetAdvert() {
        // When
        Advert find = this.advertRepository.findByTitle(title);

        // Then
        assertThat(find.getId()).isEqualTo(1L);
        assertThat(find.getTitle()).isEqualTo(title);
        assertThat(find.getContent()).isEqualTo(content);
    }

    @Test
    public void whenFindByEmail_thenGetNullAlert() {
        // When
        Advert find = this.advertRepository.findByTitle("My Title");

        // Then
        assertThat(find).isNull();
    }
}