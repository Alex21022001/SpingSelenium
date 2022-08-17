package tests;


import com.SpringSelenium.SpringSeleniumApplication;
import com.SpringSelenium.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


class SpringSelApplicationTests extends BaseTest {


    @Test
    void test2() {
        homePage.goToHomePage(url).test();
        System.out.println("AAAAAAAAAAAAAAAAAAA");

    }
    @Test
    void test3(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    @Test
    void test1() throws InterruptedException {
        homePage.goToHomePage(url)
                .goToLogin(name,password);
    }
}
