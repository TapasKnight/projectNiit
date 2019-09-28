package com.example.check.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.check.Adapters.CardViewAdapter;
import com.example.check.Adapters.RecyclerViewAdapter;
import com.example.check.Models.Book;
import com.example.check.Models.Music;
import com.example.check.R;

import java.util.ArrayList;
import java.util.List;


public class BookFragment extends Fragment {

    View b;
    List<Book> lstBook;
    private RecyclerView myRecyclerView;


    public BookFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        b =  inflater.inflate(R.layout.fragment_book, container, false);
        myRecyclerView = (RecyclerView) b.findViewById(R.id.recyclerview_book);
        CardViewAdapter cardViewAdapter = new CardViewAdapter(getContext(),lstBook);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        myRecyclerView.setAdapter(cardViewAdapter);

        return b;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Haruki Murakami " +
                "(村上 春樹 Murakami Haruki, born January 12, 1949)" +
                " is a Japanese writer. His books and stories have been bestsellers in Japan as well as " +
                "internationally, with his work being translated into 50 languages[1] and selling millions" +
                " of copies outside his native country.[2][3] His work has received numerous awards, including " +
                "the World Fantasy Award, the Frank O'Connor International Short Story Award, the Franz Kafka " +
                "Prize, and the Jerusalem Prize." +
                "Murakami's most notable works include A Wild Sheep Chase (1982), Norwegian Wood (1987), " +
                "The Wind-Up Bird Chronicle (1994–95), Kafka on the Shore (2002), and 1Q84 (2009–10)." +
                " He has also translated into Japanese works by writers including Raymond Carver and J. D. Salinger. " +
                "His fiction, sometimes criticized by Japan's literary establishment as un-Japanese,[4][5] was " +
                "influenced by Western writers from Chandler to Vonnegut by way of Brautigan." +
                " It is frequently surrealistic and melancholic or fatalistic, marked by a Kafkaesque rendition " +
                "of the recurrent themes of alienation and loneliness[6] he weaves into his narratives. " +
                "Steven Poole of The Guardian praised Murakami " +
                "as among the world's greatest living novelists for his works and achievements","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Haruki Murakami " +
                "(村上 春樹 Murakami Haruki, born January 12, 1949)" +
                " is a Japanese writer. His books and stories have been bestsellers in Japan as well as " +
                "internationally, with his work being translated into 50 languages[1] and selling millions" +
                " of copies outside his native country.[2][3] His work has received numerous awards, including " +
                "the World Fantasy Award, the Frank O'Connor International Short","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.thewildrobot));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.themartian));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.hediedwith));
    }


}
