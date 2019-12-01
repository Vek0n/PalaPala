package com.szymonkaczmarek.palapala;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class FrenchFragment extends Fragment {

    public FrenchFragment() {}

    EditText textFieldFrench;
    Button buttonFrench;
    ListView listFrench;
    ImageButton buttonInfo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_french, container, false);

        textFieldFrench = (EditText) view.findViewById(R.id.editTextFrench);
        buttonFrench = (Button) view.findViewById(R.id.buttonFrench);
        listFrench = (ListView) view.findViewById(R.id.listFrench);
        buttonInfo = (ImageButton) view.findViewById(R.id.imageButtonInfoFr);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogHelper alertDialogHelper = new AlertDialogHelper(getContext());
                alertDialogHelper.showDialog("Help","Type in letters without spaces. Blank tiles replace with '?' symbol.","Close");
            }
        });


        buttonFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Word word = new Word();
                SearchHelper searchHelper = new SearchHelper(textFieldFrench, getContext(), word);

                ArrayList<String> finalListFrench = searchHelper.getListOfWords();

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(FrenchFragment.this.getActivity(),
                        android.R.layout.simple_list_item_1,
                        finalListFrench);
                listFrench.setAdapter(arrayAdapter);
            }
        });

        return view;
    }

}
