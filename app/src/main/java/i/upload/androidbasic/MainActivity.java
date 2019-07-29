package i.upload.androidbasic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    List<MovieModel> movieModels = new ArrayList<>();
    MovieAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter =new MovieAdapter(context, movieModels);
        addData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv = (RecyclerView) findViewById(R.id.rv_movie);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);

    }

    private void addData(){
        String[] title = getResources().getStringArray(R.array.title);
        String[] image = getResources().getStringArray(R.array.image);
        for (int i = 0; i<title.length; i++){
            MovieModel movieModel = new MovieModel(title[i], image[i]);
            movieModels.add(movieModel);
        }

        adapter.notifyDataSetChanged();
    }
}
