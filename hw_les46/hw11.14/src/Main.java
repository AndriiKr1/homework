import Exceptions.ProgrammerBusyException;
import Exceptions.ProgrammerUnavailableNowException;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Jack");
        System.out.println(programmer);
        System.out.println("Меняем статус:");
        programmer.setBusy();
        System.out.println(programmer);
        try {
            System.out.println(programmer.doWork("Java"));
        } catch (ProgrammerUnavailableNowException e) {
            System.out.println("Программист недоступен!");
        } catch (ProgrammerBusyException e) {
            System.out.println("Программист занят другой задачей");
        }
    }
}