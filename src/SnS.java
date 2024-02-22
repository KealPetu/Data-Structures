import javax.swing.*;

public class SnS {
    private Object[] arrangedArray, disarrangedArray; // Un array de tipo Object para almacenar los elementos.
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
                searchWichArray();
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

    private void searchWichArray() {
        String array2Choose = JOptionPane.showInputDialog("Wich array do you want to search?\n1. Arranged Array\n2. Disarranged Array\n0. Go back");
        switch (array2Choose){
            case "0":
                showMenuOfOptions();
                break;
            case "1":
                sequentialSearch(arrangedArray);
                searchWichArray();
                break;
            case "2":
                sequentialSearch(disarrangedArray);
                searchWichArray();
                break;
            default:
                searchWichArray();
                break;
        }
    }

    private void insertionSort() {  //El algoritmo de ordenación por inserción funciona construyendo una secuencia ordenada
                                    // de elementos uno a uno tomando elementos de la lista y colocándolos en la posición correcta.
        for (int i = 1; i < arraySize; i++) {
            Object auxiliar = arrangedArray[i];
            int j = i - 1;

            while (j >= 0 && (int) arrangedArray[j] > (int)auxiliar) {
                arrangedArray[j + 1] = arrangedArray[j];
                j = j - 1;
            }
            arrangedArray[j + 1] = auxiliar;
            printArray();
        }
    }

    private void sequentialSearch(Object[] array) {   //Realiza una búsqueda secuencial en el array para encontrar
                                        //un valor ingresado por el usuario.
        int value2Find = Integer.parseInt(JOptionPane.showInputDialog("What value do you wish to find?"));
        for (int i = 0; i < arraySize; i++) {
            if (value2Find == (int) array[i]){
                JOptionPane.showMessageDialog(null, "Value " + array[i] + " found at [" + i + "]");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Value " + value2Find + " not found");
    }

    private void directSelection() {    //Implementa el algoritmo de selección directa (direct selection).
                                        // Ordena el array de manera ascendente.
        for (int i = 1; i < arraySize - 1; i++) {
            int least = (int) arrangedArray[i],
                    position = i;
            for (int j = i + 1; j != arraySize; j++) {
                if ((int) arrangedArray[j] < least){
                    least = (int) arrangedArray[j];
                    position = j;
                }
            }
            if (position != i){
                Object auxiliar = arrangedArray[i];
                arrangedArray[i] = arrangedArray[position];
                arrangedArray[position] = auxiliar;
            }
            printArray();
        }
    }

    private void majorBubbleSorting() { //Implementa el algoritmo de ordenación de burbuja (bubble sort)
                                        //de manera ascendente.
        Object auxiliar;
        for (int i = 0; i != arraySize - 1; i++) {
            for (int j = 0; j != arraySize - 1; j++) {
                if ((int) arrangedArray[j] > (int) arrangedArray[j + 1]){
                    auxiliar = arrangedArray[j];
                    arrangedArray[j] = arrangedArray[j + 1];
                    arrangedArray[j + 1] = auxiliar;
                    printArray();
                }
            }
        }
    }

    private void printArray() { //Imprime el contenido del array en una ventana de mensaje.
        String message = "Arranged array: ";
        for (int i = 0; i < arraySize; i++) {
            message = message + "[" + arrangedArray[i] + "] ";
        }
        message = message + "\nDisarranged Array: ";
        for (int i = 0; i < arraySize; i++) {
            message = message + "[" + disarrangedArray[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void minorBubbleSorting() { //Implementa el algoritmo de ordenación de burbuja de manera descendente.
        Object auxiliar;
        for (int i = 0; i != arraySize - 1; i++) {
            for (int j = arraySize - 1; j != i; j--) {
                if ((int) arrangedArray[j] < (int) arrangedArray[j - 1]){
                    auxiliar = arrangedArray[j - 1];
                    arrangedArray[j - 1] = arrangedArray[j];
                    arrangedArray[j] = auxiliar;
                    printArray();
                }
            }
        }
    }

    private void addValueToArray() {    //Permite al usuario agregar un valor al array en la primera posición disponible.
        int value = 0;
        try {
            value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value: "));
        } catch (NumberFormatException e) {
            value = 0;
        }
        for (int i = 0; i < arraySize; i++) {
            if (disarrangedArray[i] == null){
                disarrangedArray[i] = arrangedArray[i] = value;
                JOptionPane.showMessageDialog(null, "Item: " + value + "\nPlaced at: [" + i + "]");
                return;
            }
        }
    }

    private void arrayCreation() {  //Solicita al usuario el tamaño del array y lo inicializa.
        arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        disarrangedArray = new Object[arraySize];
        arrangedArray = new Object[arraySize];
    }
}
