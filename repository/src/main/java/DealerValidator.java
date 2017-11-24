class DealerValidator {

    private DealerService dealerService;

    DealerValidator(){

        dealerService = new DealerService();
    }

    private Dealer getDealerFromDealerEntity(DealerEntity dealerEntity){
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    Dealer findDealer(Dealer dealer){
        DealerEntity foundDealer = dealerService.getDealerEntity(dealer.getDealerName());
        return getDealerFromDealerEntity(foundDealer);

    }

    boolean createDealer(String dealerName, String dealerPassword){
        boolean isCreated;

        isCreated = dealerService.createDealerEntity(dealerName, dealerPassword);
        return isCreated;
    }
}
