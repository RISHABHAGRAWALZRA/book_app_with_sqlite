package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnsrh, btn1, btn2, btn3;
    TextView txtara;

    SQLiteDatabase db;
    SQLite sqLite;
    Cursor cursor0;
    Cursor cursor1;
    Cursor cursor2;
    Cursor cursor3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsrh = findViewById(R.id.btnsrh);
        btn1 = findViewById(R.id.btnwant);
        btn2 = findViewById(R.id.btncurrent);
        btn3 = findViewById(R.id.btnalready);
        txtara = findViewById(R.id.txtara);

        Utility.context=MainActivity.this;
        Utility.initalizeDATABASE();

        DatabaseAsyncTask databaseAsyncTask=new DatabaseAsyncTask();
        databaseAsyncTask.execute();


        btnsrh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BooksSrch.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bookwantread.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bookcurrentlyreading.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookAlreadyread.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        db.close();
        cursor0.close();
        cursor1.close();
        cursor2.close();
        cursor3.close();

    }

    public class DatabaseAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
             sqLite=Utility.getSqLite();
             db=Utility.getDb();
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                cursor0 =db.query("AllBooks",null,null,null,null,null,null);
                ArrayList<book> AllBooks=new ArrayList<>();
                if(cursor0.moveToFirst()){
                    for(int i=0;i<cursor0.getCount();i++){
                        book book =new book();
                        for(int j=0;j<cursor0.getColumnCount();j++){
                            switch (cursor0.getColumnName(j)){
                                case "name":
                                    book.setName(cursor0.getString(j));
                                    break;
                                case "_id":
                                    book.setId(cursor0.getInt(j));
                                    break;
                                case "imgurl":
                                    book.setImgUrl(cursor0.getString(j));
                                    break;
                                case "author":
                                    book.setAuthor(cursor0.getString(j));
                                    break;
                                case  "pages":
                                    book.setPages(cursor0.getString(j));
                                    break;
                                case "description":
                                    book.setDescription(cursor0.getString(j));
                                    break;
                                case "price":
                                    book.setPrice(cursor0.getDouble(j));
                                    break;
                                default:
                                    break;
                            }
                        }
                        AllBooks.add(book);
                        cursor0.moveToNext();
                    }
                    Utility.setAllBooks(AllBooks);
                }


                cursor1 =db.query("currentlyReadingBooks",null,null,null,null,null,null);
                ArrayList<book> currentlyReadingBooks=new ArrayList<>();
                if(cursor1.moveToFirst()){
                    for(int i=0;i<cursor1.getCount();i++){
                        book book =new book();
                        for(int j=0;j<cursor1.getColumnCount();j++){
                            switch (cursor1.getColumnName(j)){
                                case "name":
                                    book.setName(cursor1.getString(j));
                                    break;
                                case "_id":
                                    book.setId(cursor1.getInt(j));
                                    break;
                                case "imgurl":
                                    book.setImgUrl(cursor1.getString(j));
                                    break;
                                case "author":
                                    book.setAuthor(cursor1.getString(j));
                                    break;
                                case  "pages":
                                    book.setPages(cursor1.getString(j));
                                    break;
                                case "description":
                                    book.setDescription(cursor1.getString(j));
                                    break;
                                case "price":
                                    book.setPrice(cursor1.getDouble(j));
                                    break;
                                default:
                                    break;
                            }
                        }
                        currentlyReadingBooks.add(book);
                        cursor1.moveToNext();
                    }
                }
                Utility.setCurrentlyReadingBooks(currentlyReadingBooks);


                cursor2 =db.query("wantToReadBooks",null,null,null,null,null,null);
                ArrayList<book> wantToReadBooks=new ArrayList<>();
                if(cursor2.moveToFirst()){
                    for(int i=0;i<cursor2.getCount();i++){
                        book book =new book();
                        for(int j=0;j<cursor2.getColumnCount();j++){
                            switch (cursor2.getColumnName(j)){
                                case "name":
                                    book.setName(cursor2.getString(j));
                                    break;
                                case "_id":
                                    book.setId(cursor2.getInt(j));
                                    break;
                                case "imgurl":
                                    book.setImgUrl(cursor2.getString(j));
                                    break;
                                case "author":
                                    book.setAuthor(cursor2.getString(j));
                                    break;
                                case  "pages":
                                    book.setPages(cursor2.getString(j));
                                    break;
                                case "description":
                                    book.setDescription(cursor2.getString(j));
                                    break;
                                case "price":
                                    book.setPrice(cursor2.getDouble(j));
                                    break;
                                default:
                                    break;
                            }
                        }
                        wantToReadBooks.add(book);
                        cursor2.moveToNext();
                    }
                }
                Utility.setWantToReadBooks(wantToReadBooks);


                cursor3 =db.query("alreadyReadBook",null,null,null,null,null,null);
                ArrayList<book> alreadyReadBook=new ArrayList<>();
                if(cursor3.moveToFirst()){
                    for(int i=0;i<cursor3.getCount();i++){
                        book book =new book();
                        for(int j=0;j<cursor3.getColumnCount();j++){
                            switch (cursor3.getColumnName(j)){
                                case "name":
                                    book.setName(cursor3.getString(j));
                                    break;
                                case "_id":
                                    book.setId(cursor3.getInt(j));
                                    break;
                                case "imgurl":
                                    book.setImgUrl(cursor3.getString(j));
                                    break;
                                case "author":
                                    book.setAuthor(cursor3.getString(j));
                                    break;
                                case  "pages":
                                    book.setPages(cursor3.getString(j));
                                    break;
                                case "description":
                                    book.setDescription(cursor3.getString(j));
                                    break;
                                case "price":
                                    book.setPrice(cursor3.getDouble(j));
                                    break;
                                default:
                                    break;
                            }
                        }
                        alreadyReadBook.add(book);
                        cursor3.moveToNext();
                    }
                }
                Utility.setAlreadyReadBooks(alreadyReadBook);


            }catch (SQLException e){
                e.printStackTrace();
            }

            return "DatabaseSet";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }


}
