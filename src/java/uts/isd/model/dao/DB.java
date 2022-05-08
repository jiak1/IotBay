package uts.isd.model.dao;

import java.sql.Connection;
/**
 *
 * @author AlexK
 * Super class of DAO classes that stores the database information
 */
//jdbc:derby://localhost:1527/usersdb [isduser on ISDUSER]
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "iotdb"; //name of the database   
    protected String dbuser = "iotuser"; //db root user   
    protected String dbpass = "admin"; //db root password   
    protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}