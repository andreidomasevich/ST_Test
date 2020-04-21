package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkPage extends BasePage {

    private static final By contentLinksLocator = By.xpath("//*[@class='content clearfix']//*[@href]");
    private static final By frameLocator = By.xpath("*//iframe");

    SelenideElement getFrame(){

        return $(frameLocator).shouldBe(enabled);
    }

    public ArrayList<String> getLinks(){
        wait(1);
        ElementsCollection elements = $$(contentLinksLocator);
        ArrayList<String> elementsLinks= new ArrayList<>();

        elements.forEach(el -> elementsLinks.add(el.getAttribute("href").trim()));

        return elementsLinks;
    }


}
