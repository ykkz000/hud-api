package ykkz000.hudapi;

import com.mojang.logging.LogUtils;
import ykkz000.hudapi.gui.widget.Panel;
import ykkz000.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Main class of Hud Api. However, I suppose that you may use the "MAIN_PANEL" field
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public final class HudApiMain {
    /**
     * The Logger for this Mod
     */
    public static final Logger LOGGER = LogUtils.getLogger();
    /**
     * The basic frames, you should add your own widget into this panel
     */
    public static final Collection<Panel> FRAMES = new ArrayList<>();

    /**
     * Allocate a frame. Mods should use this method other than FRAMES field directly.
     *
     * @return A new frame
     */
    public static Panel allocateFrame() {
        Panel frame = new Panel(new Region(0, 0, 0, 0));
        FRAMES.add(frame);
        return frame;
    }
}
