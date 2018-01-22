package Rat;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

class RatLogFile 
{
    static FileOutputStream fd;
    static PrintWriter pw;
    static String defaultFileName = ".\\Rat.log";
    static final boolean APPENDING = true;
    
    RatLogFile(){
        try{
            File f = new File(defaultFileName);
            if(!f.exists())
                f.createNewFile();
        }
        catch(Exception e){
            System.out.println("Error creating log file.");
        }
    }
    
    static void lg(String str){
        try{
            fd = new FileOutputStream(defaultFileName, APPENDING);
            pw = new PrintWriter(fd);
            pw.print(str + "\n");
        }
        catch(Exception e){
            System.out.println("File not found.");
        }
        finally{
            pw.close();
        }
    }
}
