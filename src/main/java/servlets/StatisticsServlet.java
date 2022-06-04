package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.StatisticsUtil;

public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StatisticsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatisticsUtil stats = new StatisticsUtil();
		request.setAttribute("totalNumber", stats.getTotalNumberOfReadBooks());
		request.setAttribute("booksByYear", stats.getNumberOfReadBooksByYear());
		request.setAttribute("booksByMonthYear", stats.getNumberOfReadBooksByMonthYear());
		request.getRequestDispatcher("statistics.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
