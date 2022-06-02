package servlets;

import java.io.IOException;
import java.util.List;

import dao.AuthorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;

// This class needs this @WebServlet annotation beucase there is no mention of its path in the web.xml file.

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		List<Author> authors = AuthorDAO.getAuthors();
		for(Author author: authors)
			System.out.println(author);
	}
	
    public AuthorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Author> authors = AuthorDAO.getAuthors();
		request.setAttribute("authors", authors);
		request.getRequestDispatcher("authors.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
