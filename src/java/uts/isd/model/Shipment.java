package uts.isd.model;

import java.io.Serializable;

public class Shipment implements Serializable {

    public int trackingNumber;
    public String carrier;
    public String currentLocation;
    public String status;

    public Shipment() {
    }

    public Shipment(int trackingNumber, String carrier, String currentLocation, String status) {
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.currentLocation = currentLocation;
        this.status = status;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
