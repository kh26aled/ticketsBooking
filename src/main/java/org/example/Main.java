package org.example;

import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        //rows and cols nums
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter num of rows: ");
        int row = scanner.nextInt();
        System.out.println("Enter num of cols: ");
        int col = scanner.nextInt();
        char[][] seats = new char[row][col];


        //Movies Names and nums
        System.out.println("Enter num of movies: ");
        int numMovies = scanner.nextInt();

        scanner.nextLine();
        String[] movieNames = new String[numMovies];
        for (int i = 0; i < numMovies; i++) {
            System.out.println("Enter movie name: ");
            movieNames[i] = scanner.nextLine();
        }
        fillSeats(seats);

        //Main Menu
        int choice;
        do {

            System.out.print(
                    "===== Cinema Booking System =====\n" +
                            "1. Display Seats\n" +
                            "2. Book a Seat\n" +
                            "3. Cancel Booking\n" +
                            "4. Show all movies\n" +
                            "5. Show Available and Booked Seats\n" +
                            "0. Exit\n" +
                            "Select your choice: "
            );
            choice=scanner.nextInt() ;
            switch (choice){
                case 1:
                    displaySeats(seats);
                    break;

                case 2:
                    bookSeats(seats);
                    break;

                case 3:
                    cancelBooking(seats);
                    break;

                case 4:
                    movieName(movieNames);
                    break;

                case 5:
                    countSeats(seats);
                    break;
                default:
                    System.out.println("Invalid choice! try again.");
                    break;


            }
        }while (choice !=0);


        if(choice ==0){
            System.out.println("goodbye");
        }






    }


    // fill all seats with'O'
    static void fillSeats(char[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'O';
            }

        }
    }

    //Display seats
    static void displaySeats(char[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    //book a Seat
    static void bookSeats(char[][] seats) {
        System.out.println("Enter seat num: ");
        Scanner scanner = new Scanner(System.in);
        int seatNum = scanner.nextInt();
        int row = seatNum / 10;
        int col = seatNum % 10;
        if (row >= 1 && row <= seats.length &&
                col >= 1 && col <= seats[row - 1].length) {
            if (seats[row - 1][col - 1] == 'X') {
                System.out.println("seat is already booked!");
            } else {
                seats[row - 1][col - 1] = 'X';
                System.out.println("Seat booked successfully!");
            }
        } else {
            System.out.println("invalid seat!");
        }
        displaySeats(seats);
        bookingRate(seats);

    }

    //Cancel Booking
    static void cancelBooking(char[][]seats){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter seat num: ");
        int seatNum = scanner.nextInt();
        int row = seatNum / 10;
        int col = seatNum % 10;
        if (row >= 1 && row <= seats.length &&
                col >= 1 && col <= seats[row - 1].length) {
            if (seats[row - 1][col - 1] == 'X'){
                seats[row - 1][col - 1] = 'O';
                System.out.println("your booking has been canceled");
            }else{
                System.out.println("This seat is NOT booked!");
            }
        }else {
            System.out.println("invalid seat!");
        }
    }

    // Movie names
    static void movieName(String[] movieNames) {
        System.out.println(Arrays.toString(movieNames));
    }

    //Available and Booked seats
    static void countSeats(char[][] seats) {
        int availSeats = 0;
        int bookedSeats = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'O') {
                    availSeats += 1;
                } else {
                    bookedSeats += 1;
                }
            }
        }
        System.out.println("Available Seats: " + availSeats + "\n" + "Booked seats: " + bookedSeats);
    }

    //Almost Full
    static void bookingRate(char[][] seats) {
        int totalSeats = seats.length * seats[0].length;
        int bookedSeats = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'X') {
                    bookedSeats += 1;
                }

            }
        }
        if(bookedSeats > totalSeats * 0.8){
            System.out.println("Almost Full!");
        }

    }
}