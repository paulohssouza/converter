package br.com.oracle.model;

import java.awt.*;

public class Speed {

    private Double value;
    private String unitSelected;
    private final List units;

    public Speed() {
        this.units = new List();
        units.add("Km/h");
        units.add("m/s");
        units.add("Mph");
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnitSelected() {
        return unitSelected;
    }

    public void setUnitSelected(String unitSelected) {
        this.unitSelected = unitSelected;
    }

    public List getUnits() {
        return units;
    }

    public void convertToMeterPerSecond() {
        if(this.unitSelected.equalsIgnoreCase("km/h")) {
            this.value = this.value / 3.6;
            this.unitSelected = "m/s";
        } else if(this.unitSelected.equalsIgnoreCase("Mph")) {
            this.value = this.value * 1609.34 / 3600;
            this.unitSelected = "Mph";
        }
    }

    public void convertToKilometerPerHour() {
        if(this.unitSelected.equalsIgnoreCase("m/s")) {
            this.value = this.value * 3.6;
            this.unitSelected = "Km/h";
        } else if(this.unitSelected.equalsIgnoreCase("Mph")) {
            this.value = this.value * 1.60934;
            this.unitSelected = "Km/h";
        }
    }

    public void convertToMilesPerHour() {
        if(this.unitSelected.equalsIgnoreCase("m/s")) {
            this.value = this.value * 3600 / 1609.34;
            this.unitSelected = "Mph";
        } else if(this.unitSelected.equalsIgnoreCase("Mph")) {
            this.value = this.value / 1.60934;
            this.unitSelected = "Mph";
        }
    }

    @Override
    public String toString() {
        return this.value + " " + this.unitSelected;
    }
}
