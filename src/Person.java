/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      
 *@included     N/A
 */

public class Person {
    private int SSN;
    private String name;
    private String email;
    public SSNGenerator SSNGen;
    
    public Person(int Social, String incName, String incEmail) {
        SSN = Social;
        name = incName;
        email = incEmail;
    }
    
    public Person(String incName, String incEmail) {
        SSN = SSNGen.getRandom();
        name = incName;
        email = incEmail;
    }
    
    //Returns the Person's Social Security Number
    protected int getSSN() {
        return SSN;
    }
    
    
    //Returns the Person's name
    protected String getName() {
        return name;
    }
    
    //Returns the Person's email
    protected String getEmail() {
        return email;
    }
    
    //Returns 0 if the Person's SSN are equal
    //Returns 1 if this Person's SSN is higher than the parameter's SSN
    //Returns -1 if this Person's SSN is lower than the parameter's SSN
    public int compareTo(Person inc) {
        if(this.equals(inc))
            return 0;
        else if(this.getSSN() > inc.getSSN())
            return 1;
        else
            return -1;
    }
    
    //Returns true if the Persons are equal, returns false otherwise
    public boolean equals(Person inc) {
        return(this.getSSN() == inc.getSSN());
    }
    
    //Returns a string containing the name, email,
    //and Social Security Number of this Person
    public String toString() {
        return ("Name: " + name + "\nEmail address: " + email + 
                "\nSocial Security Number: " + SSN);
    }
}