package personalfinance.saveload;

import personalfinance.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveLoad {

    public static void load(SaveData saveData) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) unmarshaller.unmarshal(Settings.getSaveFile());
            saveData.setAccounts(wrapper.getAccounts());
            saveData.setArticles(wrapper.getArticles());
            saveData.setCurrencies(wrapper.getCurrencies());
            saveData.setTransactions(wrapper.getTransactions());
            saveData.setTransfers(wrapper.getTransfers());
        } catch (JAXBException e) {
            System.out.println("Файл ня йснуе!");
            throw new RuntimeException(e);
        }

    }

    public static void save(SaveData saveData) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Wrapper wrapper = new Wrapper();

            wrapper.setAccounts(saveData.getAccounts());
            wrapper.setArticles(saveData.getArticles());
            wrapper.setCurrencies(saveData.getCurrencies());
            wrapper.setTransactions(saveData.getTransactions());
            wrapper.setTransfers(saveData.getTransfers());

            marshaller.marshal(wrapper, Settings.getSaveFile());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
