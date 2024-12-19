package com.individualproject_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionBook {

    private ObservableList<Reyestr> reyestrList = FXCollections.observableArrayList();

    public void add(Reyestr reyestr) {
        reyestrList.add(reyestr);
    }

    public void update(Reyestr reyestr) {
    }

    public void delete(Reyestr reyestr) {
        reyestrList.remove(reyestr);
    }


    // GET ta SET
    public ObservableList<Reyestr> getReyestrList() {
        return reyestrList;
    }

    public void setReyestrList(ObservableList<Reyestr> reyestrList) {
        this.reyestrList = reyestrList;
    }
}
