package ar.edu.unahur.obj2.energia.observadores;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public interface IObservadorBateria {
    public void informarOperacionExitosa(BateriaAlmacenamiento bateria, String tipo, Integer cantEnergia);
}
