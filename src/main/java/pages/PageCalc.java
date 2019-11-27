package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageCalc {
    public Itogo sendData() {
        $(By.cssSelector("[name='param3']")).sendKeys("1");
        $(By.cssSelector("[name='param5']")).sendKeys("1");
        $(By.cssSelector("[name='param6']")).sendKeys("1");
        $(By.cssSelector("[name='param7']")).sendKeys("1");
        $(By.cssSelector("[name='param8']")).sendKeys("1");
        $(By.cssSelector("[name='param9']")).sendKeys("1");
        $(By.cssSelector("[name='param10']")).sendKeys("1");
        $(By.id("OK")).click();
        return new Itogo();
    }

    public boolean checkPhotoPrint() {
        $(By.cssSelector("#check4")).click();
        return $(By.cssSelector("[name='param5']")).isDisplayed();
    }


    public class Itogo {
        public String getResult() {
            return $(By.id("itogo")).getText();
        }
    }
}

