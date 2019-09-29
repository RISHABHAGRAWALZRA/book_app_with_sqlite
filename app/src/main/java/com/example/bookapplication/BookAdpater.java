package com.example.bookapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdpater extends RecyclerView.Adapter<BookAdpater.ViewHolder> {

    private Context context;
    private String type;
    private Utility util = new Utility();

    public void setType(String type) {
        this.type = type;
    }

    public BookAdpater(Context context, ArrayList<book> books) {
        this.context = context;
        this.books = books;
    }

    ArrayList<book> books;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.Bknm.setText(books.get(position).getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookdscrpActivity.class);
                intent.putExtra("BookId", books.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final String name = books.get(position).getName();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("You want to delete this book from this category");
                builder.setTitle("Error");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                switch (type) {
                    case "want":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                util.removewantToReadBooks(books.get(position));
                                notifyDataSetChanged();
                                Toast.makeText(context, name + " is deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case "current":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                util.removecurrentlyReadingBooks(books.get(position));
                                notifyDataSetChanged();
                                Toast.makeText(context, name + " is deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case "already":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                util.removealreadyReadBooks(books.get(position));
                                notifyDataSetChanged();
                                Toast.makeText(context, name + " is deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
                builder.create().show();
                return true;
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImgUrl())
                .into(holder.bkimg);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Bknm;
        ImageView bkimg;
        LinearLayout card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Bknm = itemView.findViewById(R.id.Bknm);
            bkimg = itemView.findViewById(R.id.bkimg);
            card = itemView.findViewById(R.id.card);
        }
    }
}
