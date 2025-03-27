package com.example.mymod;

import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OverlayRenderer {
    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        long worldTime = mc.level.getDayTime();
        long day = worldTime / 24000;
        long timeTicks = worldTime % 24000;
        long hours = (timeTicks / 1000 + 6) % 24;
        long minutes = (timeTicks % 1000) * 60 / 1000;

        String displayTime = String.format("Day %d %02d:%02d", day, hours, minutes);

        int x = 10;
        int y = 10;

        PoseStack poseStack = event.getPoseStack();
        mc.font.draw(poseStack, displayTime, x, y, 0xFFFFFF);
    }
}