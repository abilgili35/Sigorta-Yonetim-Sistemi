import java.util.Iterator;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accountList;

    public AccountManager(){
        accountList = new TreeSet<>();
        init();
    }

    public void init(){
        User aziz = new User("Aziz", "Bilgili", "abilgili35@gmail.com", "1234", "Engineer", 41);
        User mike = new User ("Mike", "Johnson", "mjohnson@hotmail.com", "1234", "Doctor", 46);
        User aziz2 = new User("Ali", "Bilgin", "abilgili35@gmail.com", "1234", "Engineer", 49);
        Individual a = new Individual(aziz);
        Individual b = new Individual(mike);
        Individual c = new Individual(aziz2);
        try{
            addAccount(a);
            addAccount(b);
            addAccount(c);
        }catch(DuplicateAccountException e){
            System.out.println("Bu hesap zaten var!");
        }
        
    }

    public void addAccount(Account account) throws DuplicateAccountException{
        
        if(!accountList.add(account)){
            throw new DuplicateAccountException();
        }
        
    }

    public Account login(String email, String password) throws InvalidAuthenticationException, AccountNotFoundException{
        Iterator<Account> itr = accountList.iterator();

        while(itr.hasNext()){
            Account a = itr.next();
            if(a.getUser().getEmail().equals(email)){
                try{
                    a.login(email, password);
                    return a;
                }catch(InvalidAuthenticationException e){
                    throw new InvalidAuthenticationException();
                }
                
            }
        }

        throw new AccountNotFoundException();
        
    }

    public void createAccount(User user, int accountType) throws DuplicateAccountException{
        try{
            if(accountType == 1){
                addAccount(new Individual(user));
            }else if(accountType == 2){
                addAccount(new Enterprise(user));
            }
        }catch(DuplicateAccountException e){
            throw new DuplicateAccountException();
        }
        
    }
}
