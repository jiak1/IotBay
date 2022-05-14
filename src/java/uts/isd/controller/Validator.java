package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author AlexK
 */
public class Validator implements Serializable{
    
    //private String emailPattern = "([-!#-'*+/-9=?A-Z^-~]+(\\.[-!#-'*+/-9=?A-Z^-~]+)*|\"([]!#-[^-~ \\t]|(\\\\[\\t -~]))+\")@([0-9A-Za-z]([0-9A-Za-z-]{0,61}[0-9A-Za-z])?(\\.[0-9A-Za-z]([0-9A-Za-z-]{0,61}[0-9A-Za-z])?)*|\\[((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|IPv6:((((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){6}|::((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){5}|[0-9A-Fa-f]{0,4}::((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){4}|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):)?(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){3}|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){0,2}(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){2}|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){0,3}(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){0,4}(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::)((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3})|(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3})|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){0,5}(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3})|(((0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}):){0,6}(0|[1-9A-Fa-f][0-9A-Fa-f]{0,3}))?::)|(?!IPv6:)[0-9A-Za-z-]*[0-9A-Za-z]:[!-Z^-~]+)])";
    private String emailPattern = "^(.+)@(.+)$";
    //private String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
    private String namePattern = "^\\w[\\w.\\-#&\\s]*$";
    private String productnamePattern = "^\\w[\\w.\\-#&\\s]*$";
    private String productsearchPattern = "^\\w[\\w.\\-#&\\s]*$";
    //private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    //private String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$";
    private String passwordPattern = "^[a-zA-Z0-9_+&*-]+"; //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$";
    private String pricePattern = "^\\$?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$"; //"^\\d{0,8}(\\.\\d{1,4})?$"; //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$";
    private String taxPattern = "^\\$?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$"; //"^\\d{0,8}(\\.\\d{1,4})?$"; //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$";
    private String intPattern = "^\\s*-?[0-9]{1,10}\\s*$"; //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$";
    private String datePattern = "([0-9]{4})-([0-9]{1,2})-([0-9]{1,2})";
            //"^(19|20)\\d\\d[- /.] (0[1-9]|1[012])[- /.] (0[1-9]|[12][0-9]|3[01])$";
    private String upperCasePattern = "[A-Z]+";
    public Validator() {
    }
    
    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }
    
    public boolean validateName(String name) {
        return validate(namePattern, name);
    }
    
    public boolean validateProductName(String productname) {
        return validate(productnamePattern, productname);
    }
    
    public boolean validateProductSearch(String productsearch) {
        return validate(productsearchPattern, productsearch);
    }
    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validatePrice(String price) {
        return validate(pricePattern, price);
    }
    
    public boolean validateTax(String tax) {
        return validate(taxPattern, tax);
    }
    
    public boolean validateDate(String date) {
        return validate(datePattern, date);
    }
    
    public boolean validateInt(String num) {
        return validate(intPattern, num);
    }
    
    public boolean validateUpperCase(String location) {
        return validate(upperCasePattern, location);
    }
            
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
        session.setAttribute("productnameErr", "Enter product name");
        session.setAttribute("productsearchErr", "Enter search term");
        session.setAttribute("intErr", "Whole number needed");
        session.setAttribute("priceErr", "Price needed $(n.nn)");
        session.setAttribute("taxErr", "Tax needed $(n.nn)");
        session.setAttribute("dateErr", "Date needed (yyyy-mm-dd)");
        session.setAttribute("upperCaseErr", "UPPERCASE needed");
    }
}   
