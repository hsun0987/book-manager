package base.repository;

import base.Book;

import java.util.*;
import java.util.function.Predicate;

public class HashMapBook implements BookRepository{

    private HashMap<Long, Book> books = new HashMap<Long, Book>();
    static Scanner sc = new Scanner(System.in);

    public void addBook(Book book){
        books.put(book.getId(), book);
    }
    public Book getBook(Long id){ return books.get(id); }
    public List<Book> getBooks(){ return new ArrayList<>(books.values()); }
    // List<Book> getBooks(Predicate<Book> predicate);
    // public List<Book> getBooks(Comparator<Book> comparator){}
    // boolean setBook(Book book);
    public void removeBook(Book book){ books.remove(book.getId()); }
}
