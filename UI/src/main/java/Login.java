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
        requestCode = Logic.checkDealer(dealerName, dealerPassword);

        switch (requestCode){
            case Utils.SUCCESS:
                return "/home/marius/IdeaProjects/DealersMarius/UI/web/pages/success.html";
            case Utils.UNAUTHORIZED:
                return "/home/marius/IdeaProjects/DealersMarius/UI/web/pages/unauthorized.html";
            case Utils.NOT_FOUND:
                return "/home/marius/IdeaProjects/DealersMarius/UI/web/pages/not_found.html";
            default:
                return "/home/marius/IdeaProjects/DealersMarius/UI/web/pages/login.html";
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
