import java.util.Scanner;

public class banco {
    public static void main(String[] args) {

        String nombre = "Tony Stark";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;


        System.out.println("**********");
        System.out.println("\nNombre del cliente: " + nombre); // "\n" se usa para que se refleje un espacio en el texto
        System.out.println("El tipo de cuenta es: " + tipoDeCuenta);
        System.out.println("Su saldo disponible es: " + saldo + "$");

        System.out.println("\n**********");

        String menu = """
                *** Escribe el número de la opción deseada
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                4 - Salir
                """;

        Scanner teclado = new Scanner(System.in);
        while (opcion != 4) { //"while" es un ciclo de repetición
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El saldo actualizado es: " + saldo + "$");
                    break;
                case 2:
                    System.out.println("¿Cuál es el valor que desea retirar?");
                    double valorARetirar = teclado.nextDouble();
                    if (saldo > valorARetirar){
                        System.out.println("Saldo insuficiente");

                    }else {
                        saldo = saldo - valorARetirar;
                        System.out.println("el saldo actualizado es: " + saldo);

                    }
                    break;
                case 3:
                    System.out.println("¿Cuál es el valor que desea depositar?");
                    double valorADepositar = teclado.nextDouble();
                    saldo += valorADepositar;
                    System.out.println("el saldo actualizado es: " + saldo);
                    break;
                case 4:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("opción no válida");

            }
        }
}
    }
