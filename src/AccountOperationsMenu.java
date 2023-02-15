import java.util.ArrayList;

public class AccountOperationsMenu extends AppMenu{

    InsuranceManagementApp app;

    public AccountOperationsMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app) {
        super("Hesap Islemleri", menuList);
        this.app = app;
    }

    private void printAccountInfo(){
        this.app.getCurrentAccount().showUserInfo();
    }

    private void addAddress(){
        String address;
        System.out.print("Lutfen adres bilgilerini giriniz : ");
        input.nextLine();
        address = input.nextLine();
        try{
            app.getCurrentAccount().addAddress(address);
        }catch(InvalidAddressException e){
            System.out.println("Hatali bir adres girdiniz.Lutfen adres bilgilerinizi uygun formatta giriniz.");
            return;
        }
        
        System.out.println("Adres girme islemi basarili bir sekilde gerceklestirildi.");

    }

    private void removeAddress(){
        int index = 1;
        int selection;
        
        System.out.println("Lutfen silmek istediginiz adresi seciniz.\n\n");
        
        for(Address adr : app.getCurrentAccount().getUser().getAddressList()){
            System.out.println(index + "- " + adr.toString());
            index++;
        }

        

        while(true){
            selection = getIntegerInput() - 1;

            try {
                AddressManager.removeAddress(app.getCurrentAccount().getUser(), selection);
                System.out.println("Adres silme islemi gerceklestirildi.");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Yanlis bir secim yaptiniz tekrar deneyiniz");
            }  catch (AddressNotFoundException e){
                System.out.println("Adres bulunamadi.");
                break;
            }
        }
        



    }

    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("1- Hesap bilgilerini goruntule");
        System.out.println("2- Yeni adres ekle");
        System.out.println("3- Adres sil");
        System.out.println("0-Cikis");

        
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
                    this.app.getCurrentAccount().showUserInfo();
                    askToContinue();
                    break;
                case 2:
                    addAddress();
                    askToContinue();
                    break;
                case 3:
                    removeAddress();
                    askToContinue();
                    break;
                default:

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
