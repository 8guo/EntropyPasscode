package launcher;

import event.Listeners;
import event.genPasscode;
import event.cordsToSeed;
import views.startFrame;
import views.gatherFrame;
import views.generateFrame;

public class Main {

    public static startFrame _startFrame;
    public static gatherFrame _gatherFrame;
    public static generateFrame _generateFrame;
    public static cordsToSeed _cord2Seed;
    public static Listeners _listeners;
    public static genPasscode _genPass;

    public static void main(String[] args) {
        _startFrame = new startFrame(); // Initial Frame with 3 buttons
        _gatherFrame = new gatherFrame(); // Collect mouse movement
        _generateFrame = new generateFrame(); // Generate passcode with entropy
        _cord2Seed = new cordsToSeed(); // Convert 256 mouse cords to use a seeds
        _listeners = new Listeners();
        _genPass = new genPasscode();
    }

    public static void clearAll(){
        _generateFrame.setVisible(false);
        _gatherFrame.resetProgress();
        _generateFrame.resetProgress();
        _genPass.resetProgress();
        _startFrame.setVisible(true);
    }
}
