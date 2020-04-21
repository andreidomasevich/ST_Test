import Helper.FileReader;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

class BaseTest {

    private static final String WORK_PAGE_URL = "WORK_PAGE_URL";

    private String url;

    BaseTest () throws IOException {
        url = FileReader.getValue(WORK_PAGE_URL);
    }

    void openWorkPage() {
        open(url);
    }

    void quit(){
        quit();
    }
}
