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

    private static void convertirEnteroABinario(Scanner scanner) {
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();
        String binario = "";
        for (int i = 7; i >= 0; i--) {
            binario += (numero >> i) & 1;
        }
        System.out.println("Binario de 8 bits: " + binario);
    }

    private static void convertirBinarioAComplementoA2(Scanner scanner) {
        System.out.print("Ingrese un número binario de 8 bits: ");
        String binario = scanner.next();
        String complementoA2 = "";
        int carry = 1;
        for (int i = 7; i >= 0; i--) {
            complementoA2 = (((binario.charAt(i) - '0') ^ 1) | carry) + complementoA2;
            if (binario.charAt(i) == '0' && carry == 1) {
                carry = 0;
            }
        }
        System.out.println("Complemento a dos: " + complementoA2);
    }
    
    private static void convertirHexadecimalADecimalYViceversa(Scanner scanner) {
        System.out.println("Seleccione la conversión:");
        System.out.println("1. Hexadecimal a Decimal");
        System.out.println("2. Decimal a Hexadecimal");
        System.out.print("Opción (1/2): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        
        if (opcion == 1) {
            System.out.print("Ingrese un número hexadecimal de 3 dígitos: ");
            String hexadecimal = scanner.next().toUpperCase();
            int decimal = 0;
            for (int i = 0; i < hexadecimal.length(); i++) {
                char hexChar = hexadecimal.charAt(i);
                int hexValue = hexChar >= 'A' ? (hexChar - 'A' + 10) : (hexChar - '0');
                decimal = 16 * decimal + hexValue;
            }
            System.out.println("Decimal: " + decimal);
        } else if (opcion == 2) {
            System.out.print("Ingrese un número decimal: ");
            int decimal = scanner.nextInt();
            String hexadecimal = "";
            while (decimal > 0) {
                int rem = decimal % 16;
                hexadecimal = (rem < 10 ? Integer.toString(rem) : String.valueOf((char)('A' + rem - 10))) + hexadecimal;
                decimal = decimal / 16;
            }
            System.out.println("Hexadecimal: " + hexadecimal);
        } else {
            System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
        }
    }
    
    

    
}
