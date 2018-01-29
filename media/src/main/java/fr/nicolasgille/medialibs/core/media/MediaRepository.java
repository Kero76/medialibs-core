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

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Calendar;

/**
 *
 * @since Medialibs Core 1.0
 * @version 1.1
 */
@Transactional
public interface MediaRepository extends JpaRepository<Media, Long> {

    /**
     * Find the media by name and release date.
     *
     * @param name
     *  Name of the media.
     * @param releaseDate
     *  Release date of the media.
     * @return
     *  The instance of media.
     * @since 1.1
     */
    Media findByNameAndReleaseDate(String name, Calendar releaseDate);
}
