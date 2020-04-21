import Helper.LinkUtil;
import Pages.WorkPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class WorkPageTest extends BaseTest{

    private WorkPage workPage;
    private static final int RESPONSE_STATUS_200 = 200;
    private static final int RESPONSE_STATUS_0 = 0;

    WorkPageTest() throws IOException {
    }

    @BeforeClass
    public void setUp(){
        openWorkPage();
        workPage = new WorkPage();
        openWorkPage();
    }

    @Test
    public void checkLinkAvailability(){
        workPage.getLinks().forEach(link -> Assert.assertTrue(LinkUtil.getResponseCode(link) == RESPONSE_STATUS_200 || LinkUtil.getResponseCode(link) == RESPONSE_STATUS_0, "check the link " + link + " response code: " + LinkUtil.getResponseCode(link)));

    }

}