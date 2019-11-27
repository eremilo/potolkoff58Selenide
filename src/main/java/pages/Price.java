package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Price {

    public SelenideElement zagolovok = $(By.cssSelector("h1 span"));
    public SelenideElement table1 = $(By.xpath("//*[@id=\"contact\"]/div[2]/table/tbody"));
    public SelenideElement callMasterLink = $(By.cssSelector("[href='http://potolkoff58.ru/callback']"));
    //public ElementsCollection table1 = $$(By.cssSelector("tr"));
}
