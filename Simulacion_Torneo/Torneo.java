package Simulacion_Torneo;

public class Torneo {
    public static void main(String[] args) {

        ArbolTorneo torneo = new ArbolTorneo();

        torneo.simularTorneo();

        torneo.mostrar(torneo.raiz);

        System.out.println("\nCampeon: " + torneo.raiz.ganador);
    }
}
