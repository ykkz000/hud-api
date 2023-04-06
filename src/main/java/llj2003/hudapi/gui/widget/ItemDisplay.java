package llj2003.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import llj2003.hudapi.HudApiMain;
import llj2003.hudapi.util.Region;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.joml.Matrix4f;

/**
 * ItemDisplay widget to display item
 * Cautious: The region size != display size, display size = 16 * 16
 *
 * @author llj2003
 */
public class ItemDisplay extends Widget {
    private ItemStack itemStack;

    /**
     * Initialization
     *
     * @param region Region of the Widget
     */
    public ItemDisplay(Region region) {
        this(region, null);
    }

    /**
     * Initialization
     *
     * @param region    Region of the Widget
     * @param itemStack Item to be drawn
     */
    public ItemDisplay(Region region, ItemStack itemStack) {
        super(region);
        this.itemStack = itemStack;
    }

    /**
     * Get ItemStack
     *
     * @return ItemStack
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * Set ItemStack
     *
     * @param itemStack ItemStack
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public void render(MatrixStack matrixStack) {
        Matrix4f matrixTranslate = matrixStack.peek().getPositionMatrix();
        float dx = matrixTranslate.get(3, 0);
        float dy = matrixTranslate.get(3, 1);
        if (itemStack != null && !itemStack.isEmpty()) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            drawGuiItem(matrixStack, itemStack, (int) dx + getRegion().getX(), (int) dy + getRegion().getY());
        }
    }
}
