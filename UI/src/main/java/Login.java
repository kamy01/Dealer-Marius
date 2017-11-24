import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped

public class Login implements Serializable {


    private int requestCode;

    private String dealerName;
    private String dealerPassword;

    public Login(){}

    public void checkLogIn(){
        requestCode = LoginService.getResponseCode(dealerName, dealerPassword);

    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword){
        this.dealerPassword = dealerPassword;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public int getRequestCode(){return requestCode;}

}
