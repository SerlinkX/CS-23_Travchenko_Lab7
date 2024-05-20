import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            ComputeImpl obj = new ComputeImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Compute", obj);
            System.out.println("ComputeServer is ready.");
        } catch (Exception e) {
            System.err.println("ComputeServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}