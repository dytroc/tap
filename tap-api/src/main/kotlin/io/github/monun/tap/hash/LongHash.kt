/*
 * Copyright (C) 2022 Monun
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.monun.tap.hash


infix fun Int.pair(least: Int): Long {
    return (toLong() and 0xFFFFFFFFL) or ((least.toLong() and 0xFFFFFFFFL) shl 32)
}

fun Long.mostInt() = (this ushr 32 and 0xFFFFFFFFL).toInt()

fun Long.leastInt() = (this and 0xFFFFFFFFL).toInt()