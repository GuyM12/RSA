import java.math.BigInteger;

public class Decryption {

    private BigInteger x;

    public Decryption(BigInteger n, BigInteger d, BigInteger encryption){

        x = decrypt(n, d, encryption);
    }

    public BigInteger decrypt(BigInteger n, BigInteger d, BigInteger encryption){
        return encryption.modPow(d,n);
    }


    public String getX(){
        return x.toString();
    }
}
