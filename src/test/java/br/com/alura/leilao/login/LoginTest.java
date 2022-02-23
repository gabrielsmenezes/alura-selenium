package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private LoginPage loginPage;


    private static final String URL_LEILOES = "http://localhost:8080/leiloes/2";

    @BeforeEach
    void setUp() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    void tearDown() {
        this.loginPage.quit();
    }

    @Test
    public void deveLogarComDadosValidos() {
        this.loginPage.login("fulano", "pass");

        Assertions.assertFalse(this.loginPage.isLoginPageWithParam("error"));
        Assertions.assertEquals("fulano", this.loginPage.getLoggedUser());
    }


    @Test
    public void naoDeveLogarComValorInvalido() {
        this.loginPage.login("invalido", "123123");

        Assertions.assertTrue(this.loginPage.isLoginPage());
        Assertions.assertTrue(this.loginPage.containsInvalidMessage());
    }

//    Este teste deve estar no teste de Leiloes Page
//    @Test
//    public void naoDeveAcessarAreaRestritaDeslogado(){
//        this.browser.navigate().to(URL_LEILOES);
//
//        Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
//        Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
//
//    }
}
