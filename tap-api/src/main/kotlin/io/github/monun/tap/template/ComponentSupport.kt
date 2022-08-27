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

package io.github.monun.tap.template

import net.kyori.adventure.text.BuildableComponent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentBuilder
import net.kyori.adventure.text.TextComponent
import org.bukkit.configuration.ConfigurationSection

fun <T : ComponentBuilder<*, *>> T.renderTemplates(config: ConfigurationSection): T {
    applyDeep {
        if (it is TextComponent.Builder)
            it.content(it.content().renderTemplates(config))
    }

    return this
}

@Suppress("UNCHECKED_CAST")
fun <T : Component> T.renderTemplates(config: ConfigurationSection) = if (this is BuildableComponent<*, *>) {
    toBuilder().renderTemplates(config).build() as T
} else {
    this
}


@JvmName("renderComponentBuilderTemplatesAll")
fun <T : ComponentBuilder<*, *>> Iterable<T>.renderTemplatesAll(config: ConfigurationSection) =
    forEach { it.renderTemplates(config) }

@JvmName("renderComponentTemplatesAll")
fun <T : Component> Iterable<T>.renderTemplatesAll(config: ConfigurationSection): List<T> = map {
    it.renderTemplates(config)
}