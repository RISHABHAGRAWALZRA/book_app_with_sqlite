package com.example.bookapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION=1;
    private final static String DATABASE_NAME="Books";

    public SQLite(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTable0= "CREATE TABLE AllBooks (_id integer Primary Key Autoincrement ,name text, imgurl text, pages text, description text, price double, author text)";
        db.execSQL(sqlTable0);

        String sqlTable1= "CREATE TABLE currentlyReadingBooks (_id integer Primary Key Autoincrement ,name text, imgurl text, pages text, description text, price double, author text)";
        db.execSQL(sqlTable1);

        String sqlTable2= "CREATE TABLE wantToReadBooks (_id integer Primary Key Autoincrement ,name text, imgurl text, pages text, description text, price double, author text)";
        db.execSQL(sqlTable2);

        String sqlTable3= "CREATE TABLE alreadyReadBook (_id integer Primary Key Autoincrement ,name text, imgurl text, pages text, description text, price double, author text)";
        db.execSQL(sqlTable3);

        initiateDATA(db);
    }

    public void initiateDATA(SQLiteDatabase db){

        String name = "";
        String imgUrl = "";
        String pages = "";
        String description = "";
        Double price = 0.0;
        String author;





        ContentValues contentValues0= new ContentValues();
        name = "1984";
        author = "George Orwell";
        pages = "1550";
        price = 50.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/41JXbM1R40L.jpg";
        description = "Set in 1984, Winston Smith must overcome a " +
                "frightening enemy: an omniscient government with an agenda. " +
                "This is the book that became a standard-bearer for dystopian fiction " +
                "and introduced Big Brother into our everyday vocabulary. Perhaps the " +
                "mightiest of George Orwell’s works.";
        //contentValues0.put("_id",0);
        contentValues0.put("name",name);
        contentValues0.put("imgurl",imgUrl);
        contentValues0.put("author",author);
        contentValues0.put("pages",pages);
        contentValues0.put("description",description);
        contentValues0.put("price",price);
        db.insert("AllBooks",null,contentValues0);



        ContentValues contentValues1= new ContentValues();
        name = "The Adventures of Huckleberry Finn";
        author = "Mark Twain";
        pages = "1750";
        price = 70.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51fnDjjQGjL._SX311_BO1,204,203,200_.jpg";
        description = "A young boy and a slave in 19th-century Louisiana " +
                "must find their way home — with only the Mississippi " +
                "River for a guide. This slender book by Mark Twain’s is so " +
                "well-regarded that it’s said by many to be The Great American Novel. ";

        contentValues1.put("name",name);
        contentValues1.put("imgurl",imgUrl);
        contentValues1.put("author",author);
        contentValues1.put("pages",pages);
        contentValues1.put("description",description);
        contentValues1.put("price",price);
        db.insert("AllBooks",null,contentValues1);



        ContentValues contentValues2= new ContentValues();
        name = " The Adventures of Sherlock Holmes";
        author = "Arthur Conan Doyle";
        pages = "1850";
        price = 80.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51bSUpX5QXL.jpg";
        description = "In 1891, Sir Arthur Conan Doyle published " +
                "“A Scandal in Bohemia,” the first short story to " +
                "feature Sherlock Holmes. Sharp and engrossing, this " +
                "collection shows how exactly Sherlock Holmes became a cultural " +
                "phenomenon and the most recognizable detective of all time.";
        contentValues2.put("name",name);
        contentValues2.put("imgurl",imgUrl);
        contentValues2.put("author",author);
        contentValues2.put("pages",pages);
        contentValues2.put("description",description);
        contentValues2.put("price",price);
        db.insert("AllBooks",null,contentValues2);



        ContentValues contentValues3= new ContentValues();
        name = " The Alchemist";
        author = "Paulo Coelho";
        pages = "1950";
        price = 90.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51Z0nLAfLmL.jpg";
        description = "Written in only two weeks, " +
                "The Alchemist has sold more than two million copies" +
                " worldwide — and the magical story of Santiago’s journey " +
                "to the pyramids of Egypt continues to enchant readers worldwide. A dreamy triumph. ";

        contentValues3.put("name",name);
        contentValues3.put("imgurl",imgUrl);
        contentValues3.put("author",author);
        contentValues3.put("pages",pages);
        contentValues3.put("description",description);
        contentValues3.put("price",price);
        db.insert("AllBooks",null,contentValues3);




        ContentValues contentValues4= new ContentValues();
        name = "  The Aleph and Other Stories ";
        author = "Jorge Luis Borges";
        pages = "2050";
        price = 100.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/518XLVWcEHL._SX322_BO1,204,203,200_.jpg";
        description = "Jorge Luis Borges’ keen insight and philosophical " +
                "wisdom is on full display in this acclaimed short story " +
                "collection. From “The Immortal” to “The House of Asterion,” " +
                "the stories within are glittering, haunting examples of worlds " +
                "created by a master of magic realism. ";

        contentValues4.put("name",name);
        contentValues4.put("imgurl",imgUrl);
        contentValues4.put("author",author);
        contentValues4.put("pages",pages);
        contentValues4.put("description",description);
        contentValues4.put("price",price);
        db.insert("AllBooks",null,contentValues4);




        ContentValues contentValues5= new ContentValues();
        name = "  Animal Farm  ";
        author = "George Orwell";
        pages = "2150";
        price = 110.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51xxFek7H8L.jpg";
        description = "When Old Major the boar dies on Manor " +
                "Farm, two young pigs named Snowball and Napoleon " +
                "rise to create new leadership in this allegorical " +
                "book that is supposed to mirror the Russian Revolution " +
                "of 1917 — and the ensuing Stalinist Soviet Union. A stunning " +
                "achievement, and not just because Orwell proved that a story " +
                "about pigs can be terrifying. ";

        contentValues5.put("name",name);
        contentValues5.put("imgurl",imgUrl);
        contentValues5.put("author",author);
        contentValues5.put("pages",pages);
        contentValues5.put("description",description);
        contentValues5.put("price",price);
        db.insert("AllBooks",null,contentValues5);




        ContentValues contentValues6= new ContentValues();
        name = "  Aesop’s Fables ";
        author = "Aesop";
        pages = "2250";
        price = 120.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51wpnFHJQxL.jpg";
        description = "This enduring collection of tales was passed " +
                "down through oral tradition more than two millennia " +
                "ago. More than simple stories, Aesop’s stories reflect every aspect of human nature.";

        contentValues6.put("name",name);
        contentValues6.put("imgurl",imgUrl);
        contentValues6.put("author",author);
        contentValues6.put("pages",pages);
        contentValues6.put("description",description);
        contentValues6.put("price",price);
        db.insert("AllBooks",null,contentValues6);




        ContentValues contentValues7= new ContentValues();
        name = " Alice’s Adventures in Wonderland";
        author = "Lewis Carroll";
        pages = "2350";
        price = 130.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/516GSmQmqPL._SX346_BO1,204,203,200_.jpg";
        description = "Alice is only a young seven-year old girl " +
                "when she notices a White Rabbit with a pocket watch " +
                "running by. Thus begins Alice’s adventures in a land that " +
                "is not all that it seems. Lewis Carroll published this novel " +
                "in 1865, sending it down the rabbit hole and straight into the " +
                "hallowed halls of children’s most treasured literature.";

        contentValues7.put("name",name);
        contentValues7.put("imgurl",imgUrl);
        contentValues7.put("author",author);
        contentValues7.put("pages",pages);
        contentValues7.put("description",description);
        contentValues7.put("price",price);
        db.insert("AllBooks",null,contentValues7);




        ContentValues contentValues8= new ContentValues();
        name = "  Anna Karenina";
        author = "Leo Tolstoy";
        pages = "2450";
        price = 140.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51j1lkQWmtL.jpg";
        description = "If you like lengthy books in which to immerse yourself," +
                " then this is a real treat. This epic novel tells the parallel " +
                "stories of Anna Karenina and Konstantin Levin over a span " +
                "of 800+ pages — dealing with social change, politics, theology," +
                " and philosophy in nineteenth-century Russia all the while.";

        contentValues8.put("name",name);
        contentValues8.put("imgurl",imgUrl);
        contentValues8.put("author",author);
        contentValues8.put("pages",pages);
        contentValues8.put("description",description);
        contentValues8.put("price",price);
        db.insert("AllBooks",null,contentValues8);




        ContentValues contentValues9= new ContentValues();
        name = "  Anne of the Green Gables";
        author = " L.M. Montgomery";
        pages = "2550";
        price = 150.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51X09FpauIL._SX331_BO1,204,203,200_.jpg";
        description = "To read Anne of the Green Gables is to fall in love with " +
                "its characters — particularly its protagonist, a fiery young " +
                "girl with an imagination the size of castles. From coming-of-age " +
                "arcs to the occasional drunken episode, this beloved classic by " +
                "L.M. Montgomery has it all: laughs, pain, and heart. ";

        contentValues9.put("name",name);
        contentValues9.put("imgurl",imgUrl);
        contentValues9.put("author",author);
        contentValues9.put("pages",pages);
        contentValues9.put("description",description);
        contentValues9.put("price",price);
        db.insert("AllBooks",null,contentValues9);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(SQLiteDatabase db, String tableName, int ID){

        Cursor cursor=db.query("AllBooks",null,
                       "_id=?",new String[]{String.valueOf(ID)},null,null,null);

        if (cursor.moveToFirst()){
            ContentValues contentValues=new ContentValues();
            contentValues.put("_id",Integer.valueOf(cursor.getString(0)));
            contentValues.put("name",cursor.getString(1));
            contentValues.put("imgurl",cursor.getString(2));
            contentValues.put("author",cursor.getString(6));
            contentValues.put("pages",cursor.getString(3));
            contentValues.put("description",cursor.getString(4));
            contentValues.put("price",cursor.getString(5));
            db.insert(tableName,null,contentValues);
        }

    }

    public void delete(SQLiteDatabase db, String tableName, int ID){
        db.delete(tableName,"_id=?",new String[]{String.valueOf(ID)});
    }
}
