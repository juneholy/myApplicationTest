package com.example.houlinjiang.myapplicationtest.sqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

/**
 * Created by houlin.jiang on 2016/1/7.
 */
public class SQLiteActivity extends AppCompatActivity {
    private TextView tv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_activity);
        tv = (TextView) findViewById(R.id.tv_sql_log);
        lv = (ListView) findViewById(R.id.lv_table);
        ContentResolver resolver = getContentResolver();

        SQLiteDatabase db = openOrCreateDatabase("myfriend.db", Context.MODE_PRIVATE,null);
        try {
            db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");
            Person person = new Person("holy", true, 18);
            db.execSQL("INSERT INTO person VALUES (NULL, ?, ?)", new Object[]{person.name, person.age});

            person.name = "david";
            person.age = 33;
            //ContentValues以键值对的形式存放数据
            ContentValues cv = new ContentValues();
            cv.put("name", person.name);
            cv.put("age", person.age);
            //插入ContentValues中的数据
            db.insert("person", null, cv);

            cv = new ContentValues();
            cv.put("age", 35);
            //更新数据
            db.update("person", cv, "name = ?", new String[]{"john"});

            Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"33"});
            while (c.moveToNext()) {
                int _id = c.getInt(c.getColumnIndex("_id"));
                String name = c.getString(c.getColumnIndex("name"));
                int age = c.getInt(c.getColumnIndex("age"));
                tv.setText("_id=>" + _id + ", name=>" + name + ", age=>" + age);
            }
            c.close();
        }catch (Exception e) {
            Log.d("sql",e.toString());
        }

        //关闭当前数据库
        db.close();
    }



}
