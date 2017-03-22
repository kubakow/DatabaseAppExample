package com.example.rent.databaseappexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    private Dao<Task, Long> dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this);
        dao = dbHelper.getTaskDao();

        dbHelper.onUpgrade(dbHelper.getWritableDatabase(), 0, 0);
        try {
            testOrmLite();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void testOrmLite() throws SQLException{
        Log.d("test", "test");
        Task newTask = new Task("Notatka 1");
        dao.create(newTask);
        dao.create(new Task("Notatka 2"));
        List<Task> allTasks = dao.queryForAll();
        for (Task task: allTasks) {
            Log.d("Tag", task.toString());
        }
    }

}
