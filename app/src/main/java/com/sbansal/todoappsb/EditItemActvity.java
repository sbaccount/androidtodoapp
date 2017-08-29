package com.sbansal.todoappsb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActvity extends AppCompatActivity {

    private int pos;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item_actvity);

        EditText etEditItems = (EditText) findViewById(R.id.etEditItems);
        pos = getIntent().getIntExtra("itemPos", 1);
        etEditItems.setText(getIntent().getStringExtra("item"));
    }

    public void onSubmit(View v) {
        EditText etEditItems = (EditText) findViewById(R.id.etEditItems);
        String editedString = etEditItems.getText().toString();
        if(editedString.length() >0) {
            Intent i = new Intent();
            i.putExtra("item", editedString);
            i.putExtra("itemPos", pos);
            setResult(RESULT_OK, i);
            finish();
        }
        else {
            Toast.makeText(this, "Error: Empty Text", Toast.LENGTH_SHORT).show();
        }
    }
}
