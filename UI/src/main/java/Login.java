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

    public String checkLogIn(){
        requestCode = ProcessDealerInput.authorizationCode(dealerName, dealerPassword);

        switch (requestCode){
            case Utils.SUCCESS:
                return "success";
            case Utils.UNAUTHORIZED:
                return "unauthorized";
            case Utils.NOT_FOUND:
                return "not_found";
            default:
                return "login";
        }
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

}
