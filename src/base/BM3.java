package base;

import java.time.LocalDate;
import java.util.*;

// BookManager를 구현하는 구현 객체
public class BM3 extends BookManager {

    private ArrayList<Book> bookList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    @Override
    void init() {
        bookList.add(new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"), LocalDate.parse("2020-06-15")));
        bookList.add(new Book(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20")));
        bookList.add(new Book(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2023-07-19")));
    }

    @Override
    void interactWithUser() {
        while (true) {
            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
            System.out.println("(1) 도서 조회");
            System.out.println("(2) 도서 등록");
            System.out.println("(3) 도서 수정");
            System.out.println("(4) 도서 삭제");
            System.out.println("(q) 프로그램 종료");
            System.out.print("선택 >> ");
            String userInput = sc.nextLine();


            switch (userInput) {
                case "1":
                    // 조회
                    System.out.println("1. 전체 조회");
                    System.out.println("2. 책 제목 조회");
                    System.out.println("3. 책 제목순 정렬");
                    System.out.println("4. 출간일 기간 조회");
                    System.out.println("5. 출간일 기간순 정렬");
                    System.out.print("선택 >> ");
                    String op = sc.nextLine();

                    switch (op){
                        case "1":
                            printAllBook();
                            break;
                        case "2":
                            printBookName();
                            break;
                        case "3":
                            bookNameSort();
                            break;
                        case "4":
                            printPublishedDate();
                            break;
                        case "5":
                            dateSort();
                            break;
                    }
                    break;
                case "2":
                    // 등록
                    addBook();
                    break;
                case "3":
                    // 수정
                    updateBook();
                    break;
                case "4":
                    // 삭제
                    removeBook();
                    break;
                case "5":
                    printBookName();
                    break;
                case "q":
                    // 메소드를 종료
                    System.out.println("프로그램 종료!");
                    return;
            }
        }
    }

    @Override
    public void addBook() {
        try {
            System.out.println("등록 메서드 실행");
            // 1. 콘솔화면을 통해 사용자로부터 도서정보를 입력을 받는다.
            // id, 제목, 저자, isbn, 출판일 (5가지) (v)
            // 위의 정보로 책 객체를 생성한다. (v)
            // 2. 도서를 등록한다.
            // 사서를 통해 도서 저장 요청
            String[] bookInfo = new String[9];

            System.out.println("등록할 책의 종류를 선택해주세요.");
            System.out.println("(1)Book");
            System.out.println("(2)EBook");
            System.out.println("(3)AudioBook");
            System.out.print("선택 >> ");
            int bookType = Integer.parseInt(sc.nextLine());

            System.out.print("id: ");
            bookInfo[0] = sc.nextLine();
            System.out.print("제목: ");
            bookInfo[1] = sc.nextLine();
            System.out.print("저자: ");
            bookInfo[2] = sc.nextLine();
            System.out.print("isbn: ");
            bookInfo[3] = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            bookInfo[4] = sc.nextLine();

            if (bookType == 1) {
                // book을 저장소에 저장
                Book book = new Book(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]));
                bookList.add(book);
            } else if (bookType == 2) {
                // ebook을 저장소에 저장
                System.out.print("파일 크기: ");
                bookInfo[5] = sc.nextLine();
                Book eBook = new EBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        bookInfo[5]);
                bookList.add(eBook);
            } else if (bookType == 3) {
                // audiobook을 저장소에 저장
                System.out.print("파일 크기: ");
                bookInfo[5] = sc.nextLine();
                System.out.print("언어: ");
                bookInfo[6] = sc.nextLine();
                System.out.print("실행시간: ");
                bookInfo[7] = sc.nextLine();

                Book audioBook = new AudioBook(Long.parseLong(bookInfo[0]),
                        bookInfo[1],
                        bookInfo[2],
                        Long.parseLong(bookInfo[3]),
                        LocalDate.parse(bookInfo[4]),
                        bookInfo[5],
                        bookInfo[6],
                        Integer.parseInt(bookInfo[7]));
                bookList.add(audioBook);
            }else
                System.out.print("책 종류에 해당하지 않습니다.");
        }catch (Exception e){
            System.out.println("예외가 발생했습니다.");
        }
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
            if (book instanceof EBook){
                System.out.print(((EBook)book).getFilesize());
            }
            if(book instanceof AudioBook){
                System.out.print(((AudioBook)book).getFilesize());
                System.out.print(", ");
                System.out.print(((AudioBook)book).getLanguage());
                System.out.print(", ");
                System.out.print(((AudioBook)book).getPlayTime());
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printBookName(){
        System.out.print("책 제목 : ");
        String bookName = sc.nextLine();
        for (Book book : bookList) {
            if(bookName.equals(book.getName())){
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
                if (book instanceof EBook){
                    System.out.print(((EBook)book).getFilesize());
                }
                if(book instanceof AudioBook){
                    System.out.print(((AudioBook)book).getFilesize());
                    System.out.print(", ");
                    System.out.print(((AudioBook)book).getLanguage());
                    System.out.print(", ");
                    System.out.print(((AudioBook)book).getPlayTime());
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    class NameComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            if (o1.getName().compareTo(o2.getName()) > 0) return 1;
            if (o1.getName().compareTo(o2.getName()) < 0) return -1;
            return 0;
        }
    }

    public void bookNameSort(){
        Collections.sort(bookList, new NameComparator());
        printAllBook();
    }


    class DateComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            if (o1.getPublishedDate().isAfter(o2.getPublishedDate())) return 1;
            if (o1.getPublishedDate().isBefore(o2.getPublishedDate())) return -1;
            return 0;
        }
    }
    public void dateSort(){ // 출간일 정렬
        Collections.sort(bookList, new DateComparator());
        printAllBook();
    }

    public void printPublishedDate(){
        System.out.print("조회 시작일 : ");
        String start = sc.nextLine();
        System.out.print("조회 종료일 : ");
        String end = sc.nextLine();

        for (Book book : bookList) {
            if(book.getPublishedDate().isAfter(LocalDate.parse(start))  &&  book.getPublishedDate().isBefore(LocalDate.parse(end))){
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
                if (book instanceof EBook){
                    System.out.print(((EBook)book).getFilesize());
                }
                if(book instanceof AudioBook){
                    System.out.print(((AudioBook)book).getFilesize());
                    System.out.print(", ");
                    System.out.print(((AudioBook)book).getLanguage());
                    System.out.print(", ");
                    System.out.print(((AudioBook)book).getPlayTime());
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    @Override
    public void updateBook() {
        try{
            System.out.println("수정 메서드 실행");
            // 1. 수정할 도서를 찾는다. (사서는 알 수 있다.) (v)
            // 있으면 수정 가능
            // 없으면 수정 불가
            // 2. 수정할 도서가 있을 때:
            // 새로운 입력 값 : 사용자로부터 입력받는다.
            // 도서 정보(필드)를 바꾼다.

            System.out.print("수정할 도서번호를 입력해주세요: ");
            String id = sc.nextLine();
            Book book = findBook(Long.parseLong(id));

            // 책이 존재하지 않을 때
            if (book == null) {
                System.out.println("입력하신 책을 찾을 수 없습니다.");
                return;
            }
            // 책이 존재할 때
            String[] bookInfo = new String[9];
            bookInfo[0] = id;
            System.out.println("[수정 정보를 입력해주세요]");
            System.out.print("제목: ");
            bookInfo[1] = sc.nextLine();
            System.out.print("저자: ");
            bookInfo[2] = sc.nextLine();
            System.out.print("isbn: ");
            bookInfo[3] = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            bookInfo[4] = sc.nextLine();

            book.setName(bookInfo[1]);
            book.setAuthor(bookInfo[2]);
            book.setIsbn(Long.parseLong(bookInfo[3]));
            book.setPublishedDate(LocalDate.parse(bookInfo[4]));
            if (book instanceof EBook){
                System.out.print("파일 크기: ");
                bookInfo[5] = sc.nextLine();

                ((EBook)book).setFilesize(bookInfo[5]);
            }
            if(book instanceof AudioBook){
                System.out.print("파일 크기: ");
                bookInfo[5] = sc.nextLine();
                System.out.print("언어: ");
                bookInfo[6] = sc.nextLine();
                System.out.print("실행시간: ");
                bookInfo[7] = sc.nextLine();

                ((AudioBook)book).setFilesize(bookInfo[5]);
                ((AudioBook)book).setLanguage(bookInfo[6]);
                ((AudioBook)book).setPlayTime(Integer.parseInt(bookInfo[7]));
            }
        }catch (Exception e){
            System.out.println("예외가 발생했습니다.");
        }
    }

    @Override
    public void removeBook() {
        System.out.println("삭제 메서드 실행");
        // 1. 삭제할 도서를 찾는다.
        // 없으면 삭제 불가
        // 있으면 삭제 가능
        // 2. 삭제할 도서가 있다면
        // 사서한테 도서 삭제 요청
        System.out.print("삭제할 도서번호를 입력해주세요: ");
        String id = sc.nextLine();

        Book book = findBook(Long.parseLong(id));
        if (book == null) {
            System.out.println("입력하신 책을 찾을 수 없습니다.");
        }
        bookList.remove(book);
    }

    public Book findBook(long id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
                return book;
            }
        }
        // bookList를 다 돌았는데 해당 id의 도서를 못찾았다.
        return null;
    }
}