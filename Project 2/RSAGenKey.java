
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
public class RSAGenKey {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter p q e: "); 
		BigInteger p = scanner.nextBigInteger(); 
		BigInteger q = scanner.nextBigInteger();
		BigInteger e = scanner.nextBigInteger();
	//	BigInteger f = BigInteger.valueOf(e);

		BigInteger one = new BigInteger("1");		
		BigInteger n = p.multiply(q);
		BigInteger N = (p.subtract(one)).multiply((q.subtract(one))); // ø(n) = (p-1) * (q-1)
		BigInteger d = e.modInverse(N);
		System.out.println("The public key is" +"( " + e+" , "+ n + " )"); //KU={e,n}
		System.out.println("The private key is" +"( " + d+" , "+n + " )"); //KR={d,n}
		
		PrintWriter writer = new PrintWriter(new FileOutputStream("pub_key.txt", false));
		writer.println("e="+e);
		writer.println("n="+n);
		writer.close();
		
		PrintWriter writer1 = new PrintWriter(new FileOutputStream("pri_key.txt", false));
		writer1.println("d="+d);
		writer1.println("n="+n);
		writer1.close();





//		File pub = new File("c:\\pub_key.txt");
//		File priv = new File("c:\\pri_key.txt");
//
//		//Write Content
//		FileWriter writer1 = new FileWriter(pub);
//		writer1.write("e = " + e);
//		writer1.write(System.lineSeparator());
//		writer1.write("n = " + n);
//		writer1.close();
//		
//		FileWriter writer2 = new FileWriter(priv);
//		writer2.write("d = " + d);
//		writer2.write(System.lineSeparator());
//		writer2.write("n = " + n);
//		writer2.close();
		



	}


}