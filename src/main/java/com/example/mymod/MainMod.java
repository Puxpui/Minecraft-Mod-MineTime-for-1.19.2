package com.example.mymod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

@Mod(MainMod.MOD_ID)
public class MainMod {
    public static final String MOD_ID = "minetime";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MainMod() {
        LOGGER.info("Initializing MainMod...");
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(OverlayRenderer.class);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGuiOverlayEvent.Post event) {
    }
}
