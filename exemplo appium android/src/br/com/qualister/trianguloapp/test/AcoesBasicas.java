package br.com.qualister.trianguloapp.test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xerces.util.URI.MalformedURIException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Test;


public class AcoesBasicas {

	@Test
	public void testeTriangulo() throws MalformedURLException{
		
		//informar onde esta o arquivo para a instalação
	      File caminhoArquivo = new File ("C:\\apps");
	      File arquivoCompleto = new File(caminhoArquivo,"TrianguloApp.apk");
	      
		//capacidades do dispositivo alvo dos testes
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Androie Emulator");
		capacidade.setCapability(MobileCapabilityType.APP,arquivoCompleto.getAbsolutePath());
	 
		//abrir a conexão entre o código e o dispositivo
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
	     
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();
		
		Assert.assertEquals("O triangulo e Equilatero",
				driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());
		
		driver.quit();
	
			
 
	}

}

