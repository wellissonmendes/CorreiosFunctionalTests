package Tests;

import Pages.BuscaCepPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BuscaCepTest {


    private WebDriver driver;
    private BuscaCepPage buscaCepPage;

    @BeforeEach
    public void setUp() {
        // Setup do WebDriver usando WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://buscacepinter.correios.com.br/");
        buscaCepPage = new BuscaCepPage(driver);
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após cada teste
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void buscaNome() throws InterruptedException, IOException {
        buscaCepPage.busca("Lojas Bemol");
        assertTrue(buscaCepPage.obterLogradouro().contains("Lojas Bemol"),
                "O logradouro não contém 'Lojas Bemol'");
    }

    @Test
    public void buscaCEP() throws InterruptedException, IOException {
        buscaCepPage.busca("69005-040");
        assertTrue(buscaCepPage.obterCEP().contains("69005-040"),
                "O CEP não contém '69005-040'");

    }


}
