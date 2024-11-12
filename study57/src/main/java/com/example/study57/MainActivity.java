package com.example.study57;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
        gvMain = (GridView) findViewById(R.id.gvMain);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }


    private void adjustGridView() {
    /* 2-й вариант
        gvMain.setNumColumns(3);
     */
    /* 3-й вариант
        gvMain.setNumColumns(GridView.AUTO_FIT);
     */
    /* 4-й вариант
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(150);
     */
    /* 5-й вариант
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(150);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
     */
    /* 6-й вариант
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(300);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.NO_STRETCH);
     */
    /* 7-й вариант (STRETCH_COLUMN_WIDTH
//    – свободное пространство используется столбцами,
//    это режим по умолчанию)
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(300);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
     */
    /* 8-й вариант (STRETCH_SPACING)
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(300);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_SPACING);
     */
//    /* 9-й вариант (STRETCH_SPACING_UNIFORM)
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(300);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
//     */
    }
}