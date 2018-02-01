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

package fr.nicolasgille.medialibs.core.user;

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
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private final String email = "nic.gille@gmail.com";
    private final String password = "My so strong and sexy password <3";
    private final Role role = Role.SUPERVISOR_ROLE;
    private User user;

    @Before
    public void setUp() {
        this.user = new User();
        this.user.setEmail(email);
        this.user.setPassword(password);
        this.user.setRole(role);

        entityManager.persist(user);
    }

    @After
    public void tearDown() {
        entityManager.remove(user);
    }

    @Test
    public void whenFindByEmail_thenReturnUser() {
        // When
        User find = this.userRepository.findByEmail(email);

        // Then
        assertThat(find.getId()).isEqualTo(2L);
        assertThat(find.getEmail()).isEqualTo(email);
        assertThat(find.getPassword()).isEqualTo(password);
        assertThat(find.getRole()).isInstanceOf(Role.class);
        assertThat(find.getRole()).isSameAs(Role.SUPERVISOR_ROLE);
    }

    @Test
    public void whenFindByEmail_thenReturnNull() {
        // When
        User find = this.userRepository.findByEmail("");

        // Then
        assertThat(find).isNull();
    }

}