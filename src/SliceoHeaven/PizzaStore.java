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


    public void takeOrder1() {
        Scanner scanner = new Scanner(System.in);//构建输入流,用户方输入
        System.out.println("Enter three ingredients for your pizza (use spaces to separate\n" +
                "ingredients):");
        String temp = scanner.nextLine();//读取并缓存

       //将字符串分割成子字符串数组
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
        //解析日期字符串
        LocalDate dob = LocalDate.parse(birthdate);
        //获取当前日期
        LocalDate now = LocalDate.now();
        //计算两个LocalDate对象之间的时间间隔
        Period age = Period.between(dob, now);
        //检查年龄是否小于18岁，并且月份和日期是否与当前日期相同
        if (age.getYears() < 18 && dob.getMonth() == now.getMonth() && dob.getDayOfMonth() == now.getDayOfMonth()) {
            System.out.println("Congratulations!You pay only half the price for your order.");
        } else {

            System.out.println("Too bad!You do not meet the conditions to get our 50% discount.");
        }

    }

    public void makeCardPayment() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        //nextLong()方法读取输入的卡号，由于nextLong()方法不会读取换行符，所以需要nextLine()方法读取并丢弃换行符，否则影响后续的输入
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





        // 定义披萨选择枚举
        public enum PizzaSelection {
            PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
            HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
            VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
            BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
            EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

            private final String pizzaName;
            private final String pizzaToppings;
            private final int price;

            PizzaSelection(String pizzaName, String pizzaToppings, int price) {
                this.pizzaName = pizzaName;
                this.pizzaToppings = pizzaToppings;
                this.price = price;
            }

            public String getPizzaName() {
                return pizzaName;
            }

            public String getPizzaToppings() {
                return pizzaToppings;
            }

            public int getPrice() {
                return price;
            }

            @Override
            public String toString() {
                return String.format("%s Pizza with %s, for €%d", pizzaName, pizzaToppings, price);
            }
        }

        // 定义披萨配料枚举
        public enum PizzaToppings {
            HAM("Ham", 2),
            PEPPERONI("Pepperoni", 2),
            BEEF("Beef", 2),
            CHICKEN("Chicken", 2),
            SAUSAGE("Sausage", 2),
            PINEAPPLE("Pineapple", 1),
            ONION("Onion", 0.5),
            TOMATOES("Tomatoes", 0.4),
            GREEN_PEPPER("Green Pepper", 0.5),
            BLACK_OLIVES("Black Olives", 0.5),
            SPINACH("Spinach", 0.5),
            CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
            MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
            FETA_CHEESE("Feta Cheese", 1),
            PARMESAN_CHEESE("Parmesan Cheese", 1);

            private final String topping;
            private final double toppingPrice;

            PizzaToppings(String topping, double toppingPrice) {
                this.topping = topping;
                this.toppingPrice = toppingPrice;
            }

            public String getTopping() {
                return topping;
            }

            public double getToppingPrice() {
                return toppingPrice;
            }

            @Override
            public String toString() {
                return String.format("%s: €%.2f", topping, toppingPrice);
            }
        }

        // 定义披萨尺寸枚举
        public enum PizzaSize {
            LARGE("Large", 10),
            MEDIUM("Medium", 5),
            SMALL("Small", 0);

            private final String pizzaSize;
            private final int addToPizzaPrice;

            PizzaSize(String pizzaSize, int addToPizzaPrice) {
                this.pizzaSize = pizzaSize;
                this.addToPizzaPrice = addToPizzaPrice;
            }

            public String getPizzaSize() {
                return pizzaSize;
            }

            public int getAddToPizzaPrice() {
                return addToPizzaPrice;
            }

            @Override
            public String toString() {
                return String.format("%s: €%d", pizzaSize, addToPizzaPrice);
            }
        }

        // 定义配菜枚举
        public enum SideDish {
            CALZONE("Calzone", 15),
            CHICKEN_PUFF("Chicken Puff", 20),
            MUFFIN("Muffin", 12),
            NOTHING("No side dish", 0);

            private final String sideDishName;
            private final int addToPizzaPrice;

            SideDish(String sideDishName, int addToPizzaPrice) {
                this.sideDishName = sideDishName;
                this.addToPizzaPrice = addToPizzaPrice;
            }

            public String getSideDishName() {
                return sideDishName;
            }

            public int getAddToPizzaPrice() {
                return addToPizzaPrice;
            }

            @Override
            public String toString() {
                return String.format("%s: €%d", sideDishName, addToPizzaPrice);
            }
        }

        // 定义饮料枚举
        public enum Drinks {
            COCA_COLA("Coca Cola", 8),
            COCOA_DRINK("Cocoa Drink", 10),
            NOTHING("No drinks", 0);

            private final String drinkName;
            private final int addToPizzaPrice;

            Drinks(String drinkName, int addToPizzaPrice) {
                this.drinkName = drinkName;
                this.addToPizzaPrice = addToPizzaPrice;
            }

            public String getDrinkName() {
                return drinkName;
            }

            public int getAddToPizzaPrice() {
                return addToPizzaPrice;
            }

            @Override
            public String toString() {
                return String.format("%s: €%d", drinkName, addToPizzaPrice);
            }
        }

        // 定义披萨基础价格
        private static final double PIZZA_BASE_PRICE = 10.0;
        // 定义存储订单信息的数组
        private static final String[] pizzasOrdered = new String[10];
        private static final String[] pizzaSizesOrdered = new String[10];
        private static final String[] sideDishesOrdered = new String[20];
        private static final String[] drinksOrdered = new String[20];
        private static int pizzaIndex = 0;
        private static int sideDishIndex = 0;
        private static int drinkIndex = 0;
        private static double totalOrderPrice = 0;

        // 处理订单的方法
        public static void takeOrder() {
            Scanner scanner = new Scanner(System.in);
            boolean continueOrdering = true;

            while (continueOrdering) {
                // 展示披萨菜单
                System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
                PizzaSelection[] pizzaSelections = PizzaSelection.values();
                for (int i = 0; i < pizzaSelections.length; i++) {
                    System.out.println((i + 1) + ". " + pizzaSelections[i]);
                }
                System.out.println((pizzaSelections.length + 1) + ". Custom Pizza with a maximum of 10 toppings that you choose");
                System.out.print("Please enter your choice (1 - " + (pizzaSelections.length + 1) + "): ");

                int pizzaChoice = scanner.nextInt();
                scanner.nextLine();

                if (pizzaChoice >= 1 && pizzaChoice <= pizzaSelections.length) {
                    PizzaSelection selectedPizza = pizzaSelections[pizzaChoice - 1];
                    pizzasOrdered[pizzaIndex] = selectedPizza.toString();
                    totalOrderPrice += selectedPizza.getPrice();
                } else if (pizzaChoice == pizzaSelections.length + 1) {
                    // 处理定制披萨
                    System.out.println("Available toppings:");
                    PizzaToppings[] toppings = PizzaToppings.values();
                    for (int i = 0; i < toppings.length; i++) {
                        System.out.println((i + 1) + ". " + toppings[i]);
                    }

                    double customPizzaPrice = PIZZA_BASE_PRICE;
                    StringBuilder customPizzaToppings = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Enter topping choice (1 - " + toppings.length + ", or 0 to finish): ");
                        int toppingChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (toppingChoice == 0) {
                            break;
                        } else if (toppingChoice >= 1 && toppingChoice <= toppings.length) {
                            PizzaToppings selectedTopping = toppings[toppingChoice - 1];
                            customPizzaToppings.append(selectedTopping.getTopping()).append(", ");
                            customPizzaPrice += selectedTopping.getToppingPrice();
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                            i--;
                        }
                    }

                    if (customPizzaToppings.length() > 0) {
                        customPizzaToppings.setLength(customPizzaToppings.length() - 2);
                    }
                    String customPizzaDescription = String.format("Custom Pizza with %s, for €%.2f", customPizzaToppings, customPizzaPrice);
                    pizzasOrdered[pizzaIndex] = customPizzaDescription;
                    totalOrderPrice += customPizzaPrice;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                pizzaIndex++;

                // 选择披萨尺寸
                System.out.println("Available pizza sizes:");
                PizzaSize[] pizzaSizes = PizzaSize.values();
                for (int i = 0; i < pizzaSizes.length; i++) {
                    System.out.println((i + 1) + ". " + pizzaSizes[i]);
                }
                System.out.print("Please enter your pizza size choice (1 - " + pizzaSizes.length + "): ");
                int sizeChoice = scanner.nextInt();
                scanner.nextLine();
                PizzaSize selectedSize = pizzaSizes[sizeChoice - 1];
                pizzaSizesOrdered[pizzaIndex - 1] = selectedSize.toString();
                totalOrderPrice += selectedSize.getAddToPizzaPrice();

                // 选择配菜
                System.out.println("Available side dishes:");
                SideDish[] sideDishes = SideDish.values();
                for (int i = 0; i < sideDishes.length; i++) {
                    System.out.println((i + 1) + ". " + sideDishes[i]);
                }
                System.out.print("Please enter your side dish choice (1 - " + sideDishes.length + "): ");
                int sideDishChoice = scanner.nextInt();
                scanner.nextLine();
                SideDish selectedSideDish = sideDishes[sideDishChoice - 1];
                sideDishesOrdered[sideDishIndex] = selectedSideDish.toString();
                totalOrderPrice += selectedSideDish.getAddToPizzaPrice();
                sideDishIndex++;

                // 选择饮料
                System.out.println("Available drinks:");
                Drinks[] drinks = Drinks.values();
                for (int i = 0; i < drinks.length; i++) {
                    System.out.println((i + 1) + ". " + drinks[i]);
                }
                System.out.print("Please enter your drink choice (1 - " + drinks.length + "): ");
                int drinkChoice = scanner.nextInt();
                scanner.nextLine();
                Drinks selectedDrink = drinks[drinkChoice - 1];
                drinksOrdered[drinkIndex] = selectedDrink.toString();
                totalOrderPrice += selectedDrink.getAddToPizzaPrice();
                drinkIndex++;

                // 询问是否继续下单
                System.out.print("Do you want to order more? (yes/no): ");
                String continueInput = scanner.nextLine();
                continueOrdering = continueInput.equalsIgnoreCase("yes");
            }
        }

        // 重写toString方法展示订单详情
        @Override
        public String toString() {
            StringBuilder orderDetails = new StringBuilder("Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
            for (int i = 0; i < pizzaIndex; i++) {
                orderDetails.append((i + 1)).append(". ").append(pizzasOrdered[i]).append("\n");
                if (i < pizzaSizesOrdered.length && pizzaSizesOrdered[i] != null) {
                    orderDetails.append("   ").append(pizzaSizesOrdered[i]).append("\n");
                }
                if (i < sideDishesOrdered.length && sideDishesOrdered[i] != null) {
                    orderDetails.append("   ").append(sideDishesOrdered[i]).append("\n");
                }
                if (i < drinksOrdered.length && drinksOrdered[i] != null) {
                    orderDetails.append("   ").append(drinksOrdered[i]).append("\n");
                }
                orderDetails.append("\n");
            }
            orderDetails.append("ORDER TOTAL: €").append(totalOrderPrice);
            return orderDetails.toString();
        }



}

