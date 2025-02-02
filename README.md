# Plane Management System

A Java-based airline seat reservation system that allows users to manage airplane seating arrangements, book tickets, and handle various seat management operations.

## Features

- Buy seats with specific row and seat number selections
- Cancel existing seat reservations
- Find the first available seat in the plane
- Display the current seating plan
- View ticket information and total sales
- Search for specific ticket details

## Seating Layout

The airplane has the following seating configuration:

- 4 rows (A, B, C, D)
- Rows A and D: 14 seats each
- Rows B and C: 12 seats each
- Different pricing zones:
  - Seats 1-5: £200
  - Seats 6-9: £150
  - Seats 10-14: £180

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE (like IntelliJ IDEA, Eclipse, or NetBeans)

### Installation

1. Clone the repository or download the source code
2. Open the project in your preferred Java IDE
3. Compile and run the `PlaneManagement.java` file

## Usage

When you run the program, you'll be presented with a menu offering the following options:

1. **Buy a seat**

   - Enter row letter (A-D) and seat number
   - Provide personal details (first name, last name, email)

2. **Cancel a seat**

   - Enter row letter and seat number of the seat to cancel
   - Confirm cancellation

3. **Find first available seat**

   - Automatically displays the first available seat in the plane

4. **Show seating plan**

   - Displays the current seating arrangement
   - 'O' represents available seats
   - 'X' represents occupied seats

5. **Print tickets information and total sales**

   - Shows details of all sold tickets
   - Displays the total revenue from ticket sales

6. **Search ticket**

   - Enter row letter and seat number to view specific ticket details

7. **Quit**
   - Exit the application

## Error Handling

The system includes robust error handling for:

- Invalid row letters
- Invalid seat numbers
- Input mismatch exceptions
- Array index out of bounds exceptions

## File Management

- Ticket information is automatically saved to files when seats are purchased
- Files are automatically deleted when reservations are cancelled

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](https://opensource.org/licenses/MIT).
