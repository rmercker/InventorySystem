package UI;

import Items.Products;

/**
 * Created by dontf on 6/25/2018.
 */
public class ProductPanel extends ItemPanel {

    private Products product;

    public ProductPanel(Products product) {
        super (product.getImageURL (), product.getDescription ());
        this.product = product;
    }
}
