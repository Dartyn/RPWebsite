package sg.edu.rp.c346.rpwebsite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCat;
    Spinner spnSubCat;
    Button btnload;

    ArrayList<String> alSubCategory = new ArrayList<String>();
    ArrayAdapter<String> aaSubCategory;

    //int count == 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spnCat = (Spinner) findViewById(R.id.spinnerCategory);
        spnSubCat = (Spinner) findViewById(R.id.spinnerSubCategory);
        btnload = (Button) findViewById(R.id.buttonLoad);

        aaSubCategory = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, alSubCategory);

        spnSubCat.setAdapter(aaSubCategory);

        int pos = spnCat.getSelectedItemPosition();
        alSubCategory.clear();
        if(pos == 0){
            String[] strNumbers = getResources().getStringArray(R.array.rp);
            alSubCategory.addAll(Arrays.asList(strNumbers));
        }
        else {
            String[] strNumbers = getResources().getStringArray(R.array.soi);
            alSubCategory.addAll(Arrays.asList(strNumbers));
        }
        aaSubCategory.notifyDataSetChanged();

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*int pos = spnCat.getSelectedItemPosition();
                alSubCategory.clear();
                if(pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.rp);
                    alSubCategory.addAll(Arrays.asList(strNumbers));
                }
                else {
                    String[] strNumbers = getResources().getStringArray(R.array.soi);
                    alSubCategory.addAll(Arrays.asList(strNumbers));
                }
                aaSubCategory.notifyDataSetChanged();
                */
                String url = null;

                if (spnCat.getSelectedItemPosition() == 0){
                    if(spnSubCat.getSelectedItemPosition() == 0){
                        url = "http://www.rp.edu.sg/";
                    }
                    else if(spnSubCat.getSelectedItemPosition() == 1){
                        url = "http://www.rp.edu.sg/The_Republic_Code_of_Honour.aspx";
                    }

                }else if(spnCat.getSelectedItemPosition() == 1){
                    if(spnSubCat.getSelectedItemPosition() == 0){
                        url = "http://www.rp.edu.sg/Diploma_in_Mobile_Software_Development_(R47).aspx";
                    }
                    else if (spnSubCat.getSelectedItemPosition() == 1){
                        url = "http://www.rp.edu.sg/Diploma_in_Information_Technology_(R12).aspx";
                    }
                }
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }

        });
    }
}
