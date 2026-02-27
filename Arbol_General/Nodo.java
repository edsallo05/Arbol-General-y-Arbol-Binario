package Arbol_General;

import java.util.ArrayList;

public class Nodo<E> {
    private E data;
    private Nodo<E> padre;
    private ArrayList<Nodo> hijos = new ArrayList<>();

    public Nodo(E data,Nodo<E>padre) {
        this.data = data;
        this.padre = padre;
    }

    public Nodo(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }


}
