package christmas.benefits;

public class MerchandiseBenefit {

    private final int CHAMPAGNE_DESERVED = 120_000;

    public boolean champagneDeserved(int totalOrder){
        return totalOrder > CHAMPAGNE_DESERVED;
    }
}
