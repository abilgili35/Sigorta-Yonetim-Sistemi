import java.util.ArrayList;

public class LoginMenu extends AppMenu{

    private InsuranceManagementApp app;


    

    public LoginMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app) {
        super("Giris Menusu", menuList);
        this.app = app;
        System.out.println("Login Menu");
    }


    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("Lutfen kullanici bilgilerini giriniz.");
    }

    @Override
    protected void performActions() {
        String email;
        String password;
        System.out.print("Kullanici Adi : ");
        email = input.next();
        System.out.print("Sifre : ");
        password = input.next();

        try{
            app.setCurrentAccount(app.getAccountManager().login(email, password));
        }catch(InvalidAuthenticationException e){
            System.out.println("Yanlis hesap bilgileri!");
            askToContinue();
        }catch(AccountNotFoundException e){
            System.out.println("Kullanici sistemde mevcut degil! Lutfen kayit olun.");
            askToContinue();
        }



    }

    @Override
    public void onMenu() {
        clearScreen();
        printMenu();
        performActions();
    }
    
}
