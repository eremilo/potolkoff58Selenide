package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PotolkoffPage {


    public PageCalc pageCalc (){
        $(By.cssSelector(".footer_nav [href='/calc']")).click();
    return new PageCalc();
    }

    public SelenideElement topmenu() {
        return $(By.cssSelector(".topmenu"));
    }

    public PhotoGallery photoGallery() {
        $(By.cssSelector(".topmenu li a[href='/catalog/2']")).click();
        return new PhotoGallery();
    }

    public Price price() {
        $(By.cssSelector(".topmenu li [href='/articles/6']")).click();
        return new Price();
    }

    public ContactsPage contacts() {
        $(By.cssSelector(".footer_nav a[href='/contactus']")).click();
        return new ContactsPage();
    }


}
