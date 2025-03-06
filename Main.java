public class Main 
{
    public static void main(String[] args) 
    {
        Inventory inventory = new Inventory();

        Product product1 = new Product("Apples", 1000);
        Product product2 = new Product("Pears", 500);
        Product product3 = new Product("Oranges", 75);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        System.out.println("\nCurrent inventory:");
        inventory.displayInventory();

        System.out.println("\nCheck low inventory:");
        inventory.checkLowInventory();

        System.out.println("\nRemove Pears from inventory:");
        inventory.removeProduct(product2);

        System.out.println("\nAgain check low inventory: ");
        inventory.checkLowInventory();
    }
}
