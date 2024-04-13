package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Vraj Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Smit Soni","Hospital Address:Baroda","Exp : 5yrs","Mobile Number:123456779","1200"},
                    {"Doctor Name : Rishabh Soni","Hospital Address:Ahmedabad","Exp : 4yrs","Mobile Number:122456789","5000"},
                    {"Doctor Name : Ansh Patel","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Jiya Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : Vraj Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Smit Soni","Hospital Address:Baroda","Exp : 5yrs","Mobile Number:123456779","1200"},
                    {"Doctor Name : Rishabh Soni","Hospital Address:Ahmedabad","Exp : 4yrs","Mobile Number:122456789","5000"},
                    {"Doctor Name : Ansh Patel","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Jiya Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name : Vraj Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Smit Soni","Hospital Address:Baroda","Exp : 5yrs","Mobile Number:123456779","1200"},
                    {"Doctor Name : Rishabh Soni","Hospital Address:Ahmedabad","Exp : 4yrs","Mobile Number:122456789","5000"},
                    {"Doctor Name : Ansh Patel","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Jiya Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"}
            };

    private String[][] doctor_details4=
            {
                    {"Doctor Name : Vraj Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Smit Soni","Hospital Address:Baroda","Exp : 5yrs","Mobile Number:123456779","1200"},
                    {"Doctor Name : Rishabh Soni","Hospital Address:Ahmedabad","Exp : 4yrs","Mobile Number:122456789","5000"},
                    {"Doctor Name : Ansh Patel","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Jiya Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"}
            };

    private String[][] doctor_details5=
            {
                    {"Doctor Name : Vraj Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Smit Soni","Hospital Address:Baroda","Exp : 5yrs","Mobile Number:123456779","1200"},
                    {"Doctor Name : Rishabh Soni","Hospital Address:Ahmedabad","Exp : 4yrs","Mobile Number:122456789","5000"},
                    {"Doctor Name : Ansh Patel","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"},
                    {"Doctor Name : Jiya Chauhan","Hospital Address:Ahmedabad","Exp : 5yrs","Mobile Number:123456789","1000"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewHADTitle);
        btn=findViewById(R.id.buttonBMCartCheckout);

        Intent it= getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("Line 1", doctor_details[i][0]);
            item.put("Line 2", doctor_details[i][1]);
            item.put("Line 3", doctor_details[i][2]);
            item.put("Line 4", doctor_details[i][3]);
            item.put("Line 5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
    sa= new SimpleAdapter(this,list,
            R.layout.multi_lines,
            new String[]{"Line 1","Line 2","Line 3","Line 4","Line 5"},
            new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
            );

        ListView lst = findViewById(R.id.imageViewHAD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text 1",title);
                it.putExtra("text 2",doctor_details[i][0]);
                it.putExtra("text 3",doctor_details[i][1]);
                it.putExtra("text 4",doctor_details[i][3]);
                it.putExtra("text 5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}
