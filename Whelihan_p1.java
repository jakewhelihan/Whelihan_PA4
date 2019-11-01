package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        DuplicateRemover app = new DuplicateRemover();
        app.remove("problem1.txt");
        app.write("unique_words.txt");
    }
}
class DuplicateRemover{

    ArrayList<String> uniqueWords = new ArrayList <String>();
    FileInputStream fileByteStream = null;
    Scanner inFS = null;





    public void remove(String dataFile) throws FileNotFoundException {

        fileByteStream = new FileInputStream(dataFile);
        inFS = new Scanner(dataFile);
        while(inFS.hasNextLine()){

            String Lines = inFS.nextLine();

            while(Lines != null){

                String[] L1 = Lines.split(" ");

                for(String j: L1){
                    if(!uniqueWords.contains(j))
                        uniqueWords.add(j);
                }

                Lines = inFS.nextLine();
            }

            inFS.close();
        }
    }

    public void write(String outPutFile) throws IOException {
        File outPut = new File(outPutFile);
        FileWriter writeFile;
        Iterator input = uniqueWords.iterator();

        if(outPut.exists()) {
            writeFile = new FileWriter(outPut, true);


            while (input.hasNext()) {
                String words = (String) input.next();
                writeFile.write(words);
            }

            writeFile.close();

        }

        else {
            outPut.createNewFile();
            writeFile = new FileWriter(outPut);

            while(input.hasNext()){
                String words = (String) input.next();
                writeFile.write(words);
            }

            writeFile.close();
        }






    }
}
