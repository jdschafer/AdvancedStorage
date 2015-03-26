public interface IOInterface {
    // constructor will be sent an array of strings
    // if the array is empty, all input should be read from System.in and all
    //    all output should be sent to System.out
    // if the array has only one element and it is the string "robot" all
    //    i/o will be done with the nxt robot
    // if the array has elements, the first string is the name of the input
    //    file and the second string is the name of the output file
    
    //DON'T USE
    int getInt(int port); // if reading from a file, ignore port else specifies
                          // the port to read from (if needed)
    int getInt();       // reads one integer from input
                        // this could be an int showing which port was pressed
                        // this could be an int indicating a reading on a port
                        // this could be an int indicating which button
    String getString();    // reads one string from input (until space)
    String getStringLn();  // reads one string (until end of line) from input
    
    // all other input will be done via the form of a String and then converted
    
    void writeString(String str); // this outputs the string without <cr>
    void writeStringLn(String str); // this outputs the string with <cr>
    //DON'T USE
    void writeString(String str, int x, int y); // this outputs the string at
                                               // the specified location
    //DON'T USE
    void makeSound(String str); // makes a sound represented by the str
                               // if working with files, this does nothing
    //DON'T USE
    void turn(int direction); // this will either turn a robot a specified 
                              // direction (-1 => -90%, 0 => 180%, 1 => 90%
                              // or output "turn left", "turn around" or
                              // "turn right"
    void move();              // this will either move the robot forward one
                              // unit or output "move forward one step"
}