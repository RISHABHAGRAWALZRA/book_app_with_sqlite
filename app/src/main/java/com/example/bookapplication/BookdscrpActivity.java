package com.example.bookapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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


        final Utility util = new Utility();

        ArrayList<book> books = util.getAllBooks();
        final ArrayList<book> cbook = util.getCurrentlyReadingBooks();
        final ArrayList<book> wbook = util.getWantToReadBooks();
        final ArrayList<book> abook = util.getAlreadyReadBooks();


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
                            util.addwantToReadBooks(c);
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
                                util.addCurrentlyReadingBooks(c);
                                util.removewantToReadBooks(c);
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
                                util.addCurrentlyReadingBooks(c);

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
                                util.addCurrentlyReadingBooks(c);
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
                                util.removecurrentlyReadingBooks(c);
                                util.addalreadyReadBooks(c);

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
                                util.addalreadyReadBooks(c);
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
