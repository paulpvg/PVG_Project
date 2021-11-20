package ru.gb;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App 
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );

        System.out.println("--------------------------------------------------------------------------------------------\n" +
                           "        Выполнение Тест-кейс №1. Создание проекта на сйте CRM.\n" +
                           "--------------------------------------------------------------------------------------------\n");

        if(ProjectCreating()){
            System.out.println(ANSI_GREEN + "Тест на создание проекта пройден успешно\n" + ANSI_RESET);
        }

        else{
            System.out.println(ANSI_RED + "Тест на создание проекта не пройден\n" + ANSI_RESET);
        }

        System.out.println("--------------------------------------------------------------------------------------------\n" +
                           "        Выполнение Тест-кейс №2. Создание контактного лица в организации на сйте CRM.\n" +
                           "--------------------------------------------------------------------------------------------\n");

        if(ContactCreating()){
            System.out.println(ANSI_GREEN + "Тест на создание контактного лица пройден успешно\n" + ANSI_RESET);
        }

        else{
            System.out.println(ANSI_RED + "Тест на создание контактного лица не пройден\n" + ANSI_RESET);
        }

    }

    public static boolean ProjectCreating() throws InterruptedException {

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");

        System.out.println("\nПрохождение теста:\n");

        boolean stepOk = true;

        //Step 01: type id = prependedInput
        List<WebElement> webElementListStep01 = driver.findElements(By.id("prependedInput"));
        if(stepOk && webElementListStep01.size() == 1) {
            webElementListStep01.get(0).sendKeys("Applanatest1");
            System.out.println("Step 01: id = prependedInput - Локатор найден, шаг теста: " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep01.size() > 0){
            System.out.println("Step 01: id = prependedInput - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else  if (stepOk && webElementListStep01.size() == 0){
            System.out.println("Step 01: id = prependedInput - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 02: type id = prependedInput2
        List<WebElement> webElementListStep02 = driver.findElements(By.id("prependedInput2"));
        if(stepOk && webElementListStep02.size() == 1) {
            webElementListStep02.get(0).sendKeys("Student2020!");
            System.out.println("Step 02: id = prependedInput2 - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep02.size() > 0){
            System.out.println("Step 02: id = prependedInput2 - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep02.size() == 0) {
            System.out.println("Step 02: id = prependedInput2 - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 03: click id = _submit
        List<WebElement> webElementListStep03 = driver.findElements(By.id("_submit"));
        if(stepOk && webElementListStep03.size() == 1) {
            webElementListStep03.get(0).click();
            System.out.println("Step 03: id = _submit - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep03.size() > 0){
            System.out.println("Step 03: id = _submit - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep03.size() == 0){
            System.out.println("Step 03: id = _submit - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 04: mouse over xpath=//a[@href="#"]/span[contains(text(), "Проекты")]
        List<WebElement> webElementListStep04 = driver.findElements(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Проекты\")]"));
        if(stepOk && webElementListStep04.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep04.get(0)).build().perform();
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Проекты\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep04.size() > 0){
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Проекты\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep04.size() == 0){
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Проекты\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 05: click xpath=//a[@href="/project/my"]/span[@class="title"]
        List<WebElement> webElementListStep05 = driver.findElements(By.xpath("//a[@href=\"/project/my\"]/span[@class=\"title\"]"));
        if(stepOk && webElementListStep05.size() == 1) {
            webElementListStep05.get(0).click();
            System.out.println("Step 05: xpath=//a[@href=\"/project/my\"]/span[@class=\"title\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep05.size() > 0){
            System.out.println("Step 05: xpath=//a[@href=\"/project/my\"]/span[@class=\"title\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep05.size() == 0){
            System.out.println("Step 05: xpath=//a[@href=\"/project/my\"]/span[@class=\"title\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 06: mouse over xpath=//ul[contains(@class,"main-menu")]
        List<WebElement> webElementListStep06 = driver.findElements(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Проекты\")]"));
        if(stepOk && webElementListStep06.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep06.get(0)).build().perform();
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep06.size() > 0){
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep06.size() == 0){
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 07: click xpath=//a[@title="Создать проект"]
        List<WebElement> webElementListStep07 = driver.findElements(By.xpath("//a[@title=\"Создать проект\"]"));
        if(stepOk && webElementListStep07.size() == 1) {
            webElementListStep07.get(0).click();
            System.out.println("Step 07: xpath=//a[@title=\"Создать проект\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep07.size() > 0){
            System.out.println("Step 07: xpath=//a[@title=\"Создать проект\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep07.size() == 0){
            System.out.println("Step 07: xpath=//a[@title=\"Создать проект\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 08: type xpath=//input[@data-ftid="crm_project_name"]
        List<WebElement> webElementListStep08 = driver.findElements(By.xpath("//input[@data-ftid=\"crm_project_name\"]"));
        if(stepOk && webElementListStep08.size() == 1) {
            webElementListStep08.get(0).sendKeys("Организация заготовительных пунктов в калмыцких степях");
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_project_name\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep08.size() > 0){
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_project_name\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep08.size() == 0) {
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_project_name\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 09: mouse down xpath=//a[contains(@class, "select2-default")]/span[@class="select2-arrow"]
        List<WebElement> webElementListStep09 = driver.findElements(By.xpath("//a[contains(@class, \"select2-default\")]/span[@class=\"select2-arrow\"]"));
        if(stepOk && webElementListStep09.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep09.get(0)).clickAndHold().perform();
            System.out.println("Step 09: xpath=//a[contains(@class, \"select2-default\")]/span[@class=\"select2-arrow\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep09.size() > 0){
            System.out.println("Step 09: xpath=//a[contains(@class, \"select2-default\")]/span[@class=\"select2-arrow\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep09.size() == 0){
            System.out.println("Step 09: xpath=//a[contains(@class, \"select2-default\")]/span[@class=\"select2-arrow\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 10: mouse up id=select2-drop-mask
        List<WebElement> webElementListStep10 = driver.findElements(By.id("select2-drop-mask"));
        if(stepOk && webElementListStep10.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep10.get(0)).release().perform();
            System.out.println("Step 10: id=select2-drop-mask - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep10.size() > 0){
            System.out.println("Step 10: id=select2-drop-mask - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep10.size() == 0){
            System.out.println("Step 10: id=select2-drop-mask - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 11: click xpath=//div[@id="select2-drop"]
        List<WebElement> webElementListStep11 = driver.findElements(By.xpath("//div[@id=\"select2-drop\"]"));
        if(stepOk && webElementListStep11.size() == 1) {
            webElementListStep11.get(0).click();
            System.out.println("Step 11: xpath=//div[@id=\"select2-drop\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep11.size() > 0){
            System.out.println("Step 11: xpath=//div[@id=\"select2-drop\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep11.size() == 0){
            System.out.println("Step 11: xpath=//div[@id=\"select2-drop\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 12: type xpath=//input[contains(@class, "select2-focused")]
        List<WebElement> webElementListStep12 = driver.findElements(By.xpath("//input[contains(@class, \"select2-focused\")]"));
        if(stepOk && webElementListStep12.size() == 1) {
            webElementListStep12.get(0).sendKeys("Черноморское отделение Арбатовской конторы по заготовке рогов и копыт");
            System.out.println("Step 12: xpath=//input[contains(@class, \"select2-focused\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep12.size() > 0){
            System.out.println("Step 12: xpath=//input[contains(@class, \"select2-focused\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep12.size() == 0) {
            System.out.println("Step 12: xpath=//input[contains(@class, \"select2-focused\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 13: click xpath=//span[@class="select2-match"]
        List<WebElement> webElementListStep13 = driver.findElements(By.xpath("//span[@class=\"select2-match\"]"));
        if(stepOk && webElementListStep13.size() == 1) {
            webElementListStep13.get(0).click();
            System.out.println("Step 13: xpath=//span[@class=\"select2-match\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep13.size() > 0){
            System.out.println("Step 13: xpath=//span[@class=\"select2-match\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep13.size() == 0){
            System.out.println("Step 13: xpath=//span[@class=\"select2-match\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 14: select xpath=//select[@name="crm_project[businessUnit]"]
        List<WebElement> webElementListStep14 = driver.findElements(By.xpath("//select[@name=\"crm_project[businessUnit]\"]"));
        if(stepOk && webElementListStep14.size() == 1) {
            Select selectObject = new Select(webElementListStep14.get(0));
            selectObject.selectByVisibleText("Research & Development");
            System.out.println("Step 14: xpath=//select[@name=\"crm_project[businessUnit]\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep14.size() > 0){
            System.out.println("Step 14: xpath=//select[@name=\"crm_project[businessUnit]\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep14.size() == 0){
            System.out.println("Step 14: xpath=//select[@name=\"crm_project[businessUnit]\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 15: select xpath=//select[@name="crm_project[curator]"]
        List<WebElement> webElementListStep15 = driver.findElements(By.xpath("//select[@name=\"crm_project[curator]\"]"));
        if(stepOk && webElementListStep15.size() == 1) {
            Select selectObject = new Select(webElementListStep15.get(0));
            selectObject.selectByVisibleText("Мясников Сергей");
            System.out.println("Step 15: xpath=//select[@name=\"crm_project[curator]\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep15.size() > 0){
            System.out.println("Step 15: xpath=//select[@name=\"crm_project[curator]\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep15.size() == 0){
            System.out.println("Step 15: xpath=//select[@name=\"crm_project[curator]\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 16: select xpath=//select[@name="crm_project[rp]"]
        List<WebElement> webElementListStep16 = driver.findElements(By.xpath("//select[@name=\"crm_project[rp]\"]"));
        if(stepOk && webElementListStep16.size() == 1) {
            Select selectObject = new Select(webElementListStep16.get(0));
            selectObject.selectByVisibleText("Степанов Андрей");
            System.out.println("Step 16: xpath=//select[@name=\"crm_project[rp]\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep16.size() > 0){
            System.out.println("Step 16: xpath=//select[@name=\"crm_project[rp]\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep16.size() == 0){
            System.out.println("Step 16: xpath=//select[@name=\"crm_project[rp]\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 17: select xpath=//select[@name="crm_project[administrator]"]
        List<WebElement> webElementListStep17 = driver.findElements(By.xpath("//select[@name=\"crm_project[administrator]\"]"));
        if(stepOk && webElementListStep17.size() == 1) {
            Select selectObject = new Select(webElementListStep17.get(0));
            selectObject.selectByVisibleText("Исаева Анастасия");
            System.out.println("Step 17: xpath=//select[@name=\"crm_project[administrator]\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep17.size() > 0){
            System.out.println("Step 17: xpath=//select[@name=\"crm_project[administrator]\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep17.size() == 0){
            System.out.println("Step 17: xpath=//select[@name=\"crm_project[administrator]\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 18: select xpath=//select[@name="crm_project[manager]"]
        List<WebElement> webElementListStep18 = driver.findElements(By.xpath("//select[@name=\"crm_project[manager]\"]"));
        if(stepOk && webElementListStep18.size() == 1) {
            Select selectObject = new Select(webElementListStep18.get(0));
            selectObject.selectByVisibleText("Ломакина Ксения");
            System.out.println("Step 18: xpath=//select[@name=\"crm_project[manager]\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep18.size() > 0){
            System.out.println("Step 18: xpath=//select[@name=\"crm_project[manager]\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep18.size() == 0){
            System.out.println("Step 18: xpath=//select[@name=\"crm_project[manager]\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 19: mouse down xpath=//div[@class="select2-container select2"]/a/span[@class="select2-arrow"]
        List<WebElement> webElementListStep19 = driver.findElements(By.xpath("//div[@class=\"select2-container select2\"]/a/span[@class=\"select2-arrow\"]"));
        if(stepOk && webElementListStep19.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep19.get(0)).clickAndHold().perform();
            System.out.println("Step 19: xpath=//div[@class=\"select2-container select2\"]/a/span[@class=\"select2-arrow\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep19.size() > 0){
            System.out.println("Step 19: xpath=//div[@class=\"select2-container select2\"]/a/span[@class=\"select2-arrow\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep19.size() == 0){
            System.out.println("Step 19: xpath=//div[@class=\"select2-container select2\"]/a/span[@class=\"select2-arrow\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 20: mouse up id=select2-drop-mask
        List<WebElement> webElementListStep20 = driver.findElements(By.id("select2-drop-mask"));
        if(stepOk && webElementListStep20.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep20.get(0)).release().perform();
            System.out.println("Step 20: id=select2-drop-mask - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep20.size() > 0){
            System.out.println("Step 20: id=select2-drop-mask - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep20.size() == 0){
            System.out.println("Step 20: id=select2-drop-mask - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 21: type xpath=//input[contains(@class, "select2-focused")]
        List<WebElement> webElementListStep21 = driver.findElements(By.xpath("//input[contains(@class, \"select2-focused\")]"));
        if(stepOk && webElementListStep21.size() == 1) {
            webElementListStep21.get(0).sendKeys("Балаганов Шура");
            System.out.println("Step 21: xpath=//input[contains(@class, \"select2-focused\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep21.size() > 0){
            System.out.println("Step 21: xpath=//input[contains(@class, \"select2-focused\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep21.size() == 0) {
            System.out.println("Step 21: xpath=//input[contains(@class, \"select2-focused\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 22: click xpath=//span[@class="select2-match"]
        List<WebElement> webElementListStep22 = driver.findElements(By.xpath("//span[@class=\"select2-match\"]"));
        if(stepOk && webElementListStep22.size() == 1) {
            webElementListStep22.get(0).click();
            System.out.println("Step 22: xpath=//span[@class=\"select2-match\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep22.size() > 0){
            System.out.println("Step 22: xpath=//span[@class=\"select2-match\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep22.size() == 0){
            System.out.println("Step 22: xpath=//span[@class=\"select2-match\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 23: click xpath=//button[contains(text(),"Сохранить и закрыть")]
        List<WebElement> webElementListStep23 = driver.findElements(By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]"));
        if(stepOk && webElementListStep23.size() == 1) {
            webElementListStep23.get(0).click();
            System.out.println("Step 23: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep23.size() > 0){
            System.out.println("Step 23: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep23.size() == 0){
            System.out.println("Step 23: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 24: find xpath=//div[contains(text(),"Проект сохранен")]
        boolean projectCreatingOK = false;
        List<WebElement> webElementListStep24 = driver.findElements(By.xpath("//div[contains(text(),\"Проект сохранен\")]"));
        if(stepOk && webElementListStep24.size() == 1) {
            System.out.println("Step 24: xpath=//div[contains(text(),\"Проект сохранен\")] - Локатор найден, успешное создания проекта:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
            projectCreatingOK = true;
            System.out.println(ANSI_CYAN + "\nПроект создан успешно. " + ANSI_RESET + "Почистим за собой, убив его\n");
        }
        else if(stepOk && webElementListStep24.size() > 0){
            System.out.println("Step 24: xpath=//div[contains(text(),\"Проект сохранен\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep24.size() == 0){
            System.out.println("Step 24: xpath=//div[contains(text(),\"Проект сохранен\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 25: click xpath=//div[contains(text(),"Наименование")]
        List<WebElement> webElementListStep25 = driver.findElements(By.xpath("//div[contains(text(),\"Наименование\")]"));
        if(stepOk && webElementListStep25.size() == 1) {
            webElementListStep25.get(0).click();
            System.out.println("Step 25: xpath=//div[contains(text(),\"Наименование\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep25.size() > 0){
            System.out.println("Step 25: xpath=//div[contains(text(),\"Наименование\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep25.size() == 0){
            System.out.println("Step 25: xpath=//div[contains(text(),\"Наименование\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 26: type xpath=//input[@name="value"]
        List<WebElement> webElementListStep26 = driver.findElements(By.xpath("//input[@name=\"value\"]"));
        if(stepOk && webElementListStep26.size() == 1) {
            webElementListStep26.get(0).sendKeys("Организация заготовительных пунктов в калмыцких степях");
            System.out.println("Step 26: xpath=//input[@name=\"value\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep26.size() > 0){
            System.out.println("Step 26: xpath=//input[@name=\"value\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep26.size() == 0) {
            System.out.println("Step 26: xpath=//input[@name=\"value\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 27: click xpath=//button[contains(text(),"Обновить")]
        List<WebElement> webElementListStep27 = driver.findElements(By.xpath("//button[contains(text(),\"Обновить\")]"));
        if(stepOk && webElementListStep27.size() == 1) {
            webElementListStep27.get(0).click();
            System.out.println("Step 27: xpath=//button[contains(text(),\"Обновить\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep27.size() > 0){
            System.out.println("Step 27: xpath=//button[contains(text(),\"Обновить\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep27.size() == 0){
            System.out.println("Step 27: xpath=//button[contains(text(),\"Обновить\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 28: click xpath=//td[contains(text(),"Организация заготовительных пунктов в калмыцких степях")]
        List<WebElement> webElementListStep28 = driver.findElements(By.xpath("//td[contains(text(),\"Организация заготовительных пунктов в калмыцких степях\")]"));
        if(stepOk && webElementListStep28.size() == 1) {
            webElementListStep28.get(0).click();
            System.out.println("Step 28: xpath=//td[contains(text(),\"Организация заготовительных пунктов в калмыцких степях\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep28.size() > 0){
            System.out.println("Step 28: xpath=//td[contains(text(),\"Организация заготовительных пунктов в калмыцких степях\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep28.size() == 0){
            System.out.println("Step 28: xpath=//td[contains(text(),\"Организация заготовительных пунктов в калмыцких степях\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 29: click xpath=//a[@title="Удалить"][contains(@class,"btn")]
        List<WebElement> webElementListStep29 = driver.findElements(By.xpath("//a[@title=\"Удалить\"][contains(@class,\"btn\")]"));
        if(stepOk && webElementListStep29.size() == 1) {
            webElementListStep29.get(0).click();
            System.out.println("Step 29: xpath=//a[@title=\"Удалить\"][contains(@class,\"btn\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep29.size() > 0){
            System.out.println("Step 29: xpath=//a[@title=\"Удалить\"][contains(@class,\"btn\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep29.size() == 0){
            System.out.println("Step 29: xpath=//a[@title=\"Удалить\"][contains(@class,\"btn\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 30: click xpath=//a[contains(text(),"Да, удалить")]
        List<WebElement> webElementListStep30 = driver.findElements(By.xpath("//a[contains(text(),\"Да, удалить\")]"));
        if(stepOk && webElementListStep30.size() == 1) {
            webElementListStep30.get(0).click();
            System.out.println("Step 30: xpath=//a[contains(text(),\"Да, удалить\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep30.size() > 0){
            System.out.println("Step 30: xpath=//a[contains(text(),\"Да, удалить\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep30.size() == 0){
            System.out.println("Step 30: xpath=//a[contains(text(),\"Да, удалить\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 31: find xpath=//div[contains(text(),"Элемент удален")]
        boolean projectDeletingOK = false;
        List<WebElement> webElementListStep31 = driver.findElements(By.xpath("//div[contains(text(),\"Элемент удален\")]"));
        if(stepOk && webElementListStep31.size() == 1) {
            System.out.println("Step 31: xpath=//div[contains(text(),\"Элемент удален\")] - Локатор найден, успешное удаление проекта:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
            projectDeletingOK = true;
            System.out.println(ANSI_CYAN + "\nПроект успешно удален. " + ANSI_RESET + "До новых встреч!!!\n");
        }
        else if(stepOk && webElementListStep31.size() > 0){
            System.out.println("Step 31: xpath=//div[contains(text(),\"Элемент удален\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep31.size() == 0){
            System.out.println("Step 31: xpath=//div[contains(text(),\"Элемент удален\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        Thread.sleep(5000);
        driver.quit();

        if(projectCreatingOK && projectDeletingOK){
            System.out.println("Все шаги теста пройдены успешно " + ANSI_GREEN + ":)\n" + ANSI_RESET);
            return true;
        }
        else{
            System.out.println("Не сложилось... " + ANSI_RED + ":(\n" + ANSI_RESET);
            return false;
        }
    }

    public static boolean ContactCreating() throws InterruptedException {

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("incognito");

        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");

        System.out.println("\nПрохождение теста:\n");

        boolean stepOk = true;

        //Step 01: type id = prependedInput
        List<WebElement> webElementListStep01 = driver.findElements(By.id("prependedInput"));
        if(stepOk && webElementListStep01.size() == 1) {
            webElementListStep01.get(0).sendKeys("Applanatest1");
            System.out.println("Step 01: id = prependedInput - Локатор найден, шаг теста: " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep01.size() > 0){
            System.out.println("Step 01: id = prependedInput - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else  if (stepOk && webElementListStep01.size() == 0){
            System.out.println("Step 01: id = prependedInput - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 02: type id = prependedInput2
        List<WebElement> webElementListStep02 = driver.findElements(By.id("prependedInput2"));
        if(stepOk && webElementListStep02.size() == 1) {
            webElementListStep02.get(0).sendKeys("Student2020!");
            System.out.println("Step 02: id = prependedInput2 - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep02.size() > 0){
            System.out.println("Step 02: id = prependedInput2 - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep02.size() == 0) {
            System.out.println("Step 02: id = prependedInput2 - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 03: click id = _submit
        List<WebElement> webElementListStep03 = driver.findElements(By.id("_submit"));
        if(stepOk && webElementListStep03.size() == 1) {
            webElementListStep03.get(0).click();
            System.out.println("Step 03: id = _submit - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep03.size() > 0){
            System.out.println("Step 03: id = _submit - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep03.size() == 0){
            System.out.println("Step 03: id = _submit - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 04: mouse over xpath=//a[@href="#"]/span[contains(text(), "Контрагенты")]
        List<WebElement> webElementListStep04 = driver.findElements(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Контрагенты\")]"));
        if(stepOk && webElementListStep04.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep04.get(0)).build().perform();
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Контрагенты\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep04.size() > 0){
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Контрагенты\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep04.size() == 0){
            System.out.println("Step 04: xpath=//a[@href=\"#\"]/span[contains(text(), \"Контрагенты\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 05: click xpath=//a[@href="/contact/"]/span[@class="title"]
        List<WebElement> webElementListStep05 = driver.findElements(By.xpath("//a[@href=\"/contact/\"]/span[@class=\"title\"]"));
        if(stepOk && webElementListStep05.size() == 1) {
            webElementListStep05.get(0).click();
            System.out.println("Step 05: xpath=//a[@href=\"/contact/\"]/span[@class=\"title\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep05.size() > 0){
            System.out.println("Step 05: xpath=//a[@href=\"/contact/\"]/span[@class=\"title\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep05.size() == 0){
            System.out.println("Step 05: xpath=//a[@href=\"/contact/\"]/span[@class=\"title\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 06: mouse over xpath=//ul[contains(@class,"main-menu")]
        List<WebElement> webElementListStep06 = driver.findElements(By.xpath("//a[@href=\"#\"]/span[contains(text(), \"Проекты\")]"));
        if(stepOk && webElementListStep06.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep06.get(0)).build().perform();
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep06.size() > 0){
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep06.size() == 0){
            System.out.println("Step 06: xpath=//ul[contains(@class,\"main-menu\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 07: click xpath=//a[@title="Создать контактное лицо"]
        List<WebElement> webElementListStep07 = driver.findElements(By.xpath("//a[@title=\"Создать контактное лицо\"]"));
        if(stepOk && webElementListStep07.size() == 1) {
            webElementListStep07.get(0).click();
            System.out.println("Step 07: xpath=//a[@title=\"Создать контактное лицо\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep07.size() > 0){
            System.out.println("Step 07: xpath=//a[@title=\"Создать контактное лицо\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep07.size() == 0){
            System.out.println("Step 07: xpath=//a[@title=\"Создать контактное лицо\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 08: type xpath=//input[@data-ftid="crm_contact_lastName"]
        List<WebElement> webElementListStep08 = driver.findElements(By.xpath("//input[@data-ftid=\"crm_contact_lastName\"]"));
        if(stepOk && webElementListStep08.size() == 1) {
            webElementListStep08.get(0).sendKeys("Новый");
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_contact_lastName\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep08.size() > 0){
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_contact_lastName\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep08.size() == 0) {
            System.out.println("Step 08: xpath=//input[@data-ftid=\"crm_contact_lastName\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 09: type xpath=//input[@data-ftid="crm_contact_firstName"]
        List<WebElement> webElementListStep09 = driver.findElements(By.xpath("//input[@data-ftid=\"crm_contact_firstName\"]"));
        if(stepOk && webElementListStep09.size() == 1) {
            webElementListStep09.get(0).sendKeys("Контакт");
            System.out.println("Step 09: xpath=//input[@data-ftid=\"crm_contact_firstName\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep09.size() > 0){
            System.out.println("Step 09: xpath=//input[@data-ftid=\"crm_contact_firstName\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep09.size() == 0) {
            System.out.println("Step 09: xpath=//input[@data-ftid=\"crm_contact_firstName\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 10: mouse down xpath=//span[@class="select2-chosen"]
        List<WebElement> webElementListStep10 = driver.findElements(By.xpath("//span[@class=\"select2-chosen\"]"));
        if(stepOk && webElementListStep10.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep10.get(0)).clickAndHold().perform();
            System.out.println("Step 10: xpath=//span[@class=\"select2-chosen\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep10.size() > 0){
            System.out.println("Step 10: xpath=//span[@class=\"select2-chosen\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep10.size() == 0){
            System.out.println("Step 10: xpath=//span[@class=\"select2-chosen\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 11: mouse up id=select2-drop-mask
        List<WebElement> webElementListStep11 = driver.findElements(By.id("select2-drop-mask"));
        if(stepOk && webElementListStep11.size() == 1) {
            Actions action = new Actions(driver);
            action.moveToElement(webElementListStep11.get(0)).release().perform();
            System.out.println("Step 11: id=select2-drop-mask - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep11.size() > 0){
            System.out.println("Step 11: id=select2-drop-mask - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep11.size() == 0){
            System.out.println("Step 11: id=select2-drop-mask - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 12: click xpath=//div[@id="select2-drop"]
        List<WebElement> webElementListStep12 = driver.findElements(By.xpath("//div[@id=\"select2-drop\"]"));
        if(stepOk && webElementListStep12.size() == 1) {
            webElementListStep12.get(0).click();
            System.out.println("Step 12: xpath=//div[@id=\"select2-drop\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep12.size() > 0){
            System.out.println("Step 12: xpath=//div[@id=\"select2-drop\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep12.size() == 0){
            System.out.println("Step 12: xpath=//div[@id=\"select2-drop\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 13: type xpath=//input[contains(@class, "select2-input")]
        List<WebElement> webElementListStep13 = driver.findElements(By.xpath("//input[contains(@class, \"select2-input\")]"));
        if(stepOk && webElementListStep13.size() == 1) {
            webElementListStep13.get(0).sendKeys("Черноморское отделение Арбатовской конторы по заготовке рогов и копыт");
            System.out.println("Step 13: xpath=//input[contains(@class, \"select2-input\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep13.size() > 0){
            System.out.println("Step 13: xpath=//input[contains(@class, \"select2-input\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep13.size() == 0) {
            System.out.println("Step 13: xpath=//input[contains(@class, \"select2-input\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 14: click xpath=//span[@class="select2-match"]
        List<WebElement> webElementListStep14 = driver.findElements(By.xpath("//span[@class=\"select2-match\"]"));
        if(stepOk && webElementListStep14.size() == 1) {
            webElementListStep14.get(0).click();
            System.out.println("Step 14: xpath=//span[@class=\"select2-match\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep14.size() > 0){
            System.out.println("Step 14: xpath=//span[@class=\"select2-match\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep14.size() == 0){
            System.out.println("Step 14: xpath=//span[@class=\"select2-match\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 15: type xpath=//input[@data-ftid="crm_contact_jobTitle"]
        List<WebElement> webElementListStep15 = driver.findElements(By.xpath("//input[@data-ftid=\"crm_contact_jobTitle\"]"));
        if(stepOk && webElementListStep15.size() == 1) {
            webElementListStep15.get(0).sendKeys("стажер");
            System.out.println("Step 15: xpath=//input[@data-ftid=\"crm_contact_jobTitle\"] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep15.size() > 0){
            System.out.println("Step 15: xpath=//input[@data-ftid=\"crm_contact_jobTitle\"] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep15.size() == 0) {
            System.out.println("Step 15: xpath=//input[@data-ftid=\"crm_contact_jobTitle\"] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 16: click xpath=//button[contains(text(),"Сохранить и закрыть")]
        List<WebElement> webElementListStep16 = driver.findElements(By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]"));
        if(stepOk && webElementListStep16.size() == 1) {
            webElementListStep16.get(0).click();
            System.out.println("Step 16: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Локатор найден, шаг теста:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
        }
        else if(stepOk && webElementListStep16.size() > 0){
            System.out.println("Step 16: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep16.size() == 0){
            System.out.println("Step 16: xpath=//button[contains(text(),\"Сохранить и закрыть\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        //Step 17: click xpath=//div[contains(text(),"Контактное лицо сохранено")]
        boolean contactCreatingOK = false;
        List<WebElement> webElementListStep17 = driver.findElements(By.xpath("//div[contains(text(),\"Контактное лицо сохранено\")]"));
        if(stepOk && webElementListStep17.size() == 1) {
            webElementListStep17.get(0).click();
            System.out.println("Step 17: xpath=//div[contains(text(),\"Контактное лицо сохранено\")] - Локатор найден, успешное создание контактного лица:  " + ANSI_GREEN + "PASSED" + ANSI_RESET);
            contactCreatingOK = true;
            System.out.println(ANSI_CYAN + "\nКонтактное лицо успешно создано. " + ANSI_RESET + "До новых встреч!!!\n");
        }
        else if(stepOk && webElementListStep17.size() > 0){
            System.out.println("Step 17: xpath=//div[contains(text(),\"Контактное лицо сохранено\")] - Плохой локатор, множественные совпадения. " + ANSI_RED + "FAILED" + ANSI_RESET);
            stepOk = false;
        }
        else if (stepOk && webElementListStep17.size() == 0){
            System.out.println("Step 17: xpath=//div[contains(text(),\"Контактное лицо сохранено\")] - Совпадений не обнаружено, тест упал :( " + ANSI_RED + "FAILED" + ANSI_RESET );
            stepOk = false;
        }

        Thread.sleep(5000);
        driver.quit();

        if(contactCreatingOK){
            System.out.println("Все шаги теста пройдены успешно " + ANSI_GREEN + ":)\n" + ANSI_RESET);
            return true;
        }
        else{
            System.out.println("Не сложилось... " + ANSI_RED + ":(\n" + ANSI_RESET);
            return false;
        }
    }
}
