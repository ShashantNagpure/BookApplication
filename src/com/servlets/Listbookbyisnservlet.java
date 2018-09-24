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
 * Servlet implementation class Listbookbyisnservlet
 */
@WebServlet("/listbook")
public class Listbookbyisnservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listbookbyisnservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int isbn=Integer.parseInt(request.getParameter("isbn"));
	List<Book>books=new ArrayList<>();
	BookDAO dao=new BookDAOimpl();
	Book book=dao.findBookbyISBN(isbn);
	books.add(book);
	request.setAttribute("books", books);
	RequestDispatcher d=request.getRequestDispatcher("show.jstl.jsp");
	d.forward(request, response);
	}

}
