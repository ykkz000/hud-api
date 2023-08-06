package ykkz000.hudapi.mixin;

import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.HudApiMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ykkz000.hudapi.gui.widget.Panel;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/gui/DrawContext;F)V")
    public void render(DrawContext context, float tickDelta, CallbackInfo info) {
        for (Panel frame : HudApiMain.FRAMES) {
            frame.exec(context);
        }
    }
    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/render/item/ItemRenderer;)V")
    public void init(MinecraftClient client, ItemRenderer itemRenderer, CallbackInfo info) {
        HudApiMain.LOGGER.info("client refreshed");
    }
}
