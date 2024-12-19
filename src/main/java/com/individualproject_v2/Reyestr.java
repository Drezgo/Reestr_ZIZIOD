package com.individualproject_v2;

import javafx.beans.property.SimpleStringProperty;

public class Reyestr {

    private SimpleStringProperty NUM = new SimpleStringProperty("");
    private SimpleStringProperty MODEL = new SimpleStringProperty("");
    private SimpleStringProperty PRESS = new SimpleStringProperty("");
    private SimpleStringProperty PIP = new SimpleStringProperty("");

    public Reyestr(String pip, String press, String model, String num) {
        this.PIP = new SimpleStringProperty(pip);
        this.PRESS = new SimpleStringProperty(press);
        this.MODEL = new SimpleStringProperty(model);
        this.NUM = new SimpleStringProperty(num);
    }

    public Reyestr() {
    }


    public String getMODEL() {
        return MODEL.get();
    }

    public SimpleStringProperty MODELProperty() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL.set(MODEL);
    }

    public String getNUM() {
        return NUM.get();
    }

    public SimpleStringProperty NUMProperty() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM.set(NUM);
    }

    public String getPIP() {
        return PIP.get();
    }

    public SimpleStringProperty PIPProperty() {
        return PIP;
    }

    public void setPIP(String PIP) {
        this.PIP.set(PIP);
    }

    public String getPRESS() {
        return PRESS.get();
    }

    public SimpleStringProperty PRESSProperty() {
        return PRESS;
    }

    public void setPRESS(String PRESS) {
        this.PRESS.set(PRESS);
    }

}
