package ar.edu.unahur.obj2.energia.observadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class RegistroCentralAuditoria implements IObservadorBateria {
    private List<String> registros = new ArrayList<>();

    public List<String> getRegistros() {
        return registros;
    }

    @Override
    public void informarOperacionExitosa(BateriaAlmacenamiento bateria, String tipo, Integer cantEnergia) {
        registros.add(this.generarRegistro(bateria, tipo, cantEnergia));
    }

    private String generarRegistro(BateriaAlmacenamiento bateria, String tipo, Integer cantEnergia) {
        return "La batería " + bateria.getIdentificador() + " tuvo un/a " + tipo + " de " + cantEnergia + " kWh.";
    }

}
