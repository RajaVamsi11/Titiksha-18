package com.example.vamsi.my;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   /* private TextView personName;
    private TextView personPhone;
    private Button buttonAdd;
    private DatabaseReference databaseReference;
    private ListView listView;
    private ArrayList<String> mUserName = new ArrayList<>();
*/
   private BottomNavigationView mainNavView;
   private UpcomingFragment upcomingFragment;
   private ResultFragment resultFragment;
   private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        mainNavView = findViewById(R.id.mainNavView);
        toolbar.getBackground().setAlpha(0);
       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("");


        upcomingFragment = new UpcomingFragment();
        resultFragment = new ResultFragment();

        replaceFragment(upcomingFragment);
        mainNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.upcoming_id:
                        replaceFragment(upcomingFragment);
                        return  true;
                    case R.id.results_id:
                        replaceFragment(resultFragment);
                        return true;
                        default:
                            return false;
                }

            }
        });

    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.gallery_id:
                Toast.makeText(this, "I am Gallery", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_id:
                startActivity(new Intent(MainActivity.this,AboutTitikshaActicity.class));
                break;
            case R.id.contact_id:
                startActivity(new Intent(MainActivity.this,ContactUsActivity.class));
                break;
                default:
                    return true;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}











































/*
        personName = findViewById(R.id.editTextName);
        personPhone = findViewById(R.id.editTextPhone);
        buttonAdd = findViewById(R.id.buttonAdd);

        databaseReference = FirebaseDatabase.getInstance().getReference("persons");
        listView = findViewById(R.id.listView);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPerson();

            }
        });

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUserName);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                String value = dataSnapshot.getValue(String.class);
                String ans = key+" : " +value;
                mUserName.add(ans);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void addPerson(){
        String name = personName.getText().toString().trim();
        String phone = personPhone.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)){

          databaseReference.child(name).setValue(phone);
            Toast.makeText(this, "Person added", Toast.LENGTH_SHORT).show();


        }else {
            Toast.makeText(this, "Enter Name and PhoneNumber", Toast.LENGTH_SHORT).show();
        }*/
