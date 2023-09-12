package ykkz000.hudapi;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ykkz000.hudapi.gui.Frame;
import ykkz000.hudapi.mixin.InGameHudMixin;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class of Hud Api.
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public final class HudApiMain {
    /**
     * The basic frames, you should insert a frame by calling {@link HudApiMain#registerFrame(Frame)} and add your own widget into the frame
     */
    private static final List<Frame> FRAMES = new ArrayList<>();

    /**
     * Insert a frame. Mods should not use {@link HudApiMain#FRAMES} field directly, please use this method.
     *
     * @param frame Frame
     */
    public static void registerFrame(Frame frame) {
        FRAMES.add(frame);
    }

    /**
     * Render all frames. Call method from {@link InGameHudMixin#render(DrawContext, float, CallbackInfo)}
     *
     * @param context DrawContext
     */
    public static void renderAll(DrawContext context) {
        for (Frame frame : HudApiMain.FRAMES) {
            frame.render(context);
        }
    }
}
