import java.sql.SQLException;

public class DealerChecker {

    DealerDAO dealerDAO;

    public DealerChecker(){

        dealerDAO = new DealerDAO();
    }

    public Dealer findDealer(String dealerName){
        Dealer foundDealer = new Dealer();
        try {
            foundDealer = dealerDAO.getDealer(dealerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundDealer;
    }

    boolean createDealer(String dealerName, String dealerPassword){
        boolean isCreated = false;
        try {
            isCreated = dealerDAO.createDealer(new Dealer(dealerName, dealerPassword));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Created Dealer failed");
        }

        return isCreated;
    }
}
