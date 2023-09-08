package ykkz000.hudapi.gui.layout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import ykkz000.hudapi.gui.widget.Panel;
import ykkz000.hudapi.gui.widget.Widget;

import java.util.List;

/**
 * Padding layout for Widgets
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
@Getter
@Setter
@AllArgsConstructor
public class PaddingLayout extends Layout{
    private int paddingX;
    private int paddingY;

    @Override
    public void layout(List<Widget> widgetList, Panel parent) {
        for (Widget widget: widgetList) {
            widget.setX(paddingX);
            widget.setY(paddingY);
            widget.setWidth(parent.getWidth() - 2 * paddingX);
            widget.setHeight(parent.getHeight() -2 * paddingY);
        }
    }
}
