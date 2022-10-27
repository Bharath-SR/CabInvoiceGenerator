import com.bridgeLabz.CabInvoiceGenerator.CabInvoiceGenerator;
import com.bridgeLabz.CabInvoiceGenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

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
    public void givenDistanceAndTime_shouldReturnTotalFareCalculate(){
        CabInvoiceGenerator invoiceGen = new CabInvoiceGenerator();
        Rides[] rides = { new Rides(2.0, 5), new Rides(0.1, 1) };
        double fare = invoiceGen.calculateFare(rides);
        Assert.assertEquals(30, fare,0.0);
    }
}