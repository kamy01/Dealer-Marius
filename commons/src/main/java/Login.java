import javax.ejb.Remote;

@Remote
public interface Login {
    int getResponseCode(String dealerName, String dealerPassword);
}
