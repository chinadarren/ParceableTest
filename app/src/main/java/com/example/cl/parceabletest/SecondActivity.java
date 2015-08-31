package com.example.cl.parceabletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by cl on 2015/8/31.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.return_view);
        button.setOnClickListener(this);
        //调用 getParcelableExtra()方法来获 取传递过来的对象
        Person person = (Person) getIntent().getSerializableExtra("person_data");
        //使用接收toast也报错
        //  Toast.makeText(getApplicationContext(),person.getName(),Toast.LENGTH_SHORT).show();
        //使用接收log会报错
        //  Log.d(SecondActivity.ACTIVITY_SERVICE,person.getName());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
