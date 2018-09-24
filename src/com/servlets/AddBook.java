package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddBook
 */
@WebServlet("/addme")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String author=request.getParameter("author");
		String publication=request.getParameter("publication");
		String bookname=request.getParameter("bookname");
		Float price=Float.parseFloat(request.getParameter("bookprice"));
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		Book book=new Book(isbn, bookname, publication, author, price);
		BookDAO dao=new BookDAOimpl();
		int rows=dao.addBook(book);
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		if(rows>0)
		{

			writer.println("book inserted successfully");
		}
		else
		{
			String message="sorry cannot add book please retry";
			RequestDispatcher d=request.getRequestDispatcher("fetch3");
			d.forward(request, response);
			
		}
	}

}
