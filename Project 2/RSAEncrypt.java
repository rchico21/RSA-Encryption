import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class RSAEncrypt {

	public static void main(String [] args) {
		String key = "";
		String line = null;
		String eString = "";
		String nString = "";
		
		
		
//		System.out.println(test.length());
		
		//Reads public key
		FileReader file = null;
		try {
			file = new FileReader("pub_key.txt");
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		BufferedReader read = new BufferedReader(file);
		try {
			line = read.readLine();
			System.out.println(line);
			eString = line.substring(2, line.length());
		} catch(IOException exception) {
			exception.printStackTrace();
		}
		
		key += line;
		
		try {
			line = read.readLine();
			System.out.println(line);
			nString = line.substring(2, line.length());
		} catch(IOException exception) {
			exception.printStackTrace();
		}
		
		BigInteger e = new BigInteger(eString);
		BigInteger n = new BigInteger(nString);
		
		BufferedReader reader = null;
		//Reads test file
		try {
			reader = new BufferedReader(new FileReader("test.txt"));
		} catch(FileNotFoundException exception) {
			exception.printStackTrace();
		}
		String message = "";
		try {
			StringBuilder builder = new StringBuilder();
			String current = null;
			try {
				current = reader.readLine();
			} catch(IOException exception) {
				exception.printStackTrace();
			}
			while (current != null) {
				builder.append(current);
				builder.append(System.lineSeparator());
				
				try {
					current = reader.readLine();
				} catch(IOException exception) {
					exception.printStackTrace();
				}
			}
			//replaces newline and carriage return
			message = builder.toString().replaceAll("(\\r|\\n)", "").toUpperCase();
		} finally {
			try {
				reader.close();
			} catch(IOException exception) {
				exception.printStackTrace();
			}
		}
//		System.out.println(message);
//		System.out.println(message.length());
		
	//	String format = "";
		int count = 1;
		for(int i = 0; i < message.length(); i += 4) {
	//		char change = (char)((test.charAt(i)));
	//		System.out.println(count++);
			System.out.println(String.format("%02d", Convert(message.charAt(i))) + "");
			String format = String.format("%02d", Convert(message.charAt(i))) + "" + String.format("%02d", Convert(message.charAt(i+1))) + "" +String.format("%02d", Convert(message.charAt(i+2))) + ""+String.format("%02d", Convert(message.charAt(i+3))) + "";
	//		String format1 = String.Convert(message.charAt(i));
			//		System.out.println(format);
	//		System.out.println(format);
			BigInteger integer = new BigInteger(format);
			integer = new BigInteger(String.format("%08d", integer));
	//		System.out.println("does it reach here?");
			
			//Encoded message
			System.out.println(String.format("%08d", integer));
			//System.out.println(integer.modPow(e, n)); 
			BigInteger cipherText = integer.modPow(e, n);
			
		//Writes text file
				PrintWriter writer;
				try {
					writer = new PrintWriter(new FileOutputStream("test.enc", true));
					writer.println(cipherText);
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		//	System.out.println(String.format("%06d",new BigInteger("2627674").modPow(new BigInteger("11296191"), n))); 

		}
		
		
		
	}
	 
	/**
	 * <p>Title: CASCII</p>
	 * <p>Description: A Compact ASCII data format</p>
	 * <p>Copyright: Copyright (c) 2003</p>
	 * <p>Company: University of Pennsylvania</p>
	 * @author Michael May
	 * @version 1.0
	 */
	
	 public static byte Convert(char c){
	    // substitute the old char for our CASCII value
	    switch ( c )
	    {
	      case 'A':
	        return A;

	      case 'B':
	        return B;

	      case 'C':
	        return C;

	      case 'D':
	        return D;

	      case 'E':
	        return E;

	      case 'F':
	        return F;

	      case 'G':
	        return G;

	      case 'H':
	        return H;

	      case 'I':
	        return I;

	      case 'J':
	        return J;

	      case 'K':
	        return K;

	      case 'L':
	        return L;

	      case 'M':
	        return M;

	      case 'N':
	        return N;

	      case 'O':
	        return O;

	      case 'P':
	        return P;

	      case 'Q':
	        return Q;

	      case 'R':
	        return R;

	      case 'S':
	        return S;

	      case 'T':
	        return T;

	      case 'U':
	        return U;

	      case 'V':
	        return V;

	      case 'W':
	        return W;

	      case 'X':
	        return X;

	      case 'Y':
	        return Y;

	      case 'Z':
	        return Z;

	      case '?':
	        return Question;

	      case '\'':
	        return Apostrophe;

	      case ':':
	        return Colon;

	      case ',':
	        return Comma;

	      case '.':
	        return Period;

	      case ' ':
	        return Space;

	      default:
	        throw new java.lang.IllegalArgumentException(
	            "Character must be upper case A-Z or { '\'', ':', ',', '.', '?', ' '} -- found: " + c);
	    }
	    
	  }
	 
	 public static char Convert( byte[] bits, int start, int end)
	  {
	    // check that it's 5 bits long only
	    if ( end - start != 4 )
	    {
	      throw new java.lang.IllegalArgumentException("Argument must only be five bits long");
	    }

	    // now find out what number this is
	    int val = 0;
	    for ( int i = start; i <= end; i++)
	    {
	      // each bit over is a raising of the power of two
	      // multiply it by the bit value - one or zero
	      val += java.lang.Math.pow(2, i-start) * bits[i];
	    }

	    // now value is the number for the letter
	    switch ( val )
	    {
	      case 0:
	        return 'A';
	      case 1:
	        return 'B';
	      case 2:
	        return 'C';
	      case 3:
	        return 'D';
	      case 4:
	        return 'E';
	      case 5:
	        return 'F';
	      case 6:
	        return 'G';
	      case 7:
	        return 'H';
	      case 8:
	        return 'I';
	      case 9:
	        return 'J';
	      case 10:
	        return 'K';
	      case 11:
	        return 'L';
	      case 12:
	        return 'M';
	      case 13:
	        return 'N';
	      case 14:
	        return 'O';
	      case 15:
	        return 'P';
	      case 16:
	        return 'Q';
	      case 17:
	        return 'R';
	      case 18:
	        return 'S';
	      case 19:
	        return 'T';
	      case 20:
	        return 'U';
	      case 21:
	        return 'V';
	      case 22:
	        return 'W';
	      case 23:
	        return 'X';
	      case 24:
	        return 'Y';
	      case 25:
	        return 'Z';
	      case 26:
	        return ' ';
	      case 27:
	        return ',';
	      case 28:
	        return '?';
	      case 29:
	        return ':';
	      case 30:
	        return '.';
	      case 31:
	        return '\'';

	      default:
	        throw new java.lang.IllegalArgumentException("Argument must be be on interval [0, 31]");
	      }
	  }

	 
	 public static String printASCII(String charIn) {
		    switch ( charIn )
		    {
		      case "00":
		        return "A";
		      case "01":
		        return "B";
		      case "02":
		        return "C";
		      case "03":
		        return "D";
		      case "04":
		        return "E";
		      case "05":
		        return "F";
		      case "06":
		        return "G";
		      case "07":
		        return "H";
		      case "08":
		        return "I";
		      case "09":
		        return "J";
		      case "10":
		        return "K";
		      case "11":
		        return "L";
		      case "12":
		        return "M";
		      case "13":
		        return "N";
		      case "14":
		        return "O";
		      case "15":
		        return "P";
		      case "16":
		        return "Q";
		      case "17":
		        return "R";
		      case "18":
		        return "S";
		      case "19":
		        return "T";
		      case "20":
		        return "U";
		      case "21":
		        return "V";
		      case "22":
		        return "W";
		      case "23":
		        return "X";
		      case "24":
		        return "Y";
		      case "25":
		        return "Z";
		      case "26":
		        return " ";
		      case "27":
		        return ",";
		      case "28":
		        return "?";
		      case "29":
		        return ":";
		      case "30":
		        return ".";
		      case "31":
		        return "\"";
		      case "32":
		    	  return "";
		      case "33":
		    	  return "";
		      case "34":
		    	  return "";
		      case "35":
		    	  return "";
		      case "36":
		    	  return "";
		      case "37":
		    	  return "";
		      case "38":
		    	  return "";
		      case "39":
		    	  return "";
		      case "40":
		    	  return "";
		      case "41":
		    	  return "";
		      case "42":
		    	  return "";
		      case "43":
		    	  return "";
		      case "44":
		    	  return "";
		      case "45":
		    	  return "";
		      case "46":
		    	  return "";
		      case "47":
		    	  return "";
		      case "48":
		    	  return "";
		      case "49":
		    	  return "";
		      case "50":
		    	  return "";
		      case "51":
		    	  return "";

		      default:
		        throw new java.lang.IllegalArgumentException("Argument must be be on interval [00, 51]");
		      }
			
		}
	 

	// Make up the letters that will be in the enumeration
	  public static byte Space = 26;
	  public static byte A = 0;
	  public static byte B = 1;
	  public static byte C = 2;
	  public static byte D = 3;
	  public static byte E = 4;
	  public static byte F = 5;
	  public static byte G = 6;
	  public static byte H = 7;
	  public static byte I = 8;
	  public static byte J = 9;
	  public static byte K = 10;
	  public static byte L = 11;
	  public static byte M = 12;
	  public static byte N = 13;
	  public static byte O = 14;
	  public static byte P = 15;
	  public static byte Q = 16;
	  public static byte R = 17;
	  public static byte S = 18;
	  public static byte T = 19;
	  public static byte U = 20;
	  public static byte V = 21;
	  public static byte W = 22;
	  public static byte X = 23;
	  public static byte Y = 24;
	  public static byte Z = 25;
	  public static byte Comma = 27;
	  public static byte Question = 28;
	  public static byte Colon = 29;
	  public static byte Period = 30;
	  public static byte Apostrophe = 31;
}
