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

        int uInput = input.nextInt();
        scanner.nextLine();

        boolean run = true
       
        while (run)
          switch (uInput) {
                case 1:
                    inventory.displayInventory();
                    break;

                case 2:
                    inventory.checkLowInventory();
                    break;

                case 3:
                    System.out.print("Enter Product Name to Add: ");
                    String productName = input.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int productQuantity = input.nextInt();
                    input.nextLine(); 
                    inventory.addProduct(new Product(productName, productQuantity));
                    System.out.println(productName + " added to inventory.");
                    break;

                case 4:
                    System.out.print("Enter Product Name to Remove: ");
                    String removeName = input.nextLine();

                    for (Product p : inventory.getProducts()) {
                        if (p.getName().equals(removeName)) {
                            inventory.removeProduct(p);
                            System.out.println(removeName + " Removed from Inventory.");
                            break;
                        }
                    }
                    break;
                    
                case 5:
                    run = false;
                    System.out.println("Exiting... ");
                    input.close();
                    break;

                default:
                    System.out.println("\nInvalid Input, Please Try Again")
                  
    }
}
