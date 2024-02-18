import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        spawnMenu(sc);

    }

    private static void spawnMenu(Scanner sc) {

        System.out.print(
                "\t||Choose the Data Structure||\n" +
                "1. Arrays\n" +
                "2. Stack\n" +
                "3. Queue\n" +
                "4. Recursion\n" +
                "5. Linked Lists\n" +
                "6. Trees\n" +
                "0. Exit\n" +
                "Option: "
        );
        int option = sc.nextInt();

        switch (option){
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case 1:
                spawnArray(sc);
                break;
        }

    }

    private static void spawnArray(Scanner sc) {
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
                spawnMenu(sc);
                break;
            case 1:
                Object oneDimensionalArray[];
                System.out.print("What's the size of the array? ");
                size0 = sc.nextInt();
                oneDimensionalArray = new Object[size0];
                break;
            case 2:
                Object biDimensionalArray[][];
                System.out.print("What are the sizes of the array?\n1st dimension: ");
                size0 = sc.nextInt();
                System.out.print("2nd dimension: ");
                size1 = sc.nextInt();
                biDimensionalArray = new Object[size0][size1];
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
                break;
            default:
                spawnArray(sc);
                break;

        }
    }
}