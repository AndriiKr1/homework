import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountService {

    //    a)    map где ключом будет owner (Person), а значением будет баланс (Double)
    public Map<Person, Double> getOwnerToBalanceMap(List<BankAccount> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap(account -> account.getOwner(), account -> account.getBalance()));
    }

    //     b)   map где ключом будет IBAN (String), а значением будет owner (Person)
    public Map<String, Person> getIbanToOwnerMap(List<BankAccount> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap(account -> account.getIBAN(), account -> account.getOwner()));
    }

    //    c)    map где ключом будет IBAN (String), а значением будет строка  J.Jack (т.e. первая буква fName и lName)
    public Map<String, String> getIbanToInitialMap(List<BankAccount> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return Collections.emptyMap();
        }
        return accounts.stream()
                .collect(Collectors.toMap(account -> account.getIBAN(), account -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append(account.getOwner().getfName().charAt(0))
                                    .append(".")
                                    .append(account.getOwner().getlName());
                            return sb.toString();
                        }
                ));

    }

    //   Задача 2:     3 самых крупных клиентов
    public List<String> getTopClientsByBalance(Map<String, BankAccount> accountMap) {
        if (accountMap == null || accountMap.isEmpty()) {
            return Collections.emptyList();
        }

        return accountMap.values().stream()
                .sorted((a, b) -> Double.compare(b.getBalance(), a.getBalance()))
                .limit(3)
                .map(acc -> acc.getOwner().getfName() + " " + acc.getOwner().getlName())
                .toList();

    }

}
