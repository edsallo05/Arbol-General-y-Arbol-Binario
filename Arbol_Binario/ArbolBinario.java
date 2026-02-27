package Arbol_Binario;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario<E> implements ArbolBinario_Interface<E>{
    private NodoBinario<E> raiz;

    public ArbolBinario(NodoBinario<E> raiz) {
        this.raiz = raiz;
    }

    public ArbolBinario() {
        this.raiz = null;
    }

    public NodoBinario<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBinario<E> raiz) {
        this.raiz = raiz;
    }

    public void insertar(E dato) {
        NodoBinario<E> nuevoNodo = new NodoBinario<>(dato);

        if (raiz == null) {
            raiz = nuevoNodo;
            return;
        }

        Queue<NodoBinario<E>> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoBinario<E> nodo = cola.poll();

            if (nodo.getIzquierdo() == null) {
                nodo.setIzquierdo(nuevoNodo);
                return;
            } else {
                cola.add(nodo.getIzquierdo());
            }

            if (nodo.getDerecho() == null) {
                nodo.setDerecho(nuevoNodo);
                return;
            } else {
                cola.add(nodo.getDerecho());
            }
        }
    }

    public NodoBinario<E> buscar(E dato) {
        if (raiz == null) return null;

        Queue<NodoBinario<E>> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoBinario<E> nodo = cola.poll();
            if (nodo.getData().equals(dato)) return nodo;

            if (nodo.getIzquierdo() != null) cola.add(nodo.getIzquierdo());
            if (nodo.getDerecho() != null) cola.add(nodo.getDerecho());
        }
        return null;
    }

    private void recorrerPreorden(NodoBinario<E> nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getData() + " ");
        recorrerPreorden(nodo.getIzquierdo());
        recorrerPreorden(nodo.getDerecho());
    }

    public void recorrerPre(){
        recorrerPreorden(raiz);
    }

    private void recorrerInorden(NodoBinario<E> nodo) {
        if (nodo == null) return;
        recorrerInorden(nodo.getIzquierdo());
        System.out.print(nodo.getData() + " ");
        recorrerInorden(nodo.getDerecho());
    }

    public void recorrerIn(){
        recorrerInorden(raiz);
    }


    private void recorrerPostorden(NodoBinario<E> nodo) {
        if (nodo == null) return;
        recorrerPostorden(nodo.getIzquierdo());
        recorrerPostorden(nodo.getDerecho());
        System.out.print(nodo.getData() + " ");
    }

    public void recorrerPost(){
        recorrerPostorden(raiz);
    }



    public boolean eliminar(E dato) {
        if (raiz == null) return false;


        if (raiz.getData().equals(dato)) {
            raiz = null;
            return true;
        }

        return eliminarRecursivo(raiz, dato);
    }

    private boolean eliminarRecursivo(NodoBinario<E> actual, E dato) {
        if (actual == null) return false;


        if (actual.getIzquierdo() != null &&
                actual.getIzquierdo().getData().equals(dato)) {

            actual.setIzquierdo(null);
            return true;
        }


        if (actual.getDerecho() != null &&
                actual.getDerecho().getData().equals(dato)) {

            actual.setDerecho(null);
            return true;
        }


        return eliminarRecursivo(actual.getIzquierdo(), dato) ||
                eliminarRecursivo(actual.getDerecho(), dato);
    }

     public ArbolBinario<E> obtenerSubarbol(E dato) {
        NodoBinario<E> nodoOriginal = buscar(dato);

        if (nodoOriginal == null) return null;

        ArbolBinario<E> nuevoArbol = new ArbolBinario<>();
        nuevoArbol.raiz = clonarSubarbol(nodoOriginal);

        return nuevoArbol;
    }
     private NodoBinario<E> clonarSubarbol(NodoBinario<E> nodo) {
        if (nodo == null) return null;

        NodoBinario<E> nuevoNodo = new NodoBinario<>(nodo.getData());

        nuevoNodo.setIzquierdo(clonarSubarbol(nodo.getIzquierdo()));
        nuevoNodo.setDerecho(clonarSubarbol(nodo.getDerecho()));

        return nuevoNodo;
    }
}
