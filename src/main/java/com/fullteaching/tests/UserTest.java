package com.fullteaching.tests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class UserTest {
    private WebDriver driver;
    String url = "https://localhost:5000/";

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors", "--allow-insecure-localhost");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        caps.setCapability("acceptInsecureCerts", true);

        System.setProperty("webdriver.chrome.driver", "/home/crismotinha/Documents/UFF/full-teaching/chromedriver");
        driver = new ChromeDriver(caps);

        Dimension d = new Dimension(1280,800);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void LoginComSucessoRedirecionaParaMyCourses() throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
        WebElement logInButton =  driver.findElement(By.xpath("/html/body/app/div/header/navbar/div/nav/div/ul/li[2]/a"));
        logInButton.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("selenium@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Seleni1m");

        WebElement login = driver.findElement(By.id("log-in-btn"));
        login.click();

        Thread.sleep(1500);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://localhost:5000/courses"));
    }

    @Test
    public void LoginComSenhaInvalidaMostraErro() throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
        WebElement logInButton =  driver.findElement(By.xpath("/html/body/app/div/header/navbar/div/nav/div/ul/li[2]/a"));
        logInButton.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("selenium@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("senhaerrada");

        WebElement login = driver.findElement(By.id("log-in-btn"));
        login.click();

        Thread.sleep(200);

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/login-modal/div/div[1]/div/form/app-error-message/div/h5"));

        Assert.assertTrue(errorMessage.getText().equals("Invalid field"));
    }

    @Test
    public void LoginComEmailInvalidoMostraErro() throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
        WebElement logInButton =  driver.findElement(By.xpath("/html/body/app/div/header/navbar/div/nav/div/ul/li[2]/a"));
        logInButton.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("emailerrado@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Seleni1m");

        WebElement login = driver.findElement(By.id("log-in-btn"));
        login.click();

        Thread.sleep(200);

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/login-modal/div/div[1]/div/form/app-error-message/div/h5"));

        Assert.assertTrue(errorMessage.getText().equals("Invalid field"));
    }

    @Test
    public void CriarNovoCursoComSucesso() throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
        Teacher teacher = PageFactory.initElements(driver, Teacher.class);
        teacher.logIn();
        Thread.sleep(1500);

        WebElement addCourse = driver.findElement(By.id("add-course-icon"));
        addCourse.click();

        String expectedTitle = "Titulo";

        WebElement title = driver.findElement(By.id("input-post-course-name"));
        title.sendKeys(expectedTitle);

        WebElement submit = driver.findElement(By.id("submit-post-course-btn"));
        submit.click();

        List<WebElement> coursesTitles = driver.findElements(By.className("title"));
        for (WebElement course : coursesTitles) {
            if (course.getText().equals(expectedTitle)) {
                Assert.assertTrue(true);
            }
        }
    }
}
