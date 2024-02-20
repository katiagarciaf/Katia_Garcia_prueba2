package Modelo;

import java.util.Objects;

public class Cabagna extends Hospederia {
    private boolean chimenea;

    public Cabagna(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente,
                   int capacidad, boolean esFumador, int cantidadNoches, boolean chimenea) {
        super(valorBaseNoche, tipoTemporada, datoscliente, capacidad, esFumador, cantidadNoches);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    // Método para calcular el subtotal (cantidad de noches por el valorBaseNoche)
    @Override
    public int subtotal() {
        return getCantidadNoches() * getValorBaseNoche();
    }

    // Método para calcular el valor adicional (30% del subtotal si es fumador y con desayuno)
    @Override
    public int adicional() {
        if (isEsFumador() && isConDesayuno()) {
            return (int) (0.3 * subtotal());
        }
        return 0;
    }

    private boolean isConDesayuno() {
        return false;
    }

    // Método para calcular el bono de descuento (25% si la temporada es baja, 12.5% si es media)
    @Override
    public int bonoDescuento() {
        if (getTipoTemporada().equalsIgnoreCase("baja")) {
            return (int) (subtotal() * 0.25);
        } else if (getTipoTemporada().equalsIgnoreCase("media")) {
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

    // Método para incrementar el valorBase en un 18% (si la capacidad de la cabaña es superior a 5)
    @Override
    public int incrementaValorBase() {
        if (getCapacidad() > 5) {
            setValorBaseNoche((int) (getValorBaseNoche() * 1.18));
        }
        return getValorBaseNoche();
    }

    private int getCapacidad() {
        return 0;
    }
}
