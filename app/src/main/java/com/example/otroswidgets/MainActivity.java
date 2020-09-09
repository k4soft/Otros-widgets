package com.example.otroswidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] lenguages = {"C", "C#", "Java","Python","PHP","Swift"};
    private AutoCompleteTextView txtAutocomplete;
    private Spinner spinner;
    private ListView listvIiew;
    private String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        selectedSpinnerItem();
        onSelectedItemListener();
    }

    private void initComponents() {
        txtAutocomplete = findViewById(R.id.txtAutocomplete);
        loadInfoAutomComplete();
        spinner = findViewById(R.id.spinner);
        loadInfoSpinner();
        listvIiew = findViewById(R.id.listvIiew);
        loadinfoListView();
    }

    private void loadinfoListView() {
        int tamanoArray = 1000;
        items = new String[tamanoArray];
        for(int i = 0; i < items.length; i++){
           String item = "Ítem ".concat((i+1)+"");
           items[i] = item;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,items);
        listvIiew.setAdapter(arrayAdapter);
    }

    private void loadInfoSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,lenguages);
        spinner.setAdapter(arrayAdapter);
    }

    private void loadInfoAutomComplete() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,lenguages);
        txtAutocomplete.setThreshold(1);
        txtAutocomplete.setAdapter(arrayAdapter);
    }

    private void selectedSpinnerItem() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),lenguages[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onSelectedItemListener() {
        listvIiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_LONG).show();
            }
        });
    }


}