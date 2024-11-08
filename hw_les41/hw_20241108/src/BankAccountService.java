import java.util.List;
import java.util.stream.Collectors;

public class BankAccountService {


    public static List<BankAccount> getLowBalanceAccounts(List<BankAccount> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() < 100)
                .collect(Collectors.toList());
    }


    public static List<Person> getAccountOwners(List<BankAccount> accounts) {
        return accounts.stream()
                .map(BankAccount::getOwner)
                .collect(Collectors.toList());
    }


    public static List<String> getRichClientsInfo(List<BankAccount> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 100000)
                .map(account -> {
                    Person owner = account.getOwner();
                    return String.format("%s %s.; IBAN: %s; %s",
                            owner.getlName(),
                            owner.getfName().charAt(0),
                            account.getIBAN(),
                            owner.getEmail());
                })
                .collect(Collectors.toList());
    }
}
