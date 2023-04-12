package ykkz000.hudapi.gui.widget;

import ykkz000.hudapi.util.Region;
import ykkz000.hudapi.util.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Image widget to display texture
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
public class Image extends Widget {
    private Texture texture;

    /**
     * Initialization
     *
     * @param region  Region of the Widget
     * @param texture Texture
     * @author ykkz000
     */
    public Image(Region region, Texture texture) {
        super(region);
        this.texture = texture;
    }

    /**
     * Get texture
     *
     * @return Texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Set texture
     *
     * @param texture Texture
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void render(MatrixStack matrixStack) {
        if (texture != null) {
            drawTexture(matrixStack, texture, getRegion());
        }
    }
}
