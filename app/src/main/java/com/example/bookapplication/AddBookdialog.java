package com.example.bookapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddBookdialog extends DialogFragment {

    EditText name,author,pages,description,price,img;
    Button ok,cancel;

    private static SQLite sqLite=Utility.getSqLite();
    private static SQLiteDatabase db=Utility.getDb();

    interface addNewBook{
        void onAdd();
    }

    private addNewBook addNewBook;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.addingbook_layout,null);
        initiateViews(view);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(view);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book book=new book();
                book.setName(name.getText().toString());
                book.setDescription(description.getText().toString());
                book.setPages(pages.getText().toString());
                book.setAuthor(author.getText().toString());
                book.setImgUrl(img.getText().toString());
                book.setPrice(Double.valueOf(price.getText().toString()));
                book.setId(Utility.id);


                ContentValues contentValues=new ContentValues();
                contentValues.put("name",book.getName());
                contentValues.put("author",book.getAuthor());
                contentValues.put("pages",book.getPages());
                contentValues.put("description",book.getDescription());
                contentValues.put("price",book.getPrice());
                contentValues.put("imgurl",book.getImgUrl());
                db.insert("AllBooks",null,contentValues);


                try {
                    addNewBook=(addNewBook)getActivity();
                    addNewBook.onAdd();
                    dismiss();

                }catch (ClassCastException e){
                    e.printStackTrace();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }

    public void initiateViews(View view){
        name=view.findViewById(R.id.edtxtnm);
        author=view.findViewById(R.id.edtxtauh);
        pages=view.findViewById(R.id.edtxtpg);
        description=view.findViewById(R.id.edtxtdsp);
        price=view.findViewById(R.id.edtxtpr);
        img=view.findViewById(R.id.edtxtimg);
        ok=view.findViewById(R.id.ok);
        cancel=view.findViewById(R.id.cnl);
    }
}
