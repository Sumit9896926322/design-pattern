package accessModifiers;

public class Seller extends User {
    void printSellerMerchantKey(){

    }

    public static void main(String[] args) {
        Seller ramesh = new Seller();
        System.out.println(ramesh.sellerMerchantId);
    }
}
