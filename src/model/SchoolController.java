package model;

import java.util.ArrayList;

/*
 * Esta clase funciona como el controlador del sistema.
 * Aquí se maneja la lógica principal para administrar los computadores
 * y los incidentes registrados en la escuela.
 */

public class SchoolController {

    private Computer[][] computers;
    private int floors = 5;
    private int columns = 10;

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     * Se creó una matriz de tipo Computer de tamaño 5x10 para almacenar los
     * computadores organizados por piso y columna. Esto cumple la relación
     * matricial solicitada en el enunciado.
     */

    public SchoolController() {
        computers = new Computer[floors][columns];
    }

    /*
     * Método modificador.
     * Agrega un computador al edificio validando el serial y el piso.
     * @param serial número serial único del computador.
     * @param floor piso donde se ubicará (1 a 5).
     * @return mensaje con el resultado del registro.
     * Precondición: el piso debe estar entre 1 y 5.
     * Postcondición: si hay espacio, el computador queda en la primera columna libre.
     */
    public String agregarComputador(String serial, int floor) {

        // Validar serial repetido
        if (findComputerBySerial(serial) != null) {
            return "Error: ya existe un computador con ese serial.";
        }

        // Validar piso
        if (floor < 1 || floor > floors) {
            return "Error: piso inválido.";
        }

        // Buscar espacio disponible
        for (int c = 0; c < columns; c++) {
            if (computers[floor - 1][c] == null) {
                computers[floor - 1][c] = new Computer(serial, floor, c + 1);
                return "Computador agregado correctamente en el piso " + floor + ", columna " + (c + 1);
            }
        }

        return "No hay espacio disponible en ese piso.";
    }

    /*
     * Método modificador.
     * Registra un incidente en el computador indicado por su serial.
     * @param serial número serial del computador.
     * @param description breve descripción del incidente.
     * @return mensaje de confirmación o error.
     * Precondición: debe existir un computador con ese serial.
     * Postcondición: el incidente queda guardado en la lista del computador.
     */
    public String agregarIncidenteEnComputador(String serial, String description) {
        Computer comp = findComputerBySerial(serial);

        if (comp != null) {
            comp.addIncident(new Incident(description));
            return "Incidente registrado al computador " + serial;
        } else {
            return "No se encontró el computador con ese serial.";
        }
    }

    /*
     * Método analizador.
     * Busca y retorna el computador con más incidentes registrados.
     * @return el computador con más incidentes o null si no hay computadores registrados.
     * Precondición: debe haber al menos un computador registrado.
     * Postcondición: no modifica nada, solo consulta.
     */
    public Computer getComputerWithMostIncidents() {
        Computer maxComp = null;
        int maxIncidents = 0;

        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < columns; j++) {

                if (computers[i][j] != null && computers[i][j].getIncidentCount() > maxIncidents) {
                    maxIncidents = computers[i][j].getIncidentCount();
                    maxComp = computers[i][j];
                }
            }
        }

        return maxComp;
    }

    /*
     * Método analizador adicional.
     * Retorna una lista con todos los computadores registrados.
     * Este método ayuda a mostrar el estado del edificio si se desea consultar.
     * @return ArrayList con todos los computadores existentes.
     */
    public ArrayList<Computer> getComputerList() {
        ArrayList<Computer> list = new ArrayList<>();

        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < columns; j++) {
                if (computers[i][j] != null) {
                    list.add(computers[i][j]);
                }
            }
        }
        return list;
    }

    // Método privado para buscar un computador por serial
    private Computer findComputerBySerial(String serial) {
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < columns; j++) {
                if (computers[i][j] != null && computers[i][j].getSerial().equalsIgnoreCase(serial)) {
                    return computers[i][j];
                }
            }
        }
        return null;
    }

}
