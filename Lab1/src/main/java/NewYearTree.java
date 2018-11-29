public class NewYearTree {
    private double height;
    private double price;
    private String name;
    private String material;

    NewYearTree(String name, double height, int price, String material) {
        setName(name);
        setHeight(height);
        setPrice(price);
        setMaterial(material);
    }

    @Override
    public String toString() {
        return "Manufacturer name " + getName() + " Height in cm: " + getHeight() + " Price: " + getPrice() + " Material: " + getMaterial();
    }

    private String getMaterial() {
        return material;
    }

    private void setMaterial(String material) {
        this.material = material;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}