import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        spawnMenu(sc);

    }

    public static void spawnMenu(Scanner sc) {

        System.out.print(
                "\t||Choose the Data Structure||\n" +
                "1. Arrays\n" +
                "2. Stack\n" +
                "3. Queue\n" +
                "4. Recursion\n" +
                "5. Linked Lists\n" +
                "6. Trees\n" +
                "7. Sort & Search\n" +
                "0. Exit\n" +
                "Option: "
        );
        int option = sc.nextInt();

        switch (option){
            case 0:
                sc.close();
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case 1:
                MyArray array = new MyArray(sc);
                break;
            case 7:
                SnS sns = new SnS(sc);
                break;
            default:
                spawnMenu(sc);
                break;
        }

    }

}