package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Book.Book;
import com.dao.BookDAO;
import com.dao.impl.BookDAOimpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		BookDAO dao=new BookDAOimpl();
		int deleted=dao.deleteBook(isbn);
		List<Book> list=dao.findAllBooks();
		request.setAttribute("books", list);
		RequestDispatcher d=request.getRequestDispatcher("show_jstl.jsp");
		d.forward(request, response);
		
	}

}
