package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.store.courseworkmain.model.Course;
import com.store.courseworkmain.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list= findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullcoursesList){//здесь мы перебираем каждый элемент и если id этого элемента существует в списке которая пренадлежит к карзине то мы название этого элемента будем перебирать в список (coursesTtitle) а потом это список и будем выводить
            if (Order.item_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());

        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,coursesTitle));
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
    public void  openNewCard(View view){
        Intent intent4 = new Intent(this,NewPage.class);
        startActivity(intent4);
    }
}