import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = List.of(
                new BankAccount(new Person("John", "Lennon", "lennon@gmail.com"), "DE111111111", 150000),
                new BankAccount(new Person("Paul", "McCartney", "paul@gmail.com"), "DE2222222222", 80),
                new BankAccount(new Person("Donald", "Trump", "trump@gmail.com"), "DE3333333333", 120000),
                new BankAccount(new Person("George", "Ferguson", "george@gmail.com"), "444444444444", 50)
        );


        System.out.println("Счета с балансом менее 100:");
        BankAccountService.getLowBalanceAccounts(accounts)
                .forEach(account -> System.out.println(account.getIBAN()));

        System.out.println("\nВладельцы всех счетов:");
        BankAccountService.getAccountOwners(accounts)
                .forEach(owner -> System.out.println(owner.getfName() + " " + owner.getlName()));

        System.out.println("\nКлиенты с балансом более 100000:");
        BankAccountService.getRichClientsInfo(accounts)
                .forEach(System.out::println);
    }
}
