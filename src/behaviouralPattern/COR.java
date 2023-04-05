package behaviouralPattern;

interface Dispense {
    void dispenseChaining(DispenseChaining chain);

    void dispenseMoney(int amount);
}

class DispenseChaining implements Dispense {
    DispenseChaining chain;
    @Override
    public void dispenseChaining(DispenseChaining chain) {
        this.chain = chain;
    }

    @Override
    public void dispenseMoney(int amount) {
        this.chain.dispenseMoney(amount);
    }
}

class Dispense100Rupees extends DispenseChaining {
    @Override
    public void dispenseMoney(int amount) {
        int amountIn50Rupees = amount / 100;
        int amountRemaining = amount % 100;
        if (amountIn50Rupees > 0)
            System.out.println("Amount in 100 rupees note " + amountIn50Rupees);

        if (amountRemaining > 0)
            super.dispenseMoney(amountRemaining);

    }
}

class Dispense50Rupees extends DispenseChaining {
    @Override
    public void dispenseMoney(int amount) {
        int amountIn50Rupees = amount / 50;
        int amountRemaining = amount % 50;
        if (amountIn50Rupees > 0)
            System.out.println("Amount in 50 rupees note " + amountIn50Rupees);

        if (amountRemaining > 0)
            super.dispenseMoney(amountRemaining);

    }
}

class Dispense20Rupees extends DispenseChaining {
    @Override
    public void dispenseMoney(int amount) {
        int amountIn50Rupees = amount / 20;
        int amountRemaining = amount % 20;
        if (amountIn50Rupees > 0)
            System.out.println("Amount in 20 rupees note " + amountIn50Rupees);

        if (amountRemaining > 0)
            super.dispenseMoney(amountRemaining);

    }
}

public class COR {
    public static DispenseChaining doChaining() {
        DispenseChaining chain = new DispenseChaining();
        Dispense100Rupees rupeesIn100Notes = new Dispense100Rupees();
        Dispense50Rupees rupeesIn50Notes = new Dispense50Rupees();
        Dispense20Rupees rupeesIn20Notes = new Dispense20Rupees();
        rupeesIn100Notes.dispenseChaining(rupeesIn50Notes);
        rupeesIn50Notes.dispenseChaining(rupeesIn20Notes);
        chain.dispenseChaining(rupeesIn100Notes);
        return chain;

        //100->50->20
    }

    public static void main(String[] args) {
        DispenseChaining chain = doChaining();
        chain.dispenseMoney(490);
    }

}
