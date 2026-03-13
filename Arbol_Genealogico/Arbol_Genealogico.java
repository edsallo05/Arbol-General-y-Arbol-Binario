package Arbol_Genealogico;
import Arbol_General.Arbol;
import Arbol_General.Nodo;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol_Genealogico {
    Arbol<Persona> arbol_genealogico = new Arbol<>();


    public void agregarPersona(Persona hijo,Persona padre){
        arbol_genealogico.insertar(hijo,padre);
    }

    public void buscarAntepasados(Persona persona){
        Nodo<Persona> real = arbol_genealogico.buscarNodo(persona);

        if(real == null){
            System.out.println("no se encotro ninguna persona con ese nombre");
            return;
        }

        Nodo<Persona> actual = real.getPadre();

        String[] niveles = {"Padre","Abuelo","Bisabuelo"};
        int i = 0;

        while (actual != null && i < niveles.length){
            System.out.println(niveles[i] + ": " + actual.getData().getNombre());
            actual = actual.getPadre();
            i++;
        }
    }

    public void listarDescendientes(Persona persona){
        Nodo<Persona> persona_buscar = arbol_genealogico.buscarNodo(persona);

        if (persona_buscar == null){
            System.out.println("No se encotro esa persona");
            return;
        }

        buscarDescendiente(persona_buscar);
    }

    private void buscarDescendiente(Nodo<Persona> persona){

        for(Nodo<Persona> hijo : persona.getHijos()){
            System.out.println(hijo.getData().getNombre());
            buscarDescendiente(hijo);
        }
    }

    public void eliminarRama(Persona persona){
        Nodo<Persona> persona_eliminar = arbol_genealogico.buscarNodo(persona);

        if (persona_eliminar == null){
            System.out.println("No se encontro la persona");
            return;
        }

        arbol_genealogico.eliminar(persona_eliminar.getData());
    }

    public void altura(){
        int altura = buscarAltura(arbol_genealogico.getRaiz());
        System.out.println("El arbol tiene " + altura + " generaciones");
    }

    private int buscarAltura(Nodo<Persona> persona){

        if(persona.getHijos().isEmpty()){
            return 1;
        }

        int max_altura = 0;

        for(Nodo<Persona> hijo: persona.getHijos()){
            int altura_hijo = buscarAltura(hijo);

            if (altura_hijo > max_altura){
                max_altura = altura_hijo;
            }
        }

        return max_altura + 1;
    }

    public void recorrerPorGeneracion(){
        Nodo<Persona> raiz = arbol_genealogico.getRaiz();

        if(raiz == null){
            System.out.println("El arbol esta vacio");
            return;
        }

        Queue<Nodo<Persona>> cola = new LinkedList<>();

        cola.add(raiz);

        int generacion = 1;

        while (!cola.isEmpty()){
            int tamano_nivel = cola.size();

            System.out.println("Generacion " + generacion + ":");

            for(int i = 0; i < tamano_nivel; i++){
                Nodo<Persona> actual = cola.poll();
                System.out.println(actual.getData().getNombre());

                for(Nodo<Persona> hijo: actual.getHijos()){
                    cola.add(hijo);
                }
            }
            generacion++;
        }
    }
}
