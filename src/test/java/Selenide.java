import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class Selenide {
    PotolkoffPage potolkoffPage = new PotolkoffPage();

    @BeforeTest
    public void setUP() {
        open("https:/potolkoff58.ru/");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @Test
    public void check1() {
        potolkoffPage.topmenu().shouldHave(text("КАТАЛОГ ПОТОЛКОВ ОСВЕЩЕНИЕ ФОТОГАЛЕРЕЯ ПРАЙС-ЛИСТ ПОЛЕЗНЫЕ СТАТЬИ ВАШИ ВОПРОСЫ КОНТАКТЫ"));

    }

    @Test
    public void check2() {
        PhotoGallery photoGallery = potolkoffPage.photoGallery();
        photoGallery.zagolovok.shouldHave(text("Фотогалерея"));
        photoGallery.catalog.shouldHave(texts("Одноуровневые потолки", "Двухуровневые потолки", "Тканевые потолки", "\"Парящие потолки\"", "Криволинейная спайка потолка", "Фотопечать"));
        photoGallery.typeOfPlace().getCatalog().shouldHave(texts("Квартиры, частные дома", "Офисные помещения"));
        photoGallery.light().checkAllPhotos();
        photoGallery.colorsCatalog().checkAllPhotos();

    }
    @Test
    public void check3(){
        Price price = potolkoffPage.price();
        price.zagolovok.shouldHave(text("Цены на натяжные потолки"));
        String table = price.table1.getText();
        Assert.assertEquals(table, "Что входит Другие компании «Потолкоff58»\n" +
                "Полотно  ✔   ✔ \n" +
                "Монтаж -  ✔\n" +
                "Разводка электричества -  ✔\n" +
                "Выезд замерщика  ✔  ✔\n" +
                "Доставка бригады и материалов -  ✔");
        System.out.println("");
        Assert.assertEquals(price.callMasterLink.getAttribute("href"),"http://potolkoff58.ru/callback");


    }
    @Test
    public void check4(){
        PageCalc pageCalc = potolkoffPage.pageCalc();
        String price = pageCalc.sendData().getResult();
        Assert.assertEquals(price,"Цена: 1491 руб.");
        Assert.assertTrue(!pageCalc.checkPhotoPrint());

    }
    @Test
    public void check5(){
        ContactsPage contactsPage = potolkoffPage.contacts();
        Assert.assertEquals(contactsPage.headline.getText(),"Контакты");
        contactsPage.Feedback("Name","E-male","message");

    }

}
