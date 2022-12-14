package org.example.InvoiceGenerator;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;

    @BeforeEach
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance,time);
        double totalFare = 0;
        Assertions.assertEquals(25,fare,0.0);
    }
    @Test
    public void givenLessDistanceOrTimeShouldReturnMinFare() {
        double distance=0.1;
        int time=1;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        Ride[] rides={new Ride(1.0,5, PremiumRide.Premium),
                new Ride(0.2,2, PremiumRide.Premium)};
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummery=new InvoiceSummary(2,20);
        Assertions.assertEquals(expectedInvoiceSummery,summary);
    }
    @Test
    public void ReturnTotalRidesTotalFareAndAverageFarePerRide() {
        Ride[] rides = {new Ride(1.0, 5, PremiumRide.Premium),
                new Ride(0.2, 2, PremiumRide.Premium)};
        double totalFare = invoiceGenerator.calculateTotalFare(rides);
        int noOfRides = invoiceGenerator.numberOfRides(rides);
        double averageFare = invoiceGenerator.calculateAverageFarePerRide(rides);
        Assertions.assertEquals(20, totalFare, 0.0);
        Assertions.assertEquals(2, noOfRides,0.0);
        Assertions.assertEquals(10, averageFare, 0.0);
    }
    @Test
    public void givenUserIdReturnTheInvoice() {
        String userID = "Driver1";
        Ride[] rides = new Ride[]{new Ride(1.0, 5, PremiumRide.Premium),
                new Ride(0.2, 2, PremiumRide.Premium)
        };
        invoiceGenerator.addRides(userID, rides);
        double rideDetails = invoiceGenerator.getRidesDetails(userID);
        int NoOfRides = invoiceGenerator.numberOfRides(rides);
        Assertions.assertEquals(20, rideDetails, 0.0);
    }
/*    @Test
    public void addingPremiumAndNormalRide() {
        String userID = "Driver1";
        Ride[] rides = new Ride[]{new Ride(10, 5, PremiumRide.Premium),
                new Ride(20, 2, PremiumRide.Normal)
        };
        invoiceGenerator.addRides(userID, rides);
        double rideDetails = invoiceGenerator.getRidesDetails(userID);
        Assertions.assertEquals(307,rideDetails, 0.0);
    }*/
}