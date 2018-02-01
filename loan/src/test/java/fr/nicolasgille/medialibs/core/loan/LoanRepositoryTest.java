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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LoanRepository loanRepository;

    private final Calendar startDate = new GregorianCalendar(2018, Calendar.JANUARY, 31);
    private final Calendar endDate = new GregorianCalendar(2018, Calendar.FEBRUARY, 02);
    private final int mediaId = 42;
    private final int borrowerId = 24;
    private Loan loan;

    @Before
    public void setUp() {
        this.loan = new Loan();
        this.loan.setStartLoanDate(startDate);
        this.loan.setEndLoanDate(endDate);
        this.loan.setMediaId(mediaId);
        this.loan.setBorrowerId(borrowerId);

        entityManager.persist(loan);
    }

    @After
    public void tearDown() {
        entityManager.remove(loan);
    }

    @Test
    public void whenFindByBorrowerAndMediaIds_thenReturnLoan() {
        // When
        Loan find = this.loanRepository.findByBorrowerIdAndMediaId(borrowerId, mediaId);

        // Then
        assertThat(find.getId()).isEqualTo(1L);
        assertThat(find.getStartLoanDate()).isEqualTo(startDate);
        assertThat(find.getEndLoanDate()).isEqualTo(endDate);
        assertThat(find.getMediaId()).isEqualTo(mediaId);
        assertThat(find.getBorrowerId()).isEqualTo(borrowerId);
    }

    @Test
    public void whenFindByTitle_thenReturnNull() {
        // When
        Loan find = this.loanRepository.findByBorrowerIdAndMediaId(borrowerId + 1, mediaId);

        // Then
        assertThat(find).isNull();
    }
}