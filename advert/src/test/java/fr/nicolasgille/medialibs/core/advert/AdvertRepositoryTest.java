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
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class AdvertRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdvertRepository advertRepository;

    @Test
    public void givenAlert_whenInsert_thenGetAlertInsertPreviously() {
        // Given
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris congue eleifend purus, " +
                "non pretium justo cursus eget. Duis ut tincidunt nisi, et commodo libero. Cras leo massa, viverra at " +
                "imperdiet sit amet, gravida at magna. Nunc vel risus a lectus laoreet feugiat vel sed massa. " +
                "Nunc efficitur urna nec aliquet molestie. Nam convallis turpis ut turpis vehicula semper. " +
                "Mauris nec ornare augue. Etiam ut nisl at est aliquam pretium non et justo. Sed id euismod erat. " +
                "Integer non augue quis ex imperdiet sollicitudin ullamcorper a quam.";
        Calendar now = new GregorianCalendar();

        Advert advert = new Advert();
        advert.setTitle("Alert");
        advert.setContent(content);
        advert.setAdvertDate(now);

        // When
        Advert save = advertRepository.save(advert);

        // Then
        assertThat(save.getId()).isEqualTo(1L);
        assertThat(save.getTitle()).isEqualTo("Alert");
        assertThat(save.getContent()).isEqualTo(content);
        assertThat(save.getAdvertDate()).isEqualTo(now);
    }

    @Test
    public void givenAlert_whenFinbByEmail_thenGetAlertWithSpecificTitle() {
        // Given
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris congue eleifend purus, " +
                "non pretium justo cursus eget. Duis ut tincidunt nisi, et commodo libero. Cras leo massa, viverra at " +
                "imperdiet sit amet, gravida at magna. Nunc vel risus a lectus laoreet feugiat vel sed massa. " +
                "Nunc efficitur urna nec aliquet molestie. Nam convallis turpis ut turpis vehicula semper. " +
                "Mauris nec ornare augue. Etiam ut nisl at est aliquam pretium non et justo. Sed id euismod erat. " +
                "Integer non augue quis ex imperdiet sollicitudin ullamcorper a quam.";
        String title = "Title";

        Advert advert = new Advert();
        advert.setTitle(title);
        advert.setContent(content);
        advert.setAdvertDate(new GregorianCalendar());
        Advert save = advertRepository.save(advert);

        // When
        Advert find = this.advertRepository.findByTitle(title);

        // Then
        assertThat(find.getTitle()).isEqualTo(title);
    }

    @Test
    public void givenAlert_whenFinbByEmail_thenGetNullAlert() {
        // Given
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris congue eleifend purus, " +
                "non pretium justo cursus eget. Duis ut tincidunt nisi, et commodo libero. Cras leo massa, viverra at " +
                "imperdiet sit amet, gravida at magna. Nunc vel risus a lectus laoreet feugiat vel sed massa. " +
                "Nunc efficitur urna nec aliquet molestie. Nam convallis turpis ut turpis vehicula semper. " +
                "Mauris nec ornare augue. Etiam ut nisl at est aliquam pretium non et justo. Sed id euismod erat. " +
                "Integer non augue quis ex imperdiet sollicitudin ullamcorper a quam.";
        String title = "Title";

        Advert advert = new Advert();
        advert.setTitle(title);
        advert.setContent(content);
        advert.setAdvertDate(new GregorianCalendar());
        Advert save = advertRepository.save(advert);

        // When
        Advert find = this.advertRepository.findByTitle("My Title");

        // Then
        assertThat(find).isNull();
    }
}