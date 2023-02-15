import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AppMenu {
    protected Scanner input;
    protected String name;
    protected AppMenu subMenu;
    protected ArrayList<AppMenu> menuList;
    
    public AppMenu(String name, ArrayList<AppMenu> menuList){
        setName(name);
        this.menuList = menuList;
        input = new Scanner(System.in);
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    protected int getIntegerInput(){
        
        int userInput = 0;
        while (true) {
            try {
                userInput = Integer.parseInt(this.input.next());
                break; 
            }catch (NumberFormatException ignore) {
                System.out.println("Yanlis turde bir veri girisi yaptiniz.Integer deger girmelisiniz.");
            }
        }
        return userInput;
    }

    protected double getDoubleInput(){
        
        double userInput = 0;
        while (true) {
            try {
                userInput = Double.parseDouble(this.input.next());
                break; 
            }catch (NumberFormatException ignore) {
                System.out.println("Yanlis turde bir veri girisi yaptiniz.Double deger girmelisiniz.");
            }
        }
        return userInput;
    }

    protected void askToContinue(){
        System.out.println("<D>evam...");
        while(true){
            
            String s = input.next();
            s = s.toUpperCase();
            if(s.equals("D")){
                break;
            }else{
                System.out.println("Gecersiz komut!");
            }
        }
    }

    protected void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    protected abstract void printMenu();

    protected abstract void performActions();

    public abstract void onMenu();


    
}
