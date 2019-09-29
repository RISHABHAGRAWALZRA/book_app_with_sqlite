package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class BooksSrch extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rclevu);

        Utility util = new Utility();
        books = util.getAllBooks();

        BookAdpater adpater = new BookAdpater(this, books);
        recyclerView.setAdapter(adpater);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
