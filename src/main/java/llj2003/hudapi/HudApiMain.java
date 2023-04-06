package llj2003.hudapi;

import llj2003.hudapi.gui.widget.Panel;
import llj2003.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Main class of Hud Api. However, I suppose that you may use the "MAIN_PANEL" field
 *
 * @author llj2003
 */
@Environment(EnvType.CLIENT)
public class HudApiMain {
    /**
     * The Id of this Mod
     */
    public static final String MOD_ID = "hud-id";
    /**
     * The Logger for this Mod
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    /**
     * The main panel, you should add your own widget into this panel
     */
    public static final Panel MAIN_PANEL = new Panel(new Region(0, 0, 0, 0));
}
