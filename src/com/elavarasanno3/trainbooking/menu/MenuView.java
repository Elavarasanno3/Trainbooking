package com.elavarasanno3.trainbooking.menu;

import com.elavarasanno3.trainbooking.bookticket.BookTicketView;

import java.util.Scanner;

import static java.awt.SystemColor.window;

public class MenuView {
    Scanner sc = new Scanner(System.in);
    MenuModel menuModel;
    public MenuView(){
        menuModel = new MenuModel(this);
    }

    public void init() {
        while(true){
            System.out.println("Welcome to IRCTC");
            System.out.println("1-booking");
            System.out.println("2-Get passenger status");
            System.out.println("3-booked Ticket");
            System.out.println("4-cancel ticket");
            System.out.println("5-List train routes");
            System.out.println("6-Search passengers");
            System.out.println("7-Add train routes");
            System.out.println("0- exit");
            System.out.println();
            System.out.println("Enter the choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :{
                    BookTicketView bookTicketView = new BookTicketView();
                    bookTicketView.init();
                    break;
                }
                case 2 :{
                    System.out.println("Enter the passenger id : ");
                    int passengerId = sc.nextInt();
                    menuModel.getStatus(passengerId);
                    break;
                }
                case 3 :
                    menuModel.getBookedDetails();
                    break;
                case 4 :
                    System.out.println("Enter passenger id : ");
                    int passengerId = sc.nextInt();
                    menuModel.cancelTicket(passengerId);
                    break;
                case 5 :
                    System.out.println("Enter train id : ");
                    break;
                case 6 :
                case 8 :
                    System.out.println("under process");
                    break;
                case 7 :
                    System.out.println("Under process");
                    break;
                case 0 : return;
                default:init();
            }
        }

    }
}
