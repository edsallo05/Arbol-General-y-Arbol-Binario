package Arbol_Genealogico;

public class Implementacion {
    public static void main(String[] args){
        Persona juan = new Persona("juan","10-10-1835","M");
        Persona pedro = new Persona("pedro","4-12-1865","M");
        Persona carlos = new Persona("carlos","1-1-1867","M");
        Persona antonio = new Persona("antonio","16-2-1902","M");
        Persona tomas = new Persona("tomas","31-08-1905","M");
        Persona rodolfo = new Persona("rodolfo","23-07-1910","M");
        Persona toni = new Persona("toni","1-1-1867","M");
        Persona mohamed = new Persona("mohamed","16-2-1902","M");
        Persona eddie = new Persona("eddie","31-08-1905","M");
        Persona freddie = new Persona("freddie","23-07-1910","M");

        Arbol_Genealogico arbol_genealogico = new Arbol_Genealogico();

        arbol_genealogico.agregarPersona(juan,null);

        arbol_genealogico.agregarPersona(pedro,juan);
        arbol_genealogico.agregarPersona(carlos,juan);

        arbol_genealogico.agregarPersona(antonio,pedro);

        arbol_genealogico.agregarPersona(tomas,carlos);
        arbol_genealogico.agregarPersona(rodolfo,carlos);

        arbol_genealogico.agregarPersona(toni,tomas);

        arbol_genealogico.agregarPersona(mohamed,rodolfo);

        arbol_genealogico.agregarPersona(eddie,mohamed);
        arbol_genealogico.agregarPersona(freddie,mohamed);
    }
}
