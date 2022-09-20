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

package io.github.monun.tap.event

import org.bukkit.event.EventPriority
import org.bukkit.plugin.EventExecutor

class HandlerStatement(
    val eventClass: Class<*>,
    val registrationClass: Class<*>,
    val provider: EventEntityProvider,
    val priority: EventPriority,
    val isIgnoreCancelled: Boolean,
    val executor: EventExecutor
)