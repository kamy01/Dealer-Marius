import javax.persistence.*;

@Entity
@Table(name = "DealerEntity")
public class DealerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DEALER_NAME")
    private String dealerName;

    @Column(name = "DEALER_PASSWORD")
    private String dealerPassword;


    public DealerEntity() {
        this.id = -1;
    }

    public DealerEntity(String dealerName, String dealerPassword) {
        this.dealerName = dealerName;
        this.dealerPassword = dealerPassword;
    }

    DealerEntity(String dealerName, String dealerPassword, int id) {
        this.id = id;
        this.dealerPassword = dealerPassword;
        this.dealerName = dealerName;
    }

    void setDealerEntityName(String dealerName) {
        this.dealerName = dealerName;
    }

    void setDealerEntityPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    void setEntityId(int id) {
        this.id = id;
    }

    String getDealerEntityName() {
        return dealerName;
    }

    String getDealerEntityPassword() {
        return dealerPassword;
    }

    int getEntityId() {
        return id;
    }
}