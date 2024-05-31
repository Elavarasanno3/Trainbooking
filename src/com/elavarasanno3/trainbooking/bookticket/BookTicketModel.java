package com.elavarasanno3.trainbooking.bookticket;

import com.elavarasanno3.trainbooking.datalayer.TrainBookingDatabase;
import com.elavarasanno3.trainbooking.model.Passenger;
import com.elavarasanno3.trainbooking.model.Train;

import java.util.ArrayList;

public class BookTicketModel {
    BookTicketView bookTicketView;
    BookTicketModel(BookTicketView bookTicketView){
       this.bookTicketView = bookTicketView;
    }

    public void handleBookTicket(Passenger passenger,int trainId) {
        ArrayList<Train> trainArrayList = TrainBookingDatabase.getInstance().getListTrains();
        for (Train train : trainArrayList){
            if(train.getId() == trainId){
                if (train.getAvailableSeat() >= 1){
                    ArrayList<Passenger> confirmedList = train.getConfirmedList();
                    confirmedList.add(passenger);
                    train.setAvailableSeat(train.getAvailableSeat()-1);
                    train.setConfirmedList(confirmedList);
                    passenger.setStatus("confirmed");
                    System.out.println("Passenger status : "+ passenger.getStatus());
                }else{
                    ArrayList<Passenger> waitingList = train.getWaitingList();
                    waitingList.add(passenger);
                    train.setWaitingList(waitingList);
                    passenger.setStatus("waiting");
                    System.out.println("Passenger status : "+ passenger.getStatus());
                }
            }
        }
    }
}
