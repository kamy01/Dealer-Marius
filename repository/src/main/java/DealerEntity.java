import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DealerEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String dealerName;
    private String dealerPassword;


    public DealerEntity() {
        this.id = -1;
    }

    public DealerEntity(String dealerName, String dealerPassword) {
        this.dealerName = dealerName;
        this.dealerPassword = dealerPassword;
    }

    public DealerEntity(String dealerName, String dealerPassword, int id) {
        this.id = id;
        this.dealerPassword = dealerPassword;
        this.dealerName = dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerPassword() {
        return dealerPassword;
    }

    public int getId() {
        return id;
    }
}