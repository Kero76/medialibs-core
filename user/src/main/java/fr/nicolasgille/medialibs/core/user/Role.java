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

/**
 * The definition of the roles are the following :
 *  - GUEST_ROLE : It can be only loan media on Medialibs.
 *  - ADMIN_ROLE : It can be loan media, manage stocks and medias on MediaLibs.
 *  - SUPERVISOR_ROLE : It can be loan media, manage stocks, medias and users on MediaLibs.
 *
 * @since MediaLibs Core 1.0
 * @since 1.0
 */
public enum Role {
    GUEST_ROLE,
    ADMIN_ROLE,
    SUPERVISOR_ROLE;
}
