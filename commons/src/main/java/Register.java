import javax.ejb.Remote;

@Remote
public interface Register {
    public boolean isCreated(String dealerName, String dealerPassword);
}
