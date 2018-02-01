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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StockRepository stockRepository;

    private final int initialStock = 12;
    private final int currentStock = 7;
    private final int mediaId = 42;
    private Stock stock;

    @Before
    public void setUp() {
        this.stock = new Stock();
        this.stock.setInitialStock(initialStock);
        this.stock.setCurrentStock(currentStock);
        this.stock.setMediaId(mediaId);

        entityManager.persist(stock);
    }

    @After
    public void tearDown() {
        entityManager.remove(this.stock);
    }

    @Test
    public void whenFindByMediaId_thenReturnLoan() {
        // When
        Stock find = this.stockRepository.findByMediaId(mediaId);

        // Then
        assertThat(find.getId()).isEqualTo(1L);
        assertThat(find.getInitialStock()).isEqualTo(initialStock);
        assertThat(find.getCurrentStock()).isEqualTo(currentStock);
        assertThat(find.getMediaId()).isEqualTo(mediaId);
    }

    @Test
    public void whenFindByMediaId_thenReturnNull() {
        // When
        Stock find = this.stockRepository.findByMediaId(mediaId + 1);

        // Then
        assertThat(find).isNull();
    }
}