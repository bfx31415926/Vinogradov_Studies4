/*
 Урок с двумя вариантами адаптера:
    с android.R.layout.simple_list_item_1 и с R.layout.my_list_item
 */
package com.example.study42;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей", "Иван", "Марья",
            "Петр", "Антон", "Даша", "Борис",  "Костя", "Игорь", "Анна",
            "Денис", "Андрей" };

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер

        //Первый вариант с дефолтным R.layout.simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        //Второй вариант с кастомным R.layout.simple_list_item_1
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.my_list_item, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

    }
}