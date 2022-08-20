package tests;

import com.SpringSelenium.SpringSeleniumApplication;
import com.SpringSelenium.pages.HomePage;
import com.SpringSelenium.utils.ScreenShotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(classes = SpringSeleniumApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {

    @Autowired
    public HomePage homePage;

    @Value("${url}")
    public String url;
    @Value("${name}")
    public String name;
    @Value("${password}")
    public String password;







}
