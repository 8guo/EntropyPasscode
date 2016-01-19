#Entropy Generated Passcode

#####About this project.
Written in Java, this project was aimed to generate an unique passcode which is created in coorlation to the entropy data collected by the user.

#####How does it work?
The JFrame first records the coordinates of the 20 clicks, and adds it to a string. After 20 clicks the string is then run through a SHA256 hash and then the result is run through a BASE64 hash. My reasoning behind running through both hashes is to lower the chances of collision as I'm trunating the output of the BASE64 hash down to 20 characters.
