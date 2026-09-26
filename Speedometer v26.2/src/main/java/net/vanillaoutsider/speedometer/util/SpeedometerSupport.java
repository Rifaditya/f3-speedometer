// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.util;

import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;

import java.net.URI;

/**
 * Utility helper connecting Speedometer with Dasik Library community & creator support.
 */
public final class SpeedometerSupport {

    private SpeedometerSupport() {
    }

    public static String getDiscordUrl() {
        return SocialLinks.DISCORD_INVITE_URL;
    }

    public static String getKofiUrl() {
        return DasikSupportHelper.KOFI_URL;
    }

    public static URI getDiscordUri() {
        return SocialLinks.getDiscordUri();
    }

    public static URI getKofiUri() {
        return SocialLinks.getKofiUri();
    }

    public static URI getGithubUri() {
        return SocialLinks.getGithubUri();
    }

    public static String getFormattedSupportInfo() {
        return "Discord: " + SocialLinks.DISCORD_INVITE_URL + " | Ko-fi: " + DasikSupportHelper.KOFI_URL;
    }
}
