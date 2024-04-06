package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación para la cola de prioridades:");
        System.out.println("1. Implementación propia (VectorHeap)");
        System.out.println("2. Implementación de Java (PriorityQueue)");
        int opcion = scanner.nextInt();
        
        if (opcion == 1) {
            VectorHeap<Paciente> patientQueue = new VectorHeap<>();
            leerPacientesVectorHeap(patientQueue);
            
            while (!patientQueue.isEmpty()) {
                System.out.println("Atendiendo a: " + patientQueue.remove());
            }
        } else if (opcion == 2) {
            PriorityQueue<Paciente> patientQueue = new PriorityQueue<>();
            leerPacientesPriorityQueue(patientQueue);
            
            while (!patientQueue.isEmpty()) {
                System.out.println("Atendiendo a: " + patientQueue.remove());
            }
        } else {
            System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }

    public static void leerPacientesVectorHeap(VectorHeap<Paciente> patientQueue) {
        try (BufferedReader reader = new BufferedReader(new FileReader("hdt8\\src\\main\\resources\\pacientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    patientQueue.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo pacientes.txt");
            e.printStackTrace();
        }
    }

    public static void leerPacientesPriorityQueue(PriorityQueue<Paciente> patientQueue) {
        try (BufferedReader reader = new BufferedReader(new FileReader("hdt8\\src\\main\\resources\\pacientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    patientQueue.add(new Paciente(parts[0], parts[1], parts[2].charAt(0)));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo pacientes.txt");
            e.printStackTrace();
        }     
    }
}
