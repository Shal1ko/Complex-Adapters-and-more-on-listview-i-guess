package com.shal1ko.proekti2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ListView list1;
    List<User> list= new ArrayList<>();
    LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button1);
        list1 = findViewById(R.id.list1);
        layout1 = findViewById(R.id.layout1);


//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LayoutInflater l = getLayoutInflater();
//                View item = l.inflate(R.layout.layout2, layout1, false);
//                TextView tt = (TextView) item;
//                tt.setText("გამარჯობა");
//                layout1.addView(tt);
//            }
//        });

        userAdapter adapter = new userAdapter(getApplicationContext(),list);
        list1.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new User("გიორგი",44));
                list.add(new User("Benjamin",41));
                list.add(new User("Tomas",64));

                adapter.notifyDataSetChanged();

            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                list.remove(position);

                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }
}