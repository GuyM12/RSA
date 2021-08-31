import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter X (1<X<99999): \n");
        String input = sc.next();
        while (Integer.parseInt(input) > 99999 || Integer.parseInt(input) < 1) {
            input = sc.next();
            System.out.println("ERROR! the X you entered does not obtain the requirements... please enter again ");
        }
        Encryption e = new Encryption(new BigInteger(input));
        Decryption d = new Decryption(e.n, e.getD(), e.encryption());
        System.out.println("GENERATING KEY...");
        System.out.println("KEY Generated Successfully: " + e.getX().equals(d.getX()));
        System.out.println(e.encryption());
        System.out.println(d.getX());

    }


}
