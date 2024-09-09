package com.astooltech.advancedview.finaldemo.liveo.interfaces;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.liveo.Model.HelpItem;
import com.astooltech.advancedview.finaldemo.liveo.Model.HelpLiveo;
import com.astooltech.advancedview.finaldemo.liveo.Model.Navigation;
import com.astooltech.advancedview.finaldemo.liveo.adapter.NavigationLiveoAdapter;
import com.astooltech.advancedview.finaldemo.liveo.navigationliveo.NavigationLiveo;
import com.astooltech.advancedview.finaldemo.liveo.navigationliveo.NavigationLiveoList;
import com.google.android.material.internal.ScrimInsetsFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<HelpItem> mHelpItem;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout mFooterDrawer;
    private RelativeLayout mFooterSecondDrawer;
    private ScrimInsetsFrameLayout mRelativeDrawer;

    private boolean isSaveInstance = false;
    private Navigation mNavigation = new Navigation();

    private NavigationLiveoAdapter mNavigationAdapter;
    public TextView userName;
    public TextView userEmail;
    public ImageView userPhoto;
    public ImageView userBackground;

    private View mHeader;

    private ListView mList;
    private Toolbar mToolbar;
    private TextView mTitleFooter;
    private ImageView mIconFooter;

    private TextView mTitleSecondFooter;
    private ImageView mIconSecondFooter;
    private ActionBarDrawerToggleCompat mDrawerToggle;
    private OnItemClickListener mOnItemClickLiveo;
    private OnPrepareOptionsMenuLiveo mOnPrepareOptionsMenu;




    private int mColorName = 0;
    private int mColorIcon = 0;
    private int mNewSelector = 0;
    private int mColorCounter = 0;
    private int mColorSeparator = 0;
    private int mColorSubHeader = 0;
    private boolean mRemoveHeader = false;
    private boolean mCustomHeader = false;

    private int mColorDefault = 0;
    private int mCurrentPosition = 1;
    private int mCurrentCheckPosition = 1;
    private int mSelectorDefault = 0;
    private float mElevationToolBar = 15;
    private boolean mRemoveAlpha = false;
    private boolean mRemoveColorFilter = false;

    public static final String CURRENT_POSITION = "CURRENT_POSITION";
    public static final String CURRENT_CHECK_POSITION = "CURRENT_CHEKC_POSITION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_main_light);
        configureFindView();
        build();
    }

    private class ActionBarDrawerToggleCompat extends ActionBarDrawerToggle {

        public ActionBarDrawerToggleCompat(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar){
            super(
                    activity,
                    drawerLayout, toolbar,
                    R.string.drawer_open,
                    R.string.drawer_close);
        }

        @Override
        public void onDrawerClosed(View view) {
            supportInvalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            supportInvalidateOptionsMenu();
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int mPosition = (!mRemoveHeader || !mCustomHeader ? position - 1 : position);

            if (mPosition == -1){
                mDrawerLayout.closeDrawer(mRelativeDrawer);
                return;
            }

            HelpItem helpItem = mHelpItem.get(mPosition);
            if (!helpItem.isHeader()) {
                if (position != 0 || (mRemoveHeader && mCustomHeader)) {
                    //setCurrentPosition(mPosition);

                    if (helpItem.isCheck()) {
                        //setCurrentCheckPosition(mPosition);
                        setCheckedItemNavigation(mPosition, true);
                    }
                    mOnItemClickLiveo.onItemClick(mPosition);
                }

                mDrawerLayout.closeDrawer(mRelativeDrawer);
            }
        }
    }

    public void build(){
        OnItemClickListener mOnItemClickLiveoe=new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        };
        if (mOnItemClickLiveo == null){
          mOnItemClickLiveo=mOnItemClickLiveoe;
        }
        HelpLiveo  mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.status_d), R.drawable.gallery_icon, 7);
        mHelpLiveo.addSubHeader(getString(R.string.status_d)); //Item subHeader
        //    mHelpLiveo.addSubHeader();
        mHelpLiveo.add(getString(R.string.status_d), R.drawable.gallery_icon);
        mHelpLiveo.add(getString(R.string.status_d), R.drawable.gallery_icon);
        mHelpLiveo.addNoCheck(getString(R.string.status_d), R.drawable.gallery_icon);
        mHelpLiveo.addSeparator(); //Item separator
        mHelpLiveo.add(getString(R.string.status_d), R.drawable.gallery_icon);
        mHelpLiveo.add(getString(R.string.status_d), R.drawable.gallery_icon, 120);
        mHelpItem=mHelpLiveo.getHelp();
       // this.addHeaderView();
        List<Integer> mListExtra = new ArrayList<>();
        mListExtra.add(0, mNewSelector);
        mListExtra.add(1, mColorDefault);
        mListExtra.add(2, mColorIcon);
        mListExtra.add(3, mColorName);
        mListExtra.add(4, mColorSeparator);
        mListExtra.add(5, mColorCounter);
        mListExtra.add(6, mSelectorDefault);
        mListExtra.add(7, mColorSubHeader);

        List<Boolean> mListRemove = new ArrayList<>();
        mListRemove.add(0, mRemoveAlpha);
        mListRemove.add(1, mRemoveColorFilter);

        if (mHelpItem != null){
            mNavigationAdapter = new NavigationLiveoAdapter(this, NavigationLiveoList.getNavigationAdapter(this, mHelpItem, mNavigation.colorSelected, mNavigation.removeSelector), mListRemove, mListExtra);
        }else {
            mNavigationAdapter = new NavigationLiveoAdapter(this, NavigationLiveoList.getNavigationAdapter(this, mNavigation), mListRemove, mListExtra);
        }

        setAdapter();
    }

    private void setAdapter(){
        if (mNavigationAdapter != null){
            mList.setAdapter(mNavigationAdapter);
        }
    }
    public void setCheckedItemNavigation(int position, boolean checked){

        if (this.mNavigationAdapter == null){
            throw new RuntimeException(getString(R.string.start_navigation_listener));
        }

        this.mNavigationAdapter.resetarCheck();
        this.mNavigationAdapter.setChecked(position, checked);
    }
    private void configureFindView(){
        mList = (ListView) findViewById(R.id.list);
        mList.setOnItemClickListener(new DrawerItemClickListener());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mDrawerToggle = new ActionBarDrawerToggleCompat(this, mDrawerLayout, mToolbar);
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mTitleFooter = (TextView) this.findViewById(R.id.titleFooter);
        mIconFooter = (ImageView) this.findViewById(R.id.iconFooter);

        mTitleSecondFooter = (TextView) this.findViewById(R.id.titleSecondFooter);
        mIconSecondFooter = (ImageView) this.findViewById(R.id.iconSecondFooter);

        mFooterDrawer = (RelativeLayout) this.findViewById(R.id.footerDrawer);
        mFooterSecondDrawer = (RelativeLayout) this.findViewById(R.id.footerSecondDrawer);
        mRelativeDrawer = (ScrimInsetsFrameLayout) this.findViewById(R.id.relativeDrawer);

        this.setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                if (!mRemoveHeader || !mCustomHeader) {
                    Resources.Theme theme = this.getTheme();
                    TypedArray typedArray = theme.obtainStyledAttributes(new int[]{android.R.attr.colorPrimary});
                    mDrawerLayout.setStatusBarBackground(typedArray.getResourceId(0, 0));
                }
            } catch (Exception e) {
                e.getMessage();
            }

            this.setElevationToolBar(mElevationToolBar);
        }
    }
    public void setElevationToolBar(float elevation){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mElevationToolBar = elevation;
            this.mToolbar.setElevation(elevation);
        }
    }
}