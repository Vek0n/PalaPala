package com.szymonkaczmarek.palapala;

import android.content.Context;
import android.widget.EditText;
import java.util.ArrayList;

class SearchHelper {

    private EditText textField;
    private Context context;
    private Word word;

    SearchHelper(EditText t, Context c, Word w){
        this.textField = t;
        this.context = c;
        this.word = w;
    }

    ArrayList<String> getListOfWords(){
        String setOfLetters = textField.getText().toString().toLowerCase();
        word.setSetOfLetters(setOfLetters);
        int i = setOfLetters.length();
        ArrayList<String> finalList;

        while (true){
            finalList = word.ReadFile(context,"words_" + i +".txt",1);

            if(setOfLetters.isEmpty()){
                finalList.add("Wpisz litery!");
            }

            if(!finalList.isEmpty()) {
                break;
            }
            else{
                i--;
                if (i<3) {
                    finalList.add("Nie znaleziono słów");
                    break;
                }
            }
        }
        return finalList;
    }
}
