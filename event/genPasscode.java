package event;

import launcher.Main;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class genPasscode {

    private final String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String Small_chars = "abcdefghijklmnopqrstuvwxyz";
    private final String numbers = "0123456789";
    private final String symbols = "+,/`~!@#$%^&*()-_=;:',<.>?\"\\";
    private String passcode = Capital_chars + Small_chars + numbers + symbols;
    String outputPass;
    Random rand;

    // Things for copy button
    private Toolkit toolkit;
    private Clipboard clipboard;
    private StringSelection copy;

    // Length
    private int length = 8;

    public void setLength(String lengthText) {
        try { Integer.parseInt(lengthText);
        } catch (NumberFormatException nfe) {
            Main._generateFrame.alert("Error: Please enter a number.");
        } if (Integer.parseInt(lengthText) < 8 || Integer.parseInt(lengthText) > 16) {
            Main._generateFrame.alert("Error: Please enter a number between 8 and 16.");
        } else { length = Integer.parseInt(lengthText); }
    }

    public void copyToClipboard() {
        toolkit = Toolkit.getDefaultToolkit();
        clipboard = toolkit.getSystemClipboard();
        copy = new StringSelection(Main._generateFrame.getPasscodeText());
        clipboard.setContents(copy, null);
    }

    public String makePasscode() {
        passcode = "";
        if (Main._generateFrame.symbolsCheckBox.isSelected()) { passcode += symbols;
        } if (Main._generateFrame.numbersCheckBox.isSelected()) { passcode += numbers;
        } if (Main._generateFrame.uppercaseCheckBox.isSelected()) { passcode += Capital_chars;
        } if (Main._generateFrame.lowercaseCheckBox.isSelected()) { passcode += Small_chars; }
        shuffle(passcode);
        outputPass = "";
        for (int i = 0; i < length; i++) {
            outputPass += passcode.charAt(seededRand(Long.parseLong(Main._cord2Seed.getSeed(i))));
        }
        return outputPass;
    }

    private int seededRand(long seed) {
        rand = new Random(seed);
        return rand.nextInt(passcode.length());
    }

    private void shuffle(String selection) {
        List<String> letters = Arrays.asList(selection.split(""));
        Collections.shuffle(letters);
        passcode = "";
        for (String letter : letters) {passcode += letter;}
    }


    public void resetProgress() { defaultLength(); }
    private void defaultLength() { length = 8;}
}
