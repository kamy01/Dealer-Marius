package com.dealer.beans;

import com.dealer.dto.Car;
import com.dealer.services.interfaces.SearchCars;
import com.dealer.utils.Utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class SearchCarBean {

    @ManagedProperty(value = "#{carBean}")
    private CarBean carBean;

    private List<Car> cars;
    private List<ColumnModel> columns;
    private ArrayList<String> colors, conditions;

    @EJB
    private SearchCars allCarsService;

    @PostConstruct
    public void init(){
        cars = allCarsService.getCars();
        colors = Utils.Colors.getColors();
        conditions = Utils.Conditions.getConditions();
        createColumns();
    }

    public CarBean getCarBean() {
        return carBean;
    }

    public void setCarBean(CarBean carBean) {
        this.carBean = carBean;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public List<ColumnModel> getColumns(){
        return columns;
    }

    public boolean filterByPrice(Object value, Object filter){
        String filterText = (filter == null) ? null: filter.toString().trim();

        if(filterText == null || filterText.equals("")){
            return true;
        }

        if(value == null){
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    private void createColumns(){
        String[] columnsKeys = {"name", "mark", "color", "price", "condition", "registrationDate"};
        columns = new ArrayList<ColumnModel>();
        for(String key:columnsKeys) {
            columns.add(new ColumnModel(key.toUpperCase(), key));
        }
    }

    static public class ColumnModel implements Serializable{
        private String header;
        private String attribute;

        ColumnModel(String header, String attribute){
            this.header = header;
            this.attribute = attribute;
        }

        public String getHeader() {
            return header;
        }

        public String getAttribute(){
            return attribute;
        }
    }
}
