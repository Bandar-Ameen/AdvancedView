
# Advancedview 

This library  you can Convert json To view at run time. 

# dependency 




 # require
Api 30
#### Example
define 
proteus=   new ProteusBuilder()
                    /* .register(SupportV4Module.create())
                     .register(RecyclerViewModule.create())
                     .register(SliderViewModel.create())
                     .register(AutoCompleteTextViewModel.create())
                     .register(SppinerViewBModel.create())
                     .register(CardViewModule.create())
                     .register(DesignModule.create())
                     .register(new CircleViewParser())*/
                    .build();
                    
                    selectedFragment = new  advancedfragment(proteus,layoutt);//layout is json text 

```java

package com.astooltech.advancedview.finaldemo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.finaldemo.conectionbase;
import com.astooltech.advancedview.finaldemo.flex;
import com.astooltech.advancedview.finaldemo.loadSettingsFirstly;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log;

import java.util.List;

public class MainfragmentActivity extends AppCompatActivity {

    Button ba;
    Button bb;
    Proteus proteus;
    private  String layoutt="{}";//layout fragment string as json data 
    loadSettingsFirstly f;

    private  void loads(){
try {
    f = new loadSettingsFirstly(this, conectionbase.fir);
    f.isexitsornot();
    com.astooltech.advancedview.database.DatabaseHelper tt = new DatabaseHelper(this);

    ScriptModel gx1 = new ScriptModel(0, "00", f.getfulUrl(conectionbase.Alayouts));
    List<ScriptModel> hx1 = tt.getAllNotes(gx1);
    layoutt = hx1.get(0).getContent();
}catch (Exception ex){
    Log.e("er",ex.getMessage());
}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfragment);
        ba=(Button) findViewById(R.id.frb);
        bb=(Button) findViewById(R.id.fra);
        loads();

        if(proteus==null){
            proteus=   new ProteusBuilder()
                    /* .register(SupportV4Module.create())
                     .register(RecyclerViewModule.create())
                     .register(SliderViewModel.create())
                     .register(AutoCompleteTextViewModel.create())
                     .register(SppinerViewBModel.create())
                     .register(CardViewModule.create())
                     .register(DesignModule.create())
                     .register(new CircleViewParser())*/
                    .build();
        }
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = null;
                selectedFragment = new  concorfragment();
                loadFragment(selectedFragment);
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = null;
                selectedFragment = new  advancedfragment(proteus,layoutt);//layout is json text 
                loadFragment(selectedFragment);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainx, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment selectedFragment = null;

        int itemId = item.getItemId();
        if (itemId == R.id.menu_fragment_a) {
            selectedFragment = new concorfragment();
        } else if (itemId == R.id.menu_fragment_b) {//selectedFragment = new concorfragmentb();
        } else {
            return super.onOptionsItemSelected(item);
        }

        if (selectedFragment != null) {
            loadFragment(selectedFragment);
        }

        return true;
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cfragment_container3, fragment)
                .commit();
    }
}


```

# screenshot
