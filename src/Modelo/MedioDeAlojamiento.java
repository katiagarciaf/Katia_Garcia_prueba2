package Modelo;

public class MedioDeAlojamiento {
    /*
    *int valorBaseNoche
    String tipoTemporada (alta, media o baja)
    DatosCliente
    *
     */

    protected int valorBaseNoche;
    protected String tipoTemporada;
    protected DatosCliente datoscliente;


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

    public MedioDeAlojamiento(int valorBaseNoche, String tipoTemporada, DatosCliente datoscliente) {
        this.valorBaseNoche = valorBaseNoche;
        this.tipoTemporada = tipoTemporada;
        this.datoscliente = datoscliente;
    }
}
