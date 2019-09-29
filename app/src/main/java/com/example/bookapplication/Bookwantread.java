package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class Bookwantread extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookwantread);

        recyclerView = findViewById(R.id.reclvu);

        Utility util = new Utility();
        ArrayList<book> books = util.getWantToReadBooks();

        BookAdpater adpater = new BookAdpater(this, books);
        adpater.setType("want");
        recyclerView.setAdapter(adpater);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
