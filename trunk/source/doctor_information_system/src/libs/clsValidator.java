/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libs;

/**
 *
 * @author congnguyentan
 */
public class clsValidator {

    public static String makeValidate(String[] listDatas, boolean[] listRequired, String[] listRegex, String[] alerts){
        String result = "";
        try{
            for(int i=0;i<listDatas.length & i<listRequired.length & i<listRegex.length & i<alerts.length;i++){
                String dataCheck = listDatas[i];
                boolean requireCheck = listRequired[i];
                String regex = listRegex[i];
                String alert = alerts[i];
                
                //require check
                if(requireCheck){
                    if(dataCheck.trim().isEmpty()){
                        result = alert;
                        break;
                    }
                    //regex is not null -> check regex
                    if(!regex.isEmpty()){
                        if(!dataCheck.trim().matches(regex)){
                            result = alert;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
