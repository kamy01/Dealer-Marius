package com.dealer.services.impl;

import com.dealer.com.dealer.utils.Conversions;
import com.dealer.dao.impl.CarDaoImpl;
import com.dealer.services.interfaces.Import;
import https.www_w3schools.Car;
import https.www_w3schools.Cars;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

@TransactionManagement(value= TransactionManagementType.BEAN)
@Stateless
public class ImportServiceImpl implements Import{

    private Cars cars;
    private boolean isXmlValid(byte[] data, URL xsd){

        DocumentBuilder parser;

        try {

            DocumentBuilderFactory factoryDocument = DocumentBuilderFactory.newInstance();
            factoryDocument.setNamespaceAware(true);

            parser = factoryDocument.newDocumentBuilder();
            Document document = parser.parse(new InputSource(new ByteArrayInputStream(data)));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);


            Schema schema = factory.newSchema(xsd);

            Validator validator = schema.newValidator();

            try {
                validator.validate(new DOMSource(document));
                return unMarshall(data);

            } catch (SAXException e) {
                return false;
            } catch (IOException e) {
                return false;
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isValidated(byte[] xmlData) {
        URL xsd;

        xsd = this.getClass().getClassLoader().getResource("car.xsd");
        return xsd != null && isXmlValid(xmlData, xsd);

    }

    @Override
    public boolean unMarshall(byte[] xmlData) {

        try {
            JAXBContext jc = JAXBContext.newInstance(Cars.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            cars = (Cars) unmarshaller.unmarshal(new InputSource(new ByteArrayInputStream(xmlData)));
            return isXmlUploaded();

        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isXmlUploaded() {

        CarDaoImpl carDao = new CarDaoImpl();
        List<Car> cars = this.cars.getCar();
        for (Car car : cars) {
            com.dealer.dto.Car dtoCar = Conversions.getDtoCarFromImportCar(car);
            boolean added = carDao.createImportCarEntity(dtoCar.getId(),dtoCar.getName(), dtoCar.getMark(),
                    dtoCar.getCondition(), dtoCar.getPrice(), dtoCar.getRegistrationDate(), dtoCar.getColor());

            if (!added){
                return false;
            }
        }
        return true;
    }
}
