package com.szymonkaczmarek.palapala;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CountPointsFragment extends Fragment {

    TextView textViewChooseLanguage;
    EditText editTextCountPoints;
    Button buttonCountPoints;
    Spinner spinnerCountPoints;
    TextView textViewCountPoints;

    ArrayAdapter<CharSequence> arrayAdapterCountPoints;
    int chosenLanguage = 99;

    public CountPointsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_points, container, false);

        textViewChooseLanguage = (TextView) view.findViewById(R.id.chooseLanguageText);
        editTextCountPoints = (EditText) view.findViewById(R.id.editTextCountPoints);
        buttonCountPoints = (Button) view.findViewById(R.id.buttonCountPoints);
        spinnerCountPoints = (Spinner) view.findViewById(R.id.spinnerCountPoints);
        textViewCountPoints = (TextView) view.findViewById(R.id.textViewPoints);
        arrayAdapterCountPoints = (ArrayAdapter) ArrayAdapter.createFromResource(getContext(),
                R.array.chooseLanguage,
                android.R.layout.simple_spinner_item);
        arrayAdapterCountPoints.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountPoints.setAdapter(arrayAdapterCountPoints);

        //Points points;

                spinnerCountPoints.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override

                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(position == 0){
                            //English
                            chosenLanguage = 0;
                            buttonCountPoints.setText("Count");
                            textViewChooseLanguage.setText("Choose language");
                            editTextCountPoints.setHint("Type word");
                            textViewCountPoints.setText("0");
                        }
                        else if (position == 1){
                            //Polish
                            chosenLanguage = 1;
                            buttonCountPoints.setText("Policz");
                            textViewChooseLanguage.setText("Wybierz język");
                            editTextCountPoints.setHint("Wpisz słowo");
                            textViewCountPoints.setText("0");
                        }
                        else if (position == 2){
                            //Spanish
                            chosenLanguage = 2;
                            buttonCountPoints.setText("Compter");
                            editTextCountPoints.setHint("Choisissez la langue");
                            textViewChooseLanguage.setText("Entrez le mot");
                            textViewCountPoints.setText("0");

                        }
                        else if (position == 3){
                            //German
                            chosenLanguage = 3;
                            buttonCountPoints.setText("Zählst");
                            textViewChooseLanguage.setText("Wählst eine Spreche");
                            editTextCountPoints.setHint("Geben Sie das Wort");
                            textViewCountPoints.setText("0");
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getContext(),"Please choose language", Toast.LENGTH_SHORT).show();
                    }
                });

        buttonCountPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Points points;
                if (chosenLanguage == 0){
                    points = new PointsEnglish();
                    points.setWord(editTextCountPoints.getText().toString());
                    textViewCountPoints.setText(points.countPoints());
                }
                else if (chosenLanguage == 1){
                    points = new PointsPolish();
                    points.setWord(editTextCountPoints.getText().toString());
                    textViewCountPoints.setText(points.countPoints());
                }
                else if (chosenLanguage == 2){
                    points = new PointsFrench();
                    points.setWord(editTextCountPoints.getText().toString());
                    textViewCountPoints.setText(points.countPoints());
                }
                else if (chosenLanguage == 3){
                }
                else if (chosenLanguage == 99){
                    Toast.makeText(getContext(),"Please choose language", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
