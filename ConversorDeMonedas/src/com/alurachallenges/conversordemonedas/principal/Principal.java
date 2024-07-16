package com.alurachallenges.conversordemonedas.principal;
import com.alurachallenges.conversordemonedas.modelos.API;
import com.alurachallenges.conversordemonedas.modelos.Moneda;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            API api = new API();
            Moneda moneda = new Moneda(api);
            Scanner scanner = new Scanner(System.in);

            int opcion;

            System.out.println("Bienvenid(a), gracias por utilizar nuestro Conversor de Moneda.");

            do {
                System.out.println("""
                                    
                        A continuación, escribe el número correspondiente a la opción 
                        que deseas elegir:
                        """);
                System.out.println("1. Dolar a Peso Colombiano");
                System.out.println("2. Peso Colombiano a Dolar");
                System.out.println("3. Euro a Peso Colombiano");
                System.out.println("4. Peso Colombiano a Euro");
                System.out.println("5. Franco Suizo a Peso Colombiano");
                System.out.println("6. Peso Colombiano a Franco Suizo");
                System.out.println("7. Salir");

                opcion = scanner.nextInt();
                double valorUsuario;

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el valor en Dolares a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " USD es: " + moneda.convertirUsdACop(valorUsuario) + " COP");
                        break;
                    case 2:
                        System.out.println("Ingrese el valor en Pesos Colombianos a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " COP es: " + moneda.convertirCopAUsd(valorUsuario) + " USD");
                        break;
                    case 3:
                        System.out.println("Ingrese el valor en Euros a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " EUR es: " + moneda.convertirEurACop(valorUsuario) + " COP");
                        break;
                    case 4:
                        System.out.println("Ingrese el valor en Pesos Colombianos a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " COP es: " + moneda.convertirCopAEur(valorUsuario) + " EUR");
                        break;
                    case 5:
                        System.out.println("Ingrese el valor en Francos Suizos a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " CHF es: " + moneda.convertirChfACop(valorUsuario) + " COP");
                        break;
                    case 6:
                        System.out.println("Ingrese el valor en Pesos Colombianos a convertir: ");
                        valorUsuario = scanner.nextDouble();
                        System.out.println("El valor correspondiente de " + valorUsuario + " COP es: " + moneda.convertirCopAChf(valorUsuario) + " CHF");
                        break;
                    case 7:
                        System.out.println("""
                                Gracias por utilizar nuestro conversor de monedas, 
                                esperamos que su experiencia haya sido satisfactoria.""");
                        break;
                    default:
                        System.out.println("Opción inválida, por favor intente nuevamente.");
                        break;
                }
                System.out.println("********************************************");
            } while (opcion != 7);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
