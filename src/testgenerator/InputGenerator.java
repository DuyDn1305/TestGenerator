package testgenerator;

import java.io.*;

public class InputGenerator {
    String path = "./";
    String name = "undefined";
    int numberTest = 1;
    
    public FileWriter input[];
    
    public InputGenerator(String path, String name, int numberTest) {
        this.path = path;
        this.name = name;
        this.numberTest = numberTest;
        input = new FileWriter[numberTest+1];
    }
    
    static boolean newDir(String path) {
        File f = new File(path);
        if (f.mkdir()) {
            return true;
        }
        System.out.println(path+" existed");
        return false;
    }
    
    static void createFile(String path, String name) {
        File output = new File(path+name);
        try {
            output.createNewFile();
        } catch(IOException e) {}
    }
    
    public void setup() {
        // create folder for input place holder
        if (newDir(path+"/Testcases"));
        if (newDir(path+"/Testcases/"+name));
        // create folder for tests
        boolean check = true;
        int len = Integer.toString(numberTest).length();
        for (int i = 1; i <= numberTest; ++i) {
            String id = Integer.toString(i);
            while (id.length() < len) id = "0"+id;
            if (newDir(path+"Testcases/"+name+"/test"+id));
            else {
                check = false;
                break;
            }
        }
        if (check) System.out.println("Set up");
        else System.out.println("This problem is set up prevously!");
        
    }
    
    public void initFile() {
        int len = Integer.toString(numberTest).length();
        boolean check = true;
        for (int i = 1; i <= numberTest; ++i) {
            String id = Integer.toString(i);
            while (id.length() < len) id = "0"+id;
            String testPath = path+"Testcases/"+name+"/test"+id+"/";
            String testName = name+".inp";
            createFile(testPath, testName);
            
            try {
                input[i] = new FileWriter(testPath+testName);
            } catch (IOException e) {
                check = false;
                break;
            }
        }
        if (check) System.out.println("Generated input file successfully");
        else System.out.println("An error occurred while creating input file");
    }
}
