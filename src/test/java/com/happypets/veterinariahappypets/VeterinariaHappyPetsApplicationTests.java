package com.happypets.veterinariahappypets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VeterinariaHappyPetsApplicationTests {

	private WebDriver driver;
	
	@Test
	void contextLoads() {
		
		System.setProperty("webdriver.chrome.driver","src/test/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.get("http://localhost:4200/crudProducto");

		driver.findElement(By.id("id_mostrar_registro")).click();
				
		driver.findElement(By.id("descripcion")).sendKeys("Galleta para gato");
		driver.findElement(By.id("stock")).sendKeys("120");
		driver.findElement(By.id("preUni")).sendKeys("30.00");
		driver.findElement(By.id("idCategoria")).sendKeys("1");	
		
		driver.findElement(By.id("id_reg_registra")).click();
		
		
	}

}
