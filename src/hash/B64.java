package hash;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class B64 {
	
	public static SHA256 _sha256;
	
	public static String Base64(String input) throws NoSuchAlgorithmException {
		String  SHA256= hash.SHA256.SHA256Encode(input);
	    byte[] encodedBytes = Base64.getEncoder().encode(SHA256.getBytes());
	    return new String(encodedBytes, Charset.forName("UTF-8"));
	}
}
