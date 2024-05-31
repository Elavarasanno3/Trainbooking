package com.elavarasanno3.trainbooking;

import com.elavarasanno3.trainbooking.trainInitialize.TrainInitializerView;

public class TrainBookingApplication {
    private static TrainBookingApplication trainBookingApplication = null;



    public static void main(String[] args) {
        TrainBookingApplication.getInstance().start();
    }

    private void start() {
        TrainInitializerView trainInitializerView = new TrainInitializerView();
        trainInitializerView.init();
    }

    private static TrainBookingApplication getInstance() {
        if(trainBookingApplication == null){
            trainBookingApplication = new TrainBookingApplication();
        }
        return trainBookingApplication;
    }

}
