package com.example.language;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_mob, tv_email;
    TextView tv_fix_name, tv_fix_mobile, tv_fix_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = findViewById(R.id.tv_name);
        tv_mob = findViewById(R.id.tv_mobile);
        tv_email = findViewById(R.id.tv_email);
        tv_fix_name = findViewById(R.id.tv_fix_name);
        tv_fix_mobile = findViewById(R.id.tv_fix_mobile);
        tv_fix_email = findViewById(R.id.tv_fix_email);

        tv_fix_name.setText(R.string.name);
        tv_fix_mobile.setText(R.string.mob);
        tv_fix_email.setText(R.string.email);

        tv_name.setText("Hardik");
        tv_mob.setText("8401293964");
        tv_email.setText("patelhardik94271@gmail.com");

        initToolbar();
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_eng:
                setLocale("en");
                break;

            case R.id.menu_guj:
                setLocale("gu");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
