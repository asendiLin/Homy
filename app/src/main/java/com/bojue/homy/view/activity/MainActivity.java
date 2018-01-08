package com.bojue.homy.view.activity;

import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.view.fragment.CommunityFragment;
import com.bojue.homy.view.fragment.HomeFragment;
import com.bojue.homy.view.fragment.person.PersonFragment;
import com.bojue.homy.view.fragment.PublishFragment;
import com.bojue.homy.view.fragment.find.FindNeedFragment;

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

        initView();
        initData();
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
