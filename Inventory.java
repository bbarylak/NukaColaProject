import java.io.*;
import java.util.*;
public class Inventory implements Serializable
{
    private ArrayList<Product> storage;

    public Inventory() 
    {
        storage = new ArrayList<>();
    }

    public void addProduct(Product product) throws InvalidInput
    {
        storage.add(product);
    }

    public void updateProductAdd(Product product, int addAmount) throws NegativeInException
    {
        int newQuantity;
        if(addAmount < 0)
        {
            throw new NegativeInException("Input Cannot Be Negative.");
        }
        newQuantity = product.getQuantity() + addAmount;
            product.setQuantity(newQuantity);
    }

    public void updateProductSub(Product product, int subAmount) throws NegativeOutException, NegativeInException
    {
        int newQuantity;
        if(subAmount < 0)
        {
            throw new NegativeInException("Input Cannot Be Negative.");
        }
        newQuantity = product.getQuantity() - subAmount;
        if(newQuantity < 0)
        {
            throw new NegativeOutException("Cannot Subtract More Product Than Is Present.");
        }
        else 
        {
            product.setQuantity(newQuantity);
        }
    }

    public void removeProduct(Product product) throws ItemNotFound
    {
        storage.remove(product);
    }

    public void checkLowInventory() 
    {
        for (Product product : storage) 
        {
            if (product.getQuantity() <= 100)
            {
                System.out.println(product.getName() + " is low on inventory. Current quantity is: " + product.getQuantity());
            }
        }
    }

    public void displayInventory()
    {
        System.out.println();
        for (Product product : storage)
        {
            System.out.println(product.getName() + ": " + product.getQuantity() + " units");
        }
    }

    public ArrayList<Product> getProducts() 
    {
        return storage;
    }

    public void save() throws IOException
    {
        String filename = "Inventory.csv";
        try (FileOutputStream fos = new FileOutputStream(filename); ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(storage);
            System.out.println("\nSave Successful");
        }
        catch(IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void load() throws ClassNotFoundException, IOException
    {
        String filename = "Inventory.csv";
        ArrayList<Product> loadInv;
        try (FileInputStream fis = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(fis))
        {
            
            loadInv = (ArrayList<Product>) ois.readObject();
            storage = loadInv;
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class NegativeOutException extends Exception 
{
    public NegativeOutException(String message)
    {
        super(message);
    }
}

class NegativeInException extends Exception
{
    public NegativeInException(String message)
    {
        super(message);
    }
}

class ItemNotFound extends Exception
{
    public ItemNotFound(String message)
    {
        super(message);
    }
}

class InvalidInput extends Exception
{
    public InvalidInput(String message)
    {
        super(message);
    }
}