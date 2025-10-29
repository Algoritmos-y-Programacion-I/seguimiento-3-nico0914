package ui;

import java.util.Scanner;

public class SchoolApp {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para conectar esta clase con el
     * modelo.
     *Descripción: Esta clase funciona como la capa de presentación en la variante MVC utilizada
     * en el trabajo. Se encarga de:
     * -Presentar el menú principal por consola
     * -Recibir y validar la entrada del usuario
     * -Delegar operaciones al controlador
     *Relaciones con el modelo:
     *-input: Scanner para leer entrada por consola
     *-controller: instancia de SchoolController (modelo/servicio) que expone
     *-los métodos necesarios para realizar las operaciones requeridas por la ui.
     */

    private Scanner input;
    private SchoolController controller;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    /*Constructor
    * Inicializa el Scanner para la entrada por consola y crea la instancia del
     * SchoolController que será usada por esta UI para ejecutar las operaciones
     * del modelo.
     *
     * postcondición: input y controller quedan inicializados y listos para usarse.
    */
    
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController();
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }


        } while (option != 0);

        input.close();

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void registrarComputador() {
        System.out.println("\n--- Registrar Computador ---");

        System.out.println("Ingrese el número serial: ");
        String serial= input.nextLine().trim();
        if (serial.isEmpty()){
            System.out.println("El serial no puede estar vacío. Opción Cancelada");
            return;
        }
        int floor;
        try{
            System.out.print("Ingrese el piso (1-5): ");
            floor = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("Piso inválido. Debe ingresar un número entero entre 1 y 5.");
            input.nextLine();
            return;

    }

    String result = controller.addComputer (serial, floor);
    System.out.println(result);
}

    public void registrarIncidenteEnComputador() {
        System.out.println("\n--- Resgisrar Incidente en Computador ---");
        System.out.print("Ingrese el número serial del computador: ");
        String serial = input.nextLine().trim();
        if (serial.isEmpty()) {
            System.out.println("El serial no puede estar vacío. Operación cancelada.");
            return;
        }
        System.out.print("Descripción breve del incidente: ");
        String description = input.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("La descripción no puede estar vacía. Operación cancelada.");
            return;
        }
        String result = controller.reportIncident(serial, description);
        System.out.println(result);
    }


    public void consultarComputadorConMasIncidentes() {
        System.out.println("\n--- Consultar Computador con más Incidentes ---");

        Computer maxComp = controller.getComputerWithMostIncidents();
        if (maxComp != null) {
            System.out.println("Computador con más incidentes:");
            System.out.println("Serial : " + maxComp.getSerial());
            System.out.println("Piso   : " + maxComp.getFloor());
            System.out.println("Columna: " + maxComp.getColumn());
            System.out.println("Incidentes registrados: " + maxComp.getIncidentCount());
        } else {
            System.out.println("No hay computadores registrados o no hay incidentes.");
        }
    }

