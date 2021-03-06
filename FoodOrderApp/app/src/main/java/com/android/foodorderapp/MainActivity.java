package com.android.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.foodorderapp.adapters.HistoryAdapter;
import com.android.foodorderapp.adapters.RestaurantListAdapter;
import com.android.foodorderapp.model.RestaurantModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestaurantListAdapter.RestaurantListClickListener {
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    RestaurantModel restaurantModel ;
    SearchView searchView ;
    RestaurantListAdapter restaurantListAdapter;
    private DatabaseReference mDatabase;
    List<RestaurantModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thay ?????i ti??u ????? b???ng m?? khi ch???y
        //https://xuanthulab.net/toolbar-actionbar-trong-lap-trinh-android.html

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Trang tr???");


        // ????y l?? d??? li???u json
//        List<RestaurantModel> restaurantModelList;
//        restaurantModelList = getRestaurantData();
//        restaurantListAdapter = new RestaurantListAdapter(restaurantModelList,this);
//        recyclerView = findViewById(R.id.recyclerView);
//        restaurantListAdapter = new RestaurantListAdapter(getRestaurantData(),this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(restaurantListAdapter);

        recyclerView = findViewById(R.id.recyclerView);

        mDatabase = FirebaseDatabase.getInstance().getReference("restaurant");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        RestaurantModel user = ds.getValue(RestaurantModel.class);
                        list.add(user);
                    }
                }

                restaurantListAdapter= new RestaurantListAdapter(list, MainActivity.this);
                recyclerView.setAdapter(restaurantListAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        //View flipper l??m ch???y qu???ng cao tr??n trang tr???
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        // t???o ra  thanh bottom navigation view
        bottomNavigation();


    }

    // khai b??o m???t v??ng  RecylerView
    //RecyclerView l?? phi??n b???n ListView n??ng cao v?? linh ho???t h??n
    private void initRecyclerView(List<RestaurantModel> restaurantModelList) {
        // khai b??o bi???n reyclerview trong giao di???n
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // b???t s??? ki???n
        RestaurantListAdapter adapter = new RestaurantListAdapter(restaurantModelList, this);
        // ?????t thu???c t??nh adapter ????
        recyclerView.setAdapter(adapter);

        //


    }

    // l???y file ?????c file json
    // RestaurantListAdapter g??n v??o m???ng
    // chuy???n file json th??nh 1 danh s??ch m???ng
    private List<RestaurantModel> getRestaurantData() {
        // ?????c t???p json b???t k??? th?? m???c th?? n??o
        //InputStream l?? m???t l???p n???m trong package java.io, n?? l?? m???t l???p c?? s??? ?????i di???n cho m???t d??ng ch???y c???a
        // c??c bytes (stream of bytes) c?? ???????c khi ?????c m???t ngu???n d??? li???u n??o ????, ch???ng h???n file.
        InputStream is = getResources().openRawResource(R.raw.restaurent);
        // l???p Writer c???a g??i java.io l?? m???t l???p cha tr???u t?????ng ?????i di???n cho m???t d??ng k?? t???.
        // StringWriter l?? m???t l???p con c???a Writer, n?? qu???n l?? m???t ?????i t?????ng StringBuffer. C??c k?? t??? ???????c
        //ghi v??o StringWriter s??? ???????c n???i (append) v??o ?????i t?????ng StringBuffer m?? n?? ??ang qu???n l??.
        Writer writer = new StringWriter();
        // t???o buffer size
        char[] buffer = new char[1024];
        try {
            // l???p Reader c???a g??i java.io l?? m???t l???p cha tr???u t?????ng ?????i di???n cho m???t d??ng k?? t???.
            //BufferedReader l?? m???t l???p Java ????? ?????c v??n b???n t??? lu???ng ?????u v??o
            // (nh?? t???p) b???ng c??ch ?????m v?? ?????c li???n m???ch c??c k?? t???, m???ng ho???c d??ng.
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            // kh??ng c???n nh??n c??ng ???? hi???u l?? n?? ??ang l??m action g??
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {

        }

        // ?????c json
        String jsonStr = writer.toString();
        // khai gson
        Gson gson = new Gson();
        // ?????c n??
        RestaurantModel[] restaurantModels = gson.fromJson(jsonStr, RestaurantModel[].class);

        //  Tr??? v??? danh s??ch m???ng
        // danh s??ch c?? d???ng ?????i t?????ng nh?? h??ng v?? danh s??ch nh?? h??ng
        // chuy???n ?????i khu v???c m???ng
        // chuy???n ?????i m?? h??nh nh?? h??ng th??nh d???ng danh s??ch
        List<RestaurantModel> restList = Arrays.asList(restaurantModels);

        return restList;

    }

    // b???t s??? ki???n click v??o c???a h??ng chuyen qua meny
    @Override
    public void onItemClick(RestaurantModel restaurantModel) {
        // khi click v??o nh?? h??ng hi???n th??? menu
        Intent intent = new Intent(MainActivity.this, RestaurantMenuActivity.class);
        // th??ng qua m?? h??nh nh?? h??ng ????? hi???n th??? d??? li???u
        intent.putExtra("RestaurantModel", restaurantModel);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                restaurantListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return  true;

    }


    //  b???t s??? ki???n hi???n th??? m??n h??nh trong thanh bottomnavigation
    private void bottomNavigation() {

        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profile);
        LinearLayout historyBtn = findViewById(R.id.history);
        LinearLayout  notificationBtn = findViewById(R.id.setting);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HistoryActivity.class));
            }
        });
//        notificationBtn.setOnClickListener(new View.OnClickListener() {
//                                               @Override
//                                               public void onClick(View view) {
//                                                   startActivity(new Intent(MainActivity.this, NotificationActivity.class));
//                                               }
//                                           }
//        );
    }

}

