import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Imovel {


    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Dado("Está na pagina home")
    public void está_na_pagina_home() {

    }
    @Quando("selecionado um imóvel")
    public void selecionado_um_imóvel() {

    }
    @Então("o valor que aparecer nas telas seguntes tem que ser igual ao {string} da tela inicial")
    public void o_valor_que_aparecer_nas_telas_seguntes_tem_que_ser_igual_ao_da_tela_inicial(String string) {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("https://marcelodebittencourt.com/ore/");
        driver.manage().window().setSize(new Dimension(968, 1020));
        driver.findElement(By.id("city")).click();
        {
            WebElement dropdown = driver.findElement(By.id("city"));
            dropdown.findElement(By.xpath("//option[. = 'New-York']")).click();
        }
        driver.findElement(By.id("objType")).click();
        {
            WebElement dropdown = driver.findElement(By.id("objType"));
            dropdown.findElement(By.xpath("//option[. = 'apartment']")).click();
        }
        driver.findElement(By.id("priceMin")).click();
        driver.findElement(By.id("priceMin")).sendKeys("100");
        driver.findElement(By.id("btnleft")).click();
        WebElement valorInicial = driver.findElement(By.id("#appartment_box > div.appartment_item.block > div.mini_block_full_description > div:nth-child(3) > div > span:nth-child(2)"));
        driver.findElement(By.id("#appartment_box > div.appartment_item.block > div.title_block > a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement valorSegundo = driver.findElement(By.id("#page > div.content > div > div.main-content-wrapper > div.view-apartment-main-block > div.b_item__info.block-right > div.price > span:nth-child(2)"));
        if(valorInicial.equals(valorSegundo)){
            System.out.println("deu certo");
        }else{
            System.out.println("deu errado");
        }
    }




}
