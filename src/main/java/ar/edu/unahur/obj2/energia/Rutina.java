package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;
import ar.edu.unahur.obj2.energia.operaciones.IOperacion;

public class Rutina implements IOperacion {
    private List<IOperacion> operaciones = new ArrayList<>();

    public void agregarOperacion(IOperacion operacion) {
        operaciones.add(operacion);
    }

    @Override
    public void ejecutar() throws LimiteReservaExcedidaException {
        List<IOperacion> ejecutadasConExito = new ArrayList<>();
        for (IOperacion operacion : operaciones) {
            try {
                operacion.ejecutar();
                ejecutadasConExito.add(operacion);   
            } catch (LimiteReservaExcedidaException error) {
                this.revertir(ejecutadasConExito);
                throw error;
            }
        }
    }

    private void revertir(List<IOperacion> ejecutadasConExito) throws LimiteReservaExcedidaException {
        List<IOperacion> reverso = new ArrayList<>(ejecutadasConExito);
        Collections.reverse(reverso);
        for (IOperacion operacion : reverso) {
            operacion.deshacer();
        }
    }

    @Override
    public void deshacer() throws LimiteReservaExcedidaException {
        List<IOperacion> reverso = new ArrayList<>(operaciones);
        Collections.reverse(reverso);
        for (IOperacion operacion : reverso) {
            operacion.deshacer();
        }
    }

    public void vaciar() {
        operaciones.clear();
    }
}
