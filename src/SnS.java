import java.util.Scanner;

public class SnS {
    private Object array[];
    private int arraySize;

    public SnS(Scanner sc) {
        arrayCreation(sc);
        showMenuOfOptions(sc);
    }

    private void showMenuOfOptions(Scanner sc) {
        System.out.print(
                "\t||What do you wish to do?\n" +
                "1. Enter an integer\n" +
                "2. Minor bubble sorting\n" +
                "3. Major bubble sorting\n" +
                "4. Direct Selection\n" +
                "5. Sequential Search\n" +
                "6. Show Array\n" +
                "0. Go back\n" +
                "Option: ");
        int option = sc.nextInt();

        switch (option){
            case 0:
                Main.spawnMenu(sc);
                break;
            case 1:
                addValueToArray(sc);
                printArray();
                showMenuOfOptions(sc);
                break;
            case 2:
                minorBubbleSorting();
                printArray();
                showMenuOfOptions(sc);
                break;
            case 3:
                majorBubbleSorting();
                printArray();
                showMenuOfOptions(sc);
                break;
            case 4:
                directSelection();
                printArray();
                showMenuOfOptions(sc);
                break;
            case 5:
                sequentialSearch(sc);
                showMenuOfOptions(sc);
                break;
            case 6:
                printArray();
                showMenuOfOptions(sc);
                break;
            default:
                showMenuOfOptions(sc);
                break;
        }
    }

    private void sequentialSearch(Scanner sc) {
        System.out.print("What value do you wish to find? ");
        int value2Find = sc.nextInt(),
                i = 1;
        while ((i != arraySize) && ((int)array[i] != value2Find)){
            i++;
        }
        if (i > arraySize){
            System.out.print("Data not found");
        } else {
            System.out.println("Data found at [" + i + "]");
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
                }
            }
        }
    }

    private void printArray() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print("[" + array[i] + "] ");
        }
        System.out.println("\n");
    }

    private void minorBubbleSorting() {
        Object auxiliar;
        for (int i = 0; i != arraySize - 1; i++) {
            for (int j = arraySize - 1; j != i; j--) {
                if ((int)array[j] < (int)array[j - 1]){
                    auxiliar = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = auxiliar;
                }
            }
        }
    }

    private void addValueToArray(Scanner sc) {
        System.out.print("Enter the value: ");
        int value = sc.nextInt();
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == null){
                array[i] = value;
                System.out.println("Item: " + value + ";Placed at: [" + i + "]");
                return;
            } else {
                System.out.println("Array is full");
            }
        }
    }

    private void arrayCreation(Scanner sc) {
        System.out.print("Enter the size of the array: ");
        arraySize = sc.nextInt();
        array = new Object[arraySize];
    }
}
