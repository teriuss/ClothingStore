package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BrandPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_page);
    }
    public  void  openShoppingCard(View view){//переход на новую страницу
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }
    public void  openCatalogCard(View view){
        Intent intent2 = new Intent(this,CatalogPage.class);
        startActivity(intent2);
    }
    public void  openHomeCard(View view){
        Intent intent5 = new Intent(this,MainActivity.class);
        startActivity(intent5);
    }
    public void  openNewCard(View view){
        Intent intent4 = new Intent(this,NewPage.class);
        startActivity(intent4);
    }
}