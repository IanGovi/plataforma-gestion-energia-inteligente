package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.excepciones.EnergiaInvalidaException;
import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaExcedidaException;
import ar.edu.unahur.obj2.energia.operaciones.Carga;

public class BateriaAlmacenamientoTest {
    @Test
    void dadaUnaNuevaBateriaCuandoConsultoEnergiaActualDevuelveLaInicial() {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);

        assertEquals(100, bateria.getEnergiaActual());
    }

    @Test
    void dadaUnaNuevaBateriaCuandoLaCargoEntoncesAumentaSuEnergia() {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);

        bateria.cargarEnergia(20);

        assertEquals(120, bateria.getEnergiaActual());
    }

    @Test
    void dadaUnaNuevaBateriaCuandoLeConsumoEnergiaSiendoPosibleEntoncesDisminuyeSuEnergia()
            throws LimiteReservaExcedidaException {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);

        bateria.consumirEnergia(20);

        assertEquals(80, bateria.getEnergiaActual());
    }

    @Test
    void seLanzaExcepcionAlCrearCargaConEnergiaCero() {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("B1", 1000);
        assertThrows(EnergiaInvalidaException.class, () -> new Carga(bateria, 0));
    }

}
