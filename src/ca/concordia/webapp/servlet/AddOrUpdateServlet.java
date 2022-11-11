package ca.concordia.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.webapp.db.DbOperations;
import ca.concordia.webapp.vo.Flight;

@WebServlet("/addOrUpdate")
public class AddOrUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightNumber = request.getParameter("flightNumber") != null ? request.getParameter("flightNumber") : "";
		Flight flight;
		if (flightNumber.isEmpty()) {
			flight = new Flight();
		} else {
			flight = DbOperations.get(flightNumber);
		}
		
		String flightNumberList = DbOperations.getAllFlightNumbers();
		request.setAttribute("flightNumberList", flightNumberList);

		
		request.setAttribute("flight", flight);
		request.getRequestDispatcher("addOrUpdate.jsp").forward(request, response);
	}

}
