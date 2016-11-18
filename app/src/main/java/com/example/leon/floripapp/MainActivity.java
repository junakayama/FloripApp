package com.example.leon.floripapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] pontos ={"Lugar1","Lugar2","Lugar3"};
        ListView lista = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pontos);
        lista.setAdapter(adapter);
    }

  /*  public void sendMessage(View view){
//        Intent intent = new Intent(this,DisplayMessageActivity.class);
//        EditText editText =(EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE,message);
//
//        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(this,MapsActivity.class);
//        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);

    }*/
}
