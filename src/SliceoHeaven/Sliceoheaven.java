package SliceoHeaven;

public class Sliceoheaven {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.takeOrder("1234","a pizza",30.00);
        pizzaStore.displayReceipt();

        PizzaStore pizzaStore1 = new PizzaStore();
        pizzaStore1.displayReceipt();


    }
}
