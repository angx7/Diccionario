import java.util.Scanner;

public class Diccionario {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArbolBinarioBusqueda diccionario = new ArbolBinarioBusqueda();
        
        diccionario.insertar("arbol");
        diccionario.insertar("zapato");
        diccionario.insertar("serpiente");
        diccionario.insertar("bosque");

        System.out.println("¿Existe la palabra 'bosque' en el diccionario? " + diccionario.buscar("bosque"));
        System.out.println("¿Existe la palabra 'hola' en el diccionario? " + diccionario.buscar("hola"));

        System.out.println("\nRecorriendo el diccionario in-orden:");
        diccionario.recorrerInOrden();

        System.out.println("\nRecorrido en orden pre-orden:");
        diccionario.recorrerPreOrden();

        System.out.println("\nRecorrido en orden post-orden:");
        diccionario.recorrerPostOrden();

        System.out.println("\nAltura del árbol: " + diccionario.altura());

        diccionario.eliminar("bosque");
        System.out.println("¿Existe la palabra 'bosque' en el diccionario? " + diccionario.buscar("bosque"));

        diccionario.MinYMax();

        
    }
}
