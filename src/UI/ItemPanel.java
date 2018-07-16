package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dontf on 6/25/2018.
 */

public abstract class ItemPanel extends JPanel {

    // TODO: add proper setting to make a viable panel;
    private final String defaultImageURL = "resources/defaultImage.png";
    private final int smallImageFactor = 50, largeImageFactor = 100;

    protected ItemPanel (String imageURL, String description, boolean small, int width, int height) {
        setLayout(new GridBagLayout ());
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        initContent (imageURL, small, width, height, description);
        setVisible(true);
    }

    private void initContent (String imageURL, boolean small, int width, int height, String description) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 5, 5, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 5;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_START;

        File file = new File (imageURL);
        BufferedImage image;
        JLabel imageLabel = new JLabel();

        int scaleFactor = small ? smallImageFactor : largeImageFactor;
        imageLabel.setBounds(0, 0, width, scaleFactor);

        if (file.exists()) {
            try {
                image = ImageIO.read (file);
                imageLabel.setIcon(new ImageIcon(image.getScaledInstance(scaleFactor, scaleFactor, Image.SCALE_FAST)));   // may change scale type later
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                image = ImageIO.read (new File(defaultImageURL));
                imageLabel.setIcon(new ImageIcon(image.getScaledInstance(scaleFactor, scaleFactor, Image.SCALE_FAST)));   // may change scale type later
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "image not found at \"" + imageURL + "\". This can be changed later.");
        }
        add(imageLabel, c);

        c.gridx = 5;
        c.gridy = 0;
        c.gridwidth = 8;
        c.gridheight = 5;

        JLabel descLabel = new JLabel(description);
        add(descLabel, c);
    }

}
