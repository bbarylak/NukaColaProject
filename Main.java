import java.io.IOException;
import java.util.*;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Inventory inventory = new Inventory();

        try
        {
            inventory.load();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        int input;
        boolean run = true;

        while(run)
        {
            System.out.println("\nWhat Would You Like To Do?");
            System.out.println("1: Show Inventory");
            System.out.println("2: Check Low Inventory");
            System.out.println("3: Add New Product");
            System.out.println("4: Add To Product Quantity");
            System.out.println("5: Subtract From Product Quantity");
            System.out.println("6: Delete Product");
            System.out.println("7: Save Changes");
            System.out.println("8: Exit");
            System.out.print("Input: ");

            input = in.nextInt();

            switch(input)
            {
                case 1 -> inventory.displayInventory();

                case 2 -> inventory.checkLowInventory();

                case 3 -> 
                {
                    String productName;
                    int productQuantity;
                    System.out.println("\nEnter Name Of Product To Add: ");
                    productName = in.next();
                    System.out.println("\nEnter Product Quantity: ");
                    productQuantity = in.nextInt();
                    try
                    {
                        inventory.addProduct(new Product(productName, productQuantity));
                    }
                    catch(InvalidInput e)
                    {
                        System.err.println("Error: " + e.getMessage());
                    }
                    System.out.println(productQuantity + " " + productName + " Added To Inventory");
                }

                case 4 ->
                {
                    String updateName;
                    int updateAmount;
                    System.out.println("\nEnter Name Of Product To Add To: ");
                    updateName = in.next();
                    System.out.println("\nEnter How Much To Add: ");
                    updateAmount = in.nextInt();
                    for (Product p : inventory.getProducts())
                    {
                        if(p.getName().equals(updateName))
                        {
                            try
                            {
                                inventory.updateProductAdd(p, updateAmount);
                                System.out.println(updateAmount + " " + updateName + " Added To Inventory");
                            }
                            catch(NegativeInException e)
                            {
                                System.err.println("\nError: " + e.getMessage());
                            }
                            break;
                        }
                    }
                }   

                case 5 ->
                {
                    String updateName;
                    int updateAmount;
                    System.out.println("\nEnter Name Of Product To Subtract From: ");
                    updateName = in.next();
                    System.out.println("\nEnter How Much To Subtract: ");
                    updateAmount = in.nextInt();
                    for (Product p : inventory.getProducts())
                    {
                        if(p.getName().equals(updateName))
                        {
                            try
                            {
                                inventory.updateProductSub(p, updateAmount);
                                System.out.println(updateAmount + " " + updateName + " Deleted From Inventory");
                            }
                            catch(NegativeOutException | NegativeInException e)
                            {
                                System.err.println("\nError: " + e.getMessage());
                            }
                            break;
                        }
                    }
                }

                case 6 -> 
                {
                    String removeName;
                    System.out.print("\nEnter Name Of Product To Delete: ");
                    removeName = in.next();
                    for (Product p : inventory.getProducts())
                    {
                        if(p.getName().equals(removeName))
                        {
                            try
                            {
                                inventory.removeProduct(p);
                            }
                            catch(ItemNotFound e)
                            {
                                System.err.println("Error: " + e.getMessage());
                            }
                            System.out.println(removeName + " Deleted From Inventory");
                            break;
                        }
                    }
                }

                case 7 -> 
                {
                    try
                    {
                        inventory.save();
                    }
                    catch(IOException e)
                    {
                        System.err.println("Error: " + e.getMessage());
                    }
                }

                case 8 ->
                {
                    run = false;
                    System.out.println("Exiting...");
                    in.close();
                }

                default -> System.out.println("\nInvalid Input, Please Try Again");
            }
        }
    }
}
