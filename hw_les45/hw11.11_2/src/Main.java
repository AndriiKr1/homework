public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Василько", "не доступний");

        try {
            String result = programmer.doWork("Пофіксити баг");
            System.out.println("Результат роботи: " + result);
        } catch (ProgrammerBusyException e) {
            System.out.println("Програміст зайнятий іншою задачою або курить");
        } catch (ProgrammerUnavailableNowException e) {
            System.out.println("У программіста нервовий зрив");
        }
    }
}