package UI;

import Items.Materials;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dontf on 6/25/2018.
 */
public class MaterialPanel extends ItemPanel {

    private Materials material;

    public MaterialPanel(Materials material, boolean small, int width, int height) {
        super (material.getImageURL (), material.getDescription (), true, width, height);
        this.material = material;

        setUpMaterialDisplay (material, small, width, height);
    }

    private void setUpMaterialDisplay (Materials material, boolean small, int width, int height) {
        if (small) {
            setType(material.getType(),0, 5, 2, 1);
            setSupplier(material.getSupplier(), 1, 6, 2, 1);
        } else {
            // TODO: add large panel display setup
        }
    }

    private void setType (String type, int x, int y, int width, int height) {
        JLabel itemType = new JLabel();
        itemType.setText("Type: " + type);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 10);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        add (itemType, c);
    }

    private void setSupplier (String supplier, int x, int y, int width, int height) {
        JLabel itemSupplier = new JLabel();
        itemSupplier.setText("Supplier: " + supplier);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 10);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        add (itemSupplier, c);
    }
}
