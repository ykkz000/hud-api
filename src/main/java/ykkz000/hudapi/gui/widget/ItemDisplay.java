package ykkz000.hudapi.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.item.ItemStack;

/**
 * ItemDisplay widget to display item
 * Cautious: The widget size != display size, display size = 16 * 16
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Getter
@Setter
@NoArgsConstructor
public class ItemDisplay extends Widget {
    /**
     * Item to be drawn
     */
    private ItemStack itemStack = ItemStack.EMPTY;

    /**
     * Create ItemDisplay with specified ItemStack
     *
     * @param itemStack Item to be drawn
     */
    public ItemDisplay(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public void render(DrawContext context) {
        if (itemStack != null && !itemStack.isEmpty()) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexProgram);
            context.drawItem(itemStack, x, y);
        }
    }
}
