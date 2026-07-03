package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;
import ar.edu.unahur.obj2.energia.excepciones.EnergiaInvalidaException;
import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;

public class Carga implements IOperacion {
    private BateriaAlmacenamiento bateria;
    private Integer energia;

    public Carga(BateriaAlmacenamiento bateria, Integer energia) {
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
    public void ejecutar() {
        bateria.cargarEnergia(this.energia);
    }

    @Override
    public void deshacer() throws LimiteReservaExcedidaException {
        bateria.consumirEnergia(energia);
    }

}
