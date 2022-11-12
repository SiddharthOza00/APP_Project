package ca.concordia.webapp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.concordia.webapp.util.Constants;
import ca.concordia.webapp.vo.Flight;

public class DbOperations {
	public static int insert(Flight flight) {
		int rowUpdated = 0;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstat = con.prepareStatement(Constants.INSERT_QUERY)) {
			pstat.setString(1, flight.getFlightNumber());
			pstat.setString(2, flight.getHex());
			pstat.setString(3, flight.getRegNumber());
			pstat.setDouble(4, flight.getLat());
			pstat.setDouble(5, flight.getLng());
			pstat.setInt(6, flight.getAlt());
			pstat.setString(7, flight.getArrIata());
			pstat.setString(8, flight.getDepIata());
			pstat.setString(9, flight.getFlag());
			pstat.setInt(10, flight.getSpeed());
			pstat.setString(11, flight.getStatus());
			rowUpdated = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public static int multipleInsert(List<Flight> flights) {
		if (flights.size() <= 0) {
			return 0;
		}
		int rowUpdated = 0;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement stat = con.prepareStatement(Constants.INSERT_QUERY)) {
			for (Flight flight : flights) {
				stat.setString(1, flight.getFlightNumber());
				stat.setString(2, flight.getHex());
				stat.setString(3, flight.getRegNumber());
				stat.setDouble(4, flight.getLat());
				stat.setDouble(5, flight.getLng());
				stat.setInt(6, flight.getAlt());
				stat.setString(7, flight.getArrIata());
				stat.setString(8, flight.getDepIata());
				stat.setString(9, flight.getFlag());
				stat.setInt(10, flight.getSpeed());
				stat.setString(11, flight.getStatus());
				stat.addBatch();
			}
			int batch[] = stat.executeBatch();
			for (int a : batch)
				rowUpdated += a;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public static int update(Flight flight) {
		int rowUpdated = 0;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstat = con.prepareStatement(Constants.UPDATE_QUERY)) {
			pstat.setString(1, flight.getHex());
			pstat.setString(2, flight.getRegNumber());
			pstat.setDouble(3, flight.getLat());
			pstat.setDouble(4, flight.getLng());
			pstat.setInt(5, flight.getAlt());
			pstat.setString(6, flight.getArrIata());
			pstat.setString(7, flight.getDepIata());
			pstat.setString(8, flight.getFlag());
			pstat.setInt(9, flight.getSpeed());
			pstat.setString(10, flight.getStatus());
			pstat.setString(11, flight.getFlightNumber());

			rowUpdated = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public static int delete(String flightId) {
		int rowUpdated = 0;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstat = con.prepareStatement(Constants.DELETE_QUERY)) {
			pstat.setString(1, flightId);
			rowUpdated = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public static Flight get(String flightId) {
		Flight flight = new Flight();
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstat = con.prepareStatement(Constants.RETRIEVE_ONE_QUERY)) {
			pstat.setString(1, flightId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				flight.setFlightNumber(rs.getString("flight_number"));
				flight.setHex(rs.getString("hex"));
				flight.setRegNumber(rs.getString("reg_number"));
				flight.setLat(rs.getDouble("lat"));
				flight.setLng(rs.getDouble("lng"));
				flight.setAlt(rs.getInt("alt"));
				flight.setArrIata(rs.getString("arr_iata"));
				flight.setDepIata(rs.getString("dep_iata"));
				flight.setFlag(rs.getString("flag"));
				flight.setSpeed(rs.getInt("speed"));
				flight.setStatus(rs.getString("status"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flight;
	}

	public static List<Flight> getAll() {
		List<Flight> flights = new ArrayList<>();
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstat = con.prepareStatement(Constants.RETRIEVE_ALL_QUERY)) {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Flight flight = new Flight();
				flight.setFlightNumber(rs.getString("flight_number"));
				flight.setHex(rs.getString("hex"));
				flight.setRegNumber(rs.getString("reg_number"));
				flight.setLat(rs.getDouble("lat"));
				flight.setLng(rs.getDouble("lng"));
				flight.setAlt(rs.getInt("alt"));
				flight.setArrIata(rs.getString("arr_iata"));
				flight.setDepIata(rs.getString("dep_iata"));
				flight.setFlag(rs.getString("flag"));
				flight.setSpeed(rs.getInt("speed"));
				flight.setStatus(rs.getString("status"));

				flights.add(flight);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	public static void truncate() {
		try (Connection con = DbConnection.getConnection(); Statement stat = con.createStatement()) {
			stat.execute("truncate table " + Constants.DB_TABLE_NAME);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getAllFlightNumbers() {
		try (Connection con = DbConnection.getConnection(); Statement stat = con.createStatement()) {
			ResultSet rs = stat.executeQuery("SELECT flight_number from " + Constants.DB_TABLE_NAME);
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {
				sb.append(rs.getString("flight_number")).append(',');
			}
			return sb.toString();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
