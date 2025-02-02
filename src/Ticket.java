import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    //Declaring the Attributes.
    private String row;
    private int seat;
    private double price;
    private Person person;

    /**
     * This is the Constructor in this Ticket class.
     * @param row the row letter of the seat.
     * @param seat the seat number
     * @param price price of the seat.
     * @param person The object person from the Person class.
     */
    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getters and Setters.
    public String getRow(){
        return row;
    }

    public void setRow(String  row){
        this.row = row;
    }

    public int getSeat(){
        return seat;
    }

    public void setSeat(int seat){
        this.seat = seat;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    /**
     * This method returns ticket information
     * This includes the Row, Seat Number, Price, and the personal information from the Person class.
     * @return Information of the ticket.
     */
    public String ticket_information(){
        return"\nTicket "+row+seat+" details.\n> Row         : " + row + "\n> Seat Number : " + seat +"\n> Price       : £" + price + person.person_information();


    }

    /**
     * Saves the ticket information to a text file.
     * This method is called when a person buys a ticket.
     */
    public void save(){
        try {
            FileWriter writer = new FileWriter(row+seat+".txt");
            writer.write(ticket_information()); //Calling the ticket_information() method and writing the returned information on the file.
            writer.close(); //Closing the file.
            System.out.println("Ticket details are saved to file "+row.toUpperCase()+seat+".");
        }
        catch (IOException e){
            System.out.println("An error occurred while saving the file.");
        }
    }

    /**
     * Deletes the text file including ticket information when cancelling a seat.
     * This method is called when a person cancels a ticket.
     */
    public void deleteFile(){
        File fileToBeRemoved = new File(row+seat+".txt");
        if (fileToBeRemoved.exists()){ //Checking if the relevant file exists.
            fileToBeRemoved.delete(); //Deleting the file if it exists.
            System.out.println("The saved ticket " +row.toUpperCase()+seat+ " file is removed from the system.");
        }
        else {
            System.out.println("Ticket " +row.toUpperCase()+seat+ " file could not be found in the system to be deleted.");
        }
    }
}
