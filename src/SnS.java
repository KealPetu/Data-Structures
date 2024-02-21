import javax.swing.*;

public class SnS {
    private Object array[]; // Un array de tipo Object para almacenar los elementos.
                            // Utilizar Object permite almacenar cualquier tipo de objeto.
    private int arraySize; //Un entero que almacena el tamaño del array.

    public SnS() {          //Constructor de la clase.
                            // Llama al método arrayCreation() para inicializar el array y
                            // muestra el menú de opciones con showMenuOfOptions().
        arrayCreation();
        showMenuOfOptions();
    }

    private void showMenuOfOptions() {  //Muestra un menú de opciones mediante JOptionPane y ejecuta la
                                        //acción correspondiente según la opción seleccionada por el usuario.
        String option = JOptionPane.showInputDialog(
                "\t||What do you wish to do?\n" +
                "1. Enter an integer\n" +
                "2. Minor bubble sort\n" +
                "3. Major bubble sort\n" +
                "4. Direct Selection sort\n" +
                "5. Insertion sort\n" +
                "6. Sequential Search\n" +
                "7. Show Array\n" +
                "0. Go back\n" +
                "Option: ");

        switch (option){
            case "0":
                Main.spawnMenu();
                break;
            case "1":
                addValueToArray();
                showMenuOfOptions();
                break;
            case "2":
                minorBubbleSorting();
                showMenuOfOptions();
                break;
            case "3":
                majorBubbleSorting();
                showMenuOfOptions();
                break;
            case "4":
                directSelection();
                showMenuOfOptions();
                break;
            case "5":
                insertionSort();
                showMenuOfOptions();
                break;
            case "6":
                sequentialSearch();
                showMenuOfOptions();
                break;
            case "7":
                printArray();
                showMenuOfOptions();
                break;
            default:
                showMenuOfOptions();
                break;
        }
    }

    private void insertionSort() {  //El algoritmo de ordenación por inserción funciona construyendo una secuencia ordenada
                                    // de elementos uno a uno tomando elementos de la lista y colocándolos en la posición correcta.
        for (int i = 1; i < arraySize; i++) {
            Object auxiliar = array[i];
            int j = i - 1;

            while (j >= 0 && (int)array[j] > (int)auxiliar) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = auxiliar;
            printArray();
        }
    }

    private void sequentialSearch() {   //Realiza una búsqueda secuencial en el array para encontrar
                                        //un valor ingresado por el usuario.
        int value2Find = Integer.parseInt(JOptionPane.showInputDialog("What value do you wish to find?")) ,
                i = 1;
        while ((i <= arraySize) && ((int)array[i] != value2Find)){
            i++;
        }
        if (i > arraySize){
            JOptionPane.showMessageDialog(null, "Data not found");
        } else {
            JOptionPane.showMessageDialog(null, "Data found at [" + i + "]");
        }
    }

    private void directSelection() {    //Implementa el algoritmo de selección directa (direct selection).
                                        // Ordena el array de manera ascendente.
        for (int i = 1; i < arraySize - 1; i++) {
            int least = (int)array[i],
                    position = i;
            for (int j = i + 1; j != arraySize; j++) {
                if ((int)array[j] < least){
                    least = (int)array[j];
                    position = j;
                }
            }
            if (position != i){
                Object auxiliar = array[i];
                array[i] = array[position];
                array[position] = auxiliar;
            }
            printArray();
        }
    }

    private void majorBubbleSorting() { //Implementa el algoritmo de ordenación de burbuja (bubble sort)
                                        //de manera ascendente.
        Object auxiliar;
        for (int i = 0; i != arraySize - 1; i++) {
            for (int j = 0; j != arraySize - 1; j++) {
                if ((int)array[j] > (int)array[j + 1]){
                    auxiliar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = auxiliar;
                    printArray();
                }
            }
        }
    }

    private void printArray() { //Imprime el contenido del array en una ventana de mensaje.
        String message = "";
        for (int i = 0; i < arraySize; i++) {
            message = message + "[" + array[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void minorBubbleSorting() { //Implementa el algoritmo de ordenación de burbuja de manera descendente.
        Object auxiliar;
        for (int i = 0; i != arraySize - 1; i++) {
            for (int j = arraySize - 1; j != i; j--) {
                if ((int)array[j] < (int)array[j - 1]){
                    auxiliar = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = auxiliar;
                    printArray();
                }
            }
        }
    }

    private void addValueToArray() {    //Permite al usuario agregar un valor al array en la primera posición disponible.
        int value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value: "));
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == null){
                array[i] = value;
                JOptionPane.showMessageDialog(null, "Item: " + value + "\nPlaced at: [" + i + "]");
                return;
            }
        }
    }

    private void arrayCreation() {  //Solicita al usuario el tamaño del array y lo inicializa.
        arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        array = new Object[arraySize];
    }
}
