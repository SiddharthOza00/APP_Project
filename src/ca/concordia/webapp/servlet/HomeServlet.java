package ca.concordia.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.webapp.api_request.API;
import ca.concordia.webapp.db.DbOperations;
import ca.concordia.webapp.util.Constants;
import ca.concordia.webapp.util.Utils;
import ca.concordia.webapp.vo.Flight;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean isFirstTime = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Flight> flights = new ArrayList<>();
		int status = request.getParameter("status") == null ? Constants.STATUS_NORMAL
				: Integer.parseInt(request.getParameter("status"));
		if (isFirstTime) {
			flights = API.getFlights();
			DbOperations.truncate();
			DbOperations.multipleInsert(flights);
			isFirstTime = false;
		} else {
			flights = DbOperations.getAll();
		}

		request.setAttribute("flights", flights);
		request.setAttribute("msg", Utils.getMessageFromStatus(status));
		request.setAttribute("status", status);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
