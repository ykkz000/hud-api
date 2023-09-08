package ykkz000.hudapi.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ykkz000.hudapi.HudApiMain;

/**
 * Mixin {@link InGameHud}
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    /**
     * Inject in {@link InGameHud#render(DrawContext, float)} to draw frames.
     *
     * @param context   DrawContext
     * @param tickDelta tick delta
     * @param info      Callback info(not used)
     */
    @Inject(method = "render(Lnet/minecraft/client/gui/DrawContext;F)V", at = @At("RETURN"))
    public void render(DrawContext context, float tickDelta, CallbackInfo info) {
        HudApiMain.renderAll(context);
    }
}
