package base;

import java.time.LocalDate;

public class AudioBook extends Book{
    String filesize;
    String language;
    int playTime;

    AudioBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String filesize, String language, int playTime){
        super(id, name, author, isbn, publishedDate);
        this.filesize = filesize;
        this.language = language;
        this.playTime = playTime;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
}

