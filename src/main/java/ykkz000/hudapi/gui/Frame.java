package ykkz000.hudapi.gui;

import lombok.Getter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.gui.widget.Panel;

/**
 * Frame to draw huds(widgets)
 *
 * @author ykkz000
 */
@Getter
@Environment(EnvType.CLIENT)
public class Frame {
    private final Panel panel = new Panel();

    /**
     * Get window width
     *
     * @return window width
     */
    protected static int getWindowWidth() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client == null ? 0 : client.getWindow().getScaledWidth();
    }

    /**
     * Get window height
     *
     * @return window height
     */
    protected static int getWindowHeight() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client == null ? 0 : client.getWindow().getScaledHeight();
    }

    /**
     * Render the Frame
     *
     * @param context Draw context
     * @apiNote The panel in the Frame will always be same size as in Window
     */
    public void render(DrawContext context) {
        panel.setX(0);
        panel.setY(0);
        panel.setWidth(getWindowWidth());
        panel.setHeight(getWindowHeight());
        panel.renderWidget(context);
    }
}
