package com.paul.testannotation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("name","paul");
                intent.putExtra("age",19);

                intent.putExtra("person",new Person("zhangsan",20));

                Person[] persons = new Person[2];
                persons[0] = new Person("zhangsan1",20);
                persons[1] = new Person("zhangsan2",21);
                intent.putExtra("persons",persons);

                PersonPer personPer = new PersonPer();
                personPer.name = "zhangsan3";
                personPer.age  = 11;
                intent.putExtra("personPer",personPer);

                PersonPer[] personPers = new PersonPer[2];
                personPers[0] = personPer;

                PersonPer personPer2 = new PersonPer();
                personPer2.name = "zhangsan4";
                personPer2.age  = 12;
                personPers[1] = personPer2;

                intent.putExtra("personsPer",personPers);


                startActivity(intent);
            }
        });
    }
}
