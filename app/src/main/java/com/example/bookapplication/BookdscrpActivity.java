package com.example.bookapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookdscrpActivity extends AppCompatActivity {

    TextView txtbknm, txtbkarh, txtpg, txtpr, txtdsp;
    ImageView imgbk;
    Button want, already, currrent;
    private book c;

    private SQLite sqLite=Utility.getSqLite();
    private SQLiteDatabase db=Utility.getDb();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btnbookdscrp_activity);

        txtbknm = findViewById(R.id.txtbknm);
        txtbkarh = findViewById(R.id.txtarh);
        txtpg = findViewById(R.id.txtpg);
        txtpr = findViewById(R.id.txtpr);
        txtdsp = findViewById(R.id.txtdsp);
        imgbk = findViewById(R.id.imgbk);

        want = findViewById(R.id.btnwant);
        currrent = findViewById(R.id.btncurrent);
        already = findViewById(R.id.btnalready);


        Intent intent = getIntent();
        int id = intent.getIntExtra("BookId", 0);




        ArrayList<book> books = Utility.getAllBooks();
        final ArrayList<book> cbook =Utility.getCurrentlyReadingBooks();
        final ArrayList<book> wbook =Utility.getWantToReadBooks();
        final ArrayList<book> abook =Utility.getAlreadyReadBooks();


        for (book b : books) {
            if (b.getId() == id) {
                c = b;
                txtbknm.setText(b.getName());
                txtbkarh.setText(b.getAuthor());
                txtpg.setText("Pages : " + b.getPages());
                txtpr.setText("Rs " + b.getPrice());
                txtdsp.setText("Description : " + b.getDescription());

                Glide.with(this)
                        .asBitmap()
                        .load(b.getImgUrl())
                        .into(imgbk);
            }
        }


        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (wbook.contains(c)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);

                    builder.setMessage("You already added this book to your want to read books category");

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);

                    builder.setMessage("Is you want to add this book in want to read books category");

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Utility.addwantToReadBooks(c);
                            sqLite.insert(db,"wantToReadBooks",c.getId());
                            Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(BookdscrpActivity.this, "Not Added", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setCancelable(false);
                    builder.create().show();
                }

            }
        });

        currrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cbook.contains(c)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                    builder.setMessage("You already added this book to currently reading category");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    if (wbook.contains(c)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                        builder.setMessage("You want to read this book. Have you started reading this book?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Utility.addCurrentlyReadingBooks(c);
                                Utility.removewantToReadBooks(c);
                                sqLite.insert(db,"currentlyReadingBooks",c.getId());
                                sqLite.delete(db,"wantToReadBooks",c.getId());
                                Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BookdscrpActivity.this, "Not Added", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setCancelable(false);
                        builder.create().show();

                    } else if (abook.contains(c)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                        builder.setMessage("You already read this book. Is you want read it Again");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Utility.addCurrentlyReadingBooks(c);
                                Utility.removealreadyReadBooks(c);
                                sqLite.delete(db,"alreadyReadBook",c.getId());
                                sqLite.insert(db,"currentlyReadingBooks",c.getId());
                                Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BookdscrpActivity.this, "Not Added", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setCancelable(false);
                        builder.create().show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);

                        builder.setMessage("Is you want to add this book in current reading books category");

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Utility.addCurrentlyReadingBooks(c);
                                sqLite.insert(db,"currentlyReadingBooks",c.getId());
                                Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BookdscrpActivity.this, "Not Added", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setCancelable(false);
                        builder.create().show();
                    }
                }

            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (abook.contains(c)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                    builder.setMessage("You already added this book to already read books category");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    if (cbook.contains(c)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                        builder.setMessage("Have you complete reading this book?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Utility.removecurrentlyReadingBooks(c);
                                Utility.addalreadyReadBooks(c);
                                sqLite.insert(db,"alreadyReadBook",c.getId());
                                sqLite.delete(db,"currentlyReadingBooks",c.getId());
                                Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BookdscrpActivity.this, "Not added", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setCancelable(false);
                        builder.create().show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(BookdscrpActivity.this);
                        builder.setMessage("Have you read this book?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Utility.addalreadyReadBooks(c);
                                sqLite.insert(db,"alreadyReadBook",c.getId());
                                Toast.makeText(BookdscrpActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BookdscrpActivity.this, "Not added", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setCancelable(false);
                        builder.create().show();
                    }
                }

            }
        });


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
