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
 * Grid layout for Widgets
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
@Getter
@Setter
@AllArgsConstructor
public class GridLayout extends Layout {
    private int rowCount;
    private int colCount;
    private int marginX;
    private int marginY;
    private boolean stretch;

    @Override
    public void layout(List<Widget> widgetList, Panel parent) {
        final int limitWidth = (parent.getWidth() - marginX * (colCount - 1)) / colCount;
        final int limitHeight = (parent.getHeight() - marginY * (rowCount - 1)) / rowCount;
        for (int i = 0; i < widgetList.size(); i++) {
            Widget widget = widgetList.get(i);
            widget.setX((limitWidth + marginX) * (i % colCount));
            widget.setY((limitHeight + marginY) * (i / colCount));
            int currentWidth = Math.min(widgetList.get(i).getWidth(), limitWidth);
            if (stretch) {
                currentWidth = Math.max(currentWidth, limitWidth);
            }
            widget.setWidth(currentWidth);
            int currentHeight = Math.min(widgetList.get(i).getHeight(), limitHeight);
            if (stretch) {
                currentHeight = Math.max(currentHeight, limitHeight);
            }
            widget.setHeight(currentHeight);
        }
    }
}
