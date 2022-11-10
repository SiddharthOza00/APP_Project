package ca.concordia.webapp.api_request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import ca.concordia.webapp.util.Constants;
import ca.concordia.webapp.util.Utils;
import ca.concordia.webapp.vo.Flight;

public class API {
	private static final Logger logger = Logger.getLogger(API.class.getName());

	public static List<Flight> getFlights() {
		logger.info("API.getFlights start...");

		List<Flight> flights = new ArrayList<>(100);
		int limit = Constants.FLIGHT_LIMIT;
		try {
			String jsonArray = getAPIData(Constants.API_FLIGHT);
			flights = Utils.convertJsonToList(jsonArray);

			Collections.shuffle(flights);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Flights Data:" + flights.size());
		logger.info("API.getFlights end...");
		limit = Math.min(limit, flights.size());
		return flights.subList(0, limit);
	}

	public static String getAPIData(String apiUrl) throws IOException {
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		conn.connect();
		String data = "";
		try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			String line;

			while ((line = bf.readLine()) != null) {
				data += line;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
