/**
 * Main driver for the Campus Cafe Ordering System.
 *
 * @author Dazzle Mc Kenzie Adaza and Anjo Gella
 * @version 1.0
 */
public class CafeApp {
    /**
     * Creates sample customers and menu items, then prints two receipts.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Demonstrate the three Customer constructor forms.
        Customer defaultCustomer = new Customer();
        Customer namedCustomer = new Customer("Ben Cruz");
        Customer student = new Customer("Ana Reyes", true);

        // Demonstrate default and parameterized constructors for menu subclasses.
        Beverage defaultDrink = new Beverage();
        defaultDrink.setName("Hot Chocolate");
        defaultDrink.setBasePrice(80);
        defaultDrink.setItemCode("B-02");
        defaultDrink.setSize("M");

        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry warmedPastry = new Pastry("Ensaymada", 45, "P-01", true);
        Pastry defaultPastry = new Pastry();
        Meal chickenAdobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        Meal defaultMeal = new Meal();

        // Demonstrate a setter rejecting invalid data.
        defaultDrink.setBasePrice(-5);

        Order order1 = new Order("1001", student);
        order1.addItem(latte);
        order1.addItem(warmedPastry);
        order1.addItem(chickenAdobo);
        order1.addItem(new Pastry("Cookie", 25, "P-02", false)); // Fourth item is rejected.
        order1.printReceipt();

        Order order2 = new Order("1002", namedCustomer);
        order2.addItem(defaultDrink);
        order2.addItem(new Meal("Beef Tapa", 130, "M-02", false, 0));
        order2.printReceipt(20);

        // Keep references to default-created objects to demonstrate construction.
        if (defaultCustomer.getName().equals("Guest") && defaultPastry.getBasePrice() == 0
                && defaultMeal.getBasePrice() == 0) {
            System.out.println("\nDefault constructors demonstrated successfully.");
        }
    }
}
