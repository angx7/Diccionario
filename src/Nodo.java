public class Nodo {
    String palabra;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.izquierda = this.derecha = null;
    }
}
