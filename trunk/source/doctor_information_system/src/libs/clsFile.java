/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author congnguyentan
 */
public class clsFile {

    public static boolean writeToFile(String FileName,String content){
        try{
            FileWriter fw = new FileWriter(FileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
            return true;
        }
        catch(Exception e){
            System.out.printf("\nError is %s", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkFileExists(String fileName){
        try{
            File file = new File(fileName);
            return file.exists();
        }
        catch(Exception e){
            System.out.printf("\nError is %s", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static String readFromFile(String fileName){
        String result = "";
        if(checkFileExists(fileName)){
            try{
                //get information of user based on account number
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String content = br.readLine();
                while(content != null){
                    result += content + "\n";
                    content = br.readLine();
                }
                return result;
            }
            catch(Exception e){
                System.out.printf("\nError is %s", e.getMessage());
                e.printStackTrace();
            }
        }
        else{
            System.out.printf("\nFile " + fileName + " is not exists\n");
        }
        return result;
    }

    /*return : 0 -> create fail, 1 -> create success, 2 -> directory exists*/
    public static int createDirectory(String directoryName){
        int result = 0;
        try{
            File file = new File(directoryName);
            //check directory exists or not
            if(!file.exists()){
                //create directory success
                if(file.mkdir()){
                    result = 1;
                }
                //create directory fail
                else{
                    result = 0;
                }
            }
            else{
                result = 2;
            }
        }
        catch(Exception e){
            System.out.printf("\nError is %s", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
