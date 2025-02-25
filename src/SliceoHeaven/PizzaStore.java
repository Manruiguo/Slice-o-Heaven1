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

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }
    public String getOrderID(){
        return orderID;
    }

    public void setOrderTotal(int orderTotal){
        this.orderTotal= orderTotal;
    }
    public double getOrderTotal(){
        return getOrderTotal();
    }

    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients = pizzaIngredients;
    }
    public String getPizzaIngredients(){
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

    public void makePizza(){
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
}