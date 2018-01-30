package com.bojue.homy.view.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.view.fragment.community.CommunityFragment;
import com.bojue.homy.view.fragment.home.HomeFragment;
import com.bojue.homy.view.fragment.publish.PublishFragment;
import com.bojue.homy.view.fragment.person.PersonFragment;
import com.bojue.homy.view.fragment.find.FindNeedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Main界面
 */
public class MainActivity extends BaseActivity implements MainView{

    private RadioGroup rgBottom;
    private FragmentTabHost tabHost;
    private Class[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SDKInitializer.initialize(getApplicationContext());
        initView();
        List<String> permissionList = new ArrayList<>();
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String[] permissons = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissons,1);
        }else{
            initData();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0){
                    for(int result : grantResults){
                        if(result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"必须同意所有权限才能使用本程序",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    initData();
                }else{
                    Toast.makeText(this,"发生错误",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    private void initView() {
        rgBottom = findViewById(R.id.rgBottom);
        tabHost = findViewById(R.id.tabHost);

    }

    private void initData() {
        fragments = new Class[]{HomeFragment.class, FindNeedFragment.class,
                PublishFragment.class, CommunityFragment.class, PersonFragment.class};

        tabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.flContent);
        for (int i = 0; i < fragments.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));
            tabHost.addTab(tabSpec, fragments[i], null);
        }

        tabHost.setCurrentTab(0);

           rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbHome:
                        tabHost.setCurrentTab(0);
                        break;
                    case R.id.rbSearch:
                        tabHost.setCurrentTab(1);
                        break;
                    case R.id.rbPublish:
                        tabHost.setCurrentTab(2);
                        break;
                    case R.id.rbCommunity:
                        tabHost.setCurrentTab(3);
                        break;
                    case R.id.rbPerson:
                        tabHost.setCurrentTab(4);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
