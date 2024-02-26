
import javax.swing.JOptionPane;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kealpetu
 */
public class MyHash {
    private Object[] array;
    private int arraySize;

    public MyHash() {
        arrayCreation();
        showMenuOfOptions();
    }

    private void arrayCreation() {
        arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        array = new Object[arraySize];
    }

    private void showMenuOfOptions() {
        String option = JOptionPane.showInputDialog(
                "\t||What do you wish to do?\n" +
                "1. Enter an item\n" +
                "2. Search an item\n" +
                "3. Show Array\n" +
                "0. Go back\n" +
                "Option: ");

        switch (option){
            case "0" -> Main.spawnMenu();
            case "1" -> {
                addValueToArray();
                showMenuOfOptions();
            }
            case "2" -> {
                searchValueInArray();
                showMenuOfOptions();
            }
            case "3" -> {
                printArray();
                showMenuOfOptions();
            }
            default -> showMenuOfOptions();
        }
    }

    private void searchValueInArray() {
        int keyOfItem = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the key of the item you wish to find: "));
        int address = getAddress(keyOfItem);
        JOptionPane.showMessageDialog(null, "Item: " + array[address] + "; Found at: [" + address + "]");
    }

    private void printArray() { //Imprime el contenido del array en una ventana de mensaje.
        String message = "Array: ";
        for (int i = 0; i < arraySize; i++) {
            message = message + "[" + array[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void addValueToArray() {
        Object item;
        int key = 0;
        try {
            key = Integer.parseInt(JOptionPane.showInputDialog("Enter the key: "));
            item = JOptionPane.showInputDialog("Enter the item you wish to store: ");
        } catch (NumberFormatException e) {
            key = 0;
            item = JOptionPane.showInputDialog("Enter the item you wish to store: ");
        }
        int address = getAddress(key);
        array[address] = item;
    }

    private int getAddress(int key) {
        String option = JOptionPane.showInputDialog("\t||Which function do you wish to use?\n1. Modular Hashingn\n2. Squared Hashing\n3. Folded Hashing\n4.Folded Hashing\nOption: ");
        switch (option){
            case "0":
                addValueToArray();
                break;
            case "1":
                return calculateAddressByModularHashing(key);
            case "2":
                return calculateAddressBySquaredHashing(key);
            case "3":
                return calculateAddressByFoldedHashing(key);
            case "4":
                return calculateAddressByTrunkHashing(key);
            default:
                break;
        }
        return key;
    }

    private int calculateAddressByTrunkHashing(int key) {
        return chooseRandomDigits(key);
    }

    private int chooseRandomDigits(int key) {
        int numberOfDigits = 2;
        String key2String = Integer.toString(key);
        String result = "";
        for (int i = 0; i < numberOfDigits; i++) {
            int pos = i * 2;
            result += key2String.charAt(pos);
        }
        return Integer.parseInt(result);
    }

    private int calculateAddressByFoldedHashing(int key) {
        return leastMeaningfulDigit(key);
    }

    private int leastMeaningfulDigit(int key) {
        int sizeOfParts = 2;
        int result = 0;

        // Convertir la clave a una cadena para facilitar la manipulación de dígitos
        String key2String = Integer.toString(key);

        // División en partes y operación de plegamiento (result)
        for (int i = 0; i < key2String.length(); i += sizeOfParts) {
            String parte = key2String.substring(i, Math.min(i + sizeOfParts, key2String.length()));
            result += Integer.parseInt(parte);
        }

        // Reducción de tamaño (opcional)
        result %= arraySize;

        return result;
    }

    private int calculateAddressBySquaredHashing(int key) {
        return centralDigits(key * key);
    }

    private int centralDigits(int keySqrd) {
        String numAsString = Integer.toString(keySqrd);
        int stringSize = numAsString.length();

        // Verificar si la longitud es impar
        if (stringSize % 2 != 0) {
            int middleIndex = stringSize / 2;
            return Character.getNumericValue(numAsString.charAt(middleIndex));
        } else {
            // Si la longitud es par, devolver los dos dígitos del medio
            int rightIndex = stringSize / 2;
            int leftIndex = rightIndex - 1;
            String middleDigits = numAsString.substring(leftIndex, rightIndex + 1);
            return Integer.parseInt(middleDigits);
        }
    }

    private int calculateAddressByModularHashing(int key) {
        return (arraySize % key);
    }

}
