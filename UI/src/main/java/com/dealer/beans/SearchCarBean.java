package com.dealer.beans;

import com.dealer.dto.Car;
import com.dealer.services.interfaces.SearchCars;
import com.dealer.utils.Utils;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class SearchCarBean {

    @ManagedProperty(value = "#{carBean}")
    private CarBean carBean;
    private List<Car> cars;
    private List<ColumnModel> columns;
    private ArrayList<String> colors, conditions;
    private final String[] columnsKeys = {"name", "mark", "color", "price", "condition", "registrationDate"};
    private DataTable dataTable;

    @EJB
    private SearchCars allCarsService;

    @PostConstruct
    public void init(){
        dataTable = new DataTable();
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

    public void filter(String value, String columnName){

        if(columnName.equals("PRICE")) {
            if(value.length() == 0){
                setPrice("%");
            }
        }
        else if(columnName.equals("CONDITION")){
            if(value.equals("All")){
                setCondition("%");
            }
        }
        else if(columnName.equals("MARK")){
            if(value.length() == 0){
                setMark("%");
            }
        }
        else if(columnName.equals("NAME")){
            if(value.length() == 0){
                setName("%");
            }
        }
        else if(columnName.equals("COLOR")){
            if(value.equals("All")){
                setColor("%");
            }
        }

        else if(columnName.equals("REGISTRATIONDATE")){
            if(value.length() == 0){
                setRegistrationDate(Utils.getCurrentDate());
            }
        }

        cars = allCarsService.filterCars(getName(), getMark(), getCondition(), getPrice(), getRegistrationDate(), getColor());
        RequestContext.getCurrentInstance().update("main:cars:carTable");
    }

    private void createColumns(){
        columns = new ArrayList<ColumnModel>();
        for(String key:columnsKeys) {
            columns.add(new ColumnModel(key.toUpperCase(), key));
        }
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public String getName() {
        return carBean.getName() == null ? "%": carBean.getName();
    }

    public void setName(String name) {
        this.carBean.setName(name);
    }

    public String getPrice() {
        return carBean.getPrice() == null ? "%": carBean.getPrice();
    }

    public void setPrice(String price) {
        this.carBean.setPrice(price);
    }

    public String getMark() {
        return carBean.getMark() == null ? "%": carBean.getMark();
    }

    public void setMark(String mark) {
        this.carBean.setMark(mark);
    }

    public Date getRegistrationDate() {
        return carBean.getRegistrationDate() == null ? Utils.getCurrentDate(): carBean.getRegistrationDate();
    }

    public void setRegistrationDate(Date registrationDate) {
        this.carBean.setRegistrationDate(registrationDate);
    }

    public String getColor() {
        return carBean.getColor() == null || carBean.getColor().equals("All") ? "%": carBean.getColor();
    }

    public void setColor(String color) {
        this.carBean.setColor(color);
    }

    public String getCondition() {
        return carBean.getCondition() == null || carBean.getCondition().equals("All") ? "%": carBean.getCondition();
    }

    public void setCondition(String condition) {
        this.carBean.setCondition(condition);
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
