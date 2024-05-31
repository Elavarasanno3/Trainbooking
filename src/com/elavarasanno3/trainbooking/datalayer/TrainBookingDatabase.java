package com.elavarasanno3.trainbooking.datalayer;

import com.elavarasanno3.trainbooking.model.Train;

import java.util.ArrayList;

public class TrainBookingDatabase {
    static TrainBookingDatabase trainBookingDatabase = null;

    public ArrayList<Train> getListTrains() {
        return listTrains;
    }

    public void setListTrains(ArrayList<Train> listTrains) {
        this.listTrains = listTrains;
    }

    ArrayList<Train> listTrains = new ArrayList<>();



    public static TrainBookingDatabase getInstance() {
        if(trainBookingDatabase == null){
            trainBookingDatabase = new TrainBookingDatabase();
        }
        return trainBookingDatabase;
    }

    public void initializeTrains(Train train) {
        listTrains.add(train);
    }
}
