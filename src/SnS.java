import javax.swing.*;
import java.util.Scanner;

public class SnS {
    private Object array[];
    private int arraySize;

    public SnS() {
        arrayCreation();
        showMenuOfOptions();
    }

    private void showMenuOfOptions() {
        String option = JOptionPane.showInputDialog("\t||What do you wish to do?\n" +
                "1. Enter an integer\n" +
                "2. Minor bubble sorting\n" +
                "3. Major bubble sorting\n" +
                "4. Direct Selection\n" +
                "5. Sequential Search\n" +
                "6. Show Array\n" +
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
                sequentialSearch();
                showMenuOfOptions();
                break;
            case "6":
                printArray();
                showMenuOfOptions();
                break;
            default:
                showMenuOfOptions();
                break;
        }
    }

    private void sequentialSearch() {
        int value2Find = Integer.parseInt(JOptionPane.showInputDialog("What value do you wish to find?")) ,
                i = 1;
        while ((i != arraySize) && ((int)array[i] != value2Find)){
            i++;
        }
        if (i > arraySize){
            JOptionPane.showMessageDialog(null, "Data not found");
        } else {
            JOptionPane.showMessageDialog(null, "Data found at [" + i + "]");
        }
    }

    private void directSelection() {
        for (int i = 1; i != arraySize - 1; i++) {
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

    private void majorBubbleSorting() {
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

    private void printArray() {
        String message = "";
        for (int i = 0; i < arraySize; i++) {
            message = message + "[" + array[i] + "] ";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private void minorBubbleSorting() {
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

    private void addValueToArray() {
        int value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value: "));
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == null){
                array[i] = value;
                JOptionPane.showMessageDialog(null, "Item: " + value + "\nPlaced at: [" + i + "]");
                return;
            }
        }
    }

    private void arrayCreation() {
        arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array: "));
        array = new Object[arraySize];
    }
}
