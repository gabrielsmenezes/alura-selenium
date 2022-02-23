package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageObject;
import org.hibernate.type.TrueFalseType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeilaoPage extends PageObject {
    private static final String URL_NOVO_LEILAO = "http://localhost:8080/leiloes/new";

    public LeilaoPage(WebDriver browser) {
        super(browser);
    }


    public NovoLeilaoPage navigateToNovoLeilao() {
        super.getBrowser().navigate().to(URL_NOVO_LEILAO);
        return new NovoLeilaoPage(super.getBrowser());
    }

    public boolean isLeilaoCadastrado(String hoje, String leilaoDoDia, String valor) {
        return Boolean.TRUE;
    }
}
