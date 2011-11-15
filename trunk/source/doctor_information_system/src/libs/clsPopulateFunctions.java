/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libs;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.Vector;

/**
 *
 * @author congnguyentan
 */
public class clsPopulateFunctions {

    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };

    /*
      * encrypt password
      * @input String passwordNeedEncode
      * @return String password encrypted
      */
    public static String encryptPassword(String passwordNeedEncode) {
        String result = passwordNeedEncode;
        try{
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
            result = _base64Encode(pbeCipher.doFinal(passwordNeedEncode.getBytes()));
        } catch (Exception e) {
            System.out.println("Error is : " + e.getMessage());
        }
        return result;
    }

    private static String _base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Encoder().encode(bytes);
    }

    /*
      * decrypt password
      * @input String passwordNeedDecode
      * @return String password decrypted
      */
    public static String decryptPassword(String passwordNeedDecode) {
        String result = passwordNeedDecode;
        try{
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
            result = new String(pbeCipher.doFinal(_base64Decode(passwordNeedDecode)));
        } catch (Exception e) {
            System.out.println("Error is : " + e.getMessage());
        }
        return result;
    }

    private static byte[] _base64Decode(String passwordNeedDecode) throws IOException {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Decoder().decodeBuffer(passwordNeedDecode);
    }

    /*
     * show notice, warning
     * @input String content: content of notice, warning
     * @input String type: type of notice
     * @input javax.swing.JFrame object
     */
     public static void showNotice(String content,String type,javax.swing.JFrame object){
         //check type valid
         if(type.isEmpty() || (!type.equalsIgnoreCase("notice") && !type.equalsIgnoreCase("warning"))){
             type = "notice";
         }
         if(type.equalsIgnoreCase("notice")){
             JOptionPane.showMessageDialog(object, (Object) content, "Notice from application", JOptionPane.INFORMATION_MESSAGE);
         }
        else{
            JOptionPane.showMessageDialog(object, (Object) content, "Warning from application", JOptionPane.ERROR_MESSAGE);
        }
     }

     /*
      * convert an array String to a String with string delimiter between two element in array
      *
      * @param: String[] arrays
      * @param: String delimiter
      * @return: String result
      */
     public static String joinArray(String[] arrays, String delimiter){
        String result = "";
        try{
            int k=arrays.length;
            if (k==0){
                return "";
            }
            StringBuilder out=new StringBuilder();
            out.append(arrays[0]);
            for (int x=1;x<k;++x){
                if(!arrays[x].isEmpty()){
                    out.append(delimiter).append(arrays[x]);
                }
            }
            result = out.toString();
        } catch (Exception e) {
            System.out.println("Error is : " + e.getMessage());
        }
         return result;
     }
	 
	 /*
      * convert a Vector to a String with string delimiter between two element in array
      *
      * @param: Vector arrays
      * @param: String delimiter
      * @return: String result
      */
     public static String joinVector(Vector vector, String delimiter){
        String result = "";
        try{
            int k= vector.size();
            if (k==0){
                return "";
            }
            StringBuilder out=new StringBuilder();
            out.append(vector.get(0).toString());
            for (int x=1;x<k;++x){
                String element = vector.get(x).toString();
                if(!element.isEmpty()){
                    out.append(delimiter).append(element);
                }
            }
            result = out.toString();
        } catch (Exception e) {
            System.out.println("Error is : " + e.getMessage());
        }
         return result;
     }
}