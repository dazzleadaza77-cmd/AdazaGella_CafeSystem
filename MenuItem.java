/**
 * Abstract parent class for all items sold by the Campus Cafe.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Creates an unnamed menu item with default values. */
    public MenuItem() {
        this("Unnamed Item", 0.0, "N/A");
    }

    /**
     * Creates a menu item with the supplied details.
     * @param name item name
     * @param basePrice base price in pesos
     * @param itemCode item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name == null || name.trim().isEmpty() ? "Unnamed Item" : name;
        this.basePrice = 0.0;
        setBasePrice(basePrice);
        this.itemCode = itemCode == null || itemCode.trim().isEmpty() ? "N/A" : itemCode;
    }

    /**
     * Computes the final price according to the concrete item type.
     * @return computed item price
     */
    public abstract double computePrice();

    /**
     * Returns the item's name and code.
     * @return item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return the item name */
    public String getName() { return name; }

    /**
     * Updates the item name when a nonblank value is supplied.
     * @param name new item name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: item name cannot be empty.");
    }

    /** @return the base price */
    public double getBasePrice() { return basePrice; }

    /**
     * Updates the base price; negative values are rejected.
     * @param basePrice new base price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) this.basePrice = basePrice;
        else System.out.println("Error: base price cannot be negative.");
    }

    /** @return the item code */
    public String getItemCode() { return itemCode; }

    /**
     * Updates the item code when a nonblank value is supplied.
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) this.itemCode = itemCode;
        else System.out.println("Error: item code cannot be empty.");
    }
}
