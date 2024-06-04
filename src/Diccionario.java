import java.util.Scanner;

public class Diccionario {
    private static String defaultcolor = "\u001B[37m";
    static Scanner sc = new Scanner(System.in);

    private static void limpiarConsola() {
        System.out.print("\033[2J");
        System.out.print("\033[H");
    }

    // Método para validar solo números
    public static boolean IsInteger(String text) {
        int v;
        try {
            // Convierte la cadena de texto en un valor entero
            v = Integer.parseInt(text);
            if (v < 0 || v > 9) {
                return false;
            }
            return true;
            // Si el usuario ingreso un caracter devuelve un false
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void menu() {
        System.out.println("\u001B[36m"
                + " ----------------------------------------------------------------------------------------------------------------------------------\r\n"
                +
                "\t\t\tBienvenido\n\n" +
                "1. Añadir palabra\n" +
                "2. Buscar palabra\n" +
                "3. Eliminar palabra\n" +
                "4. Imprimir in-orden\n" +
                "5. Imprimr en post-orden\n" +
                "6. Imprimir en pre-orden\n" +
                "7. Altura del árbol\n" +
                "8. Encontrar el valor mínimo y máximo\n" +
                "9. Salir\n"
                + " ----------------------------------------------------------------------------------------------------------------------------------\r\n"
                + defaultcolor);
    }

    public static void main(String[] args) throws Exception {
        ArbolBinarioBusqueda diccionario = new ArbolBinarioBusqueda();

        int op = 0;
        limpiarConsola();
        do {
            menu();
            String option = sc.next();
            while (!IsInteger(option)) {
                System.out.print(
                        "El valor ingresado no es un entero o no es una opción válida\n\nIntente nuevamente: ");
                option = sc.next();
            }
            op = Integer.parseInt(option);

            switch (op) {
                case 1:
                    System.out.println("Ingrese la palabra a añadir: ");
                    String palabra = sc.next().toLowerCase();
                    diccionario.insertar(palabra);
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("Ingrese la palabra a buscar: ");
                    String buscar = sc.next().toLowerCase();
                    System.out.println(
                            "¿Existe la palabra '" + buscar + "' en el diccionario? "
                                    + (diccionario.buscar(buscar) ? "Sí" : "No"));
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("Ingrese la palabra a eliminar: ");
                    String eliminar = sc.next().toLowerCase();
                    diccionario.eliminar(eliminar);
                    System.out.println(
                            "¿Existe la palabra '" + eliminar + "' en el diccionario? "
                                    + (diccionario.buscar(eliminar) ? "Sí" : "No"));
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("\nRecorriendo el diccionario in-orden:");
                    diccionario.recorrerInOrden();
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\nRecorrido en orden post-orden:");
                    diccionario.recorrerPostOrden();
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 6:
                    System.out.println("\nRecorrido en orden pre-orden:");
                    diccionario.recorrerPreOrden();
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 7:
                    System.out.println("\nAltura del árbol: " + diccionario.altura());
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 8:
                    diccionario.MinYMax();
                    sc.nextLine();
                    sc.nextLine();
                    break;

                default:
                    System.out.println("Saliendo...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
            }

        } while (op != 9);
    }
}
