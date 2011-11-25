/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author De
 */
public class Check {
    /**
     * Method checkName()
     * @param str
     * @return
     */
    public static boolean checkName( String str){
        if (str == null || str.length() == 0) {
            return false;
        } else {
            String strPattern = "[^a-z ]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(str);
            return !m.find();
        }
    }
    /**
     * Method checkSpace()
     * @param str
     * @return
     */
    public static boolean checkSpace(String str){
        String strPattern = "[^ ]";
        Pattern p;
        Matcher m;
        int flag = Pattern.CASE_INSENSITIVE;
        p = Pattern.compile(strPattern, flag);
        m = p.matcher(str);
        return m.find();
    }
    /**
     * Method checkTxtArea()
     * @param n
     * @return
     */
    public static boolean checkTxtArea(String str) {
        if (str == null ||str.length() == 0) {
            return false;
        }
        return true;
    }
    /**
     * 
     * @param args
     */
    public static void main(String args[]){
        new Check();
        System.out.println("go to check");
    }
}
