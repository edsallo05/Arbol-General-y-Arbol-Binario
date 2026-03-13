package Simulacion_Torneo;

import Simulacion_Torneo.NodoTorneo;

class ArbolTorneo {

    NodoTorneo raiz;

    public ArbolTorneo() {
        construirArbol();
    }

    private void construirArbol() {

        NodoTorneo qf1 = new NodoTorneo("Korea", "Republica Dominicana", "Cuartos");
        NodoTorneo qf2 = new NodoTorneo("USA", "Canada", "Cuartos");
        NodoTorneo qf3 = new NodoTorneo("Puerto Rico", "Italia", "Cuartos");
        NodoTorneo qf4 = new NodoTorneo("Japon", "Venezuela", "Cuartos");

        NodoTorneo semi1 = new NodoTorneo(null, null, "Semifinal");
        NodoTorneo semi2 = new NodoTorneo(null, null, "Semifinal");

        NodoTorneo finalNodo = new NodoTorneo(null, null, "Final");

        semi1.izquierda = qf1;
        semi1.derecha = qf2;

        semi2.izquierda = qf3;
        semi2.derecha = qf4;

        finalNodo.izquierda = semi1;
        finalNodo.derecha = semi2;

        raiz = finalNodo;
    }

    private void simularPartido(NodoTorneo nodo) {

        if (Math.random() < 0.5) {
            nodo.ganador = nodo.equipo1;
        } else {
            nodo.ganador = nodo.equipo2;
        }
    }

    public void simularTorneo() {
        simularRec(raiz);
    }

    private void simularRec(NodoTorneo nodo) {

        if (nodo == null) return;

        simularRec(nodo.izquierda);
        simularRec(nodo.derecha);

        if (nodo.izquierda != null && nodo.derecha != null) {
            nodo.equipo1 = nodo.izquierda.ganador;
            nodo.equipo2 = nodo.derecha.ganador;
        }

        simularPartido(nodo);
    }

    public void mostrar(NodoTorneo nodo) {

        if (nodo == null) return;

        mostrar(nodo.izquierda);
        mostrar(nodo.derecha);

        System.out.println(
                nodo.ronda + ": " +
                        nodo.equipo1 + " vs " +
                        nodo.equipo2 + " -> Ganador: " +
                        nodo.ganador
        );
    }
}