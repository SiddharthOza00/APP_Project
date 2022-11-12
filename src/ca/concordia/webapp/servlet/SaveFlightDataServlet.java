package ca.concordia.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.webapp.db.DbOperations;
import ca.concordia.webapp.util.Constants;
import ca.concordia.webapp.vo.Flight;

@WebServlet("/saveFlightData")
public class SaveFlightDataServlet extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isUpdate = Integer.parseInt(request.getParameter("updateFlag")) == 1;
		String flightNumber = request.getParameter("flightNumber") != null ? request.getParameter("flightNumber") : "";
		if (flightNumber.isEmpty()) {
			response.sendRedirect(Constants.ROOT_PATH + "?status=" + Constants.STATUS_ERROR);
			return;
		}
		Flight flight = new Flight();
		flight.setFlightNumber(flightNumber);
		flight.setRegNumber(request.getParameter("regNumber"));
		flight.setHex(request.getParameter("hex"));
		flight.setLat(Double.parseDouble(request.getParameter("lat")));
		flight.setLng(Double.parseDouble(request.getParameter("lng")));
		flight.setAlt(Integer.parseInt(request.getParameter("alt")));
		flight.setArrIata(request.getParameter("arrIata"));
		flight.setDepIata(request.getParameter("depIata"));
		flight.setFlag(request.getParameter("flag"));
		flight.setSpeed(Integer.parseInt(request.getParameter("speed")));
		flight.setStatus(request.getParameter("status"));

		int status = 0;
		if (!isUpdate) {
			status = DbOperations.insert(flight) != 0 ? Constants.STATUS_INSERTED : 0;
		} else {
			status = DbOperations.update(flight) != 0 ? Constants.STATUS_UPDATED : 0;
		}

		response.sendRedirect(Constants.ROOT_PATH + "?status=" + status);
	}

}
