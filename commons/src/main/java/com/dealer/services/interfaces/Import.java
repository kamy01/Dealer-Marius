package com.dealer.services.interfaces;
import javax.ejb.Remote;

@Remote
public interface Import {
    boolean isValidated(byte[] xmlData);
    boolean unMarshall(byte[] xmlData);
    boolean isXmlUploaded();
}
