package com.dealer.beans;

import com.dealer.services.interfaces.Import;
import org.primefaces.model.UploadedFile;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ImportBean implements Serializable{

    private UploadedFile file;

    @EJB
    private Import importService;

    public void setFile(UploadedFile file) {
        this.file = file;

    }

    public UploadedFile getFile() {
        return file;
    }

    public void checkXml(){
        FacesMessage message;

        if(file != null && !file.getFileName().equals("")) {

            byte[] xmlData = file.getContents();
            boolean isValidated = importService.isValidated(xmlData);

            if(isValidated) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", file.getFileName() +
                        "was imported");
            }

            else{
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", file.getFileName() +
                        "was not imported");
            }
        }
        else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choose a file", "Import error");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
