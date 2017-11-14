package com.algoguru.algoguru;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
 public  static String PACKAGE_NAME;
    public List<String> labels=new ArrayList<>();
   public List<String> complexity= new ArrayList<>();


    //String[] complexity={"Big oh!"};
    //String[] sorting={"Bubble Sort"};
    //String[] searching={"Linear Search"};
    public List<String> sorting= new ArrayList<>();
   public List<String> searching= new ArrayList<>();
  public  Map<String, List<String>> itemMap= new HashMap<>();


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME=getApplicationContext().getPackageName();
        labels.add("complexity");
        labels.add("sorting");
        labels.add("searching");
        complexity.add("Big O!");
        sorting.add("Bubble Sort");
        searching.add("Linear Search");
        itemMap.put(labels.get(0),complexity);
        itemMap.put(labels.get(1),sorting);
        itemMap.put(labels.get(2),searching);

        /*String[] mainMenuItems={"Complexity","Sort","Search"};
        ListAdapter mainMenuAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mainMenuItems);
        ListView mainMenuView=(ListView)findViewById(R.id.mainMenu);
        mainMenuView.setAdapter(mainMenuAdapter);*/

        expandableListView= (ExpandableListView) findViewById(R.id.mainMenu);
        expandableListAdapter = new MainMenuAdapter(this,labels,itemMap);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = new Intent(MainActivity.this,SliderPageActivity.class);
              // intent.putExtra("pages", 1);
                //intent.putExtra("titleName","Big Oh Theory");
                List<String> titleList= new ArrayList<>();
                String item=itemMap.get(labels.get(i)).get(i1);

                switch(item)
                {
                    case "Big O!": {titleList.clear();titleList.add("Big O! Theory") ; titleList.add("Quiz");
                                        intent.putExtra("pages", titleList.size());
                                         intent.putStringArrayListExtra("titleList", (ArrayList<String>) titleList);
                                        break;
                        }
                    case "Bubble Sort":{ titleList.clear();titleList.add("Bubble Sort Theory") ; titleList.add("Bubble Sort Explained"); titleList.add("Quiz");
                        intent.putExtra("pages", titleList.size());
                        intent.putStringArrayListExtra("titleList", (ArrayList<String>) titleList);
                        break;
                    }
                    case "Linear Search": { titleList.clear();titleList.add("Linear Search Theory") ; titleList.add("Linear Search Explained"); titleList.add("Quiz");
                        intent.putExtra("pages", titleList.size());
                        intent.putStringArrayListExtra("titleList", (ArrayList<String>) titleList);
                        break;
                    }

                }
                startActivity(intent);
                return false;
            }
        });

    }





   /* public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText;
        editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}
