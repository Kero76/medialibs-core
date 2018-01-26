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

/**
 * An enumeration who contains all potential media support available on Medialibs.
 *
 * @since Medialibs Core 1.0
 * @version 1.0
 */
public enum MediaSupport {
    // Video support
    VIDEO_TAPE("Video Tape"),
    DVD("DVD"),
    BLU_RAY("Blu Ray"),

    // Book support
    PAPER("Paper"),

    // Music support
    AUDIO_TAPE("Audio Tape"),
    VYNIL("Vynil"),
    CD("CD"),

    // Game support
    ROM_CARTRIDGE("ROM Cartridge"),
    PHYSICAL("Physical"),

    // For all media
    DIGITAL("Digital");


    private String name;

    MediaSupport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
