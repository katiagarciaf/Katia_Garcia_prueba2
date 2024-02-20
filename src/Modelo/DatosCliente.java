package Modelo;

import java.util.Objects;

public class DatosCliente {
    private String nombre;
    private String rutCliente;

    public DatosCliente(String nombre, String rutCliente) {
        this.nombre = nombre;
        this.rutCliente = rutCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    @Override
    public String toString() {
        return "DatosCliente{" +
                "nombre='" + nombre + '\'' +
                ", rutCliente='" + rutCliente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosCliente that = (DatosCliente) o;
        return nombre.equals(that.nombre) &&
                rutCliente.equals(that.rutCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, rutCliente);
    }
}

