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

package fr.nicolasgille.medialibs.core.stock;

import javax.persistence.*;

/**
 * @since MediaLibs Core 1.0
 * @version 1.0
 */
@Entity
public class Stock {

    /**
     * The unique identifier of the stock
     * to link media thanks to the id and
     * the stock.present on system.
     *
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The identifier of the media.
     * It stored only the identifier of the media
     * to avoid strong link between each lib of the project.
     *
     * @since 1.0
     */
    @Column(name = "media_id")
    private long mediaId;

    /**
     * The initial stock of the media.
     * It will be used to check the total stock,
     * and avoid people would "steal" media ;)
     *
     * @since 1.0
     */
    @Column(name = "initial_stock")
    private int initialStock;

    /**
     * The current stock for the specific media
     *
     * @since 1.0
     */
    @Column(name = "current_stock")
    private int currentStock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}
