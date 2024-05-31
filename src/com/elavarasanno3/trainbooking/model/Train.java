package com.elavarasanno3.trainbooking.model;
import java.util.ArrayList;

public class Train {
    public static int getCurrentId() {
        return currentId;
    }

    private static int currentId = 1;
    private int id;
    private String name;
    private int departureTime;
    private int arrivalTime;

    private String route ;
    private String to;

    private int fare;
    private int availableSeat;

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public ArrayList<Passenger> getConfirmedList() {
        return confirmedList;
    }

    public void setConfirmedList(ArrayList<Passenger> confirmedList) {
        this.confirmedList = confirmedList;
    }

    public ArrayList<Passenger> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayList<Passenger> waitingList) {
        this.waitingList = waitingList;
    }

    private ArrayList<Passenger> confirmedList = new ArrayList<>();
    private ArrayList<Passenger> waitingList = new ArrayList<>();
    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }




    public Train( int id,String name, int departureTime, int arrivalTime, String route, String to, int fare,int availableSeat) {
        this.id = id;
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = route;
        this.to = to;
        this.fare = fare;
        this.availableSeat = availableSeat;
    }

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }



}
