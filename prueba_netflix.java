package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class prueba_netflix {

    private WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Home\\IdeaProjects\\cursoselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;

    }
    @Test
    public void validarTituloTest(){
        WebDriver driver = getDriver("https://www.netflix.com/");

        String tituloactual = driver.getTitle();
        System.out.println("inicio : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Netflix Uruguay: Ve series online, ve películas online");

        //driver.close();

    }
    @Test
    public void iniciarSesionPageTest(){
        WebDriver driver = getDriver("https://www.netflix.com/");

        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")).click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://www.netflix.com/","Se debería estar en otra URL");
        System.out.println("------" + driver.getCurrentUrl());

        List<WebElement> H1s = driver.findElements(By.tagName("h1"));
        for (WebElement a : H1s){
            System.out.println(a.getText());
        }

        //WebElement facebook = driver.findElement(By.partialLinkText("Facebook"));
        //System.out.println(facebook.getText());

    }
    @Test
     public void loginToNetflixErrorTest(){

        WebDriver driver = getDriver("https://www.netflix.com/");

         driver.findElement(By.xpath("//a[@href='/login']")).click();WebElement campoemail = driver.findElement(By.xpath("//input[@name='userLoginId']"));
      campoemail.sendKeys("xxx");
        WebElement campocontraseña = driver.findElement(By.xpath("//input[@name='password']"));campocontraseña.sendKeys("Holamundo");


        WebElement errorEmail = driver.findElement(By.xpath("//*[contains(text(),'Escribe un email válido.')]"));
        Assert.assertEquals(errorEmail.getText(), "Escribe un email válido.");
    }


}





