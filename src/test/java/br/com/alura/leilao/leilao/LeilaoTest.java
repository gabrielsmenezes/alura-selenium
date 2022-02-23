package br.com.alura.leilao.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeilaoTest {

    private LeilaoPage leilaoPage;

    private static final String URL_LEILOES = "http://localhost:8080/leiloes/2";

    @AfterEach
    void tearDown() {
        this.leilaoPage.quit();
    }

    @Test
    public void deveCadastrarLeilao() {
        LoginPage loginPage = new LoginPage();

        this.leilaoPage = loginPage.login("fulano", "pass");

        NovoLeilaoPage novoLeilaoPage =  this.leilaoPage.navigateToNovoLeilao();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String leilaoDoDia = "Leilão do Dia: " + hoje;
        String valor = "500.00";

        this.leilaoPage = novoLeilaoPage.cadastrarLeilao(hoje, leilaoDoDia, valor);

        Assertions.assertTrue(this.leilaoPage.isLeilaoCadastrado(hoje, leilaoDoDia, valor));
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
