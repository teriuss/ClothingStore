package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_page);

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
    public void  openNewCard(View view){
        Intent intent4 = new Intent(this,NewPage.class);
        startActivity(intent4);
    }
}