package structuralPattern.facadePattern;

import java.util.Scanner;

interface MobilePhones {

    void setModelName();

    void setPrice();
}


class Nokia implements MobilePhones {
    String modelName;
    int price;

    @Override
    public void setModelName() {
        this.modelName = "Nokia 7.1";
    }

    @Override
    public void setPrice() {
        this.price = 40000;
    }
}

class Samsung implements MobilePhones {
    String modelName;
    int price;

    @Override
    public void setModelName() {
        this.modelName = "Samsung Flip";
    }

    @Override
    public void setPrice() {
        this.price = 70000;
    }
}

class ShopKeeperFacade {
    Nokia nokia;
    Samsung samsung;

    public void buyLatestSamsung() {
        System.out.println(" Latest Samsung Phone is " + samsung.modelName + " of price " + samsung.price);
    }

    public void buyLatestNokia() {
        System.out.println(" Latest Nokia Phone is " + nokia.modelName + " of price " + nokia.price);
    }

    ShopKeeperFacade() {
        nokia = new Nokia();
        samsung = new Samsung();

        nokia.setModelName();
        nokia.setPrice();

        samsung.setPrice();
        samsung.setModelName();
    }

}


public class FacadeDemo {
    public static void main(String[] args) {
        ShopKeeperFacade shopKeeperFacade = new ShopKeeperFacade();
        System.out.println("Press 1,2 for Samsung and Nokia respectively");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            n = sc.nextInt();
            switch (n) {
                case 1:
                    shopKeeperFacade.buyLatestSamsung();
                    break;
                case 2:
                    shopKeeperFacade.buyLatestNokia();
                case 3:
                    break;
            }

        } while (n == 1 || n == 2);
    }
}