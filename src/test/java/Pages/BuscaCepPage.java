package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BuscaCepPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Localizadores
    private By campoPesquisa = By.id("endereco");


    public BuscaCepPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Ação: Pesquisar por um destino

    public void busca(String parametro) throws InterruptedException {
        driver.findElement(campoPesquisa).sendKeys(parametro);
        System.out.println("Resolva o CAPTCHA e clica em Pesquisar ....  vou aguardar 30 segundos");
        Thread.sleep(30000);

    }

    public String obterLogradouro() {
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[1]")));

        // Retornar texto
        String textoResultado = resultado.getText();
        return textoResultado;
    }

    public String obterCEP() {
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[4]")));

        //Retornar texto
        String textoResultado = resultado.getText();
        return textoResultado;
    }
}
