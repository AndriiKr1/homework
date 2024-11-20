import java.io.File;

public class FileExplorer {
    public void explore(String name) {
        try {
            File file = new File(name);

            if (!file.exists()) {
                System.out.println("Файл або папка з такою назвою не знайдені.");
                return;
            }

            if (file.isFile()) {
                System.out.println("Це файл.");
                System.out.println("Розмір файлу: " + file.length() + " байт.");
            } else if (file.isDirectory()) {
                System.out.println("Це папка. Її вміст:");
                File[] contents = file.listFiles();
                if (contents != null && contents.length > 0) {
                    for (File content : contents) {
                        System.out.println(content.getName() + (content.isDirectory() ? " (папка)" : " (файл)"));
                    }
                } else {
                    System.out.println("Папка порожня.");
                }
            }
        } catch (SecurityException e) {
            System.out.println("Помилка: немає доступу до файлу або папки.");
        } catch (Exception e) {
            System.out.println("Сталася непередбачена помилка: ");
        }
    }
}

