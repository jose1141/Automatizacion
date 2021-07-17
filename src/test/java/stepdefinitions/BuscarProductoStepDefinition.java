package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobjects.formularioLogin;
import pageobjects.formularioPrincipal;

import static support.hooks.tearDown;

public class BuscarProductoStepDefinition {
    formularioPrincipal formulario;
    formularioLogin Login;

    public BuscarProductoStepDefinition(){
        formulario = new formularioPrincipal();
        Login = new formularioLogin();
    }

    @Given("Inicio sesion en la página Fallabella con el usuario {string} y clave {string}")
    public void inicio_sesion_en_la_página_fallabella_con_el_usuario_y_clave(String usuario, String clave) {
        formulario.cargarPaginaPrincipal();
        formulario.clickLogin();
        Login.escribirUsuario(usuario, clave);
        Login.clickIniciarSesion();
    }

    @Given("Cargo la página principal con el nombre del cliente {string}")
    public void cargo_la_página_principal_y_doy_click_al_campo_de_buscar_producto(String Nombre) {
        Assert.assertTrue(formulario.validarUsuario(Nombre));
    }

    @When("Ingreso el producto {string} y doy click en el botón Buscar")
    public void ingreso_el_producto_y_doy_click_en_el_botón_buscar(String producto) {
        formulario.escribirProducto(producto);
        formulario.clickBuscar();
//        formulario.clickDeclinar();
    }

    @When("Ordeno {string} los productos")
    public void ordeno_de_mayor_a_menor_los_productos(String Orden) {
        formulario.OrdenarPor(Orden);
    }

    @Then("Se muestran los productos NIKE ordenados")
    public void se_muestran_los_productos_nike_ordenados() {
        Assert.assertTrue(formulario.verificarPrecioMayor());
        tearDown();
    }

}
