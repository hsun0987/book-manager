package base;

import java.time.LocalDate;

public class EBook extends Book{
    String filesize;

    EBook(){};

    EBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String filesize, int bookType){
        super(id, name, author, isbn, publishedDate,bookType);
        this.filesize = filesize;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }
}