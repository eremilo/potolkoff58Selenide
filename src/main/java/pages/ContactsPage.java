package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {
    public SelenideElement headline = $(By.cssSelector("#zag_2 h1"));

    public void Feedback(String name, String email, String message) {
        $(By.cssSelector("[name='first_name']")).sendKeys(name);
        $(By.cssSelector("[name='email']")).sendKeys(email);
        $(By.cssSelector("[name='text']")).sendKeys(message);
    }
}
