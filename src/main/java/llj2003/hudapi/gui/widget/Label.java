package llj2003.hudapi.gui.widget;

import llj2003.hudapi.gui.Color;
import llj2003.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Label widget to display string
 *
 * @author llj2003
 */
@Environment(EnvType.CLIENT)
public class Label extends Widget {
    private Color fontColor = Color.fromInt(0xFFFFFFFF);
    private String string;

    /**
     * Initialize a label
     *
     * @param region Region of the widget
     * @param string String to display
     */
    public Label(Region region, String string) {
        super(region);
        this.string = string;
    }

    /**
     * Get font color
     *
     * @return Font color
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * Set font color
     *
     * @param fontColor Color
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * Get string
     *
     * @return String
     */
    public String getString() {
        return string;
    }

    /**
     * Set string
     *
     * @param string String
     */
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public void render(MatrixStack matrixStack) {
        drawTextWithShadow(matrixStack, string, fontColor, getRegion().getX(), getRegion().getY());
    }
}
