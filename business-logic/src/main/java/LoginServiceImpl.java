import javax.ejb.Stateless;

@Stateless
class LoginServiceImpl implements Login{

     public int getResponseCode(String dealerName, String dealerPassword){

        Dealer possibleDealer = new Dealer(dealerName, dealerPassword);
        Dealer returnedDealer = new DealerValidator().findDealer(possibleDealer);

        if (returnedDealer.getId() == -1){
            return Utils.NOT_FOUND;
        }

        else
        {

            if(!returnedDealer.getDealerPassword().equals(dealerPassword)){
                return Utils.UNAUTHORIZED;
            }
            else{
                return Utils.SUCCESS;
            }
        }
    }
}
