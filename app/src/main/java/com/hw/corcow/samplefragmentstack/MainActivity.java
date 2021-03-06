package com.hw.corcow.samplefragmentstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment[] list = {StackFragment.newInstance("one"),
            StackFragment.newInstance("two"),
            StackFragment.newInstance(("three"))};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {       // 정상적으로 실행됬다면
            getSupportFragmentManager().beginTransaction().add(R.id.container, StackFragment.newInstance("base")).commit();

        }

        Button btn;
        btn = (Button)findViewById(R.id.btn_prev);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        });
        btn = (Button)findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getSupportFragmentManager().getBackStackEntryCount();           // 백스택에 몇개가 쌓여있는지 알 수 있음
                if (count<list.length) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, list[count])
                            .addToBackStack(null)
                            .commit();
                } else {
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });
    }
}
