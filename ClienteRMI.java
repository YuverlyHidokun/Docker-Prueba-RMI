import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 3000);
            BMIRemoto bmiService = (BMIRemoto) registry.lookup("BMIService");

            Scanner scanner = new Scanner(System.in);
            double peso = 0;
            double altura = 0;

            while (true) {
                System.out.println("Ingrese su peso (kg, mayor a 0): ");
                if (scanner.hasNextDouble()) {
                    peso = scanner.nextDouble();
                    if (peso > 0) break;
                    else System.out.println("El peso debe ser mayor a 0.");
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next();
                }
            }

            while (true) {
                System.out.println("Ingrese su altura (m, mayor a 0): ");
                if (scanner.hasNextDouble()) {
                    altura = scanner.nextDouble();
                    if (altura > 0) break;
                    else System.out.println("La altura debe ser mayor a 0.");
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next();
                }
            }

            double bmi = bmiService.calcularBMI(peso, altura);
            System.out.println("\nResultado:");
            System.out.println("Su BMI es: " + bmi);
            System.out.println("Categoría: " + bmiService.obtenerCategoriaBMI(bmi));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
