package Modelo;

public class Carpa extends MedioDeAlojamiento {
    /*
     *cantidadPersonas
     */
    protected int cantidadPersonas;

    public Carpa(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
