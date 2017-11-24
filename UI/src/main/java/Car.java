import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
public class Car implements Serializable{
    private String name;
    private String mark;
    private String color;
    private String condition;

    private long price;
    private Date registrationDate;


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public long getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getColor() {
        return color;
    }

    public String getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }
}
