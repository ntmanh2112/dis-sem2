/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libs;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author congnguyentan
 */
public class clsDateTime {

    public static String getCurrentDate(String format){
        if(format.isEmpty()){
            format = "MM/dd/yyyy";
        }
        //validate format date
        String data[] = new String[1];
        data[0] = format;
        boolean require[] = new boolean[1];
        require[0] = true;
        String regex[] = new String[1];
        regex[0] = "^(MM/dd/yyyy)$";
        String alerts[] = new String[1];
        alerts[0] = "invalid";
        String validate = clsValidator.makeValidate(data, require, regex, alerts);
        if(!validate.isEmpty()){
            format = "MM/dd/yyyy";
        }
        //get current date
        Date current_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str_current_date = sdf.format(current_date);
        return str_current_date;
    }
}
