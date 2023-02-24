package llj2003.hudapi;

import llj2003.hudapi.gui.widget.Panel;
import llj2003.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class HudApiMain {
    public static final String MOD_ID = "hud-id";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Panel MAIN_PANEL = new Panel(new Region(0, 0, 0, 0));
    public static MinecraftClient client;
    public static TextRenderer textRenderer = null;
    public static ItemRenderer itemRenderer = null;
}
