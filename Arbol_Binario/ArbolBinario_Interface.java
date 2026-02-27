package Arbol_Binario;

import Arbol_General.Arbol;
import Arbol_General.Nodo;

public interface ArbolBinario_Interface<E> {

    void insertar(E dato);

    NodoBinario<E> buscar(E dato);

    void recorrerPre();

    void recorrerPost();

    void recorrerIn();

    boolean eliminar(E dato);

    ArbolBinario<E> obtenerSubarbol(E dato);


}
