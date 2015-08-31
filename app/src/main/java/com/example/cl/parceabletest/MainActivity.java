package com.example.cl.parceabletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(20);
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("person_data",person);
        startActivity(intent);
    }
}
