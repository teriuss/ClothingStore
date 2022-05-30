package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);
    }
    public  void  openShoppingCard(View view){//переход на новую страницу
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }
    public void  openBrandCard(View view){
        Intent intent3 = new Intent(this,BrandPage.class);
        startActivity(intent3);
    }
    public void  openHomeCard(View view){
        Intent intent5 = new Intent(this,MainActivity.class);
        startActivity(intent5);
    }
    public void  openCatalogCard(View view){
        Intent intent2 = new Intent(this,CatalogPage.class);
        startActivity(intent2);
    }
}