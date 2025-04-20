import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        System.out.println("1: Display Inventory");
        System.out.println("2: Check Low Inventory");
        System.out.println("3: Add Product");
        System.out.println("4: Remove Product");
        System.out.println("5: Exit");
        System.out.println("Input: ");

        uInput = scanner.nextInt();
        scanner.nextLine();
       

          switch (choice) {
                case 1:
                    inventory.displayInventory();
                    break;

                case 2:
                    inventory.checkLowInventory();
                    break;

                case 3:
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine(); 
                    inventory.addProduct(new Product(productName, productQuantity));
                    System.out.println(productName + " added to inventory.");
                    break;

                case 4:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    Product toRemove = inventory.findProductByName(removeName);
                    if (toRemove != null) {
                        inventory.removeProduct(toRemove);
                        System.out.println(removeName + " removed from inventory.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... ");
                    break;

                  
    }
}
