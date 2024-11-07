/*
    Урок с двумя вариантами списка:
        с одиночным и множественным выделением
 */
package com.example.study43;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        // устанавливаем режим выбора пунктов списка
//        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //1-ый вариант (одиночное выделение)
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //2-ый вариант (множественное выделение)
        // Создаем адаптер, используя массив из файла ресурсов
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names,
                android.R.layout.simple_list_item_single_choice);
        lvMain.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);
    }

    //1-ый вариант (одиночное выделение)
//    public void onClick(View arg0) {
//        // пишем в лог выделенный элемент
//        Log.d(LOG_TAG, "checked: " + names[lvMain.getCheckedItemPosition()]);
//    }
    //2-ый вариант (множественное выделение)
    public void onClick(View arg0) {
        // пишем в лог выделенные элементы
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }
}