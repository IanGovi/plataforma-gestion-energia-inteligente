package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;

public interface IOperacion {
    void ejecutar() throws LimiteReservaExcedidaException;

    void deshacer() throws LimiteReservaExcedidaException;
}
