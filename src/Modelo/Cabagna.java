package Modelo;

public class Cabagna extends Hospederia {
    /*
     *chimenea (boolean)
     */

    private boolean chimenea;

    public Cabagna(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        super(valorBaseNoche, tipoTemporada, datoscliente);
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }
}
