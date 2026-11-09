public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    public MenuItem() {
        this("Unnamed Item", 0.0, "N/A");
    }

    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name == null || name.trim().isEmpty() ? "Unnamed Item" : name;
        this.basePrice = 0.0;
        setBasePrice(basePrice);
        this.itemCode = itemCode == null || itemCode.trim().isEmpty() ? "N/A" : itemCode;
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: item name cannot be empty.");
    }

    public double getBasePrice() { return basePrice; }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) this.basePrice = basePrice;
        else System.out.println("Error: base price cannot be negative.");
    }

    public String getItemCode() { return itemCode; }

    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) this.itemCode = itemCode;
        else System.out.println("Error: item code cannot be empty.");
    }
}
