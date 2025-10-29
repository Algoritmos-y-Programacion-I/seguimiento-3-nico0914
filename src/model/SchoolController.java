package model;

public class SchoolController {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */

    public SchoolController() {

        private Computer[][] computers;
        private int floors = 5;
        private int columns = 10;

        public SchoolController(){
            computers = new Computer [floors][columns];
        }
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Añada los metodos que considere hagan falta para satisfacer los
     * requerimientos.
     * Para cada metodo:
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos.
     */

    /*@param serial número serial único
      *@param floor piso donde se ubicará (1 a 5)
      *@return mensaje con el resultado de la operación
      *Precondición: el piso debe estar entre 1 y 5
      *Postcondición: el computador queda almacenado en la primera columna libre
      */
    public String agregarComputador(String serial, int floor) {
        if (findComputerBySerial(serial) != null){
            return "Error: ya existe un computador con ese serial.";
        }

        if (floor <1 || floor > floors){
            return "Error: piso inválido";
        }

        for (int c= 0; c < columns; c++){
            if (computers[floor -1][c] == null){
                computers[floor - 1][c] = new Computer(serial, floor, c + 1);
                return " Computador agregado correctamente en el piso " + floor + ", columna " + (c + 1);
            }
        }

        return " No hay espacio disponible en ese piso";

    }

    /*
     * Registra un incidente en el computador correspondiente
     * @param serial número serial del computador
     * @param description descripción del incidente
     * @return mensaje de confirmación o error
     */
    public String agregarIncidenteEnComputador(String serial, String description) {
        Computer comp = findComputerBySerial (serial);
        if (comp != null){
            comp.addIncident(new Incident(description));
            return "Incidente registrado al computador" + serial;
        } else{
            return " No se encontró el computador con ese serial ";
        }

    }

    /*
     *Busca y devuelve el computador con más incidentes
    +@return el computador con más incidentes o null si no hay
     */
    public void getComputerList() {

    }

}
