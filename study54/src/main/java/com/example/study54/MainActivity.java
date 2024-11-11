/*
    ВАЖНЫЙ КОММЕНТАРИЙ:
    Поскольку с  12 версии андроида Toast по умолчанию выводит максимум две строки,
    пришлось применить SnackBar (внизу класса), первый параметр -
    любой View, по которому можно вычислить родителя (см. файл main.xml:
    здесь первым параметром в Snackbar.make() можно взять как список, так и кнопку)
 */
package com.example.study54;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends Activity {
    Snackbar mSnackbar;
    ListView lvMain;
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 1000,
                    R.drawable.pict124, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {

        String result = "Товары в корзине:";
        for (Product p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.name;
        }
//        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        mSnackbar = Snackbar.make(lvMain, result, Snackbar.LENGTH_LONG);
        View snackbarView = mSnackbar.getView();
        TextView snackTextView =
            (TextView) snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        snackTextView.setMaxLines(8);
        mSnackbar.show();
    }
}