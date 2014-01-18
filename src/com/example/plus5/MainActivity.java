package com.example.plus5;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.plus5.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void setConfigurations(View view) {
    	Intent intent = new Intent(this, Home.class);
    	EditText destination = (EditText) findViewById(R.id.editText1);
    	EditText travelTime = (EditText) findViewById(R.id.EditText2);
    	EditText school = (EditText) findViewById(R.id.EditText01);
    	
    	String toSend = destination.getText().toString() + "-" 
    			+ travelTime.getText().toString() + "-" 
    			+ school.getText().toString();
    	
    	intent.putExtra(EXTRA_MESSAGE, toSend);
    	startActivity(intent);
    	
    }

    
}
