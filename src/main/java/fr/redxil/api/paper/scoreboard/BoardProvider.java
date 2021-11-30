/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.scoreboard;

import java.util.List;

public interface BoardProvider {

    List<BoardLine> lines();

    String getTitle();

    default long titleRefreshInterval() {
        return -1L;
    }
}
