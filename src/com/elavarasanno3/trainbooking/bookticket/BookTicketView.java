package com.elavarasanno3.trainbooking.bookticket;

import com.elavarasanno3.trainbooking.datalayer.TrainBookingDatabase;
import com.elavarasanno3.trainbooking.model.Passenger;
import com.elavarasanno3.trainbooking.model.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTicketView {
    Scanner sc = new Scanner(System.in);
    BookTicketModel bookTicketModel;
    public BookTicketView(){
        bookTicketModel = new BookTicketModel(this);
    }

    public void init() {
        System.out.println("Welcome to Booking");
        System.out.println("Enter where to start ");
        String startingPlace = sc.next();
        System.out.println("Enter where to go ");
        String endingPlace = sc.next();
        ArrayList<Train> presentTrains = new ArrayList<>();
        ArrayList<Train> trainList = TrainBookingDatabase.getInstance().getListTrains();
        for(Train train : trainList){
            if(train.getRoute().contains(startingPlace) && train.getRoute().contains(endingPlace)){
                presentTrains.add(train);
            }
        }
        if(presentTrains.isEmpty()){
            System.out.println("There is no trains available for this starting and ending points : ");
            return;
        }else{
            for (Train train : presentTrains){
                System.out.println("Train name : " + train.getName());
                System.out.println("Train id : " + train.getId());
                System.out.println("Train departure Time :" + train.getDepartureTime());
                System.out.println("Train arrival Time : " + train.getArrivalTime()) ;
                System.out.println("Train fare : " + train.getFare());
                System.out.println("Available seats : " + train.getAvailableSeat());
            }
        }
        System.out.println("Enter train number : ");
        int trainId = sc.nextInt();
        System.out.println("Enter the passengers number : ");
        int passengersCount = sc.nextInt();
        for(int i = 0;i<passengersCount;i++){
            System.out.println("Enter passenger "+ (i+1) + " name : ");
            String passengerName = sc.next();
            System.out.println("Enter passenger age : ");
            int passengerAge = sc.nextInt();
            System.out.println("Enter passenger gender");
            String passengerGender = sc.next();
            System.out.println("Enter passenger id : ");
            int passengerId = sc.nextInt();
            Passenger passenger = new Passenger(passengerId,passengerName,passengerAge,passengerGender);
            bookTicketModel.handleBookTicket(passenger,trainId);
        }
        int totalFare = 0;
        for(Train train : presentTrains){
            if(trainId == train.getId()){
                totalFare = train.getFare()* passengersCount;
            }
        }
        System.out.println("Total Fare : " + totalFare);
    }
}
