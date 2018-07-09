package UI;

import Items.Materials;

/**
 * Created by dontf on 6/25/2018.
 */
public class MaterialPanel extends ItemPanel {

    private Materials material;

    public MaterialPanel(Materials material) {
        super (material.getImageURL (), material.getDescription ());
        this.material = material;
    }
}
