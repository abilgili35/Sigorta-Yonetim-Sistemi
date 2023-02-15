import java.util.ArrayList;
import java.util.Date;

public class InsuranceOperationsMenu extends AppMenu{

    private InsuranceManagementApp app;

    public InsuranceOperationsMenu(ArrayList<AppMenu> menuList, InsuranceManagementApp app) {
        super("Sigorta Islemleri", menuList);
        this.app = app;
    }

    private void showInsuranceInfo(){
        System.out.println("########### Sigorta Bilgilieri ##############\n\n");
        System.out.println(String.format("%-25s %-20s %-20s %-10s","Sigorta Turu", "Baslangic Tarihi", "Bitis Tarihi", "Fiyat" ));
        
        for(int i=0; i<=75; i++){
            System.out.print("-");
        }

        System.out.println();

        for(Insurance ins : app.getCurrentAccount().getInsuranceList()){
            String startDate = (ins.getStartDate().getYear() + 1900) + "/" + (ins.getStartDate().getMonth() + 1) + "/" + ins.getStartDate().getDate();
            String endDate = (ins.getEndDate().getYear() + 1900) + "/" + (ins.getEndDate().getMonth() + 1) + "/"  + ins.getEndDate().getDate();
            System.out.println(String.format("%-25s %-20s %-20s %-10.2f",ins.getName(), startDate, endDate, ins.getCost()));
        }
    }

    private void addHealthInsurance(){
        int customerAge = app.getCurrentAccount().getUser().getAge();
        int insuranceDuration;
        HealthInsurance insurance;
        Date insuranceDate = new Date();
        Date insuranceEndDate = new Date(insuranceDate.getYear()+1, insuranceDate.getMonth(), insuranceDate.getDate());

        System.out.println("Lutfen eklemek istediginiz saglik sigortasinin suresini yil olarak giriniz.");
        insuranceDuration = getIntegerInput();

        
        insurance = new HealthInsurance(customerAge, insuranceDate, insuranceEndDate);

        System.out.println("Sigorta Bilgileri");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-25s %-20s %-20s %-12s %-10s","Sigorta Turu", "Baslangic Tarihi", "Bitis Tarihi", "Suresi(Gun)", "Fiyat" ));
        System.out.println(insurance.toString()+"\n\n");
        System.out.println("Sectiginiz sigortayi eklememk istiyormusunuz?");
        System.out.println("Gosterilen fiyata %" + (app.getCurrentAccount().getProfitRate()*100) + " oraninda kar eklenecektir.");
        System.out.println("<E>vet <Hayir>");

        String add;
        while(true){
            add = input.next();
            if(add.equalsIgnoreCase("E")){
                app.getCurrentAccount().addInsurance(insurance);
                break;
            }else if(add.equalsIgnoreCase("H")){
                System.out.println("Sigorta secilmedi.");
                break;
            }else{
                System.out.println("Yanlis bir komut girdiniz.");
            }
        }

    }

    private void addCarInsurance() {
        int carAge;
        int carKm;
        int insuranceDuration;
        CarInsurance insurance;
        Date insuranceDate = new Date();
        Date insuranceEndDate = new Date(insuranceDate.getYear()+1, insuranceDate.getMonth(), insuranceDate.getDate());


        System.out.println("Lutfen eklemek istediginiz arac sigortasinin suresini yil olarak giriniz.");
        insuranceDuration = getIntegerInput();

        System.out.println("Lutfen aracinizin yasini yil olarak giriniz.");
        carAge = getIntegerInput();

        System.out.println("Lutfen aracinizin gittigi km miktarini giriniz");
        carKm = getIntegerInput();

        
        insurance = new CarInsurance(carAge, carKm, insuranceDate, insuranceEndDate);

        System.out.println("Sigorta Bilgileri");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-25s %-20s %-20s %-12s %-10s","Sigorta Turu", "Baslangic Tarihi", "Bitis Tarihi", "Suresi(Gun)", "Fiyat" ));
        System.out.println(insurance.toString()+"\n\n");
        System.out.println("Sectiginiz sigortayi eklememk istiyormusunuz?");
        System.out.println("Gosterilen fiyata %" + (app.getCurrentAccount().getProfitRate()*100) + " oraninda kar eklenecektir.");
        System.out.println("<E>vet <Hayir>");

        String add;
        while(true){
            add = input.next();
            if(add.equalsIgnoreCase("E")){
                app.getCurrentAccount().addInsurance(insurance);
                break;
            }else if(add.equalsIgnoreCase("H")){
                System.out.println("Sigorta secilmedi.");
                break;
            }else{
                System.out.println("Yanlis bir komut girdiniz.");
            }
        }
    }

    private void addResidenceInsurance(){
        int residenceAge;
        int insuranceDuration;
        ResidenceInsurance insurance;
        Date insuranceDate = new Date();
        Date insuranceEndDate = new Date(insuranceDate.getYear()+1, insuranceDate.getMonth(), insuranceDate.getDate());


        System.out.println("Lutfen eklemek istediginiz konut sigortasinin suresini yil olarak giriniz.");
        insuranceDuration = getIntegerInput();

        System.out.println("Lutfen binanizin yasini yil olarak giriniz.");
        residenceAge = getIntegerInput();

        

        
        insurance = new ResidenceInsurance(residenceAge, insuranceDate, insuranceEndDate);

        System.out.println("Sigorta Bilgileri");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-25s %-20s %-20s %-12s %-10s","Sigorta Turu", "Baslangic Tarihi", "Bitis Tarihi", "Suresi(Gun)", "Fiyat" ));
        System.out.println(insurance.toString()+"\n\n");
        System.out.println("Sectiginiz sigortayi eklememk istiyormusunuz?");
        System.out.println("Gosterilen fiyata %" + (app.getCurrentAccount().getProfitRate()*100) + " oraninda kar eklenecektir.");
        System.out.println("<E>vet <Hayir>");

        String add;
        while(true){
            add = input.next();
            if(add.equalsIgnoreCase("E")){
                app.getCurrentAccount().addInsurance(insurance);
                break;
            }else if(add.equalsIgnoreCase("H")){
                System.out.println("Sigorta secilmedi.");
                break;
            }else{
                System.out.println("Yanlis bir komut girdiniz.");
            }
        }
    }

    private void addTravelInsurance(){
        
        int insuranceDuration;
        TravelInsurance insurance;
        Date insuranceDate = new Date();
        


        System.out.println("Lutfen eklemek istediginiz seyahat sigortasinin suresini gun olarak giriniz.");
        insuranceDuration = getIntegerInput();

        Date insuranceEndDate = new Date(insuranceDate.getYear(), insuranceDate.getMonth(), insuranceDate.getDate()+insuranceDuration);

        

        
        insurance = new TravelInsurance(insuranceDate, insuranceEndDate);

        System.out.println("Sigorta Bilgileri");
        System.out.println("--------------------------------");
        System.out.println(String.format("%-25s %-20s %-20s %-12s %-10s","Sigorta Turu", "Baslangic Tarihi", "Bitis Tarihi", "Suresi(Gun)", "Fiyat" ));
        System.out.println(insurance.toString()+"\n\n");
        System.out.println("Sectiginiz sigortayi eklememk istiyormusunuz?");
        System.out.println("Gosterilen fiyata %" + (app.getCurrentAccount().getProfitRate()*100) + " oraninda kar eklenecektir.");
        System.out.println("<E>vet <Hayir>");

        String add;
        while(true){
            add = input.next();
            if(add.equalsIgnoreCase("E")){
                app.getCurrentAccount().addInsurance(insurance);
                break;
            }else if(add.equalsIgnoreCase("H")){
                System.out.println("Sigorta secilmedi.");
                break;
            }else{
                System.out.println("Yanlis bir komut girdiniz.");
            }
        }
    }

    private void addInsurance(){
        int selection;
        
        System.out.println("########### Sigorta Ekle #############\n");
        System.out.println("Lutfen eklemek istediginiz sigorta turunu seciniz.");
        System.out.println("1- Saglik Sigortasi");
        System.out.println("2- Arac Sigortasi");
        System.out.println("3- Konut Sigortasi");
        System.out.println("4- Seyahat Sigortasi");
        System.out.println("0- Cikis Yap");
        
        while(true){
            selection = getIntegerInput();
            if(selection == 0){
                break;
            }else if(selection == 1){
                addHealthInsurance();
                askToContinue();
                break;
            }else if(selection == 2){
                addCarInsurance();
                askToContinue();
                break;
            }else if(selection == 3){
                addResidenceInsurance();
                askToContinue();
                break;
            }else if(selection == 4){
                addTravelInsurance();
                askToContinue();
                break;
            }else{
                System.out.println("Yanlis bir secim yaptiniz.Tekrar deneyiniz.");
            }
        }
        
    }


    
    @Override
    protected void printMenu() {
        System.out.println("############# " + this.getName() + " ############\n");
        System.out.println("1- Sigorta bilgilerini goruntule");
        System.out.println("2- Yeni sigorta ekle");
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
                    showInsuranceInfo();
                    askToContinue();
                    break;
                case 2:
                    addInsurance();
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
