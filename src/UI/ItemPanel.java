package UI;

import javax.swing.*;

/**
 * Created by dontf on 6/25/2018.
 */

public abstract class ItemPanel extends JPanel {

    // TODO: add proper setting to make a viable panel;

    private ItemImage image;
    private String desc;

    protected ItemPanel (String imageURL, String description) {
        image = new ItemImage(imageURL);
        desc = description;
    }


}
