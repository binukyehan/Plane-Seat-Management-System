import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    static {System.out.print("\n");
            System.out.print("Welcome to the Plane Management application");}

    //declaring and initializing the seats array.
    static int [][] seats = {
                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    //Declaring and initializing the tickets array.
    static String [][] tickets = {
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    };
    static double seatPrice = 0;

    /**
     * This method is used for the seat buying process.
     * This is called through the main() method when the option 1 is given as the input.
     */
    private static void buy_seat(){
        try {
            Scanner input2 = new Scanner(System.in); //Creating input2 object to read input in this part.
            System.out.print("Enter the row letter : "); //Getting the row letter from the user.
            String rowLetter = input2.next();
            int rowIndex = 0;
            //Deciding the row index using the letter entered by the user.
            if (rowLetter.equalsIgnoreCase("A")){
                rowIndex = 0;
            }
            else if (rowLetter.equalsIgnoreCase("B")){
                rowIndex = 1;
            }
            else if (rowLetter.equalsIgnoreCase("C")){
                rowIndex = 2;
            }
            else if (rowLetter.equalsIgnoreCase("D")){
                rowIndex = 3;
            }
            else {
                System.out.println("Invalid row letter.");
                buy_seat();
            }

            System.out.print("Enter seat number : "); //Getting the seat number from the user.
            int seatNumber = input2.nextInt();
            int columnIndex = seatNumber-1; //Deciding the column index using the seat number entered by the user.

            if (seats[rowIndex][columnIndex] == 1){ //Checking if the entered seat is already booked.
                System.out.print("Sorry, the seat you searched is not available. \nDo you want to try again? (yes/no) : ");
                String continue1 = input2.next();
                if (continue1.equalsIgnoreCase("yes")){
                    buy_seat();
                }
                else if (continue1.equalsIgnoreCase("no")){
                    main(null);
                }
            }
            else if (seats[rowIndex][columnIndex] == 0){ //Proceeding if the entered seat is available.
                Scanner uInfo = new Scanner(System.in); //Creating uInfo object to read input in this part.
                System.out.println("\nPlease fill the following personal details."); //Getting the personal information from the user.
                System.out.print("First name : ");
                String userFName = uInfo.next();
                System.out.print("Last name : ");
                String userSurname = uInfo.next();
                System.out.print("Email : ");
                String userEmail = uInfo.next();
                System.out.println("Your seat is booked. Thank you for the purchase.");
                seats[rowIndex][columnIndex] = 1; //Updating the seats array.
                Person person1 = new Person(userFName, userSurname,userEmail); //Creating a Person object.
                person1.setName(userFName); //Using setters to update personal information.
                person1.setSurname(userSurname);
                person1.setEmail(userEmail);
                String ticketRow = rowLetter.toUpperCase();
                //Deciding the price of the selected seat.
                double ticketPrice = switch (seatNumber) {
                    case 1, 2, 3, 4, 5 -> 200;
                    case 6, 7, 8, 9 -> 150;
                    case 10, 11, 12, 13, 14 -> 180;
                    default -> 0;
                };
                Ticket ticket1 = new Ticket(ticketRow, seatNumber,ticketPrice,person1); //Creating a Ticket object.
                ticket1.setRow(ticketRow); //Using setters to update the ticket information.
                ticket1.setSeat(seatNumber);
                ticket1.setPrice(ticketPrice);
                ticket1.setPerson(person1);
                ticket1.save(); //Calling the save() method in the Ticket class to save the details to a file.
                tickets[rowIndex][columnIndex] = ticket1.ticket_information(); //Updating the tickets array with the relevant ticket information.
                //Updating the total Price of tickets sold.
                switch (seatNumber){
                    case 1,2,3,4,5: seatPrice+=200;
                        break;
                    case 6,7,8,9: seatPrice+=150;
                        break;
                    case 10,11,12,13,14: seatPrice+=180;
                        break;
                }
                System.out.print("\nClick Enter to go back to menu. ");
                try{
                    System.in.read();
                    main(null);
                } catch (Exception e ){
                    main(null);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){ //Handling ArrayIndexOutOfBoundsException.
            System.out.println("The seat position is invalid, Please Try Again.");
            buy_seat();
        }
        catch (InputMismatchException e){ //Handling InputMismatchException.
            System.out.println("Invalid input. Please Try Again.");
            buy_seat();
        }
    }

    /**
     * This method is used for the seat cancelling process.
     * This is called through the main() method when the option 2 is given as the input.
     */
    private static void cancel_seat(){
        Scanner input3 = new Scanner(System.in); //Creating input3 object to read input in this part.
        try {
            System.out.print("Enter the row letter : ");//Getting the row letter from the user.
            String rowLetter = input3.next();
            int rowIndex = 0;
            ///Deciding the row index using the letter entered by the user.
            if (rowLetter.equalsIgnoreCase("A")){
                rowIndex = 0;
            }
            else if (rowLetter.equalsIgnoreCase("B")){
                rowIndex = 1;
            }
            else if (rowLetter.equalsIgnoreCase("C")){
                rowIndex = 2;
            }
            else if (rowLetter.equalsIgnoreCase("D")){
                rowIndex = 3;
            }
            else {
                System.out.println("Invalid row letter.");
                cancel_seat();
            }
            System.out.print("Enter seat number : ");//Getting the seat number from the user.
            int seatNumber = input3.nextInt();
            int columnIndex = seatNumber-1; //Deciding the column index using the seat number entered by the user.

            if (seats[rowIndex][columnIndex] == 1){
                System.out.print("Are you sure you want to cancel the seat "+ rowLetter.toUpperCase()+seatNumber + "? : "); //Asking user to confirm if they want to cancel the seat.
                String confirmation = input3.next();
                if (confirmation.equalsIgnoreCase("yes")) {
                    seats[rowIndex][columnIndex] = 0; //Resetting the position of that seat in the seats array to 0.
                    tickets[rowIndex][columnIndex] = "0"; //Resetting the position of that seat in the tickets array to "0".
                    System.out.println("The reservation is cancelled.");
                    Ticket ticket2 = new Ticket(rowLetter,seatNumber,0,null);
                    ticket2.deleteFile(); //Deleting the text file created when cancelling the seat.
                    switch (seatNumber){ //Updating the total price of tickets sold.
                        case 1,2,3,4,5: seatPrice-=200;
                            break;
                        case 6,7,8,9: seatPrice-=150;
                            break;
                        case 10,11,12,13,14: seatPrice-=180;
                            break;
                    }
                    System.out.print("\nClick Enter to go back to menu. ");
                    try{
                        System.in.read();
                        main(null);
                    } catch (Exception e ){
                        main(null);
                    }

                }
                else if (confirmation.equalsIgnoreCase("no")) {
                    System.out.println("The reservation is not cancelled.");
                    System.out.print("\nClick Enter to go back to menu. ");
                    try{
                        System.in.read();
                        main(null);
                    } catch (Exception e ){
                        main(null);
                    }
                }
                else {
                    System.out.println("Invalid input.\nHeading back to main menu...");
                    main(null);
                }

            }
            else if (seats[rowIndex][columnIndex] == 0){ //Checking if the entered seat is already empty.
                System.out.print("The seat you searched is not reserved, There is nothing to cancel. \nDo you want to try again? (yes/no) : ");
                String continue1 = input3.next();
                if (continue1.equalsIgnoreCase("yes")){
                    cancel_seat();
                }
                else if (continue1.equalsIgnoreCase("no")){
                    main(null);
                }
                else {
                    System.out.println("invalid input.\nHeading back to main menu...");
                    main(null);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){ //Handling the ArrayIndexOutOfBoundException.
            System.out.println("The seat position is invalid, Please Try Again.");
            cancel_seat();
        }
        catch (InputMismatchException e){ //Handling the InputMismatchException.
            System.out.println("Invalid input. Please Try Again.");
            cancel_seat();
        }
    }

    /**
     * This method is used to find the first seat available.
     * This is called through the main() method when the option 3 is given as the input.
     */
    private static void find_first_available(){
        String rowLetter = "";
        //Scanning the seats array to find index of the first element that is equal to 0.
        for (int i = 0; i<seats.length; i++){
            for (int j = 0; j<seats[i].length; j++){ //Using 2 'for' loops since seats array is a 2-dimensional array.
                if (seats[i][j] == 0){
                    switch (i){ //Deciding the Row letter of the seat.
                        case 0: rowLetter = "A";
                        break;
                        case 1: rowLetter = "B";
                        break;
                        case 2: rowLetter = "C";
                        break;
                        case 3: rowLetter = "D";
                        break;
                    }
                    int seatNumber = j+1; //Deciding the seat number of the seat.
                    System.out.println("The first seat available : "+ rowLetter + seatNumber); //Print out the first available seat.
                    System.out.print("\nClick Enter to go back to menu. ");
                    try{
                        System.in.read();
                        main(null);
                    } catch (Exception e ){
                        main(null);
                    }
                    break;
                }
            }
        }
    }

    /**
     * This method is used to display the seating plan.
     * This is called through the main() method when the option 4 is given as the input.
     */
    private static void show_seating_plan(){
        System.out.print("\n");
        //Displaying the seating plan by printing the value in each index.
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14");
        System.out.println("  -------------------------------------------");
        for (int i = 0; i<seats.length; i++){
            if (i == 0){
                System.out.print("A - ");
            }
            else if (i == 1) {
                System.out.print("B - ");
            }
            else if (i == 2) {
                System.out.print("C - ");
            }
            else if(i == 3){
                System.out.print("D - ");
            }
            for (int j = 0; j<seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("O  ");
                } else {
                    System.out.print("X  ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\nClick Enter to go back to menu. ");
        try{
            System.in.read();
            main(null);
        } catch (Exception e ){
            main(null);
        }
    }

    /**
     * This method is used to display information of the tickets sold and the total price from the tickets sold.
     * This is called through the main() method when the option 5 is given as the input.
     */
    private static void print_tickets_info(){
        for (int i = 0; i<tickets.length; i++){ //Getting the ticket information from the tickets array.
            for (int j = 0; j<tickets[i].length; j++){
                if (!tickets[i][j].equals("0")){
                    System.out.println(tickets[i][j]);
                }
            }
        }
        System.out.println("\nThe total price of the tickets sold : £" + seatPrice); //Displaying the total price of the tickets sold.
        System.out.print("\nClick Enter to go back to menu. ");
        try{
            System.in.read();
            main(null);
        } catch (Exception e ){
            main(null);
        }
    }

    /**
     * This method is used to search a specific ticket and display the ticket information of that ticket.
     * This is called through the main() method when the option 6 is given as the input.
     */
    private static void search_ticket(){
        try {
            Scanner input4 = new Scanner(System.in);
            //Getting the row letter from the user.
            System.out.print("Enter the row letter : ");
            String rowLetter = input4.next();
            int rowIndex = 0;
            //Deciding the row index from the letter entered by the user.
            if (rowLetter.equalsIgnoreCase("A")){
                rowIndex = 0;
            }
            else if (rowLetter.equalsIgnoreCase("B")){
                rowIndex = 1;
            }
            else if (rowLetter.equalsIgnoreCase("C")){
                rowIndex = 2;
            }
            else if (rowLetter.equalsIgnoreCase("D")){
                rowIndex = 3;
            }
            else {
                System.out.println("Invalid row letter.");
                search_ticket();
            }

            System.out.print("Enter seat number : ");
            int seatNumber = input4.nextInt();
            int columnIndex = seatNumber-1; //Deciding the column index from the seat number entered by the user.

            if (seats[rowIndex][columnIndex] == 1){
                System.out.println(tickets[rowIndex][columnIndex]); //Display ticket information of the seat requested by the user.
                System.out.print("\nClick Enter to go back to menu. ");
                try{
                    System.in.read();
                    main(null);
                } catch (Exception e ){
                    main(null);
                }
            }
            else if (seats[rowIndex][columnIndex] == 0){
                System.out.println("\nThe seat is available."); //Display a message if the requested seat is empty.
                System.out.print("\nClick Enter to go back to menu. ");
                try{
                    System.in.read();
                    main(null);
                } catch (Exception e ){
                    main(null);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){ //Handling the ArrayIndexOutOfBoundsException.
            System.out.println("The seat position is invalid, Please Try Again.");
            search_ticket();
        }
        catch (InputMismatchException e){ //Handling the InputMismatchException.
            System.out.println("Invalid input. Please Try Again.");
            search_ticket();
        }
    }

    /**
     * This is the entry point of the program.
     * This contains the menu options, so this method is called whenever user needs to get back to the main menu.
     * @param args An array of strings that represents command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("\n");
        //Printing out the menu options.
        for (int i =1;i<=50;i++){
            System.out.print("*");}
        System.out.print("\n");
        System.out.println("*                "+ " MENU OPTIONS " + "                  *" );
        for (int i =1;i<=50;i++){
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.println("    1) Buy a seat");
        System.out.println("    2) Cancel a seat");
        System.out.println("    3) Find first available seat");
        System.out.println("    4) Show seating plan");
        System.out.println("    5) Print tickets information and total sales");
        System.out.println("    6) Search ticket");
        System.out.println("    0) Quit");
        for (int i =1;i<=50;i++){
            System.out.print("*");
        }
        System.out.print("\n");
        try {
            System.out.print("Please select an option : ");
            Scanner input1 = new Scanner(System.in); //Getting the option number from the user.
            int Choice = input1.nextInt();
            if (Choice > 6 || Choice < 0){ //Checking if the given option is in range.
                System.out.println("There is no such option, please try again!");
                main(null);
            }
            //Calling the relevant methods depending on the option entered by the user.
            else if (Choice == 0) {
                System.out.println("Thank you for using the Plane Management application!");
                System.exit(0); 
            }
            else if (Choice == 1) {
                buy_seat();
            }
            else if (Choice == 2){
                cancel_seat();
            }
            else if (Choice == 3){
                find_first_available();
            }
            else if (Choice == 4){
                show_seating_plan();
            }
            else if (Choice == 5) {
                print_tickets_info();
            }
            else {
                search_ticket();
            }
        } catch (InputMismatchException e){ //Handling the InputMismatchException.
            System.out.println("Invalid input. Please Try Again.");
            main(null);
        }
    }
}
