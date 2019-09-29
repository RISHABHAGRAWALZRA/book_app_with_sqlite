package com.example.bookapplication;

import java.util.ArrayList;

public class Utility {

    private static ArrayList<book> currentlyReadingBooks;
    private static ArrayList<book> wantToReadBooks;
    private static ArrayList<book> AllBooks;
    private static ArrayList<book> alreadyReadBooks;

    private static int id = 0;

    public Utility() {
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<book>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<book>();
        }
        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<book>();
        }
        if (AllBooks == null) {
            AllBooks = new ArrayList<book>();

            initializeAllBooks();
        }
    }


    public static void initializeAllBooks() {


        String name = "";
        String imgUrl = "";
        String pages = "";
        String description = "";
        Double price = 0.0;
        String author;

        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
        name = "The Adventures of Huckleberry Finn";
        author = "Mark Twain";
        pages = "1750";
        price = 70.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51fnDjjQGjL._SX311_BO1,204,203,200_.jpg";
        description = "A young boy and a slave in 19th-century Louisiana " +
                "must find their way home — with only the Mississippi " +
                "River for a guide. This slender book by Mark Twain’s is so " +
                "well-regarded that it’s said by many to be The Great American Novel. ";

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
        name = " The Alchemist";
        author = "Paulo Coelho";
        pages = "1950";
        price = 90.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51Z0nLAfLmL.jpg";
        description = "Written in only two weeks, " +
                "The Alchemist has sold more than two million copies" +
                " worldwide — and the magical story of Santiago’s journey " +
                "to the pyramids of Egypt continues to enchant readers worldwide. A dreamy triumph. ";

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
        name = "  Aesop’s Fables ";
        author = "Aesop";
        pages = "2250";
        price = 120.5;
        imgUrl = "https://images-na.ssl-images-amazon.com/images/I/51wpnFHJQxL.jpg";
        description = "This enduring collection of tales was passed " +
                "down through oral tradition more than two millennia " +
                "ago. More than simple stories, Aesop’s stories reflect every aspect of human nature.";

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


        id++;
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

        AllBooks.add(new book(name, imgUrl, pages, description, price, author, id));


    }

    public static ArrayList<book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<book> getAllBooks() {
        return AllBooks;
    }

    public static ArrayList<book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static Boolean addCurrentlyReadingBooks(book b) {
        return currentlyReadingBooks.add(b);
    }

    public static Boolean addalreadyReadBooks(book b) {
        return alreadyReadBooks.add(b);
    }

    public static Boolean addwantToReadBooks(book b) {
        return wantToReadBooks.add(b);
    }

    public static Boolean addAllBooks(book b) {
        return AllBooks.add(b);
    }

    public static Boolean removeAllBooks(book e) {
        return AllBooks.remove(e);
    }

    public static Boolean removecurrentlyReadingBooks(book e) {
        return currentlyReadingBooks.remove(e);
    }

    public static Boolean removewantToReadBooks(book e) {
        return wantToReadBooks.remove(e);
    }

    public static Boolean removealreadyReadBooks(book e) {
        return alreadyReadBooks.remove(e);
    }

}
