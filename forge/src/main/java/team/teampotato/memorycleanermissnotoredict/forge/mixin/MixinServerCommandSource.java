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

package team.teampotato.memorycleanermissnotoredict.forge.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;

import team.teampotato.memorycleanermissnotoredict.event.ClientCommandRegistrationEvent;

@Mixin(ServerCommandSource.class)
public abstract class MixinServerCommandSource implements ClientCommandRegistrationEvent.ClientCommandSourceStack {
    @Override
    public void arch$sendSuccess(Text message, boolean broadcastToAdmins) {
        ((ServerCommandSource) (Object) this).sendFeedback(() -> message, broadcastToAdmins);
    }

    @Override
    public void arch$sendFailure(Text message) {
        ((ServerCommandSource) (Object) this).sendError(message);
    }

    @Override
    public ClientPlayerEntity arch$getPlayer() {
        try {
            return (ClientPlayerEntity) ((ServerCommandSource) (Object) this).getEntityOrThrow();
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vec3d arch$getPosition() {
        return ((ServerCommandSource) (Object) this).getPosition();
    }

    @Override
    public Vec2f arch$getRotation() {
        return ((ServerCommandSource) (Object) this).getRotation();
    }

    @Override
    public ClientWorld arch$getLevel() {
        return (ClientWorld) ((ServerCommandSource) (Object) this).getUnsidedLevel();
    }
}
