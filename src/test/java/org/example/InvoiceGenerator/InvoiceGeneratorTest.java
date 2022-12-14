package org.example.InvoiceGenerator;

import org.junit.Test;

import static org.junit.Assert.*;
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
        Ride[] rides={new Ride(1.0,5),
                new Ride(0.2,2)};
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummery=new InvoiceSummary(2,20);
        Assertions.assertEquals(expectedInvoiceSummery,summary);
    }
}