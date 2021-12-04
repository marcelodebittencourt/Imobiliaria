import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Imovel {


    private WebDriver driver;

    @Dado("Está na pagina home")
    public void está_na_pagina_home() {
        driver = new ChromeDriver();
        driver.get("https://marcelodebittencourt.com/ore/");
        driver.manage().window().setSize(new Dimension(1500, 1020));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Quando("selecionado um imóvel")
    public void selecionado_um_imóvel() throws InterruptedException {
        driver.findElement(By.id("city")).click();
        WebElement dropdownCity = driver.findElement(By.id("city"));
        dropdownCity.findElement(By.xpath("//option[. = 'New-York']")).click();

        driver.findElement(By.id("objType")).click();
        WebElement dropdownPropertyType = driver.findElement(By.id("objType"));
        dropdownPropertyType.findElement(By.xpath("//option[. = 'apartment']")).click();

        driver.findElement(By.id("btnleft")).click();
    }

    @Então("o valor que aparecer nas telas seguntes tem que ser igual ao valor da tela inicial")
    public void o_valor_que_aparecer_nas_telas_seguntes_tem_que_ser_igual_ao_da_tela_inicial() throws InterruptedException {

        String valorInicial = driver.findElement(By.cssSelector("#appartment_box > div.appartment_item.block > div.mini_block_full_description > div:nth-child(3) > div > span:nth-child(2)")).getText();
        driver.findElement(By.xpath("//*[@id=\"appartment_box\"]/div[7]/div[1]/a")).click();
        String valorSegundo = driver.findElement(By.cssSelector("#page > div.content > div > div.main-content-wrapper > div.view-apartment-main-block > div.b_item__info.block-right > div.price > span:nth-child(2)")).getText();
        String valorTerceiro = driver.findElement(By.cssSelector("#firsttabs > div.resp-tabs-container > div.tabs1_1.tab_bl_1.resp-tab-content.resp-tab-content-active > dl > dd:nth-child(10) > span > span:nth-child(2)")).getText();
        assertThat(valorSegundo).isEqualTo(valorInicial);
        assertThat(valorTerceiro).isEqualTo(valorInicial);
        driver.quit();
    }

}
