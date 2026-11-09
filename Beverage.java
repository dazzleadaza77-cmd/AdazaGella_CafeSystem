/**
 * Represents a drink whose price depends on its size.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /** Creates a small beverage with default item details. */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage with a selected size.
     * @param name beverage name
     * @param basePrice base price
     * @param itemCode item code
     * @param size S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /** @return price based on beverage size */
    @Override
    public double computePrice() {
        if (size.equals("M")) return basePrice + 15;
        else if (size.equals("L")) return basePrice + 25;
        else return basePrice;
    }

    /** @return item description including size */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /** @return beverage size */
    public String getSize() { return size; }

    /**
     * Sets size only when it is S, M, or L.
     * @param size requested size
     */
    public void setSize(String size) {
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L")))
            this.size = size;
        else System.out.println("Error: size must be S, M, or L.");
    }
}
