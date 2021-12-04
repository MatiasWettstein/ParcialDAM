package com.dam.parcialdam;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public List<InfoGuardada> lig = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        EditText description = (EditText) findViewById(R.id.editTextDesc);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button buttonGuardar = (Button) findViewById(R.id.buttonGuardar);
        Button buttonMostrar = (Button) findViewById(R.id.buttonMostrar);
        ListView listView = (ListView) findViewById(R.id.lv);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.info, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        InfoGuardadaDatabase db = Room.databaseBuilder(getApplicationContext(), InfoGuardadaDatabase.class, "Info").allowMainThreadQueries().build();

        buttonGuardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InfoGuardada ig = new InfoGuardada();
                        ig.setComentario(description.getText().toString());
                        ig.setInfoSelected(spinner.getSelectedItem().toString());
                        db.InfoDao().saveInfo(ig);
                    }
                });
        lig = db.InfoDao().loadInfo();
        ArrayAdapter adapter1 = new ArrayAdapter<InfoGuardada>(this,R.layout.listview,lig);

        buttonMostrar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lig = db.InfoDao().loadInfo();
                        adapter1.notifyDataSetChanged();
                        System.out.println(lig);

                    }
                });
        listView.setAdapter(adapter1);
    }
}