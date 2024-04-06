/**
 * Clase App
 * Fernando Rueda - 23748
 * Clase principal del programa que maneja pacientes en una cola de prioridad.
 */

package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
    /**
     * Punto de entrada principal del programa.
     * 
     * @param args Argumentos de línea de comando. No se utilizan en este programa.
     */
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación para la cola de prioridades:");
        System.out.println("1. Implementación propia (VectorHeap)");
        System.out.println("2. Implementación de Java (PriorityQueue)");
        int opcion = scanner.nextInt();
        // Selección de implementación de cola de prioridad y procesamiento de pacientes        
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

    /**
     * Lee pacientes desde un archivo y los agrega a una VectorHeap.
     * 
     * @param patientQueue La cola de prioridad (VectorHeap) donde se agregarán los pacientes.
     */
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
    
    /**
     * Lee pacientes desde un archivo y los agrega a una PriorityQueue de Java.
     * 
     * @param patientQueue La cola de prioridad (PriorityQueue) donde se agregarán los pacientes.
     */
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
