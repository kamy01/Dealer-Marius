import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped

public class Register implements Serializable {

    private String dealerName;
    private String dealerPassword;
    private boolean isCreated;

    public Register(){

    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    public void createDealer(){
        isCreated = RegisterService.isCreated(dealerName, dealerPassword);
    }

    public String getDealerName(){
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public boolean getIsCreated(){return isCreated;}
}