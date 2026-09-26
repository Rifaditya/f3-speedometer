// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.client;

import net.fabricmc.api.ClientModInitializer;
import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;
import net.dasik.social.util.ModVersionGuard;
import net.vanillaoutsider.speedometer.SpeedometerMod;
import org.slf4j.LoggerFactory;

public class SpeedometerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModVersionGuard.checkClass("Speedometer", "net.minecraft.client.gui.components.debug.DebugScreenEntries");
        LoggerFactory.getLogger(SpeedometerMod.MOD_ID).info("Speedometer 26.3 initialized. Community: {}, Support: {}", SocialLinks.DISCORD_INVITE_URL, DasikSupportHelper.KOFI_URL);
    }
}
