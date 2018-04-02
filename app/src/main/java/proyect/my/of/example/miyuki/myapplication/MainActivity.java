package proyect.my.of.example.miyuki.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AdpaterListview adpaterListview;
    SearchView searchView;

    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList = new ArrayList<String>();
        arrayList.add("Lion");
        arrayList.add("Tiger");
        arrayList.add("Monkey");
        arrayList.add("Rat");

        listView = findViewById(R.id.listID);


        adpaterListview = new AdpaterListview(arrayList, this);
        listView.setAdapter(adpaterListview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Snackbar.make(view,arrayList.get(position),Snackbar.LENGTH_LONG).show();
            }
        });

        searchView = findViewById(R.id.searchID);
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adpaterListview.filter(text);
                return false;
            }
        });



    }
}

