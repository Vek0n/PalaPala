package com.szymonkaczmarek.palapala;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

public class EnglishFragment extends Fragment {

    public EnglishFragment() {}

    EditText textFieldEnglish;
    Button buttonEnglish;
    ListView listEnglish;
    ImageButton buttonInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_english, container, false);

        textFieldEnglish = (EditText) view.findViewById(R.id.editTextEnglish);
        buttonEnglish = (Button) view.findViewById(R.id.buttonEnglish);
        listEnglish = (ListView) view.findViewById(R.id.listEnglish);
        buttonInfo = (ImageButton) view.findViewById(R.id.imageButtonInfoEn);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialogHelper alertDialogHelper = new AlertDialogHelper(getContext());
               alertDialogHelper.showDialog("Help", "Type in letters without spaces. Blank tiles replace with '?' symbol.", "Close");
            }
        });


        buttonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Word word = new Word();

               SearchHelper searchHelper = new SearchHelper(textFieldEnglish, getContext(), word);

               ArrayList<String> finalListEnglish = searchHelper.getListOfWords();

               ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(EnglishFragment.this.getActivity(),
                        android.R.layout.simple_list_item_1,
                        finalListEnglish);
                listEnglish.setAdapter(arrayAdapter);
            }
        });

        return view;
    }

}