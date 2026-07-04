package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;
import ar.edu.unahur.obj2.energia.observadores.IObservadorBateria;

public class BateriaAlmacenamiento {
    private String identificador;
    private Integer energiaActual;
    private static final Integer limiteReserva = -5000;
    private List<IObservadorBateria> sistemasObservadores = new ArrayList<>();

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

    public void registrarSistemaObservador(IObservadorBateria sistema) {
        this.sistemasObservadores.add(sistema);
    }

    public void eliminarSistemaObservador(IObservadorBateria sistema) {
        this.sistemasObservadores.remove(sistema);
    }

    public void cargarEnergia(Integer cantEnergia) {
        this.energiaActual += cantEnergia;
        this.avisarASistemasObservadores("Carga", cantEnergia);
    }

    public void consumirEnergia(Integer cantEnergia) throws LimiteReservaExcedidaException {
        this.validarLimiteReserva(cantEnergia);
        this.energiaActual -= cantEnergia;
        this.avisarASistemasObservadores("Consumo", cantEnergia);
    }

    private void avisarASistemasObservadores(String tipo, Integer cantEnergia) {
        sistemasObservadores.forEach(sistema -> sistema.informarOperacionExitosa(this, tipo, cantEnergia));
    }

    private void validarLimiteReserva(Integer cantEnergia) throws LimiteReservaExcedidaException {
        if (this.energiaActual - cantEnergia < limiteReserva) {
            throw new LimiteReservaExcedidaException("La bateria " + identificador + " no puede consumir " + cantEnergia
                    + " kWh, ya que superaria el limite de reserva  de " + limiteReserva + " kWH.");
        }
    }

}
