package base;

import java.awt.*;
import java.io.IOException;

public class Execute {
    static BookManager bm = new BM6();

    public static void main(String[] args) throws IOException {
        bm.init();
        bm.interactWithUser();

    }
}