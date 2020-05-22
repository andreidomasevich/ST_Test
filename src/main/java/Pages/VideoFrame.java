package Pages;

import Helper.FileReader;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VideoFrame extends BasePage{

    private static final String getVideoPlayerElement = "return document.querySelector('.html5-video-player')";// получаю объект плеера
    private static final String getPlayerState = getVideoPlayerElement + ".getPlayerState()";// js-метод для получения состояния объекта
    private static final String getCurrentTime = getVideoPlayerElement + ".getCurrentTime()";// js-метод для получения текущего времени видео
    private String videoSource = "";
    private static final By videoLocator = By.xpath("*//video");
    private static final int YOUTUBE_PLAYER_STATE_PLAY = 1;
    private static final String PLAYER_TIME_LIMIT = "PLAYER_TIME_LIMIT";

    private WorkPage workPage = new WorkPage();
    private SelenideElement videoFrame = workPage.getFrame();
    //private SelenideElement videoFrame = workPage.getFrame();

    private SelenideElement getFrame(){
        videoSource = videoFrame.getAttribute("src");
        return videoFrame;
    }

    public String getVideoSource(){

        return videoSource;
    }

    private SelenideElement getVideo(){
        return $(videoLocator).shouldBe(visible);
    }

    public Boolean checkVideoDisplayed(){

        if(getVideo().isDisplayed())
            return true;

        return false;
    }

    // посмотрел YouTube Player API => https://developers.google.com/youtube/iframe_api_reference?hl=en. код 1 - playing.
    private Boolean checkVideoPlayed(){

        return Integer.parseInt(executeJavaScript(getPlayerState).toString()) == YOUTUBE_PLAYER_STATE_PLAY;
    }

    public Boolean checkGoesTenSecondsVideo() throws IOException {
        double playerTimeLimit = Double.parseDouble(FileReader.getValue(PLAYER_TIME_LIMIT));
        while(Double.parseDouble(executeJavaScript(getCurrentTime).toString()) < playerTimeLimit){
            if(!checkVideoPlayed())
                return false;
        }

        return true;
    }

    public void switchToVideoFrame(){
        getFrame().click();
        switchTo().frame(getFrame());
        wait(1);
    }
}
