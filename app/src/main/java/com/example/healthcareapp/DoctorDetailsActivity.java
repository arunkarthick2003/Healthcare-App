package com.example.healthcareapp;

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
    private String[][] doctor_details1={
            {"Doctor Name: Arunachalam","Hospital Address: Tuticorin","Exp: 10years","Mobile No: 7650919696","600"},
            {"Doctor Name: Subbiah","Hospital Address: Chennai","Exp: 20years","Mobile No: 9587425896","800"},
            {"Doctor Name: Ramesh","Hospital Address: Tirunelveli","Exp: 5years","Mobile No: 6358954545","500"},
            {"Doctor Name: Meera Joseph","Hospital Address: Kochi","Exp: 10years","Mobile No: 9689548485","700"},
            {"Doctor Name: Raghuvaran","Hospital Address: Trichy","Exp: 15years","Mobile No: 8059687526","500"}
    };
    private String[][] doctor_details2={
            {"Doctor Name: Karthick","Hospital Address: Tuticorin","Exp: 10years","Mobile No: 9686596953","600"},
            {"Doctor Name: Soundarajan","Hospital Address: Chennai","Exp: 15years","Mobile No: 8528596325","600"},
            {"Doctor Name: Kamalesh","Hospital Address: Bangalore","Exp: 10years","Mobile No: 6358256326","800"},
            {"Doctor Name: Andrew","Hospital Address: Mangalore","Exp: 5years","Mobile No: 8080581563","600"},
            {"Doctor Name: Joey Tribbiani","Hospital Address: Vijayawada","Exp: 10years","Mobile No: 7536985214","800"}
    };
    private String[][] doctor_details3={
            {"Doctor Name: Chandler Bing","Hospital Address: Chennai","Exp: 5years","Mobile No: 7650919695","400"},
            {"Doctor Name: Ross Geller","Hospital Address: Chennai","Exp: 5years","Mobile No: 9856235698","800"},
            {"Doctor Name: Monica Geller","Hospital Address: Mumbai","Exp: 10years","Mobile No: 8052635689","800"},
            {"Doctor Name: Phoebe Buffay","Hospital Address: Mumbai","Exp: 5years","Mobile No: 8052334569","500"},
            {"Doctor Name: Rachel Green","Hospital Address: Chennai","Exp: 5years","Mobile No: 8052364589",""}
    };
    private String[][] doctor_details4={
            {"Doctor Name: Sherlock","Hospital Address: Madurai","Exp: 25years","Mobile No: 8520369854","600"},
            {"Doctor Name: David","Hospital Address:  Coimbatore","Exp: 30years","Mobile No: 8026548569","800"},
            {"Doctor Name: Watson","Hospital Address: Chennai","Exp: 18years","Mobile No: 8052635987","1000"},
            {"Doctor Name: Adithya","Hospital Address: Hyderabad","Exp: 10years","Mobile No: 7598625896","700"},
            {"Doctor Name: Ansal","Hospital Address: Tuticorin","Exp: 12years","Mobile No: 9568942586","600"}
    };
    private String[][] doctor_details5={
            {"Doctor Name: Aldrin","Hospital Address: Chennai","Exp: 5years","Mobile No: 7650919698","600"},
            {"Doctor Name: Ritu","Hospital Address: Pune","Exp: 10years","Mobile No: 8650523689","500"},
            {"Doctor Name: Deepak","Hospital Address: Mangalore","Exp: 10years","Mobile No: 9597589635","1000"},
            {"Doctor Name: Amritha","Hospital Address: Chennai","Exp: 10years","Mobile No: 8052639856","700"},
            {"Doctor Name: Karthikeya","Hospital Address: Trichy","Exp: 15years","Mobile No: 8985684256","800"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0){
            doctor_details=doctor_details1;
        }else if(title.compareTo("Dietician")==0){
            doctor_details=doctor_details2;
        }else if(title.compareTo("Dentist")==0){
            doctor_details=doctor_details3;
        }else if(title.compareTo("Surgeon")==0){
            doctor_details=doctor_details4;
        }else{
            doctor_details=doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[position][0]);
                it.putExtra("text3",doctor_details[position][1]);
                it.putExtra("text4",doctor_details[position][3]);
                it.putExtra("text5",doctor_details[position][4]);
                startActivity(it);
            }
        });
    }
}