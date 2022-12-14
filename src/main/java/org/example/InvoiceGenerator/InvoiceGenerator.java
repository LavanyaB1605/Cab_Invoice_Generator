package org.example.InvoiceGenerator;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare=distance*MINIMUM_COST_PER_KM+time*COST_PER_TIME;
        return totalFare < MINIMUM_FARE ? MINIMUM_FARE : totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides)
            totalFare+=this.calculateFare(ride.distance,ride.time);
        return new InvoiceSummary(rides.length,totalFare);
    }
    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        return totalFare;
    }

    public int numberOfRides(Ride[] rides) {
        return rides.length;
    }

    public double calculateAverageFarePerRide(Ride[] rides) {
        double totalFare = this.calculateTotalFare(rides);
        double numberOfRides = rides.length;
        double averageFare = totalFare/numberOfRides;
        return averageFare;
    }

}
