class LoginService {

    static int authorizationCode(String dealerName, String dealerPassword){

        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new DealerValidator().findDealer(possibleDealer);

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
}
