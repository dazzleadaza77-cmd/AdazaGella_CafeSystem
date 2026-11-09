/**
 * Represents a customer and tracks the customer's loyalty points.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Creates a non-student customer with no loyalty points. */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a non-student customer with the given name.
     * @param name customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with name and student status.
     * @param name customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = "Guest";
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds a specified number of loyalty points.
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points >= 0) loyaltyPoints += points;
        else System.out.println("Error: points cannot be negative.");
    }

    /**
     * Adds one point for every 50 pesos spent.
     * @param amountSpent eligible amount spent
     */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) addPoints((int) (amountSpent / 50));
        else System.out.println("Error: amount spent cannot be negative.");
    }

    /** @return customer name */
    public String getName() { return name; }

    /**
     * Updates the customer name when nonblank.
     * @param name new customer name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: customer name cannot be empty.");
    }

    /** @return true if customer is a student */
    public boolean isStudent() { return student; }

    /**
     * Updates student status.
     * @param student new student status
     */
    public void setStudent(boolean student) { this.student = student; }

    /** @return current loyalty points */
    public int getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Updates loyalty points; negative values are rejected.
     * @param loyaltyPoints new loyalty point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) this.loyaltyPoints = loyaltyPoints;
        else System.out.println("Error: loyalty points cannot be negative.");
    }
}
