public class Person {

    //Declaring the Attributes.
    private String name;
    private String surname;
    private String email;

    /**
     *This is the Constructor in this Person class.
     * @param name The first name of the person.
     * @param surname The surname of the person.
     * @param email The email of the person.
     */
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getters and setters.
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * This is the method that is called to return personal information entered by the user as a string.
     * This includes the Name, Surname and Email of a person.
     * @return Information of the person
     */
    public String person_information(){
        return "\n> Name        : "+ name + "\n> Surname     : "+ surname + "\n> Email       : "+ email;
    }
}
