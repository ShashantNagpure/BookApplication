package com.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Connect.MyConnection;
import com.beans.Book.Book;
import com.dao.BookDAO;

public class BookDAOimpl implements BookDAO {

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		try {

			String ADDBOOK = "insert into book values(?,?,?,?,?)";
			Connection con = MyConnection.openConnection();

			PreparedStatement ps = con.prepareStatement(ADDBOOK);
			ps.setInt(1, book.getISBN());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookPublication());
			ps.setString(4, book.getAuthor());
			ps.setFloat(5, book.getPrice());
			rowsAdded = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rowsAdded;
	}

	@Override
	public boolean updateBook(int ISBN, Book book) {
		boolean isUpdated = false;
		String UPDATE_BOOK = "update book set price=? where ISBN=?";
		try (Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(UPDATE_BOOK);
			ps.setFloat(1, book.getPrice());
			ps.setInt(2, ISBN);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				isUpdated = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public Book findBookbyISBN(int isbn) {
		// int rowsDeleted=0;
		String DELETE_BOOK = "select * from book where ISBN=?";
		Book bo = new Book();
		try (Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(DELETE_BOOK);
			ps.setInt(1, isbn);
			ResultSet set = ps.executeQuery();
			// int ISBN=set.getInt(1);
			while (set.next()) {
				String bookName = set.getString("bookname");
				String author = set.getString("author");
				String pub = set.getString("publication");
				float price1 = set.getFloat("price");
				bo.setAuthor(author);
				bo.setBookName(bookName);
				bo.setBookPublication(pub);
				bo.setPrice(price1);
				bo.setISBN(isbn);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// return rowsDeleted;

		return bo;
	}

	@Override
	public List<Book> findAllBooks(){
		// int rowsDeleted=0;
		String DELETE_BOOK = "select * from book ";
		List<Book>bo=new ArrayList<>();
		try (Connection con = MyConnection.openConnection()) {
			java.sql.Statement ps=con.createStatement();
			ResultSet set = ps.executeQuery(DELETE_BOOK);
			// int ISBN=set.getInt(1);
			while (set.next()) {
				int isbn=set.getInt(1);
				String bookName = set.getString("bookname");
				String author = set.getString("author");
				String pub = set.getString("publication");
				float price1 = set.getFloat("price");
				bo.add(new Book(isbn, bookName, pub, author, price1));

			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// return rowsDeleted;

		return bo;
	}

	@Override
	public List<Book> findAllBooksByprice(float price) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
		String FIND_BY_PRICE = "select * from book where price=?";
		try (Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_BY_PRICE);
			ps.setFloat(1, price);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				int ISBN = set.getInt(1);
				// String boset.getInt("bookname");
				String bookName = set.getString("bookname");
				String author = set.getString("author");
				String pub = set.getString("publication");
				float price1 = set.getFloat("price");
				Book book = new Book(ISBN, bookName, pub, author, price1);
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public int deleteBook(int isbn) {
		// TODO Auto-generated method stub
		int rowsDeleted = 0;
		String DELETE_BOOK = "delete from book where ISBN=?";
		try (Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(DELETE_BOOK);
			ps.setInt(1, isbn);
			rowsDeleted = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
