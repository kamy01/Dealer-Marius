class ProcessDealerInput {

    static int authorizationCode(String dealerName, String dealerPassword){

        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new DealerValidator().findDealer(possibleDealer);

        if (returnedDealer == null){
            return 404;
        }

        else
            {

            if(!returnedDealer.getDealerPassword().equals(dealerPassword)){
                return 401;
            }
            else{
                return 200;
            }
        }
    }

    static boolean isCreated(String dealerName, String dealerPassword){

        DealerValidator validator = new DealerValidator();
        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = validator.findDealer(possibleDealer);

        boolean isCreated = false;

        if(returnedDealer.getId() == -1){
            isCreated = validator.createDealer(dealerName, dealerPassword);
        }

        return isCreated;
    }
}
