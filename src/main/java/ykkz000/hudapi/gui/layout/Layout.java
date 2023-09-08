package ykkz000.hudapi.gui.layout;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import ykkz000.hudapi.gui.widget.Panel;
import ykkz000.hudapi.gui.widget.Widget;

import java.util.List;

/**
 * Layout of Widgets(Default no layout)
 *
 * @author ykkz000
 */
@Environment(EnvType.CLIENT)
public abstract class Layout {

    /**
     * Layout widgets on window
     *
     * @param widgetList list of widgets to be layed out
     * @param parent     panel to which widgets be in
     */
    public abstract void layout(List<Widget> widgetList, Panel parent);
}
