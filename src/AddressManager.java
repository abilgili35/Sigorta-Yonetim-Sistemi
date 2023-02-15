public class AddressManager {

    public AddressManager(){

    }
    
    public static void addAddress(User user, String address) throws InvalidAddressException{
        if(isValidBusinessAddress(address)){
            user.addAddress(createBusinessAddress(address));
        }else if(isValidHomeAddress(address)){
            user.addAddress(createHomeAddress(address));
        }else{
            throw new InvalidAddressException();
        }
    }

    public static void removeAddress(User user, int index) throws IndexOutOfBoundsException, AddressNotFoundException{
        try{
            Address adr = user.getAddressList().get(index);
            if(!user.removeAddress(adr))
            {
                throw new AddressNotFoundException();
            }
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
        
        
        
    }

    public static boolean isValidHomeAddress(String address){
        address = address.toUpperCase();
        String pattern = "(\\d+|\\w+)(\\s+)(SOKAK|SK\\.|S\\.)(\\s+)(NO:|N:)(\\d+)(\\s+)(\\w+)(\\s+)(\\d{5})";
        return address.matches(pattern);
    }

    public static boolean isValidBusinessAddress(String address){
        address = address.toUpperCase();
        String pattern = "(\\d+|\\w+)(\\s+)(SOKAK|SK\\.|S\\.)(\\s+)(NO:|N:)(\\d+)(\\s+)(\\w+)(\\s+)(\\d{5})(\\s+)(\\w+\\s?)+";
        return address.matches(pattern);
    }
    
    private static BusinessAddress createBusinessAddress(String address){
        String[] params = {};
        address = address.toUpperCase();
        String pattern = "(\\d+|\\w+)(\\s+)(SOKAK|SK\\.|S\\.)(\\s+)(NO:|N:)(\\d+)(\\s+)(\\w+)(\\s+)(\\d{5})(\\s+)(.+\\s?)+";
        address = address.replaceAll(pattern, "$1" + "-" + "$6" + "-" + "$8" + "-" + "$10" + "-" + "$12");
        params = address.split("-");
        return new BusinessAddress(params[4], params[2], params[0], Integer.parseInt(params[1]), Integer.parseInt(params[3]));
    }

    private static HomeAddress createHomeAddress(String address){
        String[] params = {};
        address = address.toUpperCase();
        String pattern = "(\\d+|\\w+)(\\s+)(SOKAK|SK\\.|S\\.)(\\s+)(NO:|N:)(\\d+)(\\s+)(\\w+)(\\s+)(\\d{5})";
        address = address.replaceAll(pattern, "$1" + "-" + "$6" + "-" + "$8" + "-" + "$10");
        params = address.split("-");
        return new HomeAddress(params[2], params[0], Integer.parseInt(params[1]), Integer.parseInt(params[3]));
    }
    
}
