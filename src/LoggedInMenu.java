import java.util.ArrayList;
import java.util.Date;

public class LoggedInMenu extends AppMenu{

    InsuranceManagementApp app;

    public LoggedInMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app) {
        super("Sigorta Yonetim Sistemi", menuList);
        this.app = app;
        this.app.getCurrentAccount().setLoginTime(new Date());
    }

    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("1- Hesap Islemleri");
        System.out.println("2- Sigorta Islemleri");
        System.out.println("0- Cikis Yap");
    }

    @Override
    protected void performActions() {
        int selection;
        boolean running = true;

        while(running){
            
            subMenu = null;
            
            selection = getIntegerInput();


            switch(selection){
                case 0:
                    //app.reset();
                    app.getCurrentAccount().setLastLogin(app.getCurrentAccount().getLoginTime());
                    app.getCurrentAccount().setLoginStatus(AuthenticationStatus.FAIL);
                    running = false;
                    break;
                case 1:
                    subMenu = menuList.get(0);
                    break;
                case 2:
                    subMenu = menuList.get(1);
                default:
                    System.out.println("Hatali secim yaptiniz.Tekrar deneyiniz.");
            }
            
            if(subMenu != null){
                subMenu.onMenu();
            }

            

            clearScreen();
            printMenu();
        
        }


        
    }

    @Override
    public void onMenu() {
        clearScreen();
        printMenu();
        performActions();
        
    }
    
}
