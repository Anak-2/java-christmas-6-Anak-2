package christmas.benefits;

public class MerchandiseBenefit {

    private final int CHAMPAGNE_DESERVED = 120_000;

    public boolean champagneDeserved(int totalOrder){
        if(totalOrder > CHAMPAGNE_DESERVED){
            return true;
        }
        return false;
    }
}
