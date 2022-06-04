package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;

public class FinishDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FinishDateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = BookDAO.getBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("finishdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int size = Integer.parseInt(request.getParameter("listSize"));
			System.out.println("Size: " + size);
			for(int i = 0; i < size; i++) {
				int id = Integer.parseInt(request.getParameter("id"+i));
				String name = request.getParameter("name" + i);
				int numberOfPages = Integer.parseInt(request.getParameter("numberOfPages" + i));
				String dateString = request.getParameter("finishDate" + i);
				Date date = null;
				if(!dateString.equals("")) {
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = formatter.parse(dateString);
				}
				else {
					System.out.println("Not read yet");
				}
				Book book = new Book(id, name, numberOfPages, date);
				BookDAO.update(book);
			}
		} catch(Exception e) {
			System.out.println("Error on assigning a finish date. Reason: " + e.getMessage());
		} finally {
			doGet(request, response);
		}
	}

}
