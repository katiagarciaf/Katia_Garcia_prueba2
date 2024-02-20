package Modelo;

import java.util.Objects;

public class Hospederia extends MedioDeAlojamiento {
    protected boolean esFumador;
    protected int cantidadNoches;

    public Hospederia(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente, int capacidad, boolean esFumador, int cantidadNoches) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
        this.esFumador = esFumador;
        this.cantidadNoches = cantidadNoches;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    // Método toString para representar los datos de la hospedería
    @Override
    public String toString() {
        return "Hospederia{" +
                "esFumador=" + esFumador +
                ", cantidadNoches=" + cantidadNoches +
                ", valorBaseNoche=" + valorBaseNoche +
                ", tipoTemporada='" + tipoTemporada + '\'' +
                ", datoscliente=" + datoscliente +
                '}';
    }

    // Método equals para comparar dos objetos de tipo Hospederia
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospederia that = (Hospederia) o;
        return esFumador == that.esFumador &&
                cantidadNoches == that.cantidadNoches &&
                valorBaseNoche == that.valorBaseNoche &&
                Objects.equals(tipoTemporada, that.tipoTemporada) &&
                Objects.equals(datoscliente, that.datoscliente);
    }

    // Método hashCode para generar un código hash único para cada objeto Hospederia
    @Override
    public int hashCode() {
        return Objects.hash(esFumador, cantidadNoches, valorBaseNoche, tipoTemporada, datoscliente);
    }

    // Método para calcular el subtotal (cantidad de noches por el valorBaseNoche)
    @Override
    public int subtotal() {
        return cantidadNoches * this.valorBaseNoche;
    }

    // Método para calcular el valor adicional (30% del subtotal si es fumador)
    @Override
    public int adicional() {
        if (esFumador) {
            return (int) (0.3 * subtotal());
        } else {
            return 0;
        }
    }

    // Método para calcular el bono de descuento (25% si la temporada es baja, 12.5% si es media)
    @Override
    public int bonoDescuento() {
        if (tipoTemporada.equalsIgnoreCase("baja")) {
            return (int) (subtotal() * 0.25);
        } else if (tipoTemporada.equalsIgnoreCase("media")) {
            return (int) (subtotal() * 0.125);
        } else {
            return 0;
        }
    }

    // Método para calcular el valor a cancelar (subtotal + adicional - bonoDescuento)
    @Override
    public int valorACancelar() {
        int subtotal = subtotal();
        int adicional = adicional();
        int bonoDescuento = bonoDescuento();
        return subtotal + adicional - bonoDescuento;
    }

    // Método para incrementar el valorBase en un 18% (no implementado aquí, implementar en clases hijas)
    @Override
    public int incrementaValorBase() {
        // No se implementa en la clase base
        return this.valorBaseNoche;
    }
}
