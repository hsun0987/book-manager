package base;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String name;
    private String author;
    private Long isbn;
    private LocalDate publishedDate;

    private int bookType;

    public Book(Long id, String name, String author, Long isbn, LocalDate publishedDate,int bookType) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.bookType = bookType;
    }

    public Book() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getBookType() { return bookType; }

    public void setBookType(int bookType) { this.bookType = bookType; }


}