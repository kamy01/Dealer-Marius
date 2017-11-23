class Logic {

    static int checkDealer(String dealerName, String dealerPassword){

        Dealer returnedDealer = new DealerChecker().findDealer(dealerName);
        if (returnedDealer.getId() == -1){
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

    static boolean createDealer(String dealerName, String dealerPassword){
        DealerChecker checker = new DealerChecker();
        Dealer returnedDealer = checker.findDealer(dealerName);
        boolean isCreated = false;

        if(returnedDealer.getId() == -1){
            isCreated = checker.createDealer(dealerName, dealerPassword);
        }

        return isCreated;
    }
}
