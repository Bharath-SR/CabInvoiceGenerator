package com.bridgeLabz.CabInvoiceGenerator;
import java.util.HashMap;
public class RideRepo {

    public static HashMap<Integer, Rides[]> RIDE_REPOSITORY = null;
    public static Integer USER_ID =0;

    public RideRepo(HashMap<Integer, Rides[]> RIDE_REPOSITORY, Integer USER_ID){
        this.RIDE_REPOSITORY = RIDE_REPOSITORY;
        this.USER_ID = USER_ID;

    }
    public InvoiceSummary calculateFare(){
        if(this.USER_ID == null || this.RIDE_REPOSITORY.get(USER_ID) == null){
            throw  new NullPointerException("Null Values are not Accepted");
        }
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        Rides[] userRideDetails = this.RIDE_REPOSITORY.get(USER_ID);
        double totalFare = 0;
        for (Rides ride : userRideDetails){
            totalFare += invoiceGenerator.calculateFare(ride.distance,ride.time);
        }
        return  new InvoiceSummary(userRideDetails.length, totalFare);
    }
}
