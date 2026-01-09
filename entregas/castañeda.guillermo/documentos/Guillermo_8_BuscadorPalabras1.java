
import java.util.Scanner;

public class BuscadorPalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] d = {
                "algoritmo", "variable", "funcion", "bucle", "condicional", "array", "metodo", "clase", "objeto",
                "herencia", "compilador", "sintaxis", "semantica", "depurar", "programa", "libreria", "parametro",
                "retorno", "recursion", "iteracion"
        };

        System.out.println("Buscador de Palabras - Diccionario Tecnico");
        System.out.println("Total de palabras en diccionario: " + d.length);

        while (true) {
            System.out.println("Introduce palabra a buscar (o 'salir'): ");
            String p = sc.nextLine().toLowerCase();

            if (p.equals("salir")) {
                break;
            }

            boolean e = false;
            for (int i = 0; i < d.length; i++) {
                if (d[i].equals(p)) {
                    e = true;
                }
            }

            if (e) {
                System.out.println("OK - La palabra existe en el diccionario");
            } else {
                System.out.println("ERROR - La palabra NO existe");
            }

            System.out.println("Palabras similares:");
            int s = 0;

            for (int i = 0; i < d.length; i++) {
                int c = 0;
                int limite = Math.min(p.length(), d[i].length());
                for (int j = 0; j < limite; j++) {
                    if (p.charAt(j) == d[i].charAt(j)) {
                        c++;
                    }
                }
                if (c >= 3) {
                    System.out.println("  * " + d[i]);
                    s++;
                }
            }
            if (s == 0) {
                System.out.println("  (no se encontraron)");
            }

            System.out.println("Palabras que contienen '" + p + "':");
            int cont = 0;

            for (int i = 0; i < d.length; i++) {
                boolean f = false;
                for (int j = 0; j <= d[i].length() - p.length(); j++) {
                    boolean m = true;
                    for (int k = 0; k < p.length(); k++) {
                        if (d[i].charAt(j + k) != p.charAt(k)) {
                            m = false;
                        }
                    }
                    if (m) {
                        f = true;
                    }
                }
                if (f) {
                    System.out.println("  * " + d[i]);
                    cont++;
                }
            }
            if (cont == 0) {
                System.out.println("  (no se encontraron)");
            }

        }

        System.out.println();
        System.out.println("Gracias por usar el buscador!");
        sc.close();
    }
}
