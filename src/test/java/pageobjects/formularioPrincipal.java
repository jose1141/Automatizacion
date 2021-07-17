package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.util;

import java.util.concurrent.TimeUnit;

public class formularioPrincipal extends util {
    @FindBy(xpath = "//*[@id=\"testId-UserAction-userinfo\"]/div/div[2]/div/p") WebElement btnLogin;
    @FindBy(xpath = "//*[@id=\"testId-UserAction-userinfo\"]/div/div[1]/div[2]/p") WebElement lblUsuario;
    @FindBy(xpath = "//*[@id=\"testId-SearchBar-Input\"]") WebElement txtBuscar;
    @FindBy(xpath = "//*[@id=\"testId-search-wrapper\"]/div/button") WebElement btnBuscar;
    //@FindBy(id = "kplDeclineButton") WebElement btnDeclinar;
    @FindBy(id = "testId-Dropdown-desktop-button") WebElement cmbListarPor;
    @FindBy(id = "testId-Dropdown-Precio de menor a mayor") WebElement cmb1;
    @FindBy(id = "testId-Dropdown-Precio de mayor a menor") WebElement cmb2;
    @FindBy(id = "testId-Dropdown-Marca") WebElement cmb3;
    @FindBy(id = "testId-Dropdown-Nuevos productos") WebElement cmb4;
    @FindBy(id = "testId-Dropdown-Los mejores evaluados") WebElement cmb5;
    @FindBy(id = "testId-Dropdown-Recomendados") WebElement cmb6;
    @FindBy(id = "testId-pod-prices-17910770") WebElement precioMayor;
    @FindBy(id = "testId-pod-prices-18097105") WebElement precioMenor;

    public formularioPrincipal() {
        PageFactory.initElements(driver, this);
    }

    public void cargarPaginaPrincipal(){
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        driver.get("https://www.falabella.com.pe/falabella-pe");
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
    }

    public void clickLogin(){
        //wait.until(ExpectedConditions.visibilityOf(btnLogin));
        btnLogin.click();
    }

    public boolean validarUsuario(String Usuario) {
        wait.until(ExpectedConditions.visibilityOf(lblUsuario));

        String as = lblUsuario.getText();
        String bs = Usuario;

        if (as.equals(bs)) {
            return true;
        } else {
            return false;
        }
    }

    public void escribirProducto(String texto) {
        //wait.until(ExpectedConditions.visibilityOf(txtBuscar));
        txtBuscar.sendKeys(texto);
    }

    public void clickBuscar(){
        btnBuscar.click();
    }


//    public void clickDeclinar(){
//        if (btnDeclinar.isDisplayed())
//        {
//            btnDeclinar.click();
//        }
//    }

    public void OrdenarPor(String Filtro){
        cmbListarPor.click();

        switch(Filtro)
        {
            case "Precio de menor a mayor" :
                cmb1.click();
                break;
            case "Precio de mayor a menor" :
                cmb2.click();
                break;

            case "Marca" :
                cmb3.click();
                break;

            case "Nuevos productos" :
                cmb4.click();
                break;

            case "Los Mejores Evaluados" :
                cmb5.click();
                break;

            case "Recomendados" :
                cmb6.click();
                break;
            default :
                cmb1.click();
        }


    }

    public boolean verificarPrecioMayor(){
        Integer Mayor = new Integer(precioMayor.getText().substring(2).trim());
        Integer Menor = new Integer(precioMenor.getText().substring(2).trim());

        if ( Mayor > Menor) {
            return true;
        } else {
            return false;
        }
    }

}
