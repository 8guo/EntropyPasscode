package model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cntrl.Main;

public class Entropy {

	private Random rand;
	private Toolkit toolkit;
	private Clipboard clipboard;
	private StringSelection copy;
	
	private int status = 0;
	private long mouseClicks[] = new long[20];
	
	private final String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private final String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
	private final String numbers = "0123456789"; 
	private final String symbols = "!@#$%^&*_=+-/.?<>)";
	private String allValues = Capital_chars + Small_chars + numbers + symbols;
	private String tempCord;	
	private String genPasscode;
	
	private boolean generated = false;
	
	
	public void generatePasscode() {
		genPasscode = "";
		shuffleString(allValues);
		for (int i = 0; i < 20; i++) {genPasscode += allValues.charAt(seededRand(mouseClicks[i]));}
		Main.pFrame.setPasscode(genPasscode);
	}
	
	public void shuffleString(String me) {
		List<String> letters = Arrays.asList(me.split(""));
		Collections.shuffle(letters);
		clearAllValues();
		for (String letter : letters) {allValues += letter;}
	}
	
	public void clearAllValues() {allValues = "";}
	public void addUppers() {allValues += Capital_chars;}
	public void addLowers() {allValues += Small_chars;}
	public void addNums() {allValues += numbers;}
	public void addSymbols() {allValues += symbols;}
	
	public int getStatus() {return status;}
	
	public void addStatus() {status++;}
	
	public String getPasscode() {return genPasscode;}
	
	public void generatedTrue() {generated = true;}
	
	public boolean getGenerated() {return generated;}
	
	public void toClipboard(String toClip) {
		toolkit = Toolkit.getDefaultToolkit();
		clipboard = toolkit.getSystemClipboard();
		copy = new StringSelection(toClip);
		clipboard.setContents(copy, null);
	}
	
	public void addCordToArray(double x, double y) {
		tempCord = "" + (int)x + (int)y;
		mouseClicks[status] = Long.parseLong(tempCord);
	}
	
	public int seededRand(long seed) {
		rand = new Random(seed);
		return rand.nextInt(allValues.length());
	}
	
}
