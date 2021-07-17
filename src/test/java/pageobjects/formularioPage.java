package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class formularioPage extends util {
    @FindBy(name = "RESULT_TextField-1") WebElement txtnombre;
    @FindBy(id = "RESULT_TextField-2") WebElement txtapellido;
    @FindBy(id = "RESULT_TextField-3") WebElement txttelefono;
    @FindBy(id = "RESULT_TextField-4") WebElement txtpais;
    @FindBy(id = "RESULT_TextField-5") WebElement txtciudad;
    @FindBy(id = "RESULT_TextField-6") WebElement txtcorreo;
    @FindBy(xpath = "//*[text()='Male']") WebElement rbdmale;
    @FindBy(xpath = "//*[text()='Female']") WebElement rbdfemale;
    @FindBy(name = "RESULT_RadioButton-9") WebElement cmbtiempo;
    @FindBy(name = "RESULT_FileUpload-10") WebElement flarchivo;
    @FindBy(id = "FSsubmit") WebElement btnsubmit;

    public formularioPage() {
        PageFactory.initElements(driver, this);
    }

    public void escribirNombre(String texto) {
        wait.until(ExpectedConditions.visibilityOf(txtnombre));
        txtnombre.sendKeys(texto);
    }

    public void escribirApellido(String texto) {
        //wait.until(ExpectedConditions.visibilityOf(txtapellido));
        txtapellido.sendKeys(texto);
    }

    public void escribirTelefono(String texto) {
        txttelefono.sendKeys(texto);
    }

    public void escribirPais(String texto) {
        txtpais.sendKeys(texto);
    }

    public void escribirCiudad(String texto) {
        txtciudad.sendKeys(texto);
    }

    public void escribirCorreo(String texto) {
        txtcorreo.sendKeys(texto);
    }

    public void seleccionarGenero(String genero){
        if (genero.toLowerCase().equals("male")){
            rbdmale.click();
        }else if (genero.toLowerCase().equals("female")){
            rbdfemale.click();
        }else{
            System.out.println("Valor inválido, escribir male o female");
        }
    }

    public void seleccionarTiempo(String tiempo){
        new Select(cmbtiempo).selectByVisibleText(tiempo);
    }

    public void subirArchivo(String archivo){
        flarchivo.sendKeys(archivo);
    }

    public void clickSubmit(){
        btnsubmit.click();
    }

    public void seleccionarDia(String dias){
        String[] dia = dias.split("-");
        for (int i = 0; i < dia.length; i++) {
            driver.findElement(By.xpath("//*[text()='"+dia[i]+"']")).click();
        }
    }

}
