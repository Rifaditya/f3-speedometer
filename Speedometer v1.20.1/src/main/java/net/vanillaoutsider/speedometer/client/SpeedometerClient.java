// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.client;

import net.fabricmc.api.ClientModInitializer;
import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;
import net.vanillaoutsider.speedometer.SpeedometerMod;
import org.slf4j.LoggerFactory;

public class SpeedometerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LoggerFactory.getLogger(SpeedometerMod.MOD_ID).info(
            "Speedometer 1.20.1 initialized. Community: {}, Support: {}",
            SocialLinks.DISCORD_INVITE_URL,
            DasikSupportHelper.KOFI_URL
        );
    }
}
