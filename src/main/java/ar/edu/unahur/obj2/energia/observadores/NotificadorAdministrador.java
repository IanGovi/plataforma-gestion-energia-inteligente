package ar.edu.unahur.obj2.energia.observadores;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class NotificadorAdministrador implements IObservadorBateria {

    @Override
    public void informarOperacionExitosa(BateriaAlmacenamiento bateria, String tipo, Integer cantEnergia) {
        System.out.println("Ha habido un/a " + tipo + " de " + cantEnergia +" kWh en su batería " + bateria + "." );
    }

}
