package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhotoGallery {
    public SelenideElement zagolovok = $(By.cssSelector("#zag_2"));
    public ElementsCollection catalog = $$(By.cssSelector(".cat_zag"));

    public CatalogTypeOfPlace typeOfPlace() {
        $(By.cssSelector("[href='/catalog/1'] .cat_menu")).click();
        return new CatalogTypeOfPlace();
    }

    public CatalogLight light() {
        $(By.cssSelector("[href='/catalog/3/18'] .cat_menu")).click();
        return new CatalogLight();

    }

    public ColorsCatalog colorsCatalog() {
        $(By.cssSelector("[href='/lackfolie'] div")).click();
        return new ColorsCatalog();
    }

    public class CatalogTypeOfPlace {

        public ElementsCollection getCatalog() {
            return $$(By.cssSelector(".cat_zag"));
        }
    }

    public class CatalogLight {

        public void checkAllPhotos() {
            ElementsCollection photos = $$(By.cssSelector(".light a div [height='190']"));
            ElementsCollection urls = $$(By.cssSelector(".light [data-title='']"));
            for (int i = 0; i < urls.size(); i++) {
                System.out.println(urls.get(i).getAttribute("href"));
                photos.get(i).isImage();
                System.out.println("isVisible");
            }
        }
    }

    public class ColorsCatalog {

        public void checkAllPhotos() {
            ElementsCollection photos = $$(By.cssSelector("[rel='group'] img[alt='']"));
            ElementsCollection urls = $$(By.cssSelector("a.two[rel='group']"));
            for (int i = 0; i < urls.size(); i++) {
                System.out.println(urls.get(i).getAttribute("href"));
                photos.get(i).isImage();
                System.out.println("isVisible");

            }
        }
    }
}
