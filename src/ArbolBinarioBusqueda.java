public class ArbolBinarioBusqueda {
    private Nodo1 raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(String palabra) {
        raiz = insertarRecursivamente(raiz, palabra);
    }

    public Nodo1 insertarRecursivamente(Nodo1 raiz, String palabra) {
        if (raiz == null) {
            raiz = new Nodo1(palabra);
            return raiz;
        }

        if (palabra.compareTo(raiz.palabra) < 0) {
            raiz.izquierda = insertarRecursivamente(raiz.izquierda, palabra);
        } else if (palabra.compareTo(raiz.palabra) > 0) {
            raiz.derecha = insertarRecursivamente(raiz.derecha, palabra);
        }

        return raiz;
    }

    public boolean buscar(String palabra) {
        return buscarRecursivamente(raiz, palabra) != null;
    }

    public Nodo1 buscarRecursivamente(Nodo1 raiz, String palabra) {
        if (raiz == null || raiz.palabra.equals(palabra)) {
            return raiz;
        }

        if (palabra.compareTo(raiz.palabra) < 0) {
            return buscarRecursivamente(raiz.izquierda, palabra);
        } else {
            return buscarRecursivamente(raiz.derecha, palabra);
        }
    }

    public void eliminar(String palabra) {
        raiz = eliminarRecursivamente(raiz, palabra);
    }

    public Nodo1 eliminarRecursivamente(Nodo1 raiz, String palabra) {
        if (raiz == null) {
            return raiz;
        }

        if (palabra.compareTo(raiz.palabra) < 0) {
            raiz.izquierda = eliminarRecursivamente(raiz.izquierda, palabra);
        } else if (palabra.compareTo(raiz.palabra) > 0) {
            raiz.derecha = eliminarRecursivamente(raiz.derecha, palabra);
        } else {
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            raiz.palabra = minimoValor(raiz.derecha);

            raiz.derecha = eliminarRecursivamente(raiz.derecha, raiz.palabra);
        }

        return raiz;
    }

    public void minYMax() {
        System.out.println("El valor minimo es: " + minimoValor(raiz));
        System.out.println("El valor maximo es: " + maximoValor(raiz));
    }

    public String minimoValor(Nodo1 raiz) {
        String minimoValor = raiz.palabra;
        while (raiz.izquierda != null) {
            minimoValor = raiz.izquierda.palabra;
            raiz = raiz.izquierda;
        }

        return minimoValor;
    }

    public String maximoValor(Nodo1 raiz) {
        String maximoValor = raiz.palabra;
        while (raiz.derecha != null) {
            maximoValor = raiz.derecha.palabra;
            raiz = raiz.derecha;
        }

        return maximoValor;
    }

    public void recorrerInOrden() {
        recorrerInOrdenRecursivamente(raiz);
    }

    public void recorrerInOrdenRecursivamente(Nodo1 raiz) {
        if (raiz != null) {
            recorrerInOrdenRecursivamente(raiz.izquierda);
            System.out.print(raiz.palabra + " ");
            recorrerInOrdenRecursivamente(raiz.derecha);
        }
    }

    public void recorrerPreOrden() {
        recorrerPreOrdenRecursivamente(raiz);
    }

    public void recorrerPreOrdenRecursivamente(Nodo1 raiz) {
        if (raiz != null) {
            System.out.print(raiz.palabra + " ");
            recorrerPreOrdenRecursivamente(raiz.izquierda);
            recorrerPreOrdenRecursivamente(raiz.derecha);
        }
    }

    public void recorrerPostOrden() {
        recorrerPostOrdenRecursivamente(raiz);
    }

    public void recorrerPostOrdenRecursivamente(Nodo1 raiz) {
        if (raiz != null) {
            recorrerPostOrdenRecursivamente(raiz.izquierda);
            recorrerPostOrdenRecursivamente(raiz.derecha);
            System.out.print(raiz.palabra + " ");
        }
    }

    public int altura() {
        return obtenerAlturaRecursivamente(raiz);
    }

    public int obtenerAlturaRecursivamente(Nodo1 raiz) {
        if (raiz == null) {
            return 0;
        } else {
            int alturaIzquierda = obtenerAlturaRecursivamente(raiz.izquierda);
            int alturaDerecha = obtenerAlturaRecursivamente(raiz.derecha);
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }

}
