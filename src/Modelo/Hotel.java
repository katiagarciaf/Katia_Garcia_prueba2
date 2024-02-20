package Modelo;

import java.util.Objects;

public class Hotel extends Hospederia {
    private static final int capacidad = 200;
    private boolean conDesayuno;

    public Hotel(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente,
                 boolean esFumador, int cantidadNoches) {
        super(valorBaseNoche, tipoTemporada, datoscliente, capacidad, esFumador, cantidadNoches);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    // Método toString para representar los datos del hotel
    @Override
    public String toString() {
        return "Hotel{" +
                "conDesayuno=" + conDesayuno +
                ", esFumador=" + esFumador +
                ", cantidadNoches=" + cantidadNoches +
                ", valorBaseNoche=" + valorBaseNoche +
                ", tipoTemporada='" + tipoTemporada + '\'' +
                ", datoscliente=" + datoscliente +
                '}';
    }

    // Método equals para comparar dos objetos de tipo Hotel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return conDesayuno == hotel.conDesayuno &&
                esFumador == hotel.esFumador &&
                cantidadNoches == hotel.cantidadNoches &&
                valorBaseNoche == hotel.valorBaseNoche &&
                Objects.equals(tipoTemporada, hotel.tipoTemporada) &&
                Objects.equals(datoscliente, hotel.datoscliente);
    }

    // Método hashCode para generar un código hash único para cada objeto Hotel
    @Override
    public int hashCode() {
        return Objects.hash(conDesayuno, esFumador, cantidadNoches, valorBaseNoche, tipoTemporada, datoscliente);
    }

    // Método para calcular el subtotal (cantidad de noches por el valorBaseNoche)
    @Override
    public int subtotal() {
        return cantidadNoches * this.valorBaseNoche;
    }

    // Método para calcular el valor adicional (30% del subtotal si es fumador y con desayuno)
    @Override
    public int adicional() {
        if (esFumador && this.conDesayuno) {
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
        return subtotal() + adicional() - bonoDescuento();
    }

    // Método para incrementar el valorBase en un 18% (no implementado aquí, implementar en clases hijas)
    @Override
    public int incrementaValorBase() {
        // Implementación específica de Hotel para incrementar el valorBase
        // Aquí puedes proporcionar una lógica específica para Hotel
        return 0;
    }
}
