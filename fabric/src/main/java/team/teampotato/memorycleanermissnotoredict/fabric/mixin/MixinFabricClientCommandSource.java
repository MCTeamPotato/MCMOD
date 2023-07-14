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

package team.teampotato.memorycleanermissnotoredict.fabric.mixin;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

import org.spongepowered.asm.mixin.Mixin;

import team.teampotato.memorycleanermissnotoredict.event.ClientCommandRegistrationEvent;

@Mixin(FabricClientCommandSource.class)
public interface MixinFabricClientCommandSource extends ClientCommandRegistrationEvent.ClientCommandSourceStack {
    @Override
    default void arch$sendSuccess(Text message, boolean broadcastToAdmins) {
        ((FabricClientCommandSource) this).sendFeedback(message);
    }

    @Override
    default void arch$sendFailure(Text message) {
        ((FabricClientCommandSource) this).sendError(message);
    }

    @Override
    default ClientPlayerEntity arch$getPlayer() {
        return ((FabricClientCommandSource) this).getPlayer();
    }

    @Override
    default Vec3d arch$getPosition() {
        return ((FabricClientCommandSource) this).getPosition();
    }

    @Override
    default Vec2f arch$getRotation() {
        return ((FabricClientCommandSource) this).getRotation();
    }

    @Override
    default ClientWorld arch$getLevel() {
        return ((FabricClientCommandSource) this).getWorld();
    }
}
