package net.morimori0317.mus.fabric.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.morimori0317.mus.api.MemoryUsageScreenAPI;
import net.morimori0317.mus.handler.RenderHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderWithTooltip", at = @At("TAIL"))
    private void renderWithTooltip(PoseStack poseStack, int i, int j, float f, CallbackInfo ci) {
        var thiz = (Screen) (Object) this;
        if (MemoryUsageScreenAPI.getInstance().isEnableScreen(thiz))
            RenderHandler.onScreenRender(poseStack, thiz, f);
    }
}
