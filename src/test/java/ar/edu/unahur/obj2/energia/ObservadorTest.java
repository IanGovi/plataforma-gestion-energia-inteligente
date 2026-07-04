package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.observadores.RegistroCentralAuditoria;

public class ObservadorTest {
        @Test
    void dadoUnObservadorRegistradoEnBateriaCuandoSeCargaEntoncesEsNotificado() {
        BateriaAlmacenamiento bateria = new BateriaAlmacenamiento("Bateria-1", 100);
        RegistroCentralAuditoria auditoria = new RegistroCentralAuditoria();
        bateria.registrarSistemaObservador(auditoria);

        bateria.cargarEnergia(1000);

        assertTrue(auditoria.getRegistros().contains("La batería Bateria-1 tuvo un/a Carga de 1000 kWh."));

    }
}
