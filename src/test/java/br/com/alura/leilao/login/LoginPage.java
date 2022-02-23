package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leilao.LeilaoPage;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super();
    }

    public LeilaoPage login(String username, String password) {
        super.getBrowser().findElement(By.id("username")).sendKeys(username);
        super.getBrowser().findElement(By.id("password")).sendKeys(password);
        super.getBrowser().findElement(By.id("login-form")).submit();

        return new LeilaoPage(super.getBrowser());
    }

    public Boolean isLoginPage() {
        return super.getBrowser().getCurrentUrl().equals(URL_LOGIN);

    }

    public String getLoggedUser() {
        return super.getBrowser().findElement(By.id("usuario-logado")).getText();
    }

    public Boolean containsInvalidMessage() {
        return super.getBrowser().getPageSource().contains("Usuário e senha inválidos.");
    }

    public boolean isLoginPageWithParam(String param) {
        return super.getBrowser().getCurrentUrl().equals(URL_LOGIN+"?"+param);
    }
}
