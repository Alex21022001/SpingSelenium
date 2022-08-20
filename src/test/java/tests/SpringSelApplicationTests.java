package tests;


import com.SpringSelenium.utils.ScreenShotUtil;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

@SuiteDisplayName("Base site tests")
@ExtendWith(ScreenShotUtil.class)
class SpringSelApplicationTests extends BaseTest {

    @Autowired
    private WebDriver driver;

    @Test
    @DisplayName("Try sign in a site")
    @Feature("Test login")
    void test1() throws InterruptedException {
        homePage.goToHomePage(url)
                .goToLogin(name, password)
                        .choseTitle();
        Assertions.assertTrue(homePage.isLogin());

    }
    @Test
    void test2(){
        homePage.goToHomePage(url)
                .goToLogin(name, password)
                .choseTitle();
        Assertions.assertTrue(homePage.isLogin());
    }

}
