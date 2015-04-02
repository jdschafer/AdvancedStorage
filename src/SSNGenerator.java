/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      Person.java
 *@included     N/A
 */

//Called by other classes who need random social security numbers
public class SSNGenerator {
    protected int random;
    
    //Generates a random number between 0 & 999,999,999 then returns it
    protected int getRandom() {
        random = (int)(Math.random() * 999999999);
        return random;
    }
}