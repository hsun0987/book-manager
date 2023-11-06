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
    Book getBook(Long id){ return books.get(id); }
    List<Book> getBooks(){ return new ArrayList<>(books.values()); }
    List<Book> getBooks(Predicate<Book> predicate);
    List<Book> getBooks(Comparator<Book> comparator);
    boolean setBook(Book book);
    boolean removeBook(Long id){
        books.remove(books);
    }
}
