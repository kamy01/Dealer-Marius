class DealerValidator {

    private DealerDao dealerDao;

    DealerValidator(){

        dealerDao = new DealerDao();
    }

    private Dealer getDealerFromDealerEntity(DealerEntity dealerEntity){
        return new Dealer(dealerEntity.getDealerEntityName(), dealerEntity.getDealerEntityPassword(),
                dealerEntity.getEntityId());
    }

    Dealer findDealer(Dealer dealer){
        DealerEntity foundDealer = dealerDao.getDealerEntity(dealer.getDealerName());
        return getDealerFromDealerEntity(foundDealer);

    }

    boolean createDealer(String dealerName, String dealerPassword){
        boolean isCreated;

        isCreated = dealerDao.createDealerEntity(dealerName, dealerPassword);
        return isCreated;
    }
}
