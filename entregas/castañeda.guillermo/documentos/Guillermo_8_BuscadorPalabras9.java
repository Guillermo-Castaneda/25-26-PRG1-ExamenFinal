import java.util.Scanner;

public class BuscadorPalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] diccionario = {
                "algoritmo", "variable", "funcion", "bucle", "condicional", "array", "metodo", "clase", "objeto",
                "herencia", "compilador", "sintaxis", "semantica", "depurar", "programa", "libreria", "parametro",
                "retorno", "recursion", "iteracion"
        };

        System.out.println("Buscador de Palabras - Diccionario Tecnico");
        System.out.println("Total de palabras en diccionario: " + diccionario.length);

        while (true) {
            System.out.println("Introduce palabra a buscar (o 'salir'): ");
            String palabra = sc.nextLine().toLowerCase();

            if (palabra.equals("salir")) {
                break;
            }

            boolean existe = false;
            for (int i = 0; i < diccionario.length; i++) {
                if (diccionario[i].equals(palabra)) {
                    existe = true;
                }
            }

            if (existe) {
                System.out.println("OK - La palabra existe en el diccionario");
            } else {
                System.out.println("ERROR - La palabra NO existe");
            }

            System.out.println("Palabras similares:");
            int contadorSimilares = 0;

            for (int i = 0; i < diccionario.length; i++) {
                int coincidencias = 0;
                int limite = Math.min(palabra.length(), diccionario[i].length());
                for (int j = 0; j < limite; j++) {
                    if (palabra.charAt(j) == diccionario[i].charAt(j)) {
                        coincidencias++;
                    }
                }
                if (coincidencias >= 3) {
                    System.out.println("  * " + diccionario[i]);
                    contadorSimilares++;
                }
            }
            if (contadorSimilares == 0) {
                System.out.println("  (no se encontraron)");
            }

            System.out.println("Palabras que contienen '" + palabra + "':");
            int contadorContienen = 0;

            for (int i = 0; i < diccionario.length; i++) {
                boolean contiene = false;
                for (int j = 0; j <= diccionario[i].length() - palabra.length(); j++) {
                    boolean coincide = true;
                    for (int k = 0; k < palabra.length(); k++) {
                        if (diccionario[i].charAt(j + k) != palabra.charAt(k)) {
                            coincide = false;
                        }
                    }
                    if (coincide) {
                        contiene = true;
                    }
                }
                if (contiene) {
                    System.out.println("  * " + diccionario[i]);
                    contadorContienen++;
                }
            }
            if (contadorContienen == 0) {
                System.out.println("  (no se encontraron)");
            }
        }

        System.out.println();
        System.out.println("Gracias por usar el buscador!");
        sc.close();
    }
}
