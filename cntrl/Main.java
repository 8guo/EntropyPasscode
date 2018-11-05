package cntrl;

import model.ActionListeners;
import model.Entropy;
import ui.ClickFrame;
import ui.PasscodeFrame;

public class Main {
	
	public static ClickFrame cFrame;
	public static PasscodeFrame pFrame;
	public static Entropy entropy;
	public static ActionListeners aListener;

	public static void main(String[] args) {
		cFrame = new ClickFrame();
		entropy = new Entropy();
		pFrame = new PasscodeFrame();
		aListener = new ActionListeners();
	}
}