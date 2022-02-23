package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {
    private WebDriver browser;

    public PageObject() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
    }

    public PageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void quit() {
        this.browser.quit();
    }

    public WebDriver getBrowser() {
        return browser;
    }
}
