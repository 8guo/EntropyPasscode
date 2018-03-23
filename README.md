#Entropy Generated Passcode

#####About this project.
Written in Java, this project was aimed to generate an unique passcode which is created in coorlation to the entropy data collected by the user.

#####How does it work?
The JFrame first records the coordinates of the 20 clicks, and adds it to a string. After 20 clicks the string is then run through a SHA256 hash and then the result is run through a BASE64 hash. My reasoning behind running through both hashes is to lower the chances of collision as I'm truncating the output of the BASE64 hash down to 20 characters.

#####Want even more possibilities?
For the sake of just simplicity and getting the idea down the WIDTH and LENGTH of the JFrame can be increased to allow more posibilities. Simply alter the WIDTH & LENGTH to a larger number and by doing so, you'll increase the posibility of coordinates.
