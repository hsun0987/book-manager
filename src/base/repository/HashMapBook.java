package base.repository;

import base.Book;

import java.util.*;
import java.util.function.Predicate;

public class HashMapBook implements BookRepository{

    private HashMap<Long, Book> books = new HashMap<Long, Book>();

    static Scanner sc = new Scanner(System.in);

    void addBook(Book book){
        books.put(book.getId(), book);
    }
    Book getBook(Long id){

    }
    List<Book> gethashMapBook();
    List<Book> gethashMapBook(Predicate<Book> predicate);
    List<Book> gethashMapBook(Comparator<Book> comparator);
    boolean setBook(Book book);
    boolean removeBook(Long id){
        books.remove(books);
    }
}
