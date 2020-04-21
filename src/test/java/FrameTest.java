import Pages.VideoFrame;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class FrameTest extends BaseTest{

    private VideoFrame videoFrame;

    FrameTest() throws IOException {
    }

    @BeforeTest
    public void setUp(){
        openWorkPage();
        videoFrame = new VideoFrame();
        videoFrame.switchToVideoFrame();
    }

    @Test
    public void checkVideoDisplayed(){
        Assert.assertTrue(videoFrame.checkVideoDisplayed() && !videoFrame.getVideoSource().isEmpty());
    }

    @Test
    public void checkVideoPlayed() throws IOException {
        Assert.assertTrue(videoFrame.checkGoesTenSecondsVideo());

    }

}