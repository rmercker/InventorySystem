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
    private final int smallImageFactor = 100, largeImageFactor = 250;

    protected ItemPanel (String imageURL, String description, boolean small) {
        setLayout(new GridBagLayout ());
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        initContent (imageURL, small, description);
        setVisible(true);
    }

    private void initContent (String imageURL, boolean small, String description) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(1, 5, 4, 5);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 5;
        c.weightx = 1f;
        c.weighty = 1f;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;

        File file = new File (imageURL);
        BufferedImage image;
        JLabel imageLabel = new JLabel();

        int scaleFactor = small ? smallImageFactor : largeImageFactor;

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
        c.insets = new Insets(15, 5, 4, 5);

        JTextArea descLabel = new JTextArea(description);
        descLabel.setLineWrap(true);
        descLabel.setWrapStyleWord(true);
        descLabel.setBackground(imageLabel.getBackground());
        descLabel.setEditable(false);
        add(descLabel, c);
    }

}
