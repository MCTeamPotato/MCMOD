/*
 * This file is part of architectury.
 * Copyright (C) 2020, 2021, 2022 architectury
 * (https://github.com/architectury/architectury-api/pull/319)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package team.teampotato.memorycleanermissnotoredict.forge;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import team.teampotato.memorycleanermissnotoredict.event.ClientCommandRegistrationEvent;

@OnlyIn(Dist.CLIENT)
public class EventHandlerClientImpl {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onClientCommandRegistration(RegisterClientCommandsEvent event) {
        ClientCommandRegistrationEvent.EVENT.invoker().register((CommandDispatcher<ClientCommandRegistrationEvent.ClientCommandSourceStack>) (CommandDispatcher<?>) event.getDispatcher());
    }
}
