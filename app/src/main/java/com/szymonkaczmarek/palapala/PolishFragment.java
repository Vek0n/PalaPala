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

public class PolishFragment extends Fragment {

    public PolishFragment() {}

    EditText textFieldPolish;
    Button buttonPolish;
    ListView listPolish;
    ImageButton buttonInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_polish, container, false);

        textFieldPolish = (EditText) view.findViewById(R.id.editTextPolish);
        buttonPolish = (Button) view.findViewById(R.id.buttonPolish);
        listPolish = (ListView) view.findViewById(R.id.listPolish);
        buttonInfo = (ImageButton) view.findViewById(R.id.imageButtonInfoPl);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogHelper alertDialogHelper = new AlertDialogHelper(getContext());
                alertDialogHelper.showDialog("Pomoc","Wpisz litery nierozdzielone spacją. Puste klocki zastąp znakami '?'", "Zamknij");
            }
        });


        buttonPolish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Word word = new Word();
                SearchHelper searchHelper = new SearchHelper(textFieldPolish, getContext(), word);

                ArrayList<String> finalListPolish = searchHelper.getListOfWords();

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(PolishFragment.this.getActivity(),
                        android.R.layout.simple_list_item_1,
                        finalListPolish);
                listPolish.setAdapter(arrayAdapter);

            }
        });


        return view;
    }
}