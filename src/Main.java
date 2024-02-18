import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option){
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case 1:
                System.out.print(
                        "\tHow many dimensions does your array have?\n" +
                        "1. One\n" +
                        "2. Two\n" +
                        "3. Three\n" +
                        "Option: ");
                int dimension = sc.nextInt();
                switch (dimension){
                    case 1:

                        break;

                }
                switch (option){

                }
                break;
        }

    }
}