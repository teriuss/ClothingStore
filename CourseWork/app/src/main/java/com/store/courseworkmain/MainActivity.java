package com.store.courseworkmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.store.courseworkmain.adapter.CategoryAdapter;
import com.store.courseworkmain.adapter.CourseAdapter;
import com.store.courseworkmain.model.Category;
import com.store.courseworkmain.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static  CourseAdapter courseAdapter;//что бы у нас сохранились
    // значения что для courseAdapter,что для courseList мы их указываем как static
    static  List<Course> courseList = new ArrayList<>();
    static  List<Course> fullcoursesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Весна"));
        categoryList.add(new Category(2,"Лето"));
        categoryList.add(new Category(3,"Осень"));
        categoryList.add(new Category(4,"Зима"));
        categoryList.add(new Category(5,"Акции"));

        setCategoryRecycler(categoryList);






        courseList.add(new Course(1,"image8","Cет от Bershka","Bershka","10800 сом","#D2DCF0",1));
        courseList.add(new Course(2,"image9","Весна от Zara","Zara","8800 сом","#D2555F",1));
        courseList.add(new Course(3,"image10","Лето от Pull and Bear","Pull and Bear"," от 8800 сом","#6E6A8B",2));
        courseList.add(new Course(4,"image11","Осень от Bershka","Bershka"," по 3300 сом","#436E78",3));

        fullcoursesList.addAll(courseList);//здесь мы получаем отдельный список из всех элементов которые у нас есть

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);//настраиваем на горизонтальное отображение

        courseRecycler = findViewById(R.id.courseRecycler);//устанавливаем ссылку на нужный объект из дизайна
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter (this , courseList);//
        courseRecycler.setAdapter(courseAdapter);// устанавливаем адаптер на(categoryRecycler)

    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);//настраиваем на горизонтальное отображение

        categoryRecycler = findViewById(R.id.categoryRecycler);//устанавливаем ссылку на нужный объект из дизайна
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this , categoryList);//
        categoryRecycler.setAdapter(categoryAdapter);// устанавливаем адаптер на(categoryRecycler)
    }

    public  void  openShoppingCard(View view){//переход на новую страницу
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }
    public void  openCatalogCard(View view){
        Intent intent2 = new Intent(this,CatalogPage.class);
        startActivity(intent2);
    }
    public void  openBrandCard(View view){
        Intent intent3 = new Intent(this,BrandPage.class);
        startActivity(intent3);
    }
    public void  openNewCard(View view){
        Intent intent4 = new Intent(this,NewPage.class);
        startActivity(intent4);
    }



    public   static  void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullcoursesList);


        List<Course> filterCourses = new ArrayList<>();
        for (Course c: courseList){//здесь мы перебираем список со всеми продуктами что у нас есть иесди категория определенного объекта будет совпадать с той категорией которая передается то мы эти продукты доавляем в новый список
            if(c.getCategory()==category)
                filterCourses.add(c);
        }
        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();//обновляет MainActivity и показывает нам определенный список товаров по категориям

    }
}