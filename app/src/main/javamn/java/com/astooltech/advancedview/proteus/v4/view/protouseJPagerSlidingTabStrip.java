package com.astooltech.advancedview.proteus.v4.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.ISlidingTabStrip;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.JPagerSlidingTabStrip;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.other.JTabStyleDelegate;

import static com.astooltech.advancedview.proteus.anotherView.viewSlider.other.JTabStyleBuilder.STYLE_DEFAULT;

public class protouseJPagerSlidingTabStrip  extends JPagerSlidingTabStrip implements ProteusView, ISlidingTabStrip {

private ProteusView.Manager viewManager;

public protouseJPagerSlidingTabStrip(Context context) {
        super(context);
        }

/*public protouseJPagerSlidingTabStrip(Context context, AttributeSet attrs) {
        super(context,null);

        setupStrip(this.getTabStyleDelegate(), STYLE_DEFAULT, this.getContext());
        this.getTabStyleDelegate().setNotDrawIcon(true).setNeedTabTextColorScrollUpdate(true).setCornerRadio(40)
                //.setIndicatorHeight(60)
                .setTextColor(Color.WHITE, Color.parseColor("#009688")).setIndicatorColor(Color.parseColor("#009688"))
                .setFrameColor(Color.parseColor("#009688")).setDividerColor(Color.TRANSPARENT);

}

public protouseJPagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, null, defStyleAttr);
        setupStrip(this.getTabStyleDelegate(), STYLE_DEFAULT, this.getContext());
        this.getTabStyleDelegate().setNotDrawIcon(true).setNeedTabTextColorScrollUpdate(true).setCornerRadio(40)
                //.setIndicatorHeight(60)
                .setTextColor(Color.WHITE, Color.parseColor("#009688")).setIndicatorColor(Color.parseColor("#009688"))
                .setFrameColor(Color.parseColor("#009688")).setDividerColor(Color.TRANSPARENT);

}
*/
        private void setupStrip(JTabStyleDelegate tabStyleDelegate, int type, Context cc){
                tabStyleDelegate.setJTabStyle(type).setShouldExpand(true).setFrameColor(Color.parseColor("#45C01A"))
                        .setTabTextSize(getDimen(R.dimen.tabstrip_textsize,cc))
                        .setTextColor(Color.parseColor("#45C01A"), Color.GRAY)
//                .setDividerWidth(6)
                        //.setTextColor(R.drawable.tabstripbg)
                        .setDividerColor(Color.parseColor("#45C01A")).setDividerPadding(0)
                        .setUnderlineColor(Color.parseColor("#3045C01A")).setUnderlineHeight(0)
                        .setIndicatorColor(Color.parseColor("#7045C01A"))
                        .setIndicatorHeight(getDimen(R.dimen.sug_event_tabheight,cc)).setFrameColor(Color.TRANSPARENT);
        }
        private int getDimen(int dimen, Context c){
                return (int)c.getResources().getDimension(dimen);
        }


        @Override
public Manager getViewManager() {
        return viewManager;
        }

@Override
public void setViewManager(@NonNull Manager manager) {
        this.viewManager = manager;
        }

@NonNull
@Override
public View getAsView() {

        setupStrip(this.getTabStyleDelegate(), STYLE_DEFAULT, this.getContext());
        this.getTabStyleDelegate().setNotDrawIcon(true).setNeedTabTextColorScrollUpdate(true).setCornerRadio(40)
                //.setIndicatorHeight(60)
                .setTextColor(Color.WHITE, Color.parseColor("#009688")).setIndicatorColor(Color.parseColor("#009688"))
                .setFrameColor(Color.parseColor("#009688")).setDividerColor(Color.TRANSPARENT);

     /*  LayoutInflater v= (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
      View mn=  v.inflate(R.layout.custem_tab,null);

*/

        return this; //mn.findViewById(R.id.tabsmy);
        }
        }
