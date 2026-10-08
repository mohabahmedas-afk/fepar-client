package com.fepar.client;

/** Fepar client core starter for Minecraft 1.21.11. */
public final class FeparClient {
    public static final String NAME = "Fepar Client";
    public static final String VERSION = "0.1.0";
    public static final String MINECRAFT_VERSION = "1.21.11";

    private FeparClient() {}

    public static void initialize() {
        System.out.println(NAME + " " + VERSION + " initialized for Minecraft " + MINECRAFT_VERSION);
        System.out.println("Planned modules: Fullbright, Freelook, HUD, cosmetics, Replay.");
    }
}
