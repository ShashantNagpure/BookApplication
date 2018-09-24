package com.dao;
import java.util.List;

import com.beans.Book.*;
public interface BookDAO {
int addBook(Book book);
boolean updateBook(int ISBN,Book book);
Book findBookbyISBN(int isbn);
List<Book>findAllBooks();
List<Book>findAllBooksByprice(float price);
int deleteBook(int isbn);


}
 