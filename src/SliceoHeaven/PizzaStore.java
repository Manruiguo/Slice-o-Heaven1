package SliceoHeaven;

public class PizzaStore {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;

    public String storeMenu;
    public String pizzaIngredients;//披萨原料
    public String pizzaPrice;

    public String sides;//配菜小食
    public String drinks;
    private String orderID;
    private double orderTotal;

    private final String DEF_ORDER_ID = "DEF - SOH - 099";
    private final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private final double DEF_ORDER_TOTAL = 15.00;

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public PizzaStore() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "无";
        this.drinks = "无";
    }


    public void takeOrder(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = "nothing";
        this.drinks = "nothing";

        makePizza();

    }

    public void makePizza() {
        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");

        System.out.println("Your order is ready!");

    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");

        System.out.println("Order ID: " + orderID);
        System.out.println("Order Details: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
        System.out.println("小食: " + sides);
        System.out.println("饮料: " + drinks);
    }

    public void displayReceipt() {
        printReceipt();
    }


    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();

        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        System.out.println("First digit of the card: " + firstCardDigit);

        String blacklistedNumber = "********";

        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card.");
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardLength - 4));

        StringBuilder sb = new StringBuilder();
        sb.append(cardNumber.charAt(0));
        for (int i = 1; i < cardLength - 4; i++) {
            sb.append('*');
        }
        sb.append(cardNumber.substring(cardLength - 4));

        String cardNumberToDisplay = sb.toString();
        System.out.println("Card number to display: " + cardNumberToDisplay);



    }
    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice){
        StringBuilder displayInfo = new StringBuilder();
        displayInfo.append("Pizza of the day: ").append(pizzaOfTheDay);
        displayInfo.append("\nSide of the day: ").append(sideOfTheDay);
        displayInfo.append("\nSpecial price: ").append(specialPrice);

        System.out.println(displayInfo.toString());
    }
}
