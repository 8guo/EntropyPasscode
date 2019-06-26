
# User Entropy Password Generator
This is a Java application which takes the users mouse movement as a form of entropy to generates strong passcodes. This is done by hashing the collection of mouse coordinates with SHA256, and using the binary output as seeds for random in character selection. If do believe this idea is flawed or have an alternative solution, please do let me know.

## Help
To use this program, click 'Start' on the initial screen and begin moving your mouse randomly on the Gatherer panel. While on this screen, it is recommended to maximize the frame so that more coordiantes may be logged. You may also click and drag your cursor to another location to prevent the application logging your movement for more randomness. After the progress bar has been filled, select which category of characters you would like to use in a password. You may also set your desired length of 8 to 16 characters.

## Strong Password
As suggested by SANS Institute, a strong password should have at least 3 out of 4 of the character types and contain at least 15 alphanumeric characters. You may read more [here.](https://www.sans.edu/student-files/projects/password-policy-updated.pdf)

## Photos
Entropy Frame
![Initial Message](https://github.com/8guo/EntropyPasscode/blob/master/Initial1.png)
Passcode Frame 
![Mouse Collection](https://github.com/8guo/EntropyPasscode/blob/master/CollectingPoints.png) 
![Generate](https://github.com/8guo/EntropyPasscode/blob/master/Generate.png)

## To-Do
- [x] Allow the user to select a custom passcode length
- [x] Include the option to select new random points without quitting and reopening
- [ ] Calculate password strength (Entropy Bits)
