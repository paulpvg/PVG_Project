package ru.gb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMTest {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(CRMTest.class);

    @BeforeAll
    static void enableDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("incognito");

        driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @Test
    @DisplayName("Создание проекта")
    void projectCreatingTest() {

        WebElement webElement = driver.findElement(By.id("prependedInput"));
        webElement.sendKeys("Applanatest1");

        webElement = driver.findElement(By.id("prependedInput2"));
        webElement.sendKeys("Student2020!");

        webElement = driver.findElement(By.id("_submit"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Проекты\")]"));
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();

        webElement = driver.findElement(By.xpath("//a[@href=\"/project/my\"]/span[@class=\"title\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[@title=\"Создать проект\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//input[@data-ftid=\"crm_project_name\"]"));
        webElement.sendKeys("Организация заготовительных пунктов в калмыцких степях");

        webElement = driver.findElement(By.xpath("//a[contains(@class, \"select2-default\")]/span[@class=\"select2-arrow\"]"));
        action.moveToElement(webElement).clickAndHold().perform();

        webElement = driver.findElement(By.xpath("//input[contains(@class, \"select2-focused\")]"));
        webElement.sendKeys("Черноморское отделение Арбатовской конторы по заготовке рогов и копыт");

        webElement = driver.findElement(By.xpath("//span[@class=\"select2-match\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//select[@name=\"crm_project[businessUnit]\"]"));
        Select selectObject = new Select(webElement);
        selectObject.selectByVisibleText("Research & Development");

        webElement = driver.findElement(By.xpath("//select[@name=\"crm_project[curator]\"]"));
        selectObject = new Select(webElement);
        selectObject.selectByVisibleText("Мясников Сергей");

        webElement = driver.findElement(By.xpath("//select[@name=\"crm_project[rp]\"]"));
        selectObject = new Select(webElement);
        selectObject.selectByVisibleText("Степанов Андрей");

        webElement = driver.findElement(By.xpath("//select[@name=\"crm_project[administrator]\"]"));
        selectObject = new Select(webElement);
        selectObject.selectByVisibleText("Исаева Анастасия");

        webElement = driver.findElement(By.xpath("//select[@name=\"crm_project[manager]\"]"));
        selectObject = new Select(webElement);
        selectObject.selectByVisibleText("Ломакина Ксения");

        webElement = driver.findElement(By.xpath("//div[@class=\"select2-container select2\"]/a/span[@class=\"select2-arrow\"]"));
        action.moveToElement(webElement).clickAndHold().perform();

        webElement = driver.findElement(By.xpath("//input[contains(@class, \"select2-focused\")]"));
        webElement.sendKeys("Балаганов Шура");

        webElement = driver.findElement(By.xpath("//span[@class=\"select2-match\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]"));
        webElement.click();

        //проверка на успешность создания нового проекта
        boolean projectCreatingOK = false;
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[contains(text(),\"Проект сохранен\")]"));
        if(webElementList.size() == 1) {
            projectCreatingOK = true;
            logger.info(ANSI_GREEN + "Новый проект успешно создан" + ANSI_RESET);
        }

        //проверка на то, что проект с таким именем уже существует, в этом случае тест должен упасть
        webElementList = driver.findElements(By.xpath("//span[text()=\"Это значение уже используется.\"]"));
        if(webElementList.size() == 1) {
            projectCreatingOK = false;
            logger.error(ANSI_YELLOW + "Тест упал, т.к. проект с этим именем уже существует" + ANSI_RESET);
            assertTrue(projectCreatingOK); //дабы уронить тест и дальше не идти и не ловить эксепшины
        }

        //удаляем созданный проект
        webElement = driver.findElement(By.xpath("//div[contains(text(),\"Наименование\")]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//input[@name=\"value\"]"));
        webElement.sendKeys("Организация заготовительных пунктов в калмыцких степях");

        webElement = driver.findElement(By.xpath("//button[contains(text(),\"Обновить\")]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//td[contains(text(),\"Организация заготовительных пунктов в калмыцких степях\")]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[@title=\"Удалить\"][contains(@class,\"btn\")]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[contains(text(),\"Да, удалить\")]"));
        webElement.click();

        //проверка на успешность удаления созданного проекта
        boolean projectDeletingOK = false;
        webElementList = driver.findElements(By.xpath("//div[contains(text(),\"Элемент удален\")]"));
        if(webElementList.size() == 1) {
            projectDeletingOK = true;
            logger.info(ANSI_GREEN + "Созданный проект успешно удален" + ANSI_RESET);
        }

        assertTrue(projectCreatingOK && projectDeletingOK);
    }

    @Test
    @DisplayName("Создание контактного лица")
    void contactCreatingTest() {

        WebElement webElement = driver.findElement(By.id("prependedInput"));
        webElement.sendKeys("Applanatest1");

        webElement = driver.findElement(By.id("prependedInput2"));
        webElement.sendKeys("Student2020!");

        webElement = driver.findElement(By.id("_submit"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Контрагенты\")]"));
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();

        webElement = driver.findElement(By.xpath("//a[@href=\"/contact/\"]/span[@class=\"title\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//a[@title=\"Создать контактное лицо\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//input[@data-ftid=\"crm_contact_lastName\"]"));
        webElement.sendKeys("Новый");

        webElement = driver.findElement(By.xpath("//input[@data-ftid=\"crm_contact_firstName\"]"));
        webElement.sendKeys("Контакт");

        webElement = driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]"));
        action.moveToElement(webElement).clickAndHold().perform();

        webElement = driver.findElement(By.id("select2-drop"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//input[contains(@class, \"select2-input\")]"));
        webElement.sendKeys("Черноморское отделение Арбатовской конторы по заготовке рогов и копыт");

        webElement = driver.findElement(By.xpath("//span[@class=\"select2-match\"]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//input[@data-ftid=\"crm_contact_jobTitle\"]"));
        webElement.sendKeys("стажер");

        webElement = driver.findElement(By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]"));
        webElement.click();

        //проверка на успешность создания нового контактного лица
        boolean contactCreatingOK = false;
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[contains(text(),\"Контактное лицо сохранено\")]"));
        if(webElementList.size() == 1) {
            contactCreatingOK = true;
            logger.info(ANSI_GREEN + "Новое контактное лицо успешно создано" + ANSI_RESET);
        }

        assertTrue(contactCreatingOK);
    }

    @AfterEach
    void releaseDriver() throws InterruptedException {
        if(driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
