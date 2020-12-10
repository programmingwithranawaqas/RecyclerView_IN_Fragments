package com.wtechweb.v2_rv_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected{

    TextView tvName;
    TextView tvContact;

    EditText etName;
    EditText etContact;
    Button btnAdd;

    ListFrag listFrag;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        tvContact = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etTel);

        btnAdd  = findViewById(R.id.btnAdd);
        manager = this.getSupportFragmentManager();

        listFrag = (ListFrag) manager.findFragmentById(R.id.listFragment);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etContact.getText().toString().trim().isEmpty() ||
                etName.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Name or Contact is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    MyApplication.people.add(new Person(etName.getText().toString().trim(), etContact.getText().toString().trim()));
                    listFrag.dataChanged();
                    etName.setText("");
                    etContact.setText("");
                }
            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(MyApplication.people.get(index).getName());
        tvContact.setText(MyApplication.people.get(index).getContact());
    }
}