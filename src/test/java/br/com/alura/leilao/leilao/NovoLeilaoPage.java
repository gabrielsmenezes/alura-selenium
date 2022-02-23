package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NovoLeilaoPage extends PageObject {

    public NovoLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeilaoPage cadastrarLeilao(String hoje, String leilaoDoDia, String valor) {
        super.getBrowser().findElement(By.id("nome")).sendKeys(leilaoDoDia);
        super.getBrowser().findElement(By.id("valorInicial")).sendKeys(valor);
        super.getBrowser().findElement(By.id("dataAbertura")).sendKeys(hoje);

        super.getBrowser().findElement(By.id("button-submit")).submit();

        return new LeilaoPage(super.getBrowser());
    }
}
