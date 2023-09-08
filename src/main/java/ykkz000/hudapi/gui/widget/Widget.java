package ykkz000.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.util.RGBColor;

import java.util.Optional;

/**
 * Basic class of all drawable widgets.
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Data
@NoArgsConstructor
public abstract class Widget {
    /**
     * The X coordinate of the upper-left corner of the widget
     */
    protected int x = 0;
    /**
     * The Y coordinate of the upper-left corner of the widget
     */
    protected int y = 0;
    /**
     * The width of the widget
     */
    protected int width = 0;
    /**
     * The height of the widget
     */
    protected int height = 0;
    /**
     * The visibility of the widget
     */
    protected boolean visible = true;
    /**
     * The background color of the widget
     */
    protected RGBColor backgroundColor = RGBColor.fromRGBA(0);

    /**
     * If visible == true, this function will call render
     *
     * @param context Draw context
     */
    public void renderWidget(DrawContext context) {
        if (visible) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            context.fill(x, y, x + width, y + height, backgroundColor.toRGBA());
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
     * @return {@link Optional} contains {@link TextRenderer}
     */
    public static Optional<TextRenderer> getTextRenderer() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client == null ? Optional.empty() : Optional.of(client.textRenderer);
    }
}
