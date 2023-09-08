package ykkz000.hudapi.gui.widget;

import lombok.*;
import net.minecraft.client.gui.DrawContext;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import ykkz000.hudapi.gui.layout.Layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Panel widget to contain other widget
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Getter
@Setter
@NoArgsConstructor
public class Panel extends Widget {
    /**
     * Children list of this panel
     */
    protected List<Widget> children = new ArrayList<>();
    /**
     * Layout for child widgets in this panel
     */
    protected Layout layout = null;

    @Override
    public void render(DrawContext context) {
        context.getMatrices().push();
        context.getMatrices().translate(x, y, 0);
        if (layout != null) {
            layout.layout(children, this);
        }
        for (Widget widget : children) {
            widget.renderWidget(context);
        }
        context.getMatrices().pop();
    }

    /**
     * Add a widget to the panel
     *
     * @param widget Widget to be added
     */
    public void add(Widget widget) {
        children.add(widget);
    }

    /**
     * Get widget count of this panel
     *
     * @return Widget count of this panel
     */
    public int size() {
        return children.size();
    }

    /**
     * Get a specific child widget
     *
     * @param index Index of the child widget
     * @return Widget at specified index
     */
    public Widget get(int index) {
        return children.get(index);
    }

    /**
     * Remove a specific child widget
     *
     * @param index Index of the child widget
     * @see Panel#remove(Widget)
     */
    public void remove(int index) {
        children.remove(index);
    }

    /**
     * Remove a child widget<br/>
     *
     * @param widget Widget to be removed
     * @see Panel#remove(int)
     */
    public void remove(Widget widget) {
        children.remove(widget);
    }
}
