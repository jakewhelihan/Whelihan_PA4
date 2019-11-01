package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        DuplicateCounter app = new DuplicateCounter();
        app.Count("problem2.txt");
        app.write("unique_word_counts.txt");

    }
}

class DuplicateCounter {
    FileInputStream fileByteStream = null;
    Scanner inFS = null;
    List<String> WordCounter = new ArrayList<String>();

    void Count(String dataFile) throws FileNotFoundException {

        fileByteStream = new FileInputStream(dataFile);
        String[] words = null;
        while (inFS.hasNextLine()) {

            String Lines = inFS.nextLine();
            while (Lines != null) {
                words = Lines.split(" ");
            }
            for (String j : words) {
                if (!WordCounter.contains(j))
                    WordCounter.add(j);
            }

            for(String st: words){
                StringBuilder numWords = new StringBuilder();
                int  wordCount = 0;
                for(String str: WordCounter) {
                    if(st.contains(str)){
                        numWords.append(wordCount + 1);}
                        else{
                            numWords.append("0");
                        }
                    }
                }
            }


        }


    void write(String outPutFile) throws IOException {
        File outPut = new File(outPutFile);
        FileWriter writeFile;
        Iterator input = WordCounter.iterator();

        if (outPut.exists()) {
            writeFile = new FileWriter(outPut, true);
            {
            }

            while (input.hasNext()) {
                String words = (String) input.next();
                writeFile.write((words));
            }

            writeFile.close();
        } else {
            outPut.createNewFile();
            writeFile = new FileWriter(outPut);

            while (input.hasNext()) {
                String words = (String) input.next();
                writeFile.write(words);
            }

            writeFile.close();
        }
    }
}


















