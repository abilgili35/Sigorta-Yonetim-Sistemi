public class DuplicateAccountException extends Exception{
    
    public DuplicateAccountException(){
        super("Bu hesap zaten var!");
    }
}
