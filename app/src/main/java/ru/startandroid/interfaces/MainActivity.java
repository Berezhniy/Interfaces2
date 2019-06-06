package ru.startandroid.interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainContract.Listener {
    //меин активити имплементирует листенер меин контракта

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // иказал куда передаётся фрагмент
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, MainFragment.newInstance())
                // передаю в активити меин (через айдишник) меин фрагмент
                .commit();
    }

    @Override
    public void openSecondActivities() {
        Intent intent = new Intent(this, SecondActivity.class);
        // передаю контекст из меин активити в секонд активити
        startActivity(intent);
        // стартую активность
    }
}
