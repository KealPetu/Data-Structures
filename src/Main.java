import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        spawnMenu();

    }

    public static void spawnMenu() {

        String option = JOptionPane.showInputDialog( "\t||Choose the Data Structure||\n" +
                "1. Arrays\n" +
                "2. Stack\n" +
                "3. Queue\n" +
                "4. Recursion\n" +
                "5. Linked Lists\n" +
                "6. Trees\n" +
                "7. Sort & Search\n" +
                "0. Exit\n" +
                "Option: ");

        switch (option){
            case "0":
                JOptionPane.showMessageDialog(null, "Goodbye");
                System.exit(0);
                break;
            case "1":
                MyArray array = new MyArray();
                break;
            case "7":
                SnS sns = new SnS();
                break;
            default:
                spawnMenu();
                break;
        }

    }

}