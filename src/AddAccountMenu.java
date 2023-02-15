import java.util.ArrayList;

public class AddAccountMenu extends AppMenu{

    private InsuranceManagementApp app;


    public AddAccountMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app) {
        super("Yeni Hesap Ekle", menuList);
        this.app = app;
    }

    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("Yeni kullanici eklemek icin bilgilerinizi giriniz!\n");
    }

    @Override
    protected void performActions() {
        String name;
        String surname;
        String email;
        String password;
        String job;
        int age;
        int accountType;

        System.out.print("Ad : ");
        name = input.next();
        System.out.print("Soyad : ");
        surname = input.next();
        System.out.print("Email : ");
        email = input.next();
        System.out.print("Sifre : ");
        password = input.next();
        System.out.print("Meslek : ");
        job = input.next();
        System.out.print("Yas : ");
        age = getIntegerInput();
        System.out.println("Hesap turu : ");
        System.out.println("1- Bireysel");
        System.out.println("2- Kurumsal");
        
        while(true){
            accountType = getIntegerInput();
            try{
                if(accountType == 1){
                    this.app.getAccountManager().createAccount(new User(name, surname, email, password, job, age), 1);
                    System.out.println("Kullanici basariyla sisteme eklendi!");
                    break;
                }else if(accountType == 2){
                    this.app.getAccountManager().createAccount(new User(name, surname, email, password, job, age), 2);
                    System.out.println("Kullanici basariyla sisteme eklendi!");
                    break;
                }else{
                    System.out.println("Yanlis secim yaptiniz! Tekrar deneyiniz!");
                }
            }catch(DuplicateAccountException e){
                System.out.println("Bu email adresi zaten sistemde kayitli! Giris yapmayi deneyin!");
                break;
            }
            
        }


    }

    @Override
    public void onMenu() {
        clearScreen();
        printMenu();
        performActions();
        askToContinue();
    }
    
}
