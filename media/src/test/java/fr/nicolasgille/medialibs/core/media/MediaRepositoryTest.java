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

package fr.nicolasgille.medialibs.core.media;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MediaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MediaRepository mediaRepository;

    private final String name = "JEE Project 2018 - The VideoGame";
    private final String description = "";
    private final MediaSupport[] supports = {MediaSupport.ROM_CARTRIDGE, MediaSupport.DIGITAL};
    private final Calendar releaseDate = new GregorianCalendar(2018, Calendar.JANUARY, 31);
    private Media media;

    @Before
    public void setUp() {
        this.media = new Media();
        this.media.setName(name);
        this.media.setDescription(description);
        this.media.setReleaseDate(releaseDate);
        this.media.setSupports(Arrays.asList(supports));

        entityManager.persist(media);
    }

    @After
    public void tearDown() {
        entityManager.remove(media);
    }

    @Test
    public void whenFindByBorrowerAndMediaIds_thenReturnLoan() {
        // When
        Media find = this.mediaRepository.findByNameAndReleaseDate(name, releaseDate);

        // Then
        assertThat(find.getId()).isEqualTo(1L);
        assertThat(find.getName()).isEqualTo(name);
        assertThat(find.getDescription()).isEqualTo(description);
        assertThat(find.getReleaseDate()).isEqualTo(releaseDate);
        assertThat(find.getSupports()).size().isEqualTo(2);
        assertThat(find.getSupports().get(0)).isSameAs(MediaSupport.ROM_CARTRIDGE);
        assertThat(find.getSupports().get(1)).isSameAs(MediaSupport.DIGITAL);
    }

    @Test
    public void whenFindByTitle_thenReturnNull() {
        // When
        Media find = this.mediaRepository.findByNameAndReleaseDate("My name is Bond, James Bond", releaseDate);

        // Then
        assertThat(find).isNull();
    }
}