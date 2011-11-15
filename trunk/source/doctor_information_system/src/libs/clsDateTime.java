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
        /*String data[] = new String[1];
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
        }*/
        //get current date
        Date current_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str_current_date = sdf.format(current_date);
        return str_current_date;
    }

    /*
     * return: -1(date1 less than date2); 0(date1 equal date2); 1(date1 greater than date2)
     */
    public static int compareDate(String strDate1, String strDate2){
        int result = 0;
        try{
            String format = "MM/dd/yyyy";
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date1 = df.parse(strDate1);
            Date date2 = df.parse(strDate2);
            result = date1.compareTo(date2)<0?-1:date1.compareTo(date2)==0?0:1;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static String increaseDate(String strDate, String format, int day){
        String result = strDate;
        try{
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(strDate);
            int milisecondIncrease = day * 24 * 60 * 60;
            long milisecondCurrentDate = date.getTime();
            milisecondCurrentDate = milisecondCurrentDate + milisecondIncrease;
            Date dateIncrease = new Date(milisecondCurrentDate);
            result = df.format(dateIncrease);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static String decreaseDate(String strDate, String format, int day){
        String result = strDate;
        try{
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(strDate);
            int milisecondDecrease = day * 24 * 60 * 60;
            long milisecondCurrentDate = date.getTime();
            milisecondCurrentDate = milisecondCurrentDate - milisecondDecrease;
            Date dateDecrease = new Date(milisecondCurrentDate);
            result = df.format(dateDecrease);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static Date convertStringToDate(String strDate1, String format){
        Date date = new Date();
        try{
            if(format.isEmpty()){
                format = "dd/MM/yyyy";
            }
            SimpleDateFormat df = new SimpleDateFormat(format);
            date = df.parse(strDate1);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return date;
    }
}
