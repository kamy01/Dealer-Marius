package com.dealer.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.dealer.utils.Utils;


@FacesValidator(Utils.REGISTRATION_DATE_VALIDATOR_NAME)
public class RegistrationDateValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if(o == null){
            return;
        }

        String dateValue = facesContext.getExternalContext().getRequestParameterMap().get(uiComponent
                .getClientId(facesContext));


        if(dateValue == null){
            return;
        }

        DateFormat dateFormat = new SimpleDateFormat(Utils.DATE_PATTERN);
        Date currentDate = new Date();

        Date registerDate;
        try {
            registerDate = dateFormat.parse(dateValue);

            if(registerDate.after(currentDate)){
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        Utils.REGISTRATION_DATE_AFTER_CURRENT_ERROR,
                        Utils.REGISTRATION_DATE_AFTER_CURRENT_ERROR));
            }

        } catch (ParseException e) {
            e.printStackTrace();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    Utils.INVALID_DATE_FORMAT_ERROR,
                    Utils.INVALID_DATE_FORMAT_ERROR));
        }


    }

}
