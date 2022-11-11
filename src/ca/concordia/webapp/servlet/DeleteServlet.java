package ca.concordia.webapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import ca.concordia.webapp.db.DbConnection;
import ca.concordia.webapp.db.DbOperations;
import ca.concordia.webapp.util.Constants;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flightNumber = request.getParameter("flightNumber") != null ? request.getParameter("flightNumber") : "";

		int status = Constants.STATUS_ERROR;
		if (!flightNumber.isEmpty()) {
			status = DbOperations.delete(flightNumber) != 0 ? Constants.STATUS_DELETED : status;
		}
		response.sendRedirect(Constants.ROOT_PATH + "?status=" + status);
	}

}
