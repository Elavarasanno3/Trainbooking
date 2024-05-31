package com.elavarasanno3.trainbooking.menu;

import com.elavarasanno3.trainbooking.datalayer.TrainBookingDatabase;
import com.elavarasanno3.trainbooking.model.Passenger;
import com.elavarasanno3.trainbooking.model.Train;

import java.util.ArrayList;

public class MenuModel {
    MenuView menuView ;
    public MenuModel(MenuView menuView){
        this.menuView = menuView;
    }

    public void getStatus(int passengerId) {
        ArrayList <Train> trainList = TrainBookingDatabase.getInstance().getListTrains();
        for(Train train : trainList){
            ArrayList<Passenger> waitingList = train.getWaitingList();
            ArrayList<Passenger> confirmedList = train.getConfirmedList();
            for(Passenger passenger : waitingList){
                if (passengerId == passenger.getId()){
                    System.out.println("your status : " + passenger.getStatus());
                }
            }
            for(Passenger passenger : confirmedList){
                if (passengerId == passenger.getId()){
                    System.out.println("your status :"+  passenger.getStatus());
                }else{
                    System.out.println("You entered the wrong passenger id");
                }
            }
        }
    }

    public void getBookedDetails() {
        ArrayList <Train> trainList = TrainBookingDatabase.getInstance().getListTrains();
        System.out.println("----- Booked list ------ ");
        for(Train train : trainList) {
            ArrayList<Passenger> bookList = train.getConfirmedList();
            System.out.println("Train id : " + train.getId());
            System.out.println("Train Name : " +  train.getName());
            for (Passenger passenger : bookList){
                System.out.println("Passenger Id :" + passenger.getId());
                System.out.println("Passenger Name : "+ passenger.getName());
                System.out.println("Passenger age :" + passenger.getAge());
                System.out.println("Passenger gender : "+ passenger.getGender());
                System.out.println("Passenger status : "+ passenger.getStatus());
            }
        }
    }

    public void cancelTicket(int passengerId) {
        ArrayList <Train> trainList = TrainBookingDatabase.getInstance().getListTrains();
        for(Train train : trainList) {
            ArrayList<Passenger> bookList = train.getConfirmedList();
            ArrayList<Passenger> waitingList = train.getWaitingList();
            if(bookList.removeIf(passenger -> passengerId == passenger.getId())){
                train.setAvailableSeat(train.getAvailableSeat()+1);
                Passenger passenger = waitingList.get(0);
                bookList.add(passenger);
                train.setConfirmedList(bookList);
            }

            waitingList.removeIf(passenger -> passengerId == passenger.getId());
            System.out.println("Passenger removed success fully");

        }

    }

    public void changeStatus(int passengerId) {
        ArrayList <Train> trainList = TrainBookingDatabase.getInstance().getListTrains();
        for(Train train : trainList){
            ArrayList<Passenger> waitingList = train.getWaitingList();
            ArrayList<Passenger> confirmedList = train.getConfirmedList();
            for(Passenger passenger : waitingList){
                if (passengerId == passenger.getId()){
                    passenger.setStatus("booked");
                    System.out.println("your status : " + passenger.getStatus());
                }
            }
            for(Passenger passenger : confirmedList){
                if (passengerId == passenger.getId()){
                    System.out.println("your status :"+  passenger.getStatus());
                }else{
                    System.out.println("You entered the wrong passenger id");
                }
            }
        }

    }

}
