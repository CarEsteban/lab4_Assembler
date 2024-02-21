import java.util.Scanner;

public class Convertidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Convertir entero a binario de 8 bits");
            System.out.println("2. Convertir binario de 8 bits a complemento a dos");
            System.out.println("3. Convertir hexadecimal de 3 dígitos a decimal y viceversa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirEnteroABinario(scanner);
                    break;
                case 2:
                    convertirBinarioAComplementoA2(scanner);
                    break;
                case 3:
                    convertirHexadecimalADecimalYViceversa(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }


    
}
