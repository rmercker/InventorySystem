package UI;

import java.util.ArrayList;

/**
 * Created by dontf on 6/25/2018.
 */
public class MultipleItemDisplay extends Display {

    //TODO: need to display all items one below the other with a scroll bar;
    private ArrayList <ItemPanel> items;

    public MultipleItemDisplay(String title, int width, int height) {
        super (title, width, height);
        items = new ArrayList<>();
    }

    public MultipleItemDisplay(String title, int width, int height, ArrayList <ItemPanel> items) {
        super (title, width, height);
        this.items = items;

        for (ItemPanel i : items)
            add(i);
    }

    public void addItem (ItemPanel item) {
        items.add(item);
        add(item);
    }

    public void removeItem (ItemPanel item) {
        items.remove(item);
        remove(item);
    }

}
