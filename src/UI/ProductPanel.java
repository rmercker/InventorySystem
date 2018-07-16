package UI;

import Items.Products;

import java.awt.*;

/**
 * Created by dontf on 6/25/2018.
 */
public class ProductPanel extends ItemPanel {

    private Products product;

    public ProductPanel(Products product, boolean small, int width, int height) {
        super (product.getImageURL (), product.getDescription (), small, width, height);
        this.product = product;
    }
}
