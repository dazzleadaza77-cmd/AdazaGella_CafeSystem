/**
 * Represents a baked item that may be warmed for an extra fee.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private boolean warmed;

    /** Creates a pastry that is not warmed. */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry and sets its warmed status.
     * @param name pastry name
     * @param basePrice base price
     * @param itemCode item code
     * @param warmed true when the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /** @return base price plus 10 pesos when warmed */
    @Override
    public double computePrice() {
        if (warmed) return basePrice + 10;
        return basePrice;
    }

    /** @return item description with warmed status when applicable */
    @Override
    public String getDescription() {
        if (warmed) return super.getDescription() + " (Warmed)";
        return super.getDescription();
    }

    /** @return true if the pastry is warmed */
    public boolean isWarmed() { return warmed; }

    /**
     * Changes the warmed status.
     * @param warmed requested warmed status
     */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
