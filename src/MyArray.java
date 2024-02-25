import java.util.Scanner;

public class MyArray {
    private Scanner sc;
    public MyArray() {
        this.sc = new Scanner(System.in);
        spawnArray(sc);
    }

    public void spawnArray(Scanner sc) {
        System.out.print(
                "\tHow many dimensions does your array have?\n" +
                        "1. One\n" +
                        "2. Two\n" +
                        "3. Three\n" +
                        "0. Go back\n" +
                        "Option: ");
        int dimension = sc.nextInt();
        int size0, size1, size2;
        switch (dimension){
            case 0:
                Main.spawnMenu();
                break;
            case 1:
                Object oneDimensionalArray[];
                System.out.print("What's the size of the array? ");
                size0 = sc.nextInt();
                oneDimensionalArray = new Object[size0];
                manipulateArray(sc, oneDimensionalArray);
                break;
            case 2:
                Object biDimensionalArray[][];
                System.out.print("What are the sizes of the array?\n1st dimension: ");
                size0 = sc.nextInt();
                System.out.print("2nd dimension: ");
                size1 = sc.nextInt();
                biDimensionalArray = new Object[size0][size1];
                manipulateArray(sc, biDimensionalArray);
                break;
            case 3:
                Object multiDimensionalArray[][][];
                System.out.print("What are the sizes of the array?\n1st dimension: ");
                size0 = sc.nextInt();
                System.out.print("2nd dimension: ");
                size1 = sc.nextInt();
                System.out.print("3rd dimension: ");
                size2 = sc.nextInt();
                multiDimensionalArray = new Object[size0][size1][size2];
                manipulateArray(sc, multiDimensionalArray);
                break;
            default:
                spawnArray(sc);
                break;

        }
    }

    private void manipulateArray(Scanner sc, Object[][][] multiDimensionalArray) {
        int operation;
        Object item;
        System.out.print("What do you want to do?\n1. Add Item\n2. Delete Item\n3. Find Item\n4. Show Array\n0. Go back\nOption: ");
        operation = sc.nextInt();
        switch (operation){
            case 0:
                spawnArray(sc);
                break;
            case 1:
                System.out.print("What do you want to add? ");
                item = sc.next();
                addItem(multiDimensionalArray, item);
                manipulateArray(sc, multiDimensionalArray);
                break;
            case 2:
                System.out.print("What do you want to delete? ");
                item = sc.next();
                deleteItem(multiDimensionalArray, item);
                manipulateArray(sc, multiDimensionalArray);
                break;
            case 3:
                System.out.print("What do you want to find? ");
                item = sc.next();
                findItem(multiDimensionalArray, item);
                manipulateArray(sc, multiDimensionalArray);
                break;
            case 4:
                printArray(multiDimensionalArray);
                manipulateArray(sc, multiDimensionalArray);
                break;
            default:
                break;
        }
    }

    private void printArray(Object[][][] multiDimensionalArray) {
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            for (int j = 0; j < multiDimensionalArray[i].length; j++) {
                for (int k = 0; k < multiDimensionalArray[i][j].length; k++) {
                    System.out.print("[" + multiDimensionalArray[i][j][k] + "] ");
                }
                System.out.println("\n");
            }
            System.out.println("\n");
        }
    }

    private void manipulateArray(Scanner sc, Object[][] biDimensionalArray) {
        int operation;
        Object item;
        System.out.print("What do you want to do?\n1. Add Item\n2. Delete Item\n3. Find Item\n4. Show Array\n0. Go back\nOption: ");
        operation = sc.nextInt();
        switch (operation){
            case 0:
                spawnArray(sc);
                break;
            case 1:
                System.out.print("What do you want to add?");
                item = sc.next();
                addItem(biDimensionalArray, item);
                manipulateArray(sc, biDimensionalArray);
                break;
            case 2:
                System.out.print("What do you want to delete?");
                item = sc.next();
                deleteItem(biDimensionalArray, item);
                manipulateArray(sc, biDimensionalArray);
                break;
            case 3:
                System.out.print("What do you want to find?");
                item = sc.next();
                findItem(biDimensionalArray, item);
                manipulateArray(sc, biDimensionalArray);
                break;
            case 4:
                printArray(biDimensionalArray);
                manipulateArray(sc, biDimensionalArray);
                break;
            default:
                manipulateArray(sc, biDimensionalArray);
                break;
        }
    }

    private void printArray(Object[][] biDimensionalArray) {
        for (int i = 0; i < biDimensionalArray.length; i++) {
            for (int j = 0; j < biDimensionalArray[i].length; j++) {
                System.out.print("[" + biDimensionalArray[i][j] + "] ");
            }
            System.out.println("\n");
        }
    }

    private void manipulateArray(Scanner sc, Object[] oneDimensionalArray) {
        Object item;
        int operation;
        System.out.println("What do you want to do?\n1. Add Item\n2. Delete Item\n3. Find Item\n4. Show Array\n0. Go back\nOption: ");
        operation = sc.nextInt();
        switch (operation){
            case 0:
                spawnArray(sc);
                break;
            case 1:
                System.out.println("What do you want to add?");
                item = sc.next();
                addItem(oneDimensionalArray, item);
                manipulateArray(sc, oneDimensionalArray);
                break;
            case 2:
                System.out.println("What do you want to delete?");
                item = sc.next();
                deleteItem(oneDimensionalArray, item);
                manipulateArray(sc, oneDimensionalArray);
                break;
            case 3:
                System.out.println("What do you want to find?");
                item = sc.next();
                findItem(oneDimensionalArray, item);
                manipulateArray(sc, oneDimensionalArray);
                break;
            case 4:
                printArray(oneDimensionalArray);
                manipulateArray(sc, oneDimensionalArray);
                break;
            default:
                break;
        }
    }

    private void printArray(Object[] oneDimensionalArray) {
        for (int i = 0; i < oneDimensionalArray.length; i++) {
            System.out.print("[" + oneDimensionalArray[i] + "] ");
        }
        System.out.println("\n");
    }

    private void findItem(Object[] array, Object item){
        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i].equals(item)){
                    System.out.println("Item: " + item + ";Found at: [" + i + "]");
                    return;
                } else {
                    System.out.println("item not found");
                }
            } catch (NullPointerException e) {
                System.out.println("item not found");
            }
        }
    }
    private void deleteItem(Object[] array, Object item){
        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i].equals(item)){
                    array[i] = null;
                    System.out.println("Item: " + item + " deleted");
                    return;
                } else {
                    System.out.println("item not found");
                }
            } catch (NullPointerException e) {
                System.out.println("item not found");
            }
        }
    }
    private void addItem(Object[] array, Object item){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                array[i] = item;
                System.out.println("Item: " + item + ";Placed at: [" + i + "]");
                return;
            } else {
                System.out.println("Array is full");
            }
        }
    }
    private void findItem(Object[][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    if (array[i][j].equals(item)){
                        System.out.println("Item: " + item + ";Found at: [" + i + "][" + j + "]");
                        return;
                    } else {
                        System.out.println("item not found");
                    }
                } catch (NullPointerException e) {
                    System.out.println("item not found");
                }
            }
        }
    }
    private void deleteItem(Object[][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    if (array[i][j].equals(item)){
                        array[i][j] = null;
                        System.out.println("Item: " + item + " deleted");
                        return;
                    } else {
                        System.out.println("item not found");
                    }
                } catch (NullPointerException e) {
                    System.out.println("item not found");
                }
            }
        }
    }
    private void addItem(Object[][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null){
                    array[i][j] = item;
                    System.out.println("Item: " + item + ";Placed at: [" + i + "][" + j + "]");
                    return;
                } else {
                    System.out.println("Array is full");
                }
            }
        }
    }
    private void findItem(Object[][][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    try {
                        if (array[i][j][k].equals(item)){
                            System.out.println("Item: " + item + ";Found at: [" + i + "][" + j + "][" + k + "]");
                            return;
                        } else {
                            System.out.println("item not found");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("item not found");
                    }
                }
            }
        }
    }
    private void deleteItem(Object[][][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    try {
                        if (array[i][j][k].equals(item)){
                            array[i][j][k] = null;
                            System.out.println("Item: " + item + " deleted");
                            return;
                        } else {
                            System.out.println("item not found");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("item not found");
                    }
                }
            }
        }
    }
    private void addItem(Object[][][] array, Object item){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    if (array[i][j][k] == null){
                        array[i][j][k] = item;
                        System.out.println("Item: " + item + ";Placed at: [" + i + "][" + j + "][" + k + "]");
                        return;
                    } else {
                        System.out.println("Array is full");
                    }
                }
            }
        }
    }
}
