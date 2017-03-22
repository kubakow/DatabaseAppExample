package com.example.rent.databaseappexample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by RENT on 2017-03-22.
 */
@DatabaseTable(tableName = "tasks")
public class Task {


    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false)
    private String title;

    @DatabaseField
    private String dateCreated;


    public Task(String title) {
        this.title = title;
    }
    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
