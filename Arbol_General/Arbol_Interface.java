package Arbol_General;

public interface Arbol_Interface<E> {

    void insertar(E dato_nuevo, E dato_padre);

    void eliminar(E dato_eliminar);

    Nodo<E> buscarNodo(E dato);

    Arbol<E> obtenerSubArbol(E dato);

    void recorrer();
}
