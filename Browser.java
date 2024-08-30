package com.example.personalassistantmanagementapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    EditText editText;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_browser);

        editText=findViewById(R.id.search);
        btnSearch=findViewById(R.id.btnsearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
              String term = editText.getText().toString();
              intent.putExtra(SearchManager.QUERY,term);
              startActivity(intent);
            }
        });
    }

}