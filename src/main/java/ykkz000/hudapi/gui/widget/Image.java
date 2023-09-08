package ykkz000.hudapi.gui.widget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

/**
 * Image widget to display texture
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Getter
@Setter
@NoArgsConstructor
public class Image extends Widget {
    /**
     * The id of the texture
     */
    private Identifier textureId = null;
    /**
     * The X coordination of the start position in the texture
     */
    private int textureX = -1;
    /**
     * The Y coordination of the start position in the texture
     */
    private int textureY = -1;
    /**
     * The width of the area to draw in the texture
     */
    private int textureWidth = -1;
    /**
     * The height of the area to draw in the texture
     */
    private int textureHeight = -1;

    /**
     * Create Image with specified textureId
     *
     * @param textureId TextureId
     */
    public Image(Identifier textureId) {
        super();
        this.textureId = textureId;
    }

    /**
     * Create Image with specified textureId and start position
     *
     * @param textureId TextureId
     * @param textureX  The X coordination of the start position in the texture
     * @param textureY  The Y coordination of the start position in the texture
     */
    public Image(Identifier textureId, int textureX, int textureY) {
        super();
        this.textureId = textureId;
        this.textureX = textureX;
        this.textureY = textureY;
    }

    /**
     * Create Image with specified textureId, start position and size
     *
     * @param textureId     TextureId
     * @param textureX      The X coordination of the start position in the texture
     * @param textureY      The Y coordination of the start position in the texture
     * @param textureWidth  The width of the area to draw in the texture
     * @param textureHeight The height of the area to draw in the texture
     */
    public Image(Identifier textureId, int textureX, int textureY, int textureWidth, int textureHeight) {
        super();
        this.textureId = textureId;
        this.textureX = textureX;
        this.textureY = textureY;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    @Override
    public void render(DrawContext context) {
        if (textureId == null) {
            return;
        }
        if (textureX == -1 && textureY == -1) {
            context.drawTexture(textureId, x, y, 0, 0, width, height);
            return;
        }
        if (textureWidth == -1 && textureHeight == -1) {
            context.drawTexture(textureId, x, y, textureX, textureY, width, height);
            return;
        }
        context.drawTexture(textureId, x, y, textureX, textureY, width, height, textureWidth, textureHeight);
    }
}
