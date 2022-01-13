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

        // Thay đổi tiêu đề bằng mã khi chạy
        //https://xuanthulab.net/toolbar-actionbar-trong-lap-trinh-android.html

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Trang trủ");


        // đây là dữ liệu json
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





        //View flipper làm chạy quảng cao trên trang trủ
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        // tạo ra  thanh bottom navigation view
        bottomNavigation();


    }

    // khai báo một vòng  RecylerView
    //RecyclerView là phiên bản ListView nâng cao và linh hoạt hơn
    private void initRecyclerView(List<RestaurantModel> restaurantModelList) {
        // khai báo biến reyclerview trong giao diện
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // bắt sự kiện
        RestaurantListAdapter adapter = new RestaurantListAdapter(restaurantModelList, this);
        // đặt thuộc tính adapter đó
        recyclerView.setAdapter(adapter);

        //


    }

    // lấy file đọc file json
    // RestaurantListAdapter gán vào mảng
    // chuyển file json thành 1 danh sách mảng
    private List<RestaurantModel> getRestaurantData() {
        // đọc tệp json bất kỳ thư mục thô nào
        //InputStream là một lớp nằm trong package java.io, nó là một lớp cơ sở đại diện cho một dòng chảy của
        // các bytes (stream of bytes) có được khi đọc một nguồn dữ liệu nào đó, chẳng hạn file.
        InputStream is = getResources().openRawResource(R.raw.restaurent);
        // lớp Writer của gói java.io là một lớp cha trừu tượng đại diện cho một dòng ký tự.
        // StringWriter là một lớp con của Writer, nó quản lý một đối tượng StringBuffer. Các ký tự được
        //ghi vào StringWriter sẽ được nối (append) vào đối tượng StringBuffer mà nó đang quản lý.
        Writer writer = new StringWriter();
        // tạo buffer size
        char[] buffer = new char[1024];
        try {
            // lớp Reader của gói java.io là một lớp cha trừu tượng đại diện cho một dòng ký tự.
            //BufferedReader là một lớp Java để đọc văn bản từ luồng đầu vào
            // (như tệp) bằng cách đệm và đọc liền mạch các ký tự, mảng hoặc dòng.
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            // không cần nhìn cũng đã hiểu là nó đang làm action gì
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {

        }

        // đọc json
        String jsonStr = writer.toString();
        // khai gson
        Gson gson = new Gson();
        // đọc nó
        RestaurantModel[] restaurantModels = gson.fromJson(jsonStr, RestaurantModel[].class);

        //  Trả về danh sách mảng
        // danh sách có dạng đối tượng nhà hàng và danh sách nhà hàng
        // chuyển đổi khu vực mảng
        // chuyển đổi mô hình nhà hàng thành dạng danh sách
        List<RestaurantModel> restList = Arrays.asList(restaurantModels);

        return restList;

    }

    // bắt sự kiện click vào cửa hàng chuyen qua meny
    @Override
    public void onItemClick(RestaurantModel restaurantModel) {
        // khi click vào nhà hàng hiển thị menu
        Intent intent = new Intent(MainActivity.this, RestaurantMenuActivity.class);
        // thông qua mô hình nhà hàng để hiển thị dữ liệu
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


    //  bắt sự kiện hiển thị màn hình trong thanh bottomnavigation
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

