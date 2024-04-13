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

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Package 1 : Full Body CheckUp","","","","899"},
            {"Package 2 : Blood Glucose Fasting","","","","599"},
            {"Package 3 : Covid 19 Antibody - IgG","","","","399"},
            {"Package 4 : Thyroid Check ","","","","799"},
            {"Package 5 : Immunity Check","","","","299"}
    };

    private  String[] package_details = {
      "Blood Glucose Fasting\n" +
              "Complete Hemogram\n" +
              "HbA1c\n" +
              "Iron Studies\n" +
              "Kidney Function Test\n"+
              "LDH Lactate Dehydrogenase,Serum\n"+
              "Lipid Profile\n"+
              "Liver Function Test",
        "Blood Glucose Fasting",
        "Covid 19 Antibody - IgG",
        "Thyroid Profile-Total (T3,T4 and TSH Ultra-Sensitive)",
        "Complete Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative,Serum\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonBMCartCheckout);
        btnBack=findViewById(R.id.buttonHADBack);
        listView=findViewById(R.id.imageViewHAD);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("Line 1",packages[i][0]);
            item.put("Line 2",packages[i][1]);
            item.put("Line 3",packages[i][2]);
            item.put("Line 4",packages[i][3]);
            item.put("Line 5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"Line 1","Line 2","Line 3","Line 4","Line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("Text 1",packages[i][0]);
                it.putExtra("Text 2",package_details[i]);
                it.putExtra("Text 3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}