package com.elavarasanno3.trainbooking.trainInitialize;

import com.elavarasanno3.trainbooking.datalayer.TrainBookingDatabase;
import com.elavarasanno3.trainbooking.menu.MenuModel;
import com.elavarasanno3.trainbooking.menu.MenuView;
import com.elavarasanno3.trainbooking.model.Train;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TrainInitializerView {
    Scanner sc = new Scanner(System.in);
    public TrainInitializerModel trainInitializerModel ;
    public TrainInitializerView(){
        trainInitializerModel = new TrainInitializerModel(this);
    }

    public void init() {
        System.out.println("Enter the train you want : ");
        int trainCounts = sc.nextInt();
        for(int i = 0;i<trainCounts;i++){
            System.out.println("Enter train number :");
            int trainNumber = sc.nextInt();
            System.out.println("Enter train name ");
            String trainName = sc.next();
            System.out.println("Enter departure time between 1 - 24 : ");
            int trainDepartureTime = sc.nextInt();
            System.out.println("Enter arrival time between 1 - 24 : ");
            int trainArrivalTime = sc.nextInt();
            System.out.println("Enter from place ");
            String trainStartingPlace = sc.next();
            System.out.println("Enter the routes gamma separate");
            String routes = sc.next();
            System.out.println("Enter to place ");
            String trainEndingPlace = sc.next();
            System.out.println("Enter the fare ");
            int trainFare = sc.nextInt();
            System.out.println("Enter the available seats :");
            int availableSeats = sc.nextInt();
            Train train = new Train(trainNumber,trainName,trainDepartureTime,trainArrivalTime,routes,trainEndingPlace,trainFare,availableSeats);
            TrainBookingDatabase.getInstance().initializeTrains(train);
        }
        MenuView menuView = new MenuView();
        menuView.init();


    }
}
