package llj2003.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import llj2003.hudapi.HudApiMain;
import llj2003.hudapi.util.Region;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

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
        matrixStack.push();
        matrixStack.translate(getRegion().getX(), getRegion().getY(), 0);
        matrixStack.scale(getRegion().getX() / 8.0F, getRegion().getY() / 8.0F, 1.0F);
        if (itemStack != null && !itemStack.isEmpty()) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            HudApiMain.itemRenderer.renderGuiItemOverlay(HudApiMain.textRenderer, itemStack, 0, 0);
            RenderSystem.disableBlend();
        }
        matrixStack.pop();
    }
}
