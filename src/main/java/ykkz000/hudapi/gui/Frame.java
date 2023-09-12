package ykkz000.hudapi.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import ykkz000.hudapi.gui.widget.Panel;

/**
 * Frame to draw huds(widgets)
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
public class Frame extends Panel {
    public Frame() {
        super();
        this.setX(0);
        this.setY(0);
        this.setWidth(getWindowWidth());
        this.setHeight(getWindowHeight());
    }

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
}
