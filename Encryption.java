import java.math.BigInteger;
import java.util.Random;

public class Encryption {
    //TODO:  isGCDone(),
    private BigInteger p;
    private BigInteger q;
    public BigInteger n;
    private BigInteger phiN;
    public BigInteger e;
    private BigInteger d;
    private BigInteger x;

    public Encryption(BigInteger x) {
        this.x = x;

        Random rnd = new Random();

        p = BigInteger.probablePrime(10, rnd);
        q = BigInteger.probablePrime(9, rnd);
        //p = new BigInteger("3");
        //q = new BigInteger("11");
        n = q.multiply(p);
        phiN = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        computeE();
        computeD();
    }

    public void computeE() {
        do {
            e = ((phiN.add(new BigInteger("1"))).multiply(new BigInteger(Integer.toString((int) (Math.random() * 10000))))).divide(new BigInteger("10000")).subtract(new BigInteger("-1"));

        } while (phiN.gcd(e).compareTo(new BigInteger("1")) != 0);
    }


    public void computeD() {
        BigInteger tmp = phiN;
        while (d == null) {
            if (tmp.add(new BigInteger("1")).mod(e).equals(new BigInteger("0")))
                d = tmp.add(new BigInteger("1")).divide(e);
            else
                tmp = tmp.add(phiN);
        }
    }


    public BigInteger encryption() {
        return x.modPow(e, n);
    }

    public String getX() {
        return x.toString();
    }

    public BigInteger getD() {
        return d;
    }

}
