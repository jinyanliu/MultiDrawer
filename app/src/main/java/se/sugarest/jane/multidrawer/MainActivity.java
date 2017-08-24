package se.sugarest.jane.multidrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolBar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton mImageButtonLeft, mImageButtonRight;
    GridView mGridViewMain, mGridViewLeft, mGridViewRight;
    CustomAdapter mCustomAdapter;
    int img[];
    String name[];
    String j;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        mGridViewMain = (GridView) findViewById(R.id.main_grid);
        mGridViewLeft = (GridView) findViewById(R.id.drawer_left);
        mGridViewRight = (GridView) findViewById(R.id.drawer_right);
        mImageButtonLeft = (ImageButton) findViewById(R.id.img_Left);
        mImageButtonRight = (ImageButton) findViewById(R.id.img_Right);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mImageButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(mGridViewLeft)) {
                    mDrawerLayout.closeDrawer(mGridViewLeft);
                } else if (!mDrawerLayout.isDrawerOpen(mGridViewLeft)) {
                    mDrawerLayout.openDrawer(mGridViewLeft);
                }
                if (mDrawerLayout.isDrawerOpen(mGridViewRight)) {
                    mDrawerLayout.closeDrawer(mGridViewRight);
                }
            }
        });

        mImageButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(mGridViewRight)) {
                    mDrawerLayout.closeDrawer(mGridViewRight);
                } else if (!mDrawerLayout.isDrawerOpen(mGridViewRight)) {
                    mDrawerLayout.openDrawer(mGridViewRight);
                }
                if (mDrawerLayout.isDrawerOpen(mGridViewLeft)) {
                    mDrawerLayout.closeDrawer(mGridViewLeft);
                }

            }
        });

        getData();

    }

    public void getData() {
        j = "Cloud, Moon, Umbrella, Flower";
        name = j.split(",");
        img = new int[]{
                R.drawable.ic_one,
                R.drawable.ic_two,
                R.drawable.ic_three,
                R.drawable.ic_four};
        mCustomAdapter = new CustomAdapter(name, mContext, img);
        mGridViewMain.setAdapter(mCustomAdapter);
        mGridViewLeft.setAdapter(mCustomAdapter);
        mGridViewRight.setAdapter(mCustomAdapter);
    }
}
