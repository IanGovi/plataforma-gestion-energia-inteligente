package ar.edu.unahur.obj2.energia;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;

public class BateriaAlmacenamiento {
    private String identificador;
    private Integer energiaActual;
    private static final Integer limiteReserva = -5000;

    public BateriaAlmacenamiento(String identificador, Integer energiaActual) {
        this.identificador = identificador;
        this.energiaActual = energiaActual;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Integer getEnergiaActual() {
        return energiaActual;
    }

    public void cargarEnergia(Integer cantEnergia) {
        this.energiaActual += cantEnergia;
    }

    public void consumirEnergia(Integer cantEnergia) throws LimiteReservaExcedidaException {
        this.validarLimiteReserva(cantEnergia);
        this.energiaActual -= cantEnergia;
    }

    private void validarLimiteReserva(Integer cantEnergia) throws LimiteReservaExcedidaException {
        if (this.energiaActual - cantEnergia < limiteReserva) {
            throw new LimiteReservaExcedidaException("La bateria " + identificador + " no puede consumir " + cantEnergia
                    + " kWh, ya que superaria el limite de reserva  de " + limiteReserva + " kWH.");
        }
    }

}
