package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

    public String details;
    public Date logDate;

    public Log() {
    }

    public Log(String details, Date logDate) {
        this.details = details;
        this.logDate = logDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

}
