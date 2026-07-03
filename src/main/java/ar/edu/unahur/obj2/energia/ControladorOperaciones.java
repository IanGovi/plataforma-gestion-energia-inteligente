package ar.edu.unahur.obj2.energia;


import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;
import ar.edu.unahur.obj2.energia.operaciones.IOperacion;

public class ControladorOperaciones {
    private Rutina rutina = new Rutina();

    public void ejecutarOperacion(IOperacion operacion) throws LimiteReservaExcedidaException {
        operacion.ejecutar();
    }

    public void registrarOperacion(IOperacion operacion) {
        rutina.agregarOperacion(operacion);
    }

    public void ejecutarOperacionesEnRutina() throws LimiteReservaExcedidaException {
        rutina.ejecutar();
        rutina.vaciar();
    }

}
