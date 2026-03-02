package com.example.dbtestmvp;



import android.app.Application;
import com.example.dbtestmvp.di.AppComponent;
import com.example.dbtestmvp.di.DaggerAppComponent;
import com.example.dbtestmvp.di.DatabaseModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}