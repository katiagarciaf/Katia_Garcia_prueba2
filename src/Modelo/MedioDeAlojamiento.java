package Modelo;

import java.util.Objects;

public abstract class MedioDeAlojamiento {
    protected int valorBaseNoche;
    protected String tipoTemporada;
    protected DatosCliente datoscliente;

    public MedioDeAlojamiento(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        this.valorBaseNoche = valorBaseNoche;
        this.tipoTemporada = tipoTemporada;
        this.datoscliente = datoscliente;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public DatosCliente getDatoscliente() {
        return datoscliente;
    }

    public void setDatoscliente(DatosCliente datoscliente) {
        this.datoscliente = datoscliente;
    }

    @Override
    public String toString() {
        return "MedioDeAlojamiento{" +
                "valorBaseNoche=" + valorBaseNoche +
                ", tipoTemporada='" + tipoTemporada + '\'' +
                ", datoscliente=" + datoscliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedioDeAlojamiento that = (MedioDeAlojamiento) o;
        return valorBaseNoche == that.valorBaseNoche &&
                tipoTemporada.equals(that.tipoTemporada) &&
                datoscliente.equals(that.datoscliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorBaseNoche, tipoTemporada, datoscliente);
    }

    public int subtotal(int cantidadNoches) {
        return cantidadNoches * this.valorBaseNoche;
    }

    public int adicional(boolean esFumador, boolean conDesayuno, int cantidadNoches) {
        if (esFumador && conDesayuno) {
            return (int) (0.3 * subtotal(cantidadNoches));
        }
        return 0;
    }

    // Método para calcular el subtotal (cantidad de noches por el valorBaseNoche)
    public abstract int subtotal();

    // Método para calcular el valor adicional (no implementado para Carpa, devuelve 0)
    public abstract int adicional();

    public int bonoDescuento() {
        if (tipoTemporada.equalsIgnoreCase("baja")) {
            return (int) (subtotal(1) * 0.25);
        } else if (tipoTemporada.equalsIgnoreCase("media")) {
            return (int) (subtotal(1) * 0.125);
        } else {
            return 0;
        }
    }

    public int valorACancelar(boolean esFumador, boolean conDesayuno, int cantidadNoches) {
        int subtotal = subtotal(cantidadNoches);
        int adicional = adicional(esFumador, conDesayuno, cantidadNoches);
        int bonoDescuento = bonoDescuento();
        return subtotal + adicional - bonoDescuento;
    }

    // Método para calcular el valor a cancelar (subtotal + adicional - bonoDescuento)
    public abstract int valorACancelar();

    public int incrementaValorBase() {
        return this.valorBaseNoche;
    }

    public DatosCliente getDatosCliente() {
        return null;
    }
}
