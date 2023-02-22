package llj2003.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import llj2003.hudapi.gui.Color;
import llj2003.hudapi.util.Region;
import llj2003.hudapi.util.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Basic class of all drawable widgets.
 *
 * @author llj2003
 */
@Environment(EnvType.CLIENT)
public abstract class Widget extends DrawableHelper {
    private Region region;
    private MinecraftClient client;
    private boolean visible;

    /**
     * Initialization
     *
     * @param region Region of the Widget
     */
    public Widget(Region region) {
        this.region = region;
        this.client = null;
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
     * Get current MinecraftClient
     *
     * @return Current MinecraftClient
     */
    protected MinecraftClient getClient() {
        return client;
    }

    /**
     * Set current MinecraftClient
     *
     * @param client Current MinecraftClient
     */
    public void setClient(MinecraftClient client) {
        this.client = client;
    }

    /**
     * Draws a string in the specified region
     *
     * @param matrixStack MatrixStack
     * @param text        String
     * @param color       Color of the string
     * @param x           X coordinate
     * @param y           Y coordinate
     */
    public void drawText(MatrixStack matrixStack, String text, Color color, int x, int y) {
        getClient().textRenderer.draw(matrixStack, text, x, y, color.toInt());
    }

    /**
     * Draws a string with shadow in the specified region
     *
     * @param matrixStack MatrixStack
     * @param text        String
     * @param color       Color of the string
     * @param x           X coordinate
     * @param y           Y coordinate
     */
    public void drawTextWithShadow(MatrixStack matrixStack, String text, Color color, int x, int y) {
        getClient().textRenderer.drawWithShadow(matrixStack, text, x, y, color.toInt());
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack   MatrixStack
     * @param texture       Texture
     * @param drawRegion    Region to draw
     */
    public void drawTexture(MatrixStack matrixStack, Texture texture, Region drawRegion) {
        drawTexture(matrixStack, texture, Color.fromInt(-1), drawRegion, texture.getSize().toRegion());
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack   MatrixStack
     * @param texture       Texture
     * @param color         Color
     * @param drawRegion    Region to draw
     */
    public void drawTexture(MatrixStack matrixStack, Texture texture, Color color, Region drawRegion) {
        drawTexture(matrixStack, texture, color, drawRegion, texture.getSize().toRegion());
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack   MatrixStack
     * @param texture       Texture
     * @param drawRegion    Region to draw
     * @param textureRegion Region of the texture
     */
    public void drawTexture(MatrixStack matrixStack, Texture texture, Region drawRegion, Region textureRegion) {
        drawTexture(matrixStack, texture, Color.fromInt(-1), drawRegion, textureRegion);
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack   MatrixStack
     * @param texture       Texture
     * @param color         Color
     * @param drawRegion    Region to draw
     * @param textureRegion Region of the texture
     */
    public void drawTexture(MatrixStack matrixStack, Texture texture, Color color, Region drawRegion, Region textureRegion) {
        RenderSystem.setShaderColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        RenderSystem.setShaderTexture(0, texture.getId());
        drawTexture(matrixStack,
                drawRegion.getX(), drawRegion.getY(), drawRegion.getWidth(), drawRegion.getHeight(),
                textureRegion.getX(), textureRegion.getY(), textureRegion.getWidth(), textureRegion.getHeight(),
                texture.getSize().getWidth(), texture.getSize().getHeight());
    }

    /**
     * Fill color in the specified region
     *
     * @param matrixStack   MatrixStack
     * @param color         Color
     * @param drawRegion    Region to draw
     */
    public void fill(MatrixStack matrixStack, Color color, Region drawRegion) {
        fill(matrixStack, drawRegion.getX(), drawRegion.getY(),
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
     * @param matrixStack matrixStack
     */
    public void exec(MatrixStack matrixStack) {
        if (visible) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            render(matrixStack);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
    /**
     * Defines how to render the widget<br/>
     * Cautious: The X and Y coordinates are relative to the parent widget
     *
     * @param matrixStack matrixStack
     */
    public abstract void render(MatrixStack matrixStack);
}
