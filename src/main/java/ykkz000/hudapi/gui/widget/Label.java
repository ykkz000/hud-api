package ykkz000.hudapi.gui.widget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.util.RGBColor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Label widget to display string
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Getter
@Setter
@NoArgsConstructor
public class Label extends Widget {
    /**
     * The color of the font
     */
    private RGBColor fontColor = RGBColor.fromRGBA(0xFFFFFFFF);
    /**
     * The text of the label
     */
    private String text = "";

    /**
     * Create Label with specified text
     *
     * @param text The text of the label
     */
    public Label(String text) {
        super();
        this.text = text;
    }

    @Override
    public void render(DrawContext context) {
        Widget.getTextRenderer().map(textRenderer -> context.drawText(textRenderer, text, x, y, fontColor.toRGBA(), true));
    }
}
