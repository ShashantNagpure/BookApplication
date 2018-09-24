package com.servlets;

import java.io.IOException;
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
 * Servlet implementation class FetchServlet2
 */
@WebServlet("/fetch2")
public class FetchServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO dao=new BookDAOimpl();
		List<Book>list=dao.findAllBooks();
		request.setAttribute("books", list);
		RequestDispatcher d=request.getRequestDispatcher("update2.jsp");
		d.forward(request, response);
	}

}
