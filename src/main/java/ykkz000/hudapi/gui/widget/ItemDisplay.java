package ykkz000.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.util.Region;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.item.ItemStack;

/**
 * ItemDisplay widget to display item
 * Cautious: The region size != display size, display size = 16 * 16
 *
 * @author ykkz000
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
    public void render(DrawContext context) {
        if (itemStack != null && !itemStack.isEmpty()) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            drawGuiItem(context, itemStack, getRegion().getX(), getRegion().getY());
        }
    }
}
