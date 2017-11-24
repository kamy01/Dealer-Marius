class RegisterService {

    static boolean isCreated(String dealerName, String dealerPassword){
        boolean isCreated = false;

        if(!dealerName.isEmpty() && !dealerPassword.isEmpty()) {

            DealerValidator validator = new DealerValidator();
            Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
            Dealer returnedDealer = validator.findDealer(possibleDealer);


            if (returnedDealer.getId() == -1) {
                isCreated = validator.createDealer(dealerName, dealerPassword);
            }
        }

        return isCreated;
    }
}
