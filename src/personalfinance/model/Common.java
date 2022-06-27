package personalfinance.model;

import personalfinance.saveload.SaveData;

public abstract class Common {

    public Common() {}

    public String getValueForComboBox() {
        return null;
    }

    public void postAdd(SaveData saveData) {}
    public void postEdit(SaveData saveData) {}
    public void postRemove(SaveData saveData) {}
}
