import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;

public class ComputeClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Compute comp = (Compute) registry.lookup("Compute");
            int digits = 20; // кількість значущих цифр
            BigDecimal pi = comp.computePi(digits);
            System.out.println("Computed value of Pi: " + pi);
        } catch (Exception e) {
            System.err.println("ComputeClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}