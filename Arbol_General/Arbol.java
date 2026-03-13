package Arbol_General;

public class Arbol<E> implements Arbol_Interface<E> {
    Nodo<E> raiz;

    public Arbol(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public Arbol() {
        this.raiz = null;
    }

    private void recorrerArbol(Nodo<E> actual){
        if(actual == null){
            return;
        };

        System.out.println(actual.getData());

        for (Nodo hijo : actual.getHijos()){
            recorrerArbol(hijo);
        }
    }

    public void recorrer(){
        recorrerArbol(raiz);
    }

    private Nodo<E> buscar(Nodo<E> actual, E dato_buscado){
        if(actual == null) return null;

        if(actual.getData().equals(dato_buscado)){
            return actual;
        }

        for (Nodo<E> hijo: actual.getHijos()){
            Nodo<E> encontrado = buscar(hijo,dato_buscado);
            if(encontrado != null){
                return encontrado;
            }
        }

        return null;
    }

    public Nodo<E> buscarNodo(E dato){
        return buscar(raiz,dato);
    }

    public void insertar(E datoNuevo,E dato_padre){
        Nodo<E> nuevo_nodo = new Nodo<>(datoNuevo);

        if(raiz == null){
            raiz = nuevo_nodo;
            return;
        }

        Nodo<E> padre = buscarNodo(dato_padre);

        if(padre != null){
            padre.getHijos().add(nuevo_nodo);
            nuevo_nodo.setPadre(padre);
        }else {
            System.out.println("Arbol_General.Nodo padre no encontrado");
        }
    }

    public void eliminar(E dato_eliminar){
        Nodo<E> nodo = buscarNodo(dato_eliminar);

        if(nodo == null) return;

        if(nodo == raiz){
            raiz = null;
            return;
        }

        nodo.getPadre().getHijos().remove(nodo);
    }

    private Nodo<E> copiarNodos(Nodo<E> actual){
        if(actual == null) {
            return null;
        }

        Nodo<E> nuevo = new Nodo<>(actual.getData());

        for(Nodo<E> hijo : actual.getHijos()){
            nuevo.getHijos().add(copiarNodos(hijo));
        }

        return nuevo;
    }

    public Arbol<E> obtenerSubArbol(E dato){
        Nodo<E> nodo = buscarNodo(dato);

        Arbol<E> subArbol = new Arbol<>();
        subArbol.raiz = copiarNodos(nodo);

        return subArbol;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }
}
