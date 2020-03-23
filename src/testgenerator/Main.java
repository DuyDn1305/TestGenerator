package testgenerator;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String arg[]) {
        // Tuning parameter
        String name = "problemD"; // the name of problem
        String path = "./"; // The whole testcase for the problem will
                            //be store directly in this folder
        int numberTest = 5; // number of testcase
        // asign new generator
        InputGenerator A = new InputGenerator(path, name, numberTest);
        Generator G = new Generator();
        A.setup(); // set up the folder to contain input
        A.initFile(); // create input file
        for (int i = 1; i <= numberTest; ++i) {
            FileWriter f = A.input[i];
            try {
                // Your input format goes here
                
                
                
                
                // write an upper character and lower one
                //f.write(""+G.nextAlphabet(true)+G.nextAlphabet(false)+'\n');
                // generate an array of n permutation
                // NOTE THAT FIRST INDEX IS 0
                int n = 17;
                int[] p = G.nextPermutationArray(n);
                for (int j = 0; j < n; ++j) {
                    f.write(p[j]+" ");
                }
                f.write('\n');
                // generate a uniform-distribution array
                n = 10;
                long[] a = G.nextLongArray(n);
                for (int j = 0; j < n; ++j) {
                    f.write(a[j]+" ");
                }
                
                
                
                
                // Now close file to save the input for each test
                f.close();
            } catch(IOException e) {}
        }
    }
}
