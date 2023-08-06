package ykkz000.hudapi.gui.widget;

import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.gui.Color;
import ykkz000.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Progress bar widget to display progress bar
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class ProgressBar extends Widget {
    private Color frontColor;
    private Color backColor;
    private float progress;

    /**
     * Initialize a ColorProgressBar
     *
     * @param region     Region of the widget
     * @param frontColor Front color
     * @param backColor  Back color
     */
    public ProgressBar(Region region, Color frontColor, Color backColor, float progress) {
        super(region);
        this.frontColor = frontColor;
        this.backColor = backColor;
        this.progress = progress;
    }

    /**
     * Get front color
     *
     * @return Front color
     */
    public Color getFrontColor() {
        return frontColor;
    }

    /**
     * Set front color
     * @param frontColor Front color
     */
    public void setFrontColor(Color frontColor) {
        this.frontColor = frontColor;
    }

    /**
     * Get Back color
     *
     * @return Back color
     */
    public Color getBackColor() {
        return backColor;
    }

    /**
     * Set back color
     * @param backColor Back color
     */
    public void setBackColor(Color backColor) {
        this.backColor = backColor;
    }

    /**
     * Get progress
     *
     * @return Progress
     */
    public float getProgress() {
        return progress;
    }

    /**
     * Set Progress
     *
     * @param progress Progress
     * @implNote In fact, progress=min(max(progress,0.0F),1.0F)
     */
    public void setProgress(float progress) {
        this.progress = Math.min(Math.max(progress, 0.0F), 1.0F);
    }

    @Override
    public void render(DrawContext context) {
        fill(context, backColor, getRegion());
        Region frontRegion = getRegion().copy();
        frontRegion.setWidth((int)(frontRegion.getWidth() * progress));
        fill(context, frontColor, frontRegion);
    }
}
