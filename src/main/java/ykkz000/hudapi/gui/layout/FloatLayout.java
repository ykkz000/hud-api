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
 * Float layout for Widgets
 *
 * @author ykkz000
 * @apiNote The further back in the directions array, the higher the priority
 */
@Environment(EnvType.CLIENT)
@Getter
@Setter
@AllArgsConstructor
public class FloatLayout extends Layout {
    private Direction[] directions;

    @Override
    public void layout(List<Widget> widgetList, Panel parent) {
        for (Widget widget : widgetList) {
            for (Direction direction : directions) {
                switch (direction) {
                    case EAST -> widget.setX(parent.getWidth() - widget.getWidth());
                    case WEST -> widget.setX(0);
                    case NORTH -> widget.setY(0);
                    case SOUTH -> widget.setY(parent.getHeight() - widget.getHeight());
                    case HORIZONTAL_CENTER -> widget.setX((parent.getWidth() - widget.getWidth()) / 2);
                    case VERTICAL_CENTER -> widget.setY((parent.getHeight() - widget.getHeight()) / 2);
                }
            }
        }
    }
}
