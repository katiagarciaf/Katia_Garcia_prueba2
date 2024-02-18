package Vista;

import Modelo.DatosCliente;

public class App_Smoke_Test {
    public static void main (String[] arg){

        DatosCliente datosCliente = new DatosCliente("",10);

        datosCliente.setRutCliente(1046958872);

        String nombre = datosCliente.getNombre();

        System.out.println("El nombre del cliente es"+nombre);

    }
}
