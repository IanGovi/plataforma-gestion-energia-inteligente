package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;
import ar.edu.unahur.obj2.energia.operaciones.Carga;
import ar.edu.unahur.obj2.energia.operaciones.Consumo;

public class ControladorOperacionesTest {
    @Test
    void dadaUnaRutinaConDosOperaciones_cuandoElControladorEjecuta_entoncesProcesaTodasYVaciaLaCola() throws LimiteReservaExcedidaException {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);
        ControladorOperaciones controlador = new ControladorOperaciones();
        controlador.registrarOperacion(new Carga(bateria, 20));
        controlador.registrarOperacion(new Consumo(bateria, 50));

        
        controlador.ejecutarOperacionesEnRutina();

        assertEquals(70, bateria.getEnergiaActual()); 
    }

    @Test
    void dadaUnaRutinaConDosOperacionesEstaMismaPuedeEjecutarYDeshacer() throws LimiteReservaExcedidaException {
        // Given
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);
        ControladorOperaciones controlador = new ControladorOperaciones();
        controlador.registrarOperacion(new Carga(bateria, 20));
        controlador.registrarOperacion(new Consumo(bateria, 50));

        
        controlador.getRutina().ejecutar();

        assertEquals(70, bateria.getEnergiaActual()); 
        
        // Cuando deshacemos
        controlador.getRutina().deshacer();

        // Then (Debe volver a 10000 sin errores)
        assertEquals(100, bateria.getEnergiaActual());
    }

    @Test
    void dadaUnaRutinaConDosOperacionesSiNoSePuedeRealizarLaSegundaLoRevierte() throws LimiteReservaExcedidaException {
        // Given
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);
        ControladorOperaciones controlador = new ControladorOperaciones();
        controlador.registrarOperacion(new Carga(bateria, 10));
        controlador.registrarOperacion(new Consumo(bateria, 5120));

        LimiteReservaExcedidaException excepcion = assertThrows(LimiteReservaExcedidaException.class, () -> {
            controlador.ejecutarOperacionesEnRutina();
        });

        assertEquals("La bateria Bateria-1 no puede consumir 5120 kWh, ya que superaria el limite de reserva  de -5000 kWH.", excepcion.getMessage());
        assertEquals(100, bateria.getEnergiaActual());
    }
}
