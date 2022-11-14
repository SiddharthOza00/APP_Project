
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import ca.concordia.webapp.db.DbOperations;
import ca.concordia.webapp.vo.Flight;
class Testing {

	@Test
	public void create() {
		DbOperations operator = new DbOperations();
		Flight flight = new Flight();
		flight.setFlightNumber("123");
		flight.setHex("1AB2");
		flight.setLat(21.12);
		flight.setLng(50.05);
		flight.setAlt(81);
		flight.setArrIata("AHM");
		flight.setDepIata("YUL");
		flight.setRegNumber("12345");
		flight.setSpeed(50);
		flight.setStatus("scheduled");
		flight.setFlag("AH");
		int check = operator.insert(flight);
		assertNotEquals(flight, null);
	}
	
	@Test
	public void update() {
		DbOperations operator = new DbOperations();
		Flight flight = operator.get("2312");
		flight.setArrIata("AHM");
		flight.setDepIata("YUL");
		int check = operator.update(flight);
		assertNotEquals(flight, null);
	}

	@Test
	public void delete() {
		DbOperations operator = new DbOperations();
		int flight2 = operator.delete("2550");
		Flight flight = operator.get("2550");
		assertNotEquals(flight, null);
		assertTrue(flight2 > 0);
	}
	
	@Test
	public void getFlightId() {
		DbOperations operator = new DbOperations();
		Flight flight = operator.get("57");
		assertNotEquals(flight, null);
		assertNotEquals(flight.getStatus(), " ");
	}
	
	
	
	
	@Test
	public void getAllFlights() {
		DbOperations operator = new DbOperations();
		List<Flight> flights = operator.getAll();
		assertNotEquals(flights, null);
		System.out.println(flights.size());
		assertTrue(flights.size() > 0);
	}
}
