import java.math.BigDecimal;

class Account {
    private final String iban;
    private final BigDecimal balance;
    private final Person owner;

    public Account(String iban, BigDecimal balance, Person owner) {
        this.iban = iban;
        this.balance = balance;
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("Account{iban='%s', balance=%s, owner=%s}", iban, balance, owner);
    }
}