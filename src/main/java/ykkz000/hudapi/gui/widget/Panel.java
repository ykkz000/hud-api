package ykkz000.hudapi.gui.widget;

import net.minecraft.client.gui.DrawContext;
import ykkz000.hudapi.gui.Color;
import ykkz000.hudapi.util.Region;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Panel widget to contain other widget
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class Panel extends Widget implements Container<Widget> {
    protected List<Widget> widgetList = new ArrayList<>();
    protected Color backgroundColor;

    /**
     * Initialize a panel(default:null, Color.fromInt(-1))
     *
     * @param region Region of the widget
     */
    public Panel(Region region) {
        this(region, Color.fromInt(0));
    }

    /**
     * Initialize a panel
     *
     * @param region            Region of the widget
     * @param backgroundColor   Color
     */
    public Panel(Region region, Color backgroundColor) {
        super(region);
        this.backgroundColor = backgroundColor;
    }

    /**
     * Get background color
     *
     * @return Background color
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Set background color
     *
     * @param backgroundColor Color
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void render(DrawContext context) {
        fill(context, backgroundColor, getRegion());
        context.getMatrices().push();
        context.getMatrices().translate(getRegion().getX(), getRegion().getY(), 0);
        //Render children
        for (Widget widget : widgetList) {
            widget.exec(context);
        }
        context.getMatrices().pop();
    }

    @Override
    public void add(Widget widget) {
        widgetList.add(widget);
    }

    @Override
    public int size() {
        return widgetList.size();
    }

    @Override
    public Widget get(int i) {
        return widgetList.get(i);
    }

    @Override
    public void remove(int i) {
        widgetList.remove(i);
    }

    @Override
    public void remove(Widget t) {
        widgetList.remove(t);
    }

    @Override
    public Iterator<Widget> iterator() {
        return widgetList.iterator();
    }
}
