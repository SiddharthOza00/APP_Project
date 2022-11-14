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

@WebServlet("/search")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightNumber = request.getParameter("flightNumber") != null ? request.getParameter("flightNumber") : "";
		Flight flight = DbOperations.get(flightNumber);

		if (flight.getFlightNumber() == null || flight.getFlightNumber().isEmpty()) {
			response.sendRedirect(Constants.ROOT_PATH + "?status=" + Constants.STATUS_SEARCH_ERROR);
		} else {
			String flightNumberList = DbOperations.getAllFlightNumbers();
			request.setAttribute("flightNumberList", flightNumberList);

			request.setAttribute("flight", flight);
			request.getRequestDispatcher("addOrUpdate.jsp").forward(request, response);
		}
	}

}
