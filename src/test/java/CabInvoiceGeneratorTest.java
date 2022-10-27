import com.bridgeLabz.CabInvoiceGenerator.CabInvoiceGenerator;
import com.bridgeLabz.CabInvoiceGenerator.InvoiceSummary;
import com.bridgeLabz.CabInvoiceGenerator.RideRepo;
import com.bridgeLabz.CabInvoiceGenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare(){
        CabInvoiceGenerator invoiceGen = new CabInvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare = invoiceGen.calculateFare(distance, time );
        Assert.assertEquals(25,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnMinFare(){
        CabInvoiceGenerator invoiceGen = new CabInvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare = invoiceGen.calculateFare(distance, time );
        Assert.assertEquals(5,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnInvoiceSummary(){
        CabInvoiceGenerator invoiceGen = new CabInvoiceGenerator();
        Rides[] rides = { new Rides(2.0, 5), new Rides(0.1, 1) };
        InvoiceSummary invoiceSummary = invoiceGen.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedSummary,invoiceSummary);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnInvoice(){
        HashMap<Integer,Rides[]> rideRepo = new HashMap<>();
        Rides[] rides1 ={new Rides(2.0,5),new Rides(0.1,1)};
        Rides[] rides2 ={new Rides(10.0,2),new Rides(5.0,1)};
        Rides[] rides3 ={new Rides(7.0,3),new Rides(5.0,1)};
        Rides[] rides4 ={new Rides(4.0,3),new Rides(5.0,4)};
        rideRepo.put(1,rides1);
        rideRepo.put(2,rides2);
        rideRepo.put(3,rides3);
        rideRepo.put(4,rides4);
        int userID = 1;
        RideRepo rideRepository = new RideRepo(rideRepo,userID);
        InvoiceSummary invoiceSummary = rideRepository.calculateFare();
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedSummary, invoiceSummary);

    }
}