package base;

import java.util.ArrayList;
import java.util.Scanner;

// BookManager를 구현하는 구현 객체
public class BM extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addBook(Book book) {
        System.out.println("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
        int bookNum = scanner.nextInt();
        System.out.println("(2) 도서명을 입력해주세요. >> ");
        String bookName = scanner.nextLine();
        System.out.println("(3) 저자명을 입력해주세요. >> ");
        String name = scanner.nextLine();
        System.out.println("(4) isbn을 입력해주세요. >> ");
        System.out.println("(5) 출간일을 입력해주세요.(YYYY-MM-DD형식) >> ");
        System.out.println("--- 도서 [" + "] 등록이 완료되었습니다. ---");
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

    }

    @Override
    public void removeBook(Book book) {

    }
}
