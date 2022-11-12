package ca.concordia.webapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;

import ca.concordia.webapp.vo.Flight;

public class Utils {
	private static final Logger logger = Logger.getLogger(Utils.class.getName());

	public static List<Flight> convertJsonToList(String json) {
		logger.info("Utils.convertJsonToList start...");
		List<Flight> flights = new ArrayList<>();
		try {
			JSONArray flightsArray = new JSONArray(json);
			for (int index = 0; index < flightsArray.length(); index++) {
				JSONArray fArray = flightsArray.getJSONArray(index);
				Flight flight = new Flight();
				flight.setFlightNumber(fArray.getString(0));
				flight.setHex(fArray.getString(1));
				flight.setRegNumber(fArray.getString(2));
				flight.setFlag(fArray.getString(3));
				flight.setLat(fArray.getDouble(4));
				flight.setLng(fArray.getDouble(5));
				flight.setAlt(fArray.getInt(6));
				flight.setArrIata(fArray.getString(7));
				flight.setDepIata(fArray.getString(8));
				flight.setSpeed(fArray.getInt(9));
				flight.setStatus(fArray.getString(10));

				flights.add(flight);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		logger.info("Utils.convertJsonToList end...");
		return flights;
	}

	public static String getMessageFromStatus(int status) {
		switch (status) {
		case Constants.STATUS_INSERTED:
			return "Data Inserted Successfully.";
		case Constants.STATUS_UPDATED:
			return "Data Updated Successfully.";
		case Constants.STATUS_DELETED:
			return "Data Deleted Successfully.";
		case Constants.STATUS_ERROR:
			return "Something Went Wrong";
		default:
			return null;
		}
	}
}
