import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileExplorer fileExplorer = new FileExplorer();

        System.out.print("Введіть назву файлу або папки: ");
        String name = scanner.nextLine();

        fileExplorer.explore(name);
    }
}
