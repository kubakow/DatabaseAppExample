package com.example.rent.databaseappexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by RENT on 2017-03-22.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String databaseName = "orm.baza";
    private static final int databaseVersion = 1;
    private Dao<Task, Long> dao;

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Task.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Task.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Dao<Task, Long> getTaskDao() {
        if (dao == null){
            try {
                dao = getDao(Task.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
        return dao;

    }
}
