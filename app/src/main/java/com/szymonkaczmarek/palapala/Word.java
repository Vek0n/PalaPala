package com.szymonkaczmarek.palapala;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by szymonkaczmarek on 30.05.2017.
 */

public class Word {

    private String setOfLetters;

    private String getSetOfLetters(){
        return setOfLetters;
    }

    public void setSetOfLetters(String setOfLettersVoid){
        setOfLetters = setOfLettersVoid;
    }

    public ArrayList<String> ReadFile(Context context, String fileName, int lang){

        InputStream fIn;
        InputStreamReader isr;
        BufferedReader input;
        ArrayList<String> wordList = new ArrayList<>();
        Points points;

        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line;

            do{
                line = input.readLine();
                if (line != null) {
                    if (isPossibleToCreateWord(getSetOfLetters(), line)) {
                        if(lang == 1){
                            points = new PointsPolish();
                            points.setWord(line);
                            wordList.add(line + "               " +points.countPoints() + " pkt");
                        }else if(lang == 2){
                            points = new PointsEnglish();
                            points.setWord(line);
                            wordList.add(line + "               " +points.countPoints() + " points");
                        }else if(lang == 3){
                            points = new PointsFrench();
                            points.setWord(line);
                            wordList.add(line + "               " +points.countPoints());
                        }

                    }
                }
            }while(line!=null);

        } catch (Exception e) {
            e.getMessage();
        }
        return wordList;
    }

    private boolean isPossibleToCreateWord(String setOfLetters, String word) {

        int finalCounter = 0, countBlankTiles = 0;
        boolean isThereLetter;
        char[] setOfLettersChar = setOfLetters.toCharArray();
        char[] wordChar = word.toCharArray();

        for (int i = 0; i < setOfLetters.length(); i++) {
            if (setOfLetters.charAt(i) == '?') {
                countBlankTiles++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            isThereLetter = false;
            for (int j = 0; j < setOfLetters.length(); j++) {
                if (wordChar[i] == setOfLettersChar[j]) {
                    isThereLetter = true;
                    setOfLettersChar[j] = '-';
                    break;
                }
            }
            if ((!isThereLetter) && (countBlankTiles > 0)) {
                isThereLetter = true;
                countBlankTiles--;
            }
            else if ((!isThereLetter) && (countBlankTiles <= 0)){
                return false;
            }
            if (isThereLetter)
                finalCounter++;
        }

        return ((finalCounter == word.length()));
    }
}
