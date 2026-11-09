public class CafeApp {
 
    public static void main(String[] args) {
       
        Customer defaultCustomer = new Customer();
        Customer namedCustomer = new Customer("Dazzle Mc Kenzie Adaza");
        Customer student = new Customer("Anjo Gella", true);

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
