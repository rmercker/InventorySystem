package UI;

import javax.swing.*;

/**
 * Created by dontf on 5/18/2018.
 */
public class Display extends JInternalFrame {

    public Display () {

    }

    public Display (String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setVisible(true);
    }
}
