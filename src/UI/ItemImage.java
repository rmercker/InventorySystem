package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by dontf on 5/18/2018.
 */
public class ItemImage extends JPanel {

    String url;
    Image image;

    public ItemImage (String imageURL) {
        try {
            image = ImageIO.read(new File(imageURL));
        } catch (IOException e) {
            throwBadImageLocationError();
        }
    }

    public void changeImage (String imageURL) {
        try {
            image = ImageIO.read(new File(imageURL));
        } catch (IOException e) {
            throwBadImageLocationError();
        }
    }

    private void throwBadImageLocationError () {
        // TODO: throw notification about bad image location
    }
}
