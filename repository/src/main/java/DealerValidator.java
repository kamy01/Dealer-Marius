public class DealerValidator {

    DealerService dealerService;



    public DealerValidator(){

        dealerService = new DealerService();
    }

    Dealer getDealerFromDealerEntity(DealerEntity dealerEntity){
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    DealerEntity getDealerEntityFromDealer(Dealer dealer){
        return new DealerEntity(dealer.getDealerName(), dealer.getDealerPassword(), dealer.getId());
    }

    public Dealer findDealer(Dealer dealer){
        DealerEntity foundDealer = dealerService.getDealerEntity(dealer.getDealerName());
        return getDealerFromDealerEntity(foundDealer);

    }

    boolean createDealer(String dealerName, String dealerPassword){
        boolean isCreated;

        isCreated = dealerService.createDealerEntity(dealerName, dealerPassword);
        return isCreated;
    }
}
