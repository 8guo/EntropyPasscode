package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	
	public SHA256() {};
	
	public static String SHA256Encode(String input) throws NoSuchAlgorithmException {
		 	MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(input.getBytes());
	        return bytesToHex(md.digest());
	}
	
	public static String bytesToHex(byte[] bytes) {
	        StringBuffer result = new StringBuffer();
	        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
	        return result.toString();
	}
}