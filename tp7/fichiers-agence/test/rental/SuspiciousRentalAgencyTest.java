package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuspiciousRentalAgencyTest {

	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient() 
					throws IllegalStateException, UnknownVehicleException {
		SuspiciousRentalAgency agency = new SuspiciousRentalAgency();
		Vehicle v = new Vehicle("Vroum", "Vroum", 2000, 100);
		agency.addVehicle(v);
		Client client1 = new Client("Tim Oleon", 25);
		assertEquals(100, agency.rentVehicle(client1, v),0.0001);
		assertTrue(agency.hasRentedAVehicle(client1));
		// client2 corresponds to same client than client1 since names are equals
		Client client2 = new Client("Tim Oleon", 25);
		// then test should succeed
		assertTrue(agency.hasRentedAVehicle(client2));
	}
	
	@Test
	public void clientUnderAgeTwentyFiveChargedExtraCost() 
				throws IllegalStateException, UnknownVehicleException{
		SuspiciousRentalAgency agency = new SuspiciousRentalAgency();
		Vehicle v = new Vehicle("Vroum", "Vroum", 2000, 100);
		agency.addVehicle(v);
		Client client1 = new Client("Tim Oleon", 28);
		Client client2 = new Client("Leaon Tim", 20);
		assertEquals(100, agency.rentVehicle(client1, v),0.0001);
		agency.returnVehicle(client1);
		assertEquals(110, agency.rentVehicle(client2, v),0.0001);	
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.SuspiciousRentalAgencyTest.class);
	}

}
