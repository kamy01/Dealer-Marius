package com.dealer.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Utils {

    public static final int NOT_FOUND = 404;
    public static final int SUCCESS = 200;
    public static final int UNAUTHORIZED = 401;

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String REGISTRATION_DATE_VALIDATOR_NAME = "registrationDateValidator";
    public static final String REGISTRATION_DATE_AFTER_CURRENT_ERROR =
            "Registration Date cannot be after current date !";
    public static final String INVALID_DATE_FORMAT_ERROR = "Invalid Date Format !";

    public static final String REGISTER_SUCCESS_MESSAGE = "Register Success";
    public static final String REGISTER_USER_EXISTS_MESSAGE = "User exists!";

    public static final String LOGIN_NOT_FOUND_MESSAGE = "Dealer not found !";
    public static final String LOGIN_UNAUTHORIZED_MESSAGE = "Wrong name or password";

    public static final String ADD_CAR_SUCCESSFUL_MESSAGE = "Car added";
    public static final String ADD_CAR_FAIL_MESSAGE = "Something went wrong, please try again";

    public enum Conditions {
        ALL{
            @Override
            public String toString() {
                return "All";
            }
        },


        BAD{
            @Override
            public String toString(){
                return "Bad";
            }
        },

        GOOD{
            @Override
            public String toString() {
                return "Good";
            }
        },

        USED{
            @Override
            public String toString() {
                return "Used";
            }
        },

        NEW{
            @Override
            public String toString(){
                return "New";
            }
        };

        public static ArrayList<String> getConditions(){
            ArrayList<String> conditions = new ArrayList<String>();

            for(Conditions c: Conditions.values()){
                conditions.add(c.toString());
            }

            return conditions;
        }
    }

    public enum Colors {
        ALL{
            @Override
            public String toString() {
                return "All";
            }
        },


        WHITE{
        @Override
        public String toString(){
            return "White";
            }
        },

        BLACK{
            @Override
            public String toString(){
                return "Black";
            }
        },

        BLUE{
            @Override
            public String toString(){
                return "Blue";
            }
        },

        RED{
            @Override
            public String toString(){
                return "Red";
            }
        },

        BROWN{
            @Override
            public String toString(){
                return "Brown";
            }
        },

        GREEN{
            @Override
            public String toString(){
                return "Green";
            }
        },


        PINK{
            @Override
            public String toString(){
                return "Pink";
            }
        },


        YELLOW{
            @Override
            public String toString(){
                return "Yellow";
            }
        },


        SILVER{
            @Override
            public String toString(){
                return "Silver";
            }
        },

        GREY{
            @Override
            public String toString(){
                return "Grey";
            }
        };

        public static ArrayList<String> getColors(){

            ArrayList<String> colors = new ArrayList<String>();

            for(Colors c: Colors.values()) {
                colors.add(c.toString());
            }

            return colors;
        }
    }

    public static Date getCurrentDate(){
        DateFormat format = new SimpleDateFormat(DATE_PATTERN);
        String currentDateString = format.format(new Date());

        try {
            return format.parse(currentDateString);

        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
