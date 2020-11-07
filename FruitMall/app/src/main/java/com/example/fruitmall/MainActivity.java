package com.example.fruitmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item2,fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getPreSent(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_page.class);
                startActivity(intent);
            }
        });
    }

    private  void initFruits(){
            Fruit apple = new Fruit(R.drawable.apple_pic,"苹果");
            fruitList.add(apple);
            Fruit banana = new Fruit(R.drawable.banana_pic,"香蕉");
            fruitList.add(banana);
            Fruit cherry = new Fruit(R.drawable.cherry_pic,"樱桃");
            fruitList.add(cherry);
            Fruit grape = new Fruit(R.drawable.grape_pic,"葡萄");
            fruitList.add(grape);
            Fruit mango = new Fruit(R.drawable.mango_pic,"芒果");
            fruitList.add(mango);
            Fruit orange = new Fruit(R.drawable.orange_pic,"橘子");
            fruitList.add(orange);
            Fruit pear = new Fruit(R.drawable.pear_pic,"梨子");
            fruitList.add(pear);
            Fruit pineapple = new Fruit(R.drawable.pineapple_pic,"菠萝");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(R.drawable.strawberry_pic,"草莓");
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit(R.drawable.watermelon_pic,"西瓜");
            fruitList.add(watermelon);
    }
}