package UI;

import Items.Products;

import java.awt.*;

/**
 * Created by dontf on 6/25/2018.
 */
public class ProductPanel extends ItemPanel {

    private Products product;

    public ProductPanel(Products product, boolean small) {
        super (product.getImageURL (), product.getDescription (), small);
        this.product = product;
    }
}
