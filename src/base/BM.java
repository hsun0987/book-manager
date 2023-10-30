package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// BookManager를 구현하는 구현 객체
public class BM extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addBook(Book book) {

        bookList.add(book);
        System.out.println("--- 도서 [" + book.getName() +  "] 등록이 완료되었습니다. ---");
    }

    @Override
    public void printAllBook() {
        for (Book book : bookList) {
            System.out.print("[");
            System.out.print(book.getId());
            System.out.print(", ");
            System.out.print(book.getName());
            System.out.print(", ");
            System.out.print(book.getAuthor());
            System.out.print(", ");
            System.out.print(book.getIsbn());
            System.out.print(", ");
            System.out.print(book.getPublishedDate());
            System.out.print("]");
            System.out.println();
        }
    }

    @Override
    public void updateBook(Book book) {
      /*  for (Book b: bookList){
            if(book.getId().equals(bookList.))
                userInput = 1;
        }*/

      // bookList.indexOf(book).setId(book.getId());
    }

    @Override
    public void removeBook(Book book) {
       // bookList.remove(bookList.indexOf(book));
    }
}
