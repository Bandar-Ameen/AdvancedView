package com.astooltech.advancedview.proteus.v7;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import com.astooltech.advancedview.vlayout.DelegateAdapter;
import com.astooltech.advancedview.vlayout.LayoutHelper;
import com.astooltech.advancedview.vlayout.RecyclablePagerAdapter;
import com.astooltech.advancedview.vlayout.VirtualLayoutManager;
import com.astooltech.advancedview.vlayout.layout.FixLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.GridLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.OnePlusNLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.OnePlusNLayoutHelperEx;
import com.astooltech.advancedview.vlayout.layout.ScrollFixLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.StickyLayoutHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProtouseRecyclerViewVlayoutParser<V extends RecyclerView> extends ViewTypeParser<V> {
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    public static final String ATTRIBUTE_ADAPTER = "adapter";
    public static final String ATTRIBUTE_LAYOUT_MANAGER = "layout_manager";
    public static String typAdapter = "layout_manager";
    public static final String ATTRIBUTE_TYPE = ProteusConstants.TYPE;
    private boolean isload = false;
    //public static final String oritation = ProteusConstants.oritation;

    private boolean loading = false;
    private int page = 0;
    private Handler handler;



    @NonNull
    @Override
    public String getType() {
        return "RecyclerViewLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProtouseRecyclerViewVlayout(context);
    }

    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new AdapterBasedViewManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("VVlayout", new AttributeProcessor<V>() {
            private static final boolean BANNER_LAYOUT = true;

            private static final boolean LINEAR_LAYOUT = true;

            private static final boolean ONEN_LAYOUT = true;

            private static final boolean GRID_LAYOUT = true;

            private static final boolean STICKY_LAYOUT = true;

            private static final boolean HORIZONTAL_SCROLL_LAYOUT = true;

            private static final boolean SCROLL_FIX_LAYOUT = true;
            @Override
            public void handleValue(final V view, Value value) {


                Array tter=value.getAsObject().getAsArray("LayoutType");



                Runnable trigger;
                ProtouseRecyclerViewVlayout view11=(ProtouseRecyclerViewVlayout)view;
               VirtualLayoutManager layoutManager = new VirtualLayoutManager(view11.manager.getContext().getActvityAllt());

                view.setOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {

                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        //mFirstText.setText("First: " + layoutManager.findFirstVisibleItemPosition());
                        //  mLastText.setText("Existing: " + OnePlusNLayoutActivity.MainViewHolder.existing + " Created: " + OnePlusNLayoutActivity.MainViewHolder.createdTimes);
                        // mCountText.setText("Count: " + recyclerView.getChildCount());
                        //  mTotalOffsetText.setText("Total Offset: " + layoutManager.getOffsetToStart());
                    }
                });


                view.setLayoutManager(layoutManager);

                /*RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
                    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                        int position = ((VirtualLayoutManager.LayoutParams) view.getLayoutParams()).getViewPosition();
                        outRect.set(4, 4, 4, 4);
                    }
                };*/


                 RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

                view.setRecycledViewPool(viewPool);
                viewPool.setMaxRecycledViews(0, 20);

                DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

                view.setAdapter(delegateAdapter);
                final     ProtouseRecyclerViewVlayout view1=(ProtouseRecyclerViewVlayout)view;
                List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
                Iterator<Value> rre = tter.iterator();
                while (rre.hasNext()) {
                   Value ddertr = rre.next();
                    int coll= ParseHelper.parseColor(ddertr.getAsObject().getAsString("Bground"));
                    int left=ddertr.getAsObject().getAsInteger("cell_margin_left");
                    int right=ddertr.getAsObject().getAsInteger("cell_margin_right");
                    int top=ddertr.getAsObject().getAsInteger("cell_margin_top");
                    int buttom=ddertr.getAsObject().getAsInteger("cell_margin_buttom");


                    int Aleft=ddertr.getAsObject().getAsInteger("cell_padding_left");
                    int Aright=ddertr.getAsObject().getAsInteger("cell_padding_right");
                    int Atop=ddertr.getAsObject().getAsInteger("cell_padding_top");
                    int Abuttom=ddertr.getAsObject().getAsInteger("cell_padding_buttom");
                   // int cellcount=ddertr.getAsObject().getAsInteger("cell_count");
                    int hi=ddertr.getAsObject().getAsInteger("cell_hight");

                  /*  int B= ddertr.getAsObject().getAsInteger("coll_B");
                    int C= ddertr.getAsObject().getAsInteger("coll_C");
                    int D= ddertr.getAsObject().getAsInteger("coll_D");
                    int E= ddertr.getAsObject().getAsInteger("coll_E");*/
                    Array rreu=ddertr.getAsObject().getAsArray("mdata");
                 float[] weig=new   float[rreu.size()];
                 int cz=0;
                    Iterator<Value> rrey = rreu.iterator();
                    List<mmodelinfalers> eeru=new ArrayList<>();
                    while (rrey.hasNext()) {
                        Value ddertry = rrey.next();
try {
    int wiht = ddertry.getAsObject().getAsInteger("Weights");
    weig[cz] = Float.valueOf(wiht);
}catch(Exception ex){

}


                        cz=cz+1;
Layout layoutinflaters=null;
                        ObjectValue vvc=ddertry.getAsObject().getAsObject("data_obj");
                        if(ddertry.getAsObject().isLayout("layoutsInflater"))
                        {
                            layoutinflaters=ddertry.getAsObject().getAsLayout("layoutsInflater");//ddertry.getAsObject().getAsString("layoutsInflater");
                        }else{
                            layoutinflaters=   ((ProtouseRecyclerViewVlayout) view).getViewManager().getContext().getInflater().inflate(ddertry.getAsObject().getAsString("layoutsInflater"),vvc).getViewManager().getLayout();
                        }
                       // String =
                        int layoutinflaterstyp=ddertry.getAsObject().getAsInteger("layoutsInflater_type");


                        mmodelinfalers ww=new mmodelinfalers(layoutinflaters,layoutinflaterstyp,vvc);
                        eeru.add(ww);

                    }
if(ddertr.getAsObject().getAsString("Types").toLowerCase().equals("one_layouta")) {


    OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();


    helper.setBgColor(coll);
    helper.setMargin(left, top, right, buttom);
    helper.setPadding(Aleft, Atop, Aright, Abuttom);
  //  helper.setColWeights(new float[]{Float.valueOf(A), Float.valueOf(B), Float.valueOf(C), Float.valueOf(D), Float.valueOf(E)});
    adapters.add(new SubAdapter(view.getContext(), helper, eeru,  hi, view11));
}


                    if(ddertr.getAsObject().getAsString("Types").toLowerCase().equals("one_layoutb")){
                        OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                        helper.setBgColor(coll);
                        //helper.setColWeights(new float[]{Float.valueOf(A), Float.valueOf(B), Float.valueOf(C), Float.valueOf(D), Float.valueOf(E)});
                        helper.setMargin(left, top, right, buttom);
try {

    helper.setColWeights(weig);//new float[]{Float.valueOf(B), Float.valueOf(C), Float.valueOf(D), Float.valueOf(E), Float.valueOf(F)});
}catch (Exception ex){

}

try{
   // helper.setHGap(Hgap);
    int A= ddertr.getAsObject().getAsInteger("AspectRatio");
    helper.setAspectRatio(Float.valueOf(A));
}catch (Exception ex){

}
                        helper.setPadding(Aleft, Atop, Aright, Abuttom);
                        adapters.add(new SubAdapter(view.getContext(), helper, eeru, hi, view11));
                    }
                    if(ddertr.getAsObject().getAsString("Types").toLowerCase().equals("one_layoutc")){
                        StickyLayoutHelper helper = new StickyLayoutHelper();
                        helper.setBgColor(coll);
                        //helper.setColWeights(new float[]{Float.valueOf(A), Float.valueOf(B), Float.valueOf(C), Float.valueOf(D), Float.valueOf(E)});
                        helper.setMargin(left, top, right, buttom);


                        try{
                            // helper.setHGap(Hgap);
                            int A= ddertr.getAsObject().getAsInteger("AspectRatio");
                            helper.setAspectRatio(Float.valueOf(A));
                        }catch (Exception ex){

                        }
                        helper.setPadding(Aleft, Atop, Aright, Abuttom);
                        adapters.add(new SubAdapter(view.getContext(), helper, eeru, hi, view11));
                    }
                    if(ddertr.getAsObject().getAsString("Types").equals("GRAD_LAYOUT")){
                        int A= ddertr.getAsObject().getAsInteger("AspectRatio");
                        int Span=ddertr.getAsObject().getAsInteger("Span_column");
                        int Hgap=ddertr.getAsObject().getAsInteger("Hgap");
                        GridLayoutHelper layoutHelper;
                        layoutHelper = new GridLayoutHelper(Span);
                        layoutHelper.setMargin(left, top, right, buttom);
                        layoutHelper.setHGap(Hgap);
                       ;
                        layoutHelper.setAspectRatio(Float.valueOf(A));
                        adapters.add(new SubAdapter(view.getContext(),layoutHelper, eeru, hi, view11));

                    }
                    if(ddertr.getAsObject().getAsString("Types").toLowerCase().equals("one_layoutd")){

                     int x=20;
                     int y=20;
                        int Span=ddertr.getAsObject().getAsInteger("Span_column");
                        int Hgap=ddertr.getAsObject().getAsInteger("Hgap");
                      try {
                          x = ddertr.getAsObject().getAsInteger("X");
                          y = ddertr.getAsObject().getAsInteger("Y");
                      }catch (Exception ex){

                      }
                        ScrollFixLayoutHelper helper = new ScrollFixLayoutHelper(Hgap==0?FixLayoutHelper.BOTTOM_RIGHT:FixLayoutHelper.BOTTOM_LEFT, x, y);
                       if(Span==0) {
                           helper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
                       }else if(Span==1) {
                           helper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
                       }else {
                           helper.setShowType(ScrollFixLayoutHelper.SHOW_ALWAYS);

                       }
                        helper.setBgColor(coll);
                        //helper.setColWeights(new float[]{Float.valueOf(A), Float.valueOf(B), Float.valueOf(C), Float.valueOf(D), Float.valueOf(E)});
                        helper.setMargin(left, top, right, buttom);


                        try{
                            // helper.setHGap(Hgap);
                            int A= ddertr.getAsObject().getAsInteger("AspectRatio");
                            helper.setAspectRatio(Float.valueOf(A));
                        }catch (Exception ex){

                        }
                        helper.setPadding(Aleft, Atop, Aright, Abuttom);
                        adapters.add(new SubAdapter(view.getContext(), helper, eeru, hi, view11));
                    }


                }
                delegateAdapter.setAdapters(adapters);
                view.requestLayout();


            /*    if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();


                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    adapters.add(new SubAdapter(view.getContext(), helper, 4));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    adapters.add(new SubAdapter(view.getContext(), helper, 5));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    adapters.add(new SubAdapter(view.getContext(), helper, 5));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    helper.setColWeights(new float[]{40f, 45f, 15f, 60f, 0f});
                    adapters.add(new SubAdapter(view.getContext(), helper, 5));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    helper.setColWeights(new float[]{20f, 80f, 0f, 60f, 20f});
                    helper.setAspectRatio(4);
                    adapters.add(new SubAdapter(view.getContext(), helper, 5));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    adapters.add(new SubAdapter(view.getContext(), helper, 6));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    adapters.add(new SubAdapter(view.getContext(), helper, 7));
                }

                if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xff876384);
                    helper.setMargin(0, 10, 0, 10);
                    helper.setColWeights(new float[]{40f, 45f, 15f, 60f, 0f, 30f, 30f});
                    adapters.add(new SubAdapter(view.getContext(), helper, 7));
                }*/

              /*  if (ONEN_LAYOUT) {
                    OnePlusNLayoutHelperEx helper = new OnePlusNLayoutHelperEx();
                    helper.setBgColor(0xffed7612);
//            helper.setMargin(10, 10, 10, 10);
//            helper.setPadding(10, 10, 10, 10);
                    helper.setColWeights(new float[]{30f, 20f, 50f, 40f, 30f, 35f, 35f});
                    adapters.add(new SubAdapter(view.getContext(), helper, 7) {
                        @Override
                        public void onBindViewHolder(MainViewHolder holder, int position) {
                            super.onBindViewHolder(holder, position);
//                    LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
//                    layoutParams.leftMargin = 10;
//                    layoutParams.topMargin = 10;
//                    layoutParams.rightMargin = 10;
//                    layoutParams.bottomMargin = 10;
//                    holder.itemView.setLayoutParams(layoutParams);
                        }
                    });
                }*/

              /*  if (STICKY_LAYOUT) {
                    StickyLayoutHelper layoutHelper = new StickyLayoutHelper();
                    layoutHelper.setAspectRatio(4);
                    adapters.add(new SubAdapter(view.getContext(), layoutHelper, 1, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)));
                }

                if (SCROLL_FIX_LAYOUT) {
                    ScrollFixLayoutHelper layoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.BOTTOM_RIGHT, 20, 20);
                    layoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
                    adapters.add(new SubAdapter(view.getContext(), layoutHelper, 1) {
                        @Override
                        public void onBindViewHolder(MainViewHolder holder, int position) {
                            super.onBindViewHolder(holder, position);
                            VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(50, 50);
                            holder.itemView.setLayoutParams(layoutParams);
                        }
                    });
                }*/
               // adapters.add(new SubAdapter(view.getContext(), new LinearLayoutHelper(), 100));







            }

            class PagerAdapter extends RecyclablePagerAdapter<MainViewHolder> {
                public PagerAdapter(SubAdapter adapter, RecyclerView.RecycledViewPool pool) {
                    super(adapter, pool);
                }

                @Override
                public int getCount() {
                    return 6;
                }

                @Override
                public void onBindViewHolder(MainViewHolder viewHolder, int position) {
                    // only vertical
                    viewHolder.itemView.setLayoutParams(
                            new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                    ((TextView) viewHolder.itemView.findViewById(R.id.title)).setText("Banner: " + position);
                }

                @Override
                public int getItemViewType(int position) {
                    return 0;
                }
            }

            class MainViewHolder extends RecyclerView.ViewHolder {

                public  volatile int existing = 0;
                public  int createdTimes = 0;
private ProteusView proteusVieww;
                public MainViewHolder(ProteusView proteusView) {
                    super(proteusView.getAsView());
                    this.proteusVieww=proteusView;
                    createdTimes++;
                    existing++;
                }

                @Override
                protected void finalize() throws Throwable {
                    existing--;
                    super.finalize();
                }
            }
            class SubAdapter extends DelegateAdapter.Adapter<MainViewHolder> {

                private Context mContext;

                private LayoutHelper mLayoutHelper;
                private List<mmodelinfalers> nameinflat;
                private  ProteusView proo;

                private VirtualLayoutManager.LayoutParams mLayoutParams;
                private int mCount = 0;


             /*   public SubAdapter(Context context, LayoutHelper layoutHelper,List<mmodelinfalers> nameinflat,ProteusView proocc) {
                    this(context, layoutHelper, nameinflat, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300),proocc);
                }*/

                public SubAdapter(Context context, LayoutHelper layoutHelper, List<mmodelinfalers> nameinflat, int height,ProteusView prooc) {
                    this.nameinflat=nameinflat;
                    this.proo=prooc;
                    this.mContext = context;
                    this.mLayoutHelper = layoutHelper;
                    this.mCount = nameinflat.size();
                    this.mLayoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
                }

                @Override
                public int getItemViewType(int position) {
                    return  nameinflat.get(position).getTypeinflater(); //List<mmodel//super.getItemViewType(position);
                }

                private Layout findinfltername(int type){
Layout name=null;
                  Iterator<mmodelinfalers> eer=     nameinflat.iterator();
                    while (eer.hasNext()){
                        mmodelinfalers tt=eer.next();
                        if(tt.getTypeinflater()==type){
                            name=tt.getNameinflater();
                            break;
                        }


                    }
                    return  name;

                }


                @Override
                public LayoutHelper onCreateLayoutHelper() {
                    return mLayoutHelper;
                }

                @Override
                public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


                    return new  MainViewHolder(proo.getViewManager().getContext().getInflater().inflate(findinfltername(viewType),new ObjectValue()));//LayoutInflater.from(mContext).inflate(R.layout.bb_aa_item, parent, false));
                }

                @Override
                public void onBindViewHolder(MainViewHolder holder, int position) {
                    // only vertical
                    holder.itemView.setLayoutParams(
                            new VirtualLayoutManager.LayoutParams(mLayoutParams));
                }


                @Override
                protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {


                    holder.proteusVieww.getViewManager().getDataContext().update(holder.proteusVieww.getViewManager().getContext(),nameinflat.get(position).getDataobj());
                   // ((TextView) holder.itemView.findViewById(R.id.title)).setText(Integer.toString(offsetTotal));
                }

                @Override
                public int getItemCount() {
                    return mCount;
                }
            }

            @Override
            public void handleResource(V view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {

            }
        });
    }
}