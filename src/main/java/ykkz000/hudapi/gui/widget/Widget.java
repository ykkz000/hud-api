package ykkz000.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import ykkz000.hudapi.gui.Color;
import ykkz000.hudapi.util.Region;
import ykkz000.hudapi.util.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

/**
 * Basic class of all drawable widgets.
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
public abstract class Widget extends DrawableHelper {
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
     * @param matrixStack MatrixStack
     * @param text        String
     * @param color       Color of the string
     * @param x           X coordinate
     * @param y           Y coordinate
     */
    public void drawText(MatrixStack matrixStack, String text, Color color, int x, int y) {
        if (getTextRenderer() != null) {
            getTextRenderer().draw(matrixStack, text, x, y, color.toInt());
        }
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
        if (getTextRenderer() != null) {
            getTextRenderer().drawWithShadow(matrixStack, text, x, y, color.toInt());
        }
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack MatrixStack
     * @param texture     Texture
     * @param drawRegion  Region to draw
     */
    public void drawTexture(MatrixStack matrixStack, Texture texture, Region drawRegion) {
        drawTexture(matrixStack, texture, Color.fromInt(-1), drawRegion, texture.getSize().toRegion());
    }

    /**
     * Draws texture in the specified region
     *
     * @param matrixStack MatrixStack
     * @param texture     Texture
     * @param color       Color
     * @param drawRegion  Region to draw
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

    public void drawGuiItem(MatrixStack matrixStack, ItemStack itemStack, int x, int y) {
        if (getItemRenderer() != null) {
            getItemRenderer().renderGuiItemIcon(matrixStack, itemStack, x, y);
        }
    }

    /**
     * Fill color in the specified region
     *
     * @param matrixStack MatrixStack
     * @param color       Color
     * @param drawRegion  Region to draw
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

    /**
     * Get text renderer
     *
     * @return TextRenderer instance
     */
    public static TextRenderer getTextRenderer() {
        return MinecraftClient.getInstance() == null ? null : MinecraftClient.getInstance().textRenderer;
    }

    /**
     * Get item renderer
     *
     * @return ItemRenderer instance
     */
    public static ItemRenderer getItemRenderer() {
        return MinecraftClient.getInstance() == null ? null : MinecraftClient.getInstance().getItemRenderer();
    }
}
