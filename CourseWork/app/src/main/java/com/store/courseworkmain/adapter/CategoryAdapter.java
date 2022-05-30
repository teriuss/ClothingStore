package com.store.courseworkmain.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.store.courseworkmain.MainActivity;
import com.store.courseworkmain.R;
import com.store.courseworkmain.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    Context context;//здесь мы передаем контекст
    List<Category> categories;//передаем список всех элементов которые должны быть выведены



    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(categoryItems);//здесь я говорю что  для всех обьектов я передаю определенный дизайн
        // и с какими именно элементами я буду работать
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {// здесь    мы создаем объект на основе вложенного класса
        holder.categoryTitle.setText(categories.get(position).getTitle());// дальше через этот объект мы обращаемся к нужным нам полям(categoryTitle) и устанавляваем текст для этого поля

        holder.itemView.setOnClickListener(new View.OnClickListener() {//Здесь я устанавливаю кнопки для распределения по категориям
            @Override
            public void onClick(View view) {
                MainActivity.showCoursesByCategory(categories.get(position).getId());//при нажатии на определенную категорию(кнопку) мы будем передовать Id той категории на которую нажали


            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public  static final class CategoryViewHolder extends  RecyclerView.ViewHolder{

        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);//здесь я указываю ссылку на нужный объект из дизайна
        }
    }
}
