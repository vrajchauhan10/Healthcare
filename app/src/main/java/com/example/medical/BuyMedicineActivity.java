package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule","","","","500"},
                    {"Uprise-Vraj 1000IU Capsule","","","","74"},
                    {"Uprise-Smit 1000IU Capsule","","","","740"},
                    {"Uprise-D3 100IU Capsule","","","","55"},
                    {"Uprise-D3 10IU Capsule","","","","74"},
                    {"Uprise-D3  Capsule","","","","544"},
                    {"Uprise-D3 Brand Capsule","","","","545"},
                    {"Uprise-D3 1U Capsule","","","","574"},
                    {"Uprise-D3 Capsule","","","","588"}
            };
    private String[] package_details = {
            "Building and Keeping the bones and teeth strong \n"+
                    "reducing Stress and Muscular pain\n"+
                    "Boosting Emunity and increasing resistance against infection",
            "Chromium is an essantial For the body",
            "Provides Relief from vitamin B\n"+
                    "Helps in formation of red blood cells\n"+
                    "Maintain healty system",
            "It promots health benifts\n"+
                    "It helps reduce skin Blemesh\n"+
                    "It act as safe guard",
            "Dolo 650 tablet helps in relive pain",
            "Help relive fever\n"+
                    "Suitable for people heart condition",
            "relives from bacterial throat\n"+
                    "provides a warm feeling",
            "Reduces risk of calcium\n"+
                    "promotes Flexibility",
            "Helps to reduce the iron deficiency"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.imageViewHAD);
        btnBack=findViewById(R.id.buttonHADBack);
        btnGoToCart=findViewById(R.id.buttonBMCartCheckout);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("Line 1", packages[i][0]);
            item.put("Line 2", packages[i][1]);
            item.put("Line 3", packages[i][2]);
            item.put("Line 4", packages[i][3]);
            item.put("Line 5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line 1","Line 2","Line 3","Line 4","Line 5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("Text 1",packages[i][0]);
                it.putExtra("Text 2",package_details[i]);
                it.putExtra("Text 3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}