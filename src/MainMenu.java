import java.util.ArrayList;

public class MainMenu extends AppMenu {

    private InsuranceManagementApp app;
    private ArrayList<AppMenu> menuList;

    public MainMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app){
        super("Ana Menu", menuList);
        subMenu = null;
        this.menuList = menuList;
        this.app = app;
    }

    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("1- Giris Yap");
        System.out.println("2- Kayit Ol");
        System.out.println("0- Cikis yap");

    }

    @Override
    public void onMenu() {
        clearScreen();
        printMenu();
        performActions();
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
                    running = false;
                    break;
                case 1:
                    subMenu = menuList.get(0);
                    break;
                case 2:
                    subMenu = menuList.get(1);
                    break;
                default:

            }
            
            if(subMenu != null){
                subMenu.onMenu();
            }

            if(app.getCurrentAccount() != null){
                if(app.getCurrentAccount().getLoginStatus() == AuthenticationStatus.SUCCESS){
                    ArrayList<AppMenu> menuList = new ArrayList<>();
                    AccountOperationsMenu accountMenu = new AccountOperationsMenu(null, app);
                    InsuranceOperationsMenu insuranceMenu = new InsuranceOperationsMenu(null, app);
                    menuList.add(accountMenu);
                    menuList.add(insuranceMenu);
                    subMenu = new LoggedInMenu(menuList, app);
                    subMenu.onMenu();
                }
            }

            clearScreen();
            printMenu();
        
        }
    
    }

}
