package accessModifiers;



public class User {
    private String userToken;
    //can't accessible outside,only accesible in getter and setter
    protected String sellerMerchantId;
    //only accessible in seller class which extends it

    int cartCount;
    //only within this package accessModifiers
    public String username;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
//access everywhere


    public static void main(String[] args) {

    }
}

