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

package fr.nicolasgille.medialibs.core.loan;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @since MediaLibs Core 1.0
 * @version 1.0
 */
@Entity
public class Loan {

    /**
     * Unique identifier of the advertiser object.
     *
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Identifier of the borrower.
     *
     * In fact, the borrower is must be register
     * on the medialibs to advertiser object.
     * Then we get the id to link advertiser and user.
     *
     * @since 1.0
     */
    @Column(name = "borrower_id")
    private long borrowerId;

    /**
     * Identifier of the media.
     *
     * In fact, to advertiser a media, this media will previously
     * add on medialibs system.
     * Then, we get the media id to link advertiser and media.
     *
     * @since 1.0
     */
    @Column(name = "media_id")
    private long mediaId;

    /**
     * The start of the advertiser.
     *
     * @since 1.0
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar startLoanDate;

    /**
     * The end of the advertiser.
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar endLoanDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public Calendar getStartLoanDate() {
        return startLoanDate;
    }

    public void setStartLoanDate(Calendar startLoanDate) {
        this.startLoanDate = startLoanDate;
    }

    public Calendar getEndLoanDate() {
        return endLoanDate;
    }

    public void setEndLoanDate(Calendar endLoanDate) {
        this.endLoanDate = endLoanDate;
    }
}
