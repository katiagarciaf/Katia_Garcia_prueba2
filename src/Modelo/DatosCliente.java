package Modelo;

public class DatosCliente {
    /*
     *String nombre
       int rutCliente
     *
     */

    private String nombre;
    private int rutCliente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public DatosCliente(String nombre, int rutCliente) {
        this.nombre = nombre;
        this.rutCliente = rutCliente;
    }
}
