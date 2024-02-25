// @author: Kevin Penafiel
// @date: 21/01/2024
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

    // showMenuOfOptions()
    // Mostrar un menú con opciones para que el usuario elija
    // Obtener la elección del usuario
    // Según la elección del usuario:
    //     Si la elección es "0":
    //         Llamar a Main.spawnMenu()
    //     Si la elección es "1":
    //         Llamar a addValueToArray()
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "2":
    //         Llamar a minorBubbleSorting()
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "3":
    //         Llamar a majorBubbleSorting()
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "4":
    //         Llamar a directSelection()
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "5":
    //         Llamar a insertionSort()
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "6":
    //         Llamar a searchWichArray()
    //     Si la elección es "7":
    //         Llamar a printArray()
    //         Llamar a showMenuOfOptions()
    //     Si la elección no es reconocida:
    //         Llamar a showMenuOfOptions()
    // Fin showMenuOfOptions

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

    // searchWichArray()
    // Mostrar un menú preguntando al usuario qué array buscar
    // Obtener la elección del usuario
    // Según la elección del usuario:
    //     Si la elección es "0":
    //         Llamar a showMenuOfOptions()
    //     Si la elección es "1":
    //         Llamar a sequentialSearch(arrangedArray)
    //         Llamar a searchWichArray()
    //     Si la elección es "2":
    //         Llamar a sequentialSearch(disarrangedArray)
    //         Llamar a searchWichArray()
    //     Si la elección no es reconocida:
    //         Llamar a searchWichArray()
    // Fin searchWichArray()

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

//  insertionSort()
//  Para cada índice i desde  1 hasta arraySize -  1:
//      Almacenar el elemento en el índice i en una variable temporal
//      Inicializar una variable j a i -  1
//      Mientras j sea mayor o igual a  0 y el elemento en el índice j sea mayor que la variable temporal:
//          Desplazar el elemento en el índice j a la derecha
//          Decrementar j en  1
//      Colocar la variable temporal en el índice j +  1
//      Imprimir el array
//  Fin insertionSort()

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

//  sequentialSearch(Object[] array)
//  Solicitar al usuario que ingrese un valor para buscar
//  Para cada índice i desde  0 hasta arraySize -  1:
//      Si el elemento en el índice i es igual al valor buscado:
//          Mostrar un mensaje indicando que el valor fue encontrado y su índice
//          Retornar
//      Si no se encuentra una coincidencia después de revisar todos los elementos:
//          Mostrar un mensaje indicando que el valor no fue encontrado
//  Fin sequentialSearch(Object[] array)

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

//  directSelection()
//  Para cada índice i desde  1 hasta arraySize -  2:
//      Inicializar las variables least y position con el elemento en el índice i y i, respectivamente
//      Para cada índice j desde i +  1 hasta arraySize -  1:
//          Si el elemento en el índice j es menor que least:
//              Actualizar least y position con el elemento en el índice j y j, respectivamente
//      Si position no es igual a i:
//          Intercambiar los elementos en los índices i y position
//      Imprimir el array
//  Fin directSelection()

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

// majorBubbleSorting()
// Para cada índice i desde  0 hasta arraySize -  2:
//     Para cada índice j desde  0 hasta arraySize -  2:
//         Si el elemento en el índice j es mayor que el elemento en el índice j +  1:
//             Intercambiar los elementos en los índices j y j +  1
//             Imprimir el array
// Fin majorBubbleSorting()

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

// printArray()
// Concatenar los elementos de arrangedArray y disarrangedArray en una cadena de mensaje
// Mostrar la cadena de mensaje en un cuadro de diálogo

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

// minorBubbleSorting()
// Para cada índice i desde  0 hasta arraySize -  2:
//     Para cada índice j desde arraySize -  1 hasta i +  1:
//         Si el elemento en el índice j es menor que el elemento en el índice j -  1:
//             Intercambiar los elementos en los índices j y j -  1
//             Imprimir el array
// Fin minorBubbleSorting()

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

// addValueToArray()`
// Solicitar al usuario que ingrese un valor
// Intentar parsear la entrada del usuario como un entero
//     Si el parseo falla, establecer el valor a  0
// Para cada índice i desde  0 hasta arraySize -  1:
//     Si el elemento en el índice i de disarrangedArray es nulo:
//         Asignar el valor a los elementos en los índices i de ambos disarrangedArray y arrangedArray
//         Mostrar un mensaje indicando que el valor fue colocado y su índice
//         Retornar
// Fin addValueToArray()

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
// arrayCreation()
// Solicitar al usuario que ingrese el tamaño del array
// Parsear la entrada del usuario como un entero
// Inicializar disarrangedArray y arrangedArray con el tamaño parseado
// Fin arrayCreation

    private void arrayCreation() {  //Solicita al usuario el tamaño del array y lo inicializa.
        arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        disarrangedArray = new Object[arraySize];
        arrangedArray = new Object[arraySize];
    }
}
