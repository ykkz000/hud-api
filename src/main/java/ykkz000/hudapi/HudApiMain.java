package ykkz000.hudapi;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ykkz000.hudapi.gui.widget.Panel;
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
     * The basic frames, you should allocate a new frame by calling {@link HudApiMain#allocateFrame()} and add your own widget into the frame
     */
    private static final List<Panel> FRAMES = new ArrayList<>();

    /**
     * Allocate a frame. Mods should not use {@link HudApiMain#FRAMES} field directly, please use this method.
     *
     * @return A new frame
     */
    public static Panel allocateFrame() {
        Panel frame = new Panel();
        FRAMES.add(frame);
        return frame;
    }

    /**
     * Render all frames. Call method from {@link InGameHudMixin#render(DrawContext, float, CallbackInfo)}
     *
     * @param context DrawContext
     */
    public static void renderAll(DrawContext context) {
        for (Panel frame : HudApiMain.FRAMES) {
            frame.renderWidget(context);
        }
    }
}
