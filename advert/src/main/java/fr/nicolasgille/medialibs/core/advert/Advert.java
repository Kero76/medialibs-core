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

import javax.persistence.*;
import java.util.Calendar;

/**
 * @since MediaLibs Core 1.0
 * @version 1.0
 */
@Entity
public class Advert {

    /**
     * Unique identifier of the advert object.
     *
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Identifier of the advert.
     *
     * The advert must be link to an user.
     *
     * @since 1.0
     */
    @Column(name = "advertiser_id")
    private long advertiserId;

    /**
     * The title of the advert.
     *
     * @since 1.0
     */
    private String title;

    /**
     * The end of the advert.
     *
     * @since 1.0
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * The date of the advert.
     *
     * @since 1.0
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar advertDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getAdvertDate() {
        return advertDate;
    }

    public void setAdvertDate(Calendar advertDate) {
        this.advertDate = advertDate;
    }
}
