package Items;

/**
 * Created by dontf on 5/18/2018.
 */
public class Materials {

    private String type;
    private double cost;
    private double units;
    private String supplier;
    private String quality;
    private String imageURL;
    private String desc;

    public Materials (String type, double cost, double units, String supplier, String quality, String imageURL, String description) {
        this.type = type;
        this.cost = cost;
        this.units = units;
        this.supplier = supplier;
        this.quality = quality;
        this.imageURL = imageURL;
        this.desc = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public String getDescription () { return desc; }

    public void setDescription (String description) { this.desc = description; }
}
