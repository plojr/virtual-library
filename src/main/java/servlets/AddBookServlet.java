package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AuthorBookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import models.Book;

//This class doesn't need the @WebServlet annotation because its path is in the web.xml file.
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// The idea here is to save the book object into the database and then call doGet
		try {
			Book book = null;
			// Check if the date was not filled. In this case, call Book's constructor with 2 parameters
			if(request.getParameter("finishDate").equals(""))
				book = new Book(request.getParameter("name"), Integer.parseInt(request.getParameter("numberOfPages")));
			else {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = formatter.parse(request.getParameter("finishDate"));
				book = new Book(request.getParameter("name"), Integer.parseInt(request.getParameter("numberOfPages")), date);
			}
			// Get the number of authors the came from the addbook.jsp. The input field has a name of numberOfPages.
			int numberOfAuthors = Integer.parseInt(request.getParameter("numberOfAuthors"));
			// Save all the authors in a list, so you can call the AuthorBookDAO.save() method.
			List<Author> authors = new ArrayList<Author>();
			for(int i = 0; i < numberOfAuthors; i++) {
				String authorName = request.getParameter("author" + String.valueOf(i));
				if(!authorName.equals(""))
					authors.add(new Author(authorName));
			}
			// Finally, with all authors inside a list, you can add the book and its authors.
			AuthorBookDAO.save(authors, book);
		} catch(Exception e) {
			System.out.println("Boook not saved. Reason: " + e.getMessage());
		}
		doGet(request, response);
	}

}
