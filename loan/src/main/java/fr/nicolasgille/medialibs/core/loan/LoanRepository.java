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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 *
 * @since MediaLibs Core 1.0
 * @version 1.1.1
 */
@Repository
@Transactional
public interface LoanRepository extends JpaRepository<Loan, Long> {

    /**
     * Return advertiser by borrower and media id.
     *
     * @param borrowerId
     *  Borrower identifier.
     * @param mediaId
     *  Media identifier.
     * @return
     *  The advertiser corresponding to the media and the borrower.
     * @since 1.1
     */
    Loan findByBorrowerIdAndMediaId(long borrowerId, long mediaId);
}
