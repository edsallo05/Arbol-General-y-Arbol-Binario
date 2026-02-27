import Arbol_Binario.ArbolBinario;
import Arbol_General.Arbol;
import Arbol_General.Nodo;

public class Main {

    public static void main(String[] args){
        //Arbol general(Sistema de Ficheros)
        Arbol<String> pc = new Arbol<>();

        pc.insertar("Disco Local",null);

        pc.insertar("Descargas","Disco Local");
        pc.insertar("Documentos","Disco Local");
        pc.insertar("Multimedia","Disco Local");

        pc.insertar("tarea.pdf","Descargas");
        pc.insertar("installer.msi","Descargas");

        pc.insertar("texto.txt","Documentos");
        pc.insertar("word.docx","Documentos");
        pc.insertar("powerpoint.pptx","Documentos");

        pc.insertar("video.mkv","Multimedia");

        //Puedes probar el resto de metodos

        //Arbol Binario(Sistema de puestos de una empresa)

        ArbolBinario<String> empresa = new ArbolBinario<>();

        empresa.insertar("CEO");
        empresa.insertar("CTO");
        empresa.insertar("CFO");
        empresa.insertar("dev1");
        empresa.insertar("dev2");
        empresa.insertar("Contador1");

        //Puedes probar el resto de metodos ya yo los probe y se que funcionan
    }
}
