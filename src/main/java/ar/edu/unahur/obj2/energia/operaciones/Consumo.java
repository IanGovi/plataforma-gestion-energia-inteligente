package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;
import ar.edu.unahur.obj2.energia.excepciones.EnergiaInvalidaException;
import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;

public class Consumo implements IOperacion {
    private BateriaAlmacenamiento bateria;
    private Integer energia;

    public Consumo(BateriaAlmacenamiento bateria, Integer energia) {
        this.validarEnergia(energia);
        this.bateria = bateria;
        this.energia = energia;
    }

    private void validarEnergia(Integer energia) {
        if (energia <= 0) {
            throw new EnergiaInvalidaException("La energia debe ser mayor a 0");    
        }
    }

    @Override
    public void ejecutar() throws LimiteReservaExcedidaException {
        bateria.consumirEnergia(energia);
    }

    @Override
    public void deshacer() {
        bateria.cargarEnergia(this.energia);
    }
}
