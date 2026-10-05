// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Locale;

@Mixin(DebugScreenOverlay.class)
public class DebugScreenOverlayMixin {

    @Inject(method = "getGameInformation", at = @At("RETURN"))
    protected void speedometer$addSpeedToDebug(CallbackInfoReturnable<List<String>> cir) {
        Minecraft client = Minecraft.getInstance();
        if (client.player != null) {
            Entity entity = client.player.getVehicle() != null ? client.player.getVehicle() : client.player;
            Vec3 delta = entity.getDeltaMovement();
            double dx = delta.x;
            double dy = delta.y;
            double dz = delta.z;
            double total = Math.sqrt(dx * dx + dy * dy + dz * dz) * 20.0;
            double horizontal = Math.sqrt(dx * dx + dz * dz) * 20.0;
            double vertical = Math.abs(dy) * 20.0;
            String text = Component.translatable("debug.entry.speedometer",
                String.format(Locale.ROOT, "%.2f", total),
                String.format(Locale.ROOT, "%.2f", horizontal),
                String.format(Locale.ROOT, "%.2f", vertical)).getString();
            if (text.equals("debug.entry.speedometer") || text.equals("Speedometer") || (!text.contains("%s") && !text.contains("b/s"))) {
                text = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horizontal, vertical);
            }
            cir.getReturnValue().add(text);
        }
    }
}
