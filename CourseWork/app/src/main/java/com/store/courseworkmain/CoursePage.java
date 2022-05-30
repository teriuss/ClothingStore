package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.store.courseworkmain.model.Order;

public class CoursePage extends AppCompatActivity {
    EditText wishes;
    Button sendWishes1;
    Button sendWishes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        init();
        clickListener();


        ConstraintLayout courseColor = findViewById(R.id.coursePageColor);// находим все объекты из xml файлаи присваиваем им переменные с которыми мы будем работать в дальнейшем
        ImageView courseImage = findViewById(R.id.coursePageImg);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseBrand = findViewById(R.id.coursePageBrand);
        TextView courseCost = findViewById(R.id.coursePageCost);


        courseColor.setBackgroundColor(getIntent().getIntExtra("courseColor", 0));//и в эти объекты мы подставляем различные значения описанные ранее
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseBrand.setText(getIntent().getStringExtra("courseBrand"));
        courseCost.setText(getIntent().getStringExtra("courseCost"));

    }
    public void init() {
        wishes = findViewById(R.id.et_my_wishes_to_astronavt);
        sendWishes1 = findViewById(R.id.btn_send);
        sendWishes2 = findViewById(R.id.btn_send);
    }
    public void  clickListener(){
        sendWishes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendWishes1.setVisibility(View.INVISIBLE);
                wishes.setVisibility(View.VISIBLE);
                wishes.setCursorVisible(true);
                sendWishes2.setVisibility(View.VISIBLE);
            }
        });
        sendWishes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT,wishes.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finish", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CoursePage.this, "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void  addToCard(View view) {
        int item_id=getIntent().getIntExtra("courseId",0);
        Order.item_id.add(item_id);
        Toast.makeText(this,"Товар добавлен в избранное!", Toast.LENGTH_LONG).show();

    }

}