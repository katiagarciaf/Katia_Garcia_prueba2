package Vista;

import Controlador.EmpresaTurismoK;
import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.DatosCliente;
import Modelo.Hotel;


public class App_Smoke_Tests {
    public static void main(String[] args) {
        EmpresaTurismoK empresa = new EmpresaTurismoK(); // Utilizamos el constructor sin parámetros

        DatosCliente cliente1 = new DatosCliente("Juan Perez", "123ABC");
        DatosCliente cliente2 = new DatosCliente("Ana Rodriguez", "456DEF");
        DatosCliente cliente3 = new DatosCliente("Pedro Gutierrez", "789GHI");

        Carpa carpa1 = new Carpa(50, "Alta", cliente1, 5, 3);
        Cabagna cabagna1 = new Cabagna(8, "Media", cliente2, 120, true, 7, true);
        Hotel hotel1 = new Hotel(80, "Baja", cliente3, true, 3);

        empresa.ingresarMedioAlojamiento(carpa1);
        empresa.ingresarMedioAlojamiento(cabagna1);
        empresa.ingresarMedioAlojamiento(hotel1);

        System.out.println("La cantidad de medios de alojamiento es: " + empresa.cantidadMediosAlojamiento("Hotel"));
        System.out.println("Total Adicional: " + empresa.totalAdicional());
        System.out.println("Total Bono Descuento: " + empresa.totalBonoDescuento());
        System.out.println("Medios de Alojamiento: ");
        empresa.mostrarMediosAlojamiento();
        System.out.println("Valor a Cancelar por cliente '123ABC': " + empresa.valorCancelarCliente("123ABC"));
        System.out.println("Valor a Cancelar por cliente '456DEF': " + empresa.valorCancelarCliente("456DEF"));
        System.out.println("Valor a Cancelar por cliente '789GHI': " + empresa.valorCancelarCliente("789GHI"));

        empresa.aplicarIncremento();
        System.out.println("Incremento aplicado a Cabañas con capacidad superior a 5.");

        System.out.println("------ Medios de Alojamiento después de operaciones ------");
        empresa.mostrarMediosAlojamiento();
    }
}