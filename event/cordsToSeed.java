package event;

import launcher.Main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cordsToSeed {

    private String cords;
    private String binary;
    private String[] seeds;

    public cordsToSeed() { resetProgress(); }

    public void resetProgress() {
        cords = "";
        binary = "";
    }

    public String getBinary() { return binary;}

    public void addCord(double x, double y) { cords += (int)x + 999 + (int)y;}

    public String cordsTo256HEX(String cords) {
        try {MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(cords.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hashBytes.length; ++i) {
                sb.append(Integer.toHexString((hashBytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Main._generateFrame.alert("Exception thrown: " + e);
        }
        return "";
    }

    public String hexToBinary(String hexString) { return new BigInteger(hexString, 16).toString(2);}

    public void getBinary(String cords) { binary = hexToBinary(cordsTo256HEX(cords));}

    public void splitBinary(String binary) { seeds = binary.split("(?<=\\G.{16})"); }

    public String getSeed(int num) { return seeds[num]; }

    public void create() {
        getBinary(cords);
        splitBinary(binary);
    }

}
