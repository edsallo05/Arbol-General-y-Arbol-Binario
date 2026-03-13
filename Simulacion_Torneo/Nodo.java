package Simulacion_Torneo;

class NodoTorneo {

    String equipo1;
    String equipo2;
    String ganador;
    String ronda;

    NodoTorneo izquierda;
    NodoTorneo derecha;

    public NodoTorneo(String equipo1, String equipo2, String ronda) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ronda = ronda;
    }
}