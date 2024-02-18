package Modelo;

public class Hospederia extends MedioDeAlojamiento {
    /*
    *esFumador (boolean)
       capacidad
    *
     */
 protected boolean esFumador;
 protected int capacidad;

    public Hospederia(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
