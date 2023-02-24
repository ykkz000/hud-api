package llj2003.hudapi.mixin;

import llj2003.hudapi.HudApiMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow @Final private ItemRenderer itemRenderer;

    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V")
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo info) {
        HudApiMain.MAIN_PANEL.exec(matrices);
    }
    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/render/item/ItemRenderer;)V")
    public void init(MinecraftClient client, ItemRenderer itemRenderer, CallbackInfo info) {
        HudApiMain.client = client;
        HudApiMain.textRenderer = client.textRenderer;
        HudApiMain.itemRenderer = itemRenderer;
        HudApiMain.LOGGER.info("client refreshed");
    }
}
