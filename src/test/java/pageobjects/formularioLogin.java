package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class formularioLogin extends util {
    @FindBy(id = "testId-cc-login-form-email-input") WebElement txtEmail;
    @FindBy(id = "testId-cc-login-form-password-input") WebElement txtContraseña;
    @FindBy(id = "testId-cc-login-form-submit") WebElement btnIniciarSesion;


    public formularioLogin() {
        PageFactory.initElements(driver, this);
    }

    public void escribirUsuario(String usuario, String contraseña) {
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(usuario);
        txtContraseña.sendKeys(contraseña);
    }


    public void clickIniciarSesion(){
        btnIniciarSesion.click();
    }

}
