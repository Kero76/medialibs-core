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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @since Medialibs Core 1.0
 * @version 1.0
 */
@Entity
public class Media {

    /**
     * Unique identifier of the media in persistent system.
     *
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the media.
     *
     * @since 1.0
     */
    private String name;

    /**
     * Description of the media.
     *
     * @since 1.0
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * Release date of the media.
     *
     * @since 1.0
     */
    @Temporal(TemporalType.DATE)
    private Calendar releaseDate;

    /**
     * The editor of the media (it the same thing for the label records in music)
     *
     * @since 1.0
     */
    private String editor;

    /**
     * Support for the media.
     *
     * @since 1.0
     */
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = MediaSupport.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MediaSupport> supports;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<MediaSupport> getSupports() {
        return supports;
    }

    public void setSupports(List<MediaSupport> supports) {
        this.supports = supports;
    }
}
