package ykkz000.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import ykkz000.hudapi.gui.Color;
import ykkz000.hudapi.util.Region;
import ykkz000.hudapi.util.Texture;

/**
 * Basic class of all drawable widgets.
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
public abstract class Widget {
    private Region region;
    private boolean visible;

    /**
     * Initialization
     *
     * @param region Region of the Widget
     */
    public Widget(Region region) {
        this.region = region;
        this.visible = true;
    }

    /**
     * Get the region of the widget
     *
     * @return Region of the widget
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Set the region of the widget
     *
     * @param region Region of the widget
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * Draws a string in the specified region
     *
     * @param text  String
     * @param color Color of the string
     * @param x     X coordinate
     * @param y     Y coordinate
     */
    public void drawText(DrawContext drawContext, String text, Color color, int x, int y, boolean shadow) {
        if (getTextRenderer() != null) {
            drawContext.drawText(getTextRenderer(), text, x, y, color.toInt(), shadow);
        }
    }

    /**
     * Draws texture in the specified region
     *
     * @param context    Draw context
     * @param texture    Texture
     * @param drawRegion Region to draw
     */
    public void drawTexture(DrawContext context, Texture texture, Region drawRegion) {
        drawTexture(context, texture, Color.fromInt(-1), drawRegion, texture.getSize().toRegion());
    }

    /**
     * Draws texture in the specified region
     *
     * @param context    Draw context
     * @param texture    Texture
     * @param color      Color
     * @param drawRegion Region to draw
     */
    public void drawTexture(DrawContext context, Texture texture, Color color, Region drawRegion) {
        drawTexture(context, texture, color, drawRegion, texture.getSize().toRegion());
    }

    /**
     * Draws texture in the specified region
     *
     * @param context       Draw context
     * @param texture       Texture
     * @param drawRegion    Region to draw
     * @param textureRegion Region of the texture
     */
    public void drawTexture(DrawContext context, Texture texture, Region drawRegion, Region textureRegion) {
        drawTexture(context, texture, Color.fromInt(-1), drawRegion, textureRegion);
    }

    /**
     * Draws texture in the specified region
     *
     * @param context       Draw context
     * @param texture       Texture
     * @param color         Color
     * @param drawRegion    Region to draw
     * @param textureRegion Region of the texture
     */
    public void drawTexture(DrawContext context, Texture texture, Color color, Region drawRegion, Region textureRegion) {
        RenderSystem.setShaderColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        context.drawTexture(texture.getId(),
                drawRegion.getX(), drawRegion.getY(), drawRegion.getWidth(), drawRegion.getHeight(),
                textureRegion.getX(), textureRegion.getY(), textureRegion.getWidth(), textureRegion.getHeight(),
                texture.getSize().getWidth(), texture.getSize().getHeight());
    }

    /**
     * Draw Gui Items at the specified position
     *
     * @param context Draw context
     * @param item    Item
     * @param x       X position
     * @param y       Y position
     */
    public void drawGuiItem(DrawContext context, ItemStack item, int x, int y) {
        context.drawItem(item, x, y);
    }

    /**
     * Fill color in the specified region
     *
     * @param context    Draw context
     * @param color      Color
     * @param drawRegion Region to draw
     */
    public void fill(DrawContext context, Color color, Region drawRegion) {
        context.fill(drawRegion.getX(), drawRegion.getY(),
                drawRegion.getX() + drawRegion.getWidth(),
                drawRegion.getY() + drawRegion.getHeight(),
                color.toInt());
    }

    /**
     * Check is this widget is visible
     *
     * @return if this is visible, return true
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Set the visibility of this widget
     *
     * @param visible "true" means "visible"
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * If visible == true, this function will call render
     *
     * @param context Draw context
     */
    public void exec(DrawContext context) {
        if (visible) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            render(context);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    /**
     * Defines how to render the widget<br/>
     * Cautious: The X and Y coordinates are relative to the parent widget
     *
     * @param context Draw context
     */
    public abstract void render(DrawContext context);

    /**
     * Get text renderer
     *
     * @return TextRenderer instance
     */
    public static TextRenderer getTextRenderer() {
        return MinecraftClient.getInstance() == null ? null : MinecraftClient.getInstance().textRenderer;
    }
}
