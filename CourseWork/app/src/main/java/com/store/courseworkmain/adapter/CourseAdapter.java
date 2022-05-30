package com.store.courseworkmain.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.store.courseworkmain.CoursePage;
import com.store.courseworkmain.R;
import com.store.courseworkmain.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List <Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {// в (onCreateViewHolder) мы указываем конкретный дмзайн
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);//здесь я говорю что  для всех обьектов я передаю определенный дизайн  и с какими именно элементами я буду работать
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {// в (onBindViewHolder) мы указываем что конретно мы будем подставлять в сам дизайн
        holder.courseColor.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));//устанавливаем цвет фона


        int courseImage= context.getResources().getIdentifier(courses.get(position).getImg(), "drawable",context.getPackageName());
        holder.courseImage.setImageResource(courseImage);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseCost.setText(courses.get(position).getCost());
        holder.courseBrand.setText(courses.get(position).getBrand());






        holder.itemView.setOnClickListener(new View.OnClickListener() {// Переход на другую страницу
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CoursePage.class);

                intent.putExtra("courseColor",Color.parseColor(courses.get(position).getColor()));//все это нужно что бы при нажатии на кнопку мы переходили на определенную другую странницу с уже ранее веденными данными
                intent.putExtra("courseImg",courseImage);
                intent.putExtra("courseTitle",courses.get(position).getTitle());
                intent.putExtra("courseCost",courses.get(position).getCost());
                intent.putExtra("courseBrand",courses.get(position).getBrand());
                intent.putExtra("courseId",courses.get(position).getId());

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static  final  class  CourseViewHolder extends  RecyclerView.ViewHolder{// в (CourseViewHolder) мы указываем с какими элементами  в дизайне мы будем работать

        CardView courseColor;
        ImageView courseImage;
        TextView courseTitle,courseBrand,courseCost;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseColor=itemView.findViewById(R.id.courseColor);
            courseImage=itemView.findViewById(R.id.courseImage);
            courseTitle=itemView.findViewById(R.id.courseTitle);
            courseBrand=itemView.findViewById(R.id.courseBrand);
            courseCost=itemView.findViewById(R.id.courseCost);

        }
    }

}
