import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.math.BigDecimal;
import java.math.MathContext;

public class ComputeImpl extends UnicastRemoteObject implements Compute {

    protected ComputeImpl() throws RemoteException {
        super();
    }

    @Override
    public BigDecimal computePi(int digits) throws RemoteException {
        MathContext mc = new MathContext(digits);
        BigDecimal arctan1_5 = arctan(5, mc);
        BigDecimal arctan1_239 = arctan(239, mc);
        BigDecimal pi = arctan1_5.multiply(new BigDecimal(16)).subtract(arctan1_239.multiply(new BigDecimal(4)));
        return pi;
    }

    private BigDecimal arctan(int inverseX, MathContext mc) {
        BigDecimal result, numer, term;
        BigDecimal invX = new BigDecimal(inverseX);
        BigDecimal invX2 = invX.multiply(invX);
        numer = BigDecimal.ONE.divide(invX, mc);
        result = numer;
        int k = 1;

        while (true) {
            numer = numer.divide(invX2, mc);
            int denom = 2 * k + 1;
            term = numer.divide(new BigDecimal(denom), mc);
            if (term.equals(BigDecimal.ZERO)) {
                break;
            }
            if (k % 2 != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            k++;
        }
        return result;
    }
}