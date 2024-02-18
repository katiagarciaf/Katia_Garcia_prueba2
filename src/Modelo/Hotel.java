package Modelo;

public class Hotel extends Hospederia{
    /*
     *conDesayuno (boolean)
     */

    private boolean conDesayuno;

    public Hotel(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }
}
