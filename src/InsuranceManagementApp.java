import java.util.ArrayList;

public class InsuranceManagementApp {

    private AccountManager accountManager;
    private ArrayList<AppMenu> appMenu;
    private Account currentAccount;
    private LoginMenu login;
    private AddAccountMenu addAccount;
    private MainMenu main;

    public InsuranceManagementApp(){
        init();
    }

    /* 
    public void reset(){
        login = new LoginMenu(null, this);
        addAccount = new AddAccountMenu(null, this);
        appMenu = new ArrayList<>();
        appMenu.add(login);
        appMenu.add(addAccount);
        main = new MainMenu(appMenu, this);
        setCurrentAccount(null);
    }
    */
    
    public void init(){
        ArrayList<AppMenu> menu2 = new ArrayList<>();
        accountManager = new AccountManager();
        login = new LoginMenu(null, this);
        addAccount = new AddAccountMenu(null, this);
        appMenu = new ArrayList<>();
        appMenu.add(login);
        appMenu.add(addAccount);
        main = new MainMenu(appMenu, this);
    }

    public void run(){
        main.onMenu();
        
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
}
