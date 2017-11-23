import sun.rmi.runtime.Log;

import java.sql.*;
import java.util.ArrayList;

public class DealerDAO {

    private String url="jdbc:mysql://localhost:3306/dealer";
    private String username="root";
    private String password="marius#$"; //todo make some hash for  these
    private Connection connection;

    public DealerDAO(){}

    public void connect() throws SQLException{

        if(connection == null || connection.isClosed()){

            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
            catch (ClassNotFoundException e){
                System.out.println("Driver not found !");
            }
        }
    }

    public void disconnect() throws SQLException{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }

    public boolean createDealer(Dealer dealer) throws SQLException{
        String addQuery = "INSERT INTO dealers (DEALER_NAME, DEALER_PASSWORD)" +
                " VALUES (?, ?)";
        connect();

        PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
        preparedStatement.setString(1, dealer.getDealerName());
        preparedStatement.setString(2, dealer.getDealerPassword());

        boolean isCreated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();

        return isCreated;
    }

    public boolean deleteDealer(Dealer dealer) throws SQLException{
        String deleteQuery = "DELETE FROM dealers WHERE id = ?";
        connect();

        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, dealer.getId());

        boolean isDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return isDeleted;
    }

    //todo updateDealer

    public Dealer getDealer(String dealerName) throws SQLException{

        Dealer dealer = new Dealer();
        String getQuery = "SELECT * FROM dealers WHERE DEALER_NAME=?";
        connect();

        PreparedStatement statement = connection.prepareStatement(getQuery);
        statement.setString(1, dealerName);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String resultDealerName = resultSet.getString("DEALER_NAME");
            String resultDealerPassword =  resultSet.getString("DEALER_PASSWORD");
            int resultDealerId = resultSet.getInt("id");

            dealer = new Dealer(resultDealerName, resultDealerPassword, resultDealerId);
        }
        resultSet.close();
        statement.close();
        disconnect();

        return dealer;
    }

    public ArrayList<Dealer> getAllDealers() throws SQLException{
        ArrayList<Dealer> dealers = new ArrayList<Dealer>();

        String selectQuery = "SELECT * FROM dealers";
        connect();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String dealerName = resultSet.getString("DEALER_NAME");
            String dealerPassword = resultSet.getString("DEALER_PASSWORD");

            Dealer dealer = new Dealer(dealerName, dealerPassword, id);
            dealers.add(dealer);
        }

        resultSet.close();
        statement.close();
        disconnect();

        return dealers;
    }
}
