import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            BMIRemoto bmi = new BMIRemotoImpl();
            Registry registry = LocateRegistry.createRegistry(3000); // Cambiar al puerto 3000
            registry.rebind("BMIService", bmi);
            System.out.println("Servidor RMI está listo en el puerto 3000.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
