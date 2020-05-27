import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class RSADecrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "";
		String line = null;
		String dString = "";
		String nString = "";
		String message = "";
		
		FileReader file = null;
		
		//reads from private key
		try {
			file = new FileReader("pri_key.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader read = new BufferedReader(file);
		try {
			line = read.readLine();
			System.out.println(line);
			dString = line.substring(2, line.length());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		key += line;
		try {
			line = read.readLine();
			System.out.println(line);
			nString = line.substring(2, line.length());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BigInteger d = new BigInteger(dString);
		BigInteger n = new BigInteger(nString);

		//reads from test.enc
		try (BufferedReader reader = new BufferedReader(new FileReader("test.enc"))) {
		    String line2;
		    while ((line2 = reader.readLine()) != null) {
				String plaintext = String.format("%08d",new BigInteger(line2).modPow(d, n));
				
				
				//Combines two integer
				String char1 = plaintext.charAt(0) + "" + plaintext.charAt(1);
				String char2 = plaintext.charAt(2) + "" + plaintext.charAt(3);
				String char3 = plaintext.charAt(4) + "" + plaintext.charAt(5);
				String char4 = plaintext.charAt(6) + "" + plaintext.charAt(7);
				
				//System.out.print(RSAEncrypt.printASCII(char1) + RSAEncrypt.printASCII(char2) + RSAEncrypt.printASCII(char3)) ;
				
				System.out.println("plaintext: " + plaintext);
				
				System.out.println("char 1:" + char1);
				System.out.println("char 2:" + char2);
				System.out.println("char 3:" + char3);
				System.out.println("char 4:" + char4);
				
				//Writes test.dec
				PrintWriter writer;
				try {
					System.out.println("does it reach here?");
					writer = new PrintWriter(new FileOutputStream("test.dec", true));
					writer.println(RSAEncrypt.printASCII(char1) + RSAEncrypt.printASCII(char2) + RSAEncrypt.printASCII(char3) + RSAEncrypt.printASCII(char4));
					//writer.println(char2);
					//writer.println(char3);
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}
	
	
}
