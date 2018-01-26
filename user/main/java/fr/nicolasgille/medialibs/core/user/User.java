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

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @since MediaLibs Core 1.07
 * @version 1.0
 */
@Entity
public class User {

    /**
     * Unique identifier of the users.
     *
     * @since 1.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Email of the user when it register on MediaLibs app.
     * It must be unique on the same instance of Medialibs.
     *
     * @since 1.0
     */
    @Email
    @Column(name = "email", unique = true)
    private String email;

    /**
     * The encoded password of the user when it register
     * and connect on Medialibs app.
     * The password size is must be between 12 and 255 characters.
     *
     * @since 1.0
     */
    @Size(min = 12, max = 255)
    private String password;

    /**
     * The role of the user, it will be change only by the supervisor users.
     *
     * @see fr.nicolasgille.medialibs.core.user.Role
     * @since 1.0
     */
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
