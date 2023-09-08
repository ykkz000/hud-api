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
 * Stream layout for Widgets
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
@Getter
@Setter
@AllArgsConstructor
public class StreamLayout extends Layout {
    private Direction startDirection;
    private int margin;
    private boolean stretch;

    @Override
    public void layout(List<Widget> widgetList, Panel parent) {
        switch (startDirection) {
            case EAST -> {
                int x = parent.getWidth();
                for (Widget widget : widgetList) {
                    x -= widget.getWidth();
                    widget.setX(x);
                    x -= margin;
                    if (stretch) {
                        widget.setY(0);
                        widget.setHeight(parent.getHeight());
                    }
                }
            }
            case NORTH -> {
                int y = 0;
                for (Widget widget : widgetList) {
                    widget.setY(y);
                    y += widget.getHeight() + margin;
                    if (stretch) {
                        widget.setX(0);
                        widget.setWidth(parent.getWidth());
                    }
                }
            }
            case SOUTH -> {
                int y = parent.getHeight();
                for (Widget widget : widgetList) {
                    y -= widget.getHeight();
                    widget.setY(y);
                    y -= margin;
                    if (stretch) {
                        widget.setX(0);
                        widget.setWidth(parent.getWidth());
                    }
                }
            }
            case WEST -> {
                int x = 0;
                for (Widget widget : widgetList) {
                    widget.setX(x);
                    x += widget.getWidth() + margin;
                    if (stretch) {
                        widget.setY(0);
                        widget.setHeight(parent.getHeight());
                    }
                }
            }
            case HORIZONTAL_CENTER, VERTICAL_CENTER -> throw new IllegalArgumentException("Unsupported Layout Direction 'CENTER' for StreamLayout");
        }
    }

}
