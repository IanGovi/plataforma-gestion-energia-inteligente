package ar.edu.unahur.obj2.energia.observadores;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class AlarmaReservaCritica implements IObservadorBateria {

    @Override
    public void informarOperacionExitosa(BateriaAlmacenamiento bateria, String tipo, Integer cantEnergia) {
        if (this.estaUsandoReserva(bateria)) {
            this.advertirUsoLimite(bateria);
        }
    }

    private Boolean estaUsandoReserva(BateriaAlmacenamiento bateria) {
        return bateria.getEnergiaActual() <= 0;
    }

    private void advertirUsoLimite(BateriaAlmacenamiento bateria) {
        System.out.println("La batería " + bateria.getIdentificador()
                + " esta haciendo uso de la reserva. Nivel Actual: " + bateria.getEnergiaActual() + " kWh.");
    }

}
