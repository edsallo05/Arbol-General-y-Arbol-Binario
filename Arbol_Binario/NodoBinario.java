package Arbol_Binario;

public class NodoBinario<E> {
    E data;
    NodoBinario<E> izquierdo;
    NodoBinario<E> derecho;


    public NodoBinario(E data) {
        this.data = data;
    }

    public NodoBinario(E data, NodoBinario<E> izquierdo, NodoBinario<E> derecho) {
        this.data = data;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodoBinario<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario<E> derecho) {
        this.derecho = derecho;
    }




}
