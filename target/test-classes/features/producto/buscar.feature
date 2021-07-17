Feature: Implementar Buscar producto

  Scenario: Buscar producto Correcto
    Given Inicio sesion en la página Fallabella con el usuario "jhuamandonayre@gmail.com" y clave "Pepe1041"
    And Cargo la página principal con el nombre del cliente "\"Jose Carlos"
    When  Ingreso el producto "NIKE" y doy click en el botón Buscar
    And   Ordeno "Precio de mayor a menor" los productos
    Then  Se muestran los productos NIKE ordenados
