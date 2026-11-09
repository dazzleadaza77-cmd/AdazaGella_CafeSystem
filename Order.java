/**
 * Connects one customer with up to three menu items and prints a receipt.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private boolean pointsAwarded;

    /**
     * Creates an order for a customer.
     * @param orderId unique order identifier
     * @param customer customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId == null ? "N/A" : orderId;
        this.customer = customer == null ? new Customer() : customer;
        itemCount = 0;
        pointsAwarded = false;
    }

    /**
     * Places an item in the first empty slot.
     * @param item menu item to add
     * @return true when added successfully
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Error: cannot add an empty item.");
            return false;
        } else if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        } else if (item1 == null) item1 = item;
        else if (item2 == null) item2 = item;
        else item3 = item;
        itemCount++;
        return true;
    }

    /** @return sum of all non-null item prices */
    public double computeSubtotal() {
        double subtotal = 0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    /** @return subtotal after the student discount, if applicable */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        if (customer.isStudent()) return subtotal - (subtotal * 0.10);
        else return subtotal;
    }

    /**
     * Applies a voucher after the student discount; total cannot be negative.
     * @param voucher voucher amount to subtract
     * @return final total
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        if (voucher > 0) total -= voucher;
        if (total < 0) total = 0;
        return total;
    }

    /** Prints item details, totals, discount, and updated loyalty points. */
    public void printReceipt() {
        System.out.println("\nOrder #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;
        double total = computeTotal();
        System.out.printf("  Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) System.out.printf("  Student discount (10%%): -%.2f%n", discount);
        System.out.printf("  TOTAL: %.2f%n", total);
        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Prints a receipt with a voucher applied.
     * @param voucher voucher amount
     */
    public void printReceipt(double voucher) {
        System.out.println("\nOrder #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;
        double total = computeTotal(voucher);
        System.out.printf("  Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) System.out.printf("  Student discount (10%%): -%.2f%n", discount);
        if (voucher > 0) System.out.printf("  Voucher: -%.2f%n", Math.min(voucher, computeTotal()));
        System.out.printf("  TOTAL: %.2f%n", total);
        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
    }

    private void printItem(MenuItem item) {
        if (item != null)
            System.out.printf("  %-48s %.2f%n", item.getDescription(), item.computePrice());
    }

    /** @return customer associated with the order */
    public Customer getCustomer() { return customer; }

    /**
     * Replaces the customer when a non-null customer is supplied.
     * @param customer new customer
     */
    public void setCustomer(Customer customer) {
        if (customer != null) this.customer = customer;
        else System.out.println("Error: customer cannot be null.");
    }

    /** @return number of items in the order */
    public int getItemCount() { return itemCount; }

    /** @return order identifier */
    public String getOrderId() { return orderId; }

    /**
     * Updates the order identifier when nonblank.
     * @param orderId new order identifier
     */
    public void setOrderId(String orderId) {
        if (orderId != null && !orderId.trim().isEmpty()) this.orderId = orderId;
        else System.out.println("Error: order ID cannot be empty.");
    }
}
