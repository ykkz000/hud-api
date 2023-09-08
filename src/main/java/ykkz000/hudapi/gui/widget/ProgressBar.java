package ykkz000.hudapi.gui.widget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.util.RGBColor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Progress bar widget to display progress bar
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Getter
@Setter
@NoArgsConstructor
public class ProgressBar extends Widget {
    /**
     * The color of the bar
     */
    private RGBColor barColor = RGBColor.fromRGBA(0xFFFFFFFF);
    /**
     * The progress of the bar
     */
    private double progress = 0;

    /**
     * Create ProgressBar with specified progress
     * @param progress The progress of the bar
     */
    public ProgressBar(double progress) {
        super();
        this.progress = progress;
    }

    @Override
    public void render(DrawContext context) {
        context.fill(x, y, (int) (x + width * progress), y + height, barColor.toRGBA());
    }
}
