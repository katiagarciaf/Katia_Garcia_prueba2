package Modelo;

import java.util.Objects;

public class Carpa extends MedioDeAlojamiento {
    private int cantidadNoches;
    private int cantidadPersonas;

    public Carpa(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente,
                 int cantidadNoches, int cantidadPersonas) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
        this.cantidadNoches = cantidadNoches;
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    // Método toString para representar los datos de la carpa
    @Override
    public String toString() {
        return "Carpa{" +
                "cantidadNoches=" + cantidadNoches +
                ", cantidadPersonas=" + cantidadPersonas +
                ", valorBaseNoche=" + valorBaseNoche +
                ", tipoTemporada='" + tipoTemporada + '\'' +
                ", datoscliente=" + datoscliente +
                '}';
    }

    // Método equals para comparar dos objetos de tipo Carpa
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carpa carpa = (Carpa) o;
        return cantidadNoches == carpa.cantidadNoches &&
                cantidadPersonas == carpa.cantidadPersonas &&
                valorBaseNoche == carpa.valorBaseNoche &&
                Objects.equals(tipoTemporada, carpa.tipoTemporada) &&
                Objects.equals(datoscliente, carpa.datoscliente);
    }

    // Método hashCode para generar un código hash único para cada objeto Carpa
    @Override
    public int hashCode() {
        return Objects.hash(cantidadNoches, cantidadPersonas, valorBaseNoche, tipoTemporada, datoscliente);
    }

    // Método para calcular el subtotal (cantidad de noches por el valorBaseNoche)
    @Override
    public int subtotal() {
        return cantidadNoches * this.valorBaseNoche;
    }

    // Método para calcular el valor adicional (no implementado para Carpa, devuelve 0)
    @Override
    public int adicional() {
        return 0;
    }

    // Método para calcular el bono de descuento (no implementado para Carpa, devuelve 0)
    @Override
    public int bonoDescuento() {
        return 0;
    }

    // Método para calcular el valor a cancelar (subtotal + adicional - bonoDescuento)
    @Override
    public int valorACancelar() {
        return subtotal() + adicional() - bonoDescuento();
    }

    // Método para incrementar el valorBase en un 18% (no implementado aquí, implementar en clases hijas)
    @Override
    public int incrementaValorBase() {
        // No se implementa en la clase base
        return this.valorBaseNoche;
    }
}
