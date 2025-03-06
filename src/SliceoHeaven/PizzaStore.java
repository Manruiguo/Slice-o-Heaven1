package SliceoHeaven;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

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

    public String ing1;
    public String ing2;
    public String ing3;
    public String pizzaSize;
    public String extraCheese;
    public String sideDish;
    public String wantDiscount;
    public int cvv;
    private long cardNumber;
    private int cardLength;

    public String cardNumberToDisplay;


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


    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);//构建输入流
        System.out.println("Enter three ingredients for your pizza (use spaces to separate\n" +
                "ingredients):");
        String temp = scanner.nextLine();//缓存

        ing1 = temp.split(" ")[0];
        ing2 = temp.split(" ")[1];
        ing3 = temp.split(" ")[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        pizzaSize = scanner.nextLine();
        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.nextLine();
        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sideDish = scanner.nextLine();
        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        drinks = scanner.nextLine();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount = scanner.nextLine();
        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }

        makePizza();
        printReceipt();

    }

    public void isItYourBirthday() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birthdate(yyyy-MM-dd)");

        String birthdate = input.nextLine();
        LocalDate dob = LocalDate.parse(birthdate);
        LocalDate now = LocalDate.now();
        Period age = Period.between(dob, now);
        if (age.getYears() < 18 && dob.getMonth() == now.getMonth() && dob.getDayOfMonth() == now.getDayOfMonth()) {
            System.out.println("Congratulations!You pay only half the price for your order.");
        } else {

            System.out.println("Too bad!You do not meet the conditions to get our 50% discount.");
        }

    }

    public void makeCardPayment() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();scanner.nextLine();
        System.out.println("Enter the card's expiry date(yyyy-MM):");
        String expiryDate = scanner.nextLine();
        System.out.println("Enter the card's cvv:");
        this.cvv = scanner.nextInt();
        System.out.println("cvv:"+ this.cvv);

        processCardPayment(cardNumber,expiryDate,cvv);

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


    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {

        this.cardNumber = cardNumber;
        cardLength = Long.toString(cardNumber).length();



        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
        System.out.println("First digit of the card: " + firstCardDigit);

        String blacklistedNumber = "********";

        if (Long.toString(cardNumber).equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card.");
        }

        int lastFourDigits = Integer.parseInt(Long.toString(cardNumber).substring(9, 13));

        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(cardNumber).charAt(0));
        for (int i = 1; i < cardLength - 4; i++) {
            sb.append('*');
        }
        sb.append(Long.toString(cardNumber).substring(9, 13));

        String cardNumberToDisplay = sb.toString();
        System.out.println("Card number to display: " + cardNumberToDisplay);


    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder displayInfo = new StringBuilder();
        displayInfo.append("Pizza of the day: ").append(pizzaOfTheDay);
        displayInfo.append("\nSide of the day: ").append(sideOfTheDay);
        displayInfo.append("\nSpecial price: ").append(specialPrice);

        System.out.println(displayInfo.toString());
    }
}

