/**
 * Represents a rice meal with optional upsizing and extra sides.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /** Creates a regular meal with no extra sides. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the selected options.
     * @param name meal name
     * @param basePrice base price
     * @param itemCode item code
     * @param upsized true when upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /** @return base price plus option fees */
    @Override
    public double computePrice() {
        return basePrice + (upsized ? 20 : 0) + (12 * extraSides);
    }

    /** @return description with upsizing and side information */
    @Override
    public String getDescription() {
        return super.getDescription() + (upsized ? " Upsized" : " Regular")
                + ", " + extraSides + (extraSides == 1 ? " side" : " sides");
    }

    /** @return true if the meal is upsized */
    public boolean isUpsized() { return upsized; }

    /**
     * Sets the upsized option.
     * @param upsized requested option
     */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    /** @return number of extra sides */
    public int getExtraSides() { return extraSides; }

    /**
     * Sets the number of extra sides; negative values are rejected.
     * @param extraSides requested number of sides
     */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) this.extraSides = extraSides;
        else System.out.println("Error: extra sides cannot be negative.");
    }
}
