/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.HeaderItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ProgressItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.myArrayAuto;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.MyObject;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.Node;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeNode;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeViewAdapter;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.bean.Dir;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder.DirectoryNodeBinder;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder.FileNodeBinder;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.ProteusRecyclerViewAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.RecyclerViewAdapterFactory;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerFactory;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.value.horizontalscrollmenulibrary.extras.ItemAdapter;
import com.astooltech.advancedview.proteus.value.horizontalscrollmenulibrary.extras.MenuItem;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.vlayout.DelegateAdapter;
import com.astooltech.advancedview.vlayout.LayoutHelper;
import com.astooltech.advancedview.vlayout.RecyclablePagerAdapter;
import com.astooltech.advancedview.vlayout.VirtualLayoutManager;
import com.astooltech.advancedview.vlayout.layout.FixLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.LinearLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.OnePlusNLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.OnePlusNLayoutHelperEx;
import com.astooltech.advancedview.vlayout.layout.ScrollFixLayoutHelper;
import com.astooltech.advancedview.vlayout.layout.StickyLayoutHelper;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static com.astooltech.advancedview.proteus.design.TreeViewCustome.getRootNod_from_List.BuildTreeAndGetRoots;

/**
 * RecyclerViewParser
 *
 * @author adityasharat
 */

public class RecyclerViewParser<V extends RecyclerView> extends ViewTypeParser<V>  {
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    public static final String ATTRIBUTE_ADAPTER = "adapter";
    public static final String ATTRIBUTE_LAYOUT_MANAGER = "layout_manager";
    public static  String typAdapter = "layout_manager";
    public static final String ATTRIBUTE_TYPE = ProteusConstants.TYPE;
    private boolean isload=false;
    //public static final String oritation = ProteusConstants.oritation;

    @NonNull
    private final RecyclerViewAdapterFactory adapterFactory;

    @NonNull
    private final LayoutManagerFactory layoutManagerFactory;
    private  boolean loading = false;
    private  int page = 0;
    private  Handler handler;

    public RecyclerViewParser(@NonNull RecyclerViewAdapterFactory adapterFactory, @NonNull LayoutManagerFactory layoutManagerFactory) {
        this.adapterFactory = adapterFactory;
        this.layoutManagerFactory = layoutManagerFactory;
        this.handler = new Handler();
    }

    @NonNull
    @Override
    public String getType() {
        return "RecyclerView";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProteusRecyclerView(context);
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

        addAttributeProcessor(Attributes.View.Recyle_use_reload, new BooleanAttributeProcessor<V>() {
            @Override
            public void setBoolean(V view, boolean value) {



                // view.setSingleLine(value);
            }
        });
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

                        Runnable trigger;

                        final VirtualLayoutManager layoutManager = new VirtualLayoutManager(view.getContext());

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

                        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
                            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                                int position = ((VirtualLayoutManager.LayoutParams) view.getLayoutParams()).getViewPosition();
                                outRect.set(4, 4, 4, 4);
                            }
                        };


                        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

                     view.setRecycledViewPool(viewPool);
                        viewPool.setMaxRecycledViews(0, 20);

                        final DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

                     view.setAdapter(delegateAdapter);
                    final     ProteusRecyclerView view1=(ProteusRecyclerView)view;
                        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

                        if (BANNER_LAYOUT) {
                            adapters.add(new SubAdapter(view.getContext(), new LinearLayoutHelper(), 1) {

                                @Override
                                public void onViewRecycled(MainViewHolder holder) {
                                    if (holder.itemView instanceof ViewPager) {
                                        ((ViewPager) holder.itemView).setAdapter(null);
                                    }
                                }

                                @Override
                                public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                                    if (viewType == 1)
                                        return new MainViewHolder(
                                                LayoutInflater.from(view1.getContext()).inflate(R.layout.bb_aa_view_pager, parent, false));

                                    return super.onCreateViewHolder(parent, viewType);
                                }

                                @Override
                                public int getItemViewType(int position) {
                                    return 1;
                                }

                                @Override
                                protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {

                                }

                                @Override
                                public void onBindViewHolder(MainViewHolder holder, int position) {
                                    if (holder.itemView instanceof ViewPager) {
                                        ViewPager viewPager = (ViewPager) holder.itemView;

                                        viewPager.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));

                                        // from position to get adapter
                                        viewPager.setAdapter(new PagerAdapter(this, viewPool));
                                    }
                                }
                            });
                        }

                        if (ONEN_LAYOUT) {
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
                        }

                        if (ONEN_LAYOUT) {
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
                        }

                        if (STICKY_LAYOUT) {
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
                        }
                        if (LINEAR_LAYOUT) {
                            adapters.add(new SubAdapter(view.getContext(), new LinearLayoutHelper(), 100));

                            delegateAdapter.setAdapters(adapters);

                            final Handler mainHandler = new Handler(Looper.getMainLooper());

                            trigger = new Runnable() {
                                @Override
                                public void run() {
                                    // recyclerView.scrollToPosition(22);
                                    // recyclerView.getAdapter().notifyDataSetChanged();
                                   view.requestLayout();
                                    // mainHandler.postDelayed(trigger, 1000);
                                }
                            };


                            mainHandler.postDelayed(trigger, 1000);
                          //  view.requestLayout();

                          //  mainHandler.postDelayed(trigger, 1000);
                        }
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

                public MainViewHolder(View itemView) {
                    super(itemView);
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


                private VirtualLayoutManager.LayoutParams mLayoutParams;
                private int mCount = 0;


                public SubAdapter(Context context, LayoutHelper layoutHelper, int count) {
                    this(context, layoutHelper, count, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
                }

                public SubAdapter(Context context, LayoutHelper layoutHelper, int count, @NonNull VirtualLayoutManager.LayoutParams layoutParams) {
                    this.mContext = context;
                    this.mLayoutHelper = layoutHelper;
                    this.mCount = count;
                    this.mLayoutParams = layoutParams;
                }

                @Override
                public LayoutHelper onCreateLayoutHelper() {
                    return mLayoutHelper;
                }

                @Override
                public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


                    return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.bb_aa_item, parent, false));
                }

                @Override
                public void onBindViewHolder(MainViewHolder holder, int position) {
                    // only vertical
                    holder.itemView.setLayoutParams(
                            new VirtualLayoutManager.LayoutParams(mLayoutParams));
                }


                @Override
                protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {
                    ((TextView) holder.itemView.findViewById(R.id.title)).setText(Integer.toString(offsetTotal));
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




             addAttributeProcessor("Adp", new AttributeProcessor<V>() {

                         @Override
                         public void handleValue(final V view, Value value) {




                                //  Gson gg = new Gson();
                                // String typev = value.getAsObject().getAsString("or");//oritation
                                //  Log.i("hhhhhhhhhh", gg.toJson(value.getAsObject().));//.getAsObject().toString());
                                final String typex = "kk"; //value.getAsObject().getAsString("tname");
                                boolean useMultiple = false;
                                boolean useOfline = false;
                                List<modeltypeview> temppxm = new ArrayList<>();
                                String valuu = "[]";


                                ObjectValue anima = value.getAsObject().getAsObject("animation");
                                try {
                                    Gson gsonn = new Gson();

                                    useOfline = anima.getAsBoolean("a_use_offline");
                                    ObjectValue usemultiple = value.getAsObject().getAsObject("UseMultiple");


                                    useMultiple = usemultiple.getAsBoolean("a_enable");
                                    valuu = usemultiple.getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                                    //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                                    ;

                                    //  Log.i("9988xx",gsonn.toJson(jkm));
                                    Type typez = new TypeToken<List<modeltypeview>>() {

                                    }.getType();
                                    temppxm = gsonn.fromJson(valuu, typez);

                                } catch (Exception ex) {
                                    //  Log.i("9988",ex.getMessage());
                                }
                                Gson gsonnx = new Gson();
                                // Log.i("9988",gsonnx.toJson(temppxm));
                                view.setTag(R.id.useMultipl, temppxm);
                                view.setTag(R.id.useMultiplenb, useMultiple);
                                final boolean useMultiplex = useMultiple;
                                final boolean useof = useOfline;
                                final List<modeltypeview> temppxmx = temppxm;

                                //  FlexibleAdapter.useTag("OverallAdapter");
                              //getdataIt(((ProteusRecyclerView) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);
                                //fdd.add(adapterFactory.create(type, (ProteusRecyclerView) view, value.getAsObject()));



                                //mRecyclerView = getView().findViewById(R.id.recycler_view);
                                view.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout
List<AbstractFlexibleItem> itt=new ArrayList<>();
                             FlexibleAdapter mnbb = new FlexibleAdapter(itt);
                             view.setAdapter(mnbb);
                             //   view.setAdapter(mnbb);


                           //     final String finalNametypData = nametypData;

                            // final String[] ggg = new String[]{"0"};

                             //  Log.i("iioopp","uuuuuuuu");
                             final IValuesData iop= new IValuesData() {
                                 @Override
                                 public void sendData(String datab, int typdata) {

                                 }
                                 @Override
                                 public void setDataAdvanced(Map<String,List<AbstractFlexibleItem>> datresult, int typ) {

                                   /*  final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                                     hv.onLoadMoreComplete(datresult);*/

                                 }
                             };
                             final ProteusView.Manager.ActionEventViewForUto wer= new ProteusView.Manager.ActionEventViewForUto() {
                                 @Override
                                 public void sendEventA(@Nullable ObjectValue data, int typ, Object anotherdata) {

                                 }

                                 @Override
                                 public void sendEventA(@Nullable ObjectValue data, int typ, String anotherdata) {

                                 }

                                 @Override
                                 public void getresultsearchA(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                                 }

                                 @Override
                                 public void getFragmentA(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                                 }
                             };
                             final Value ghh=  value.getAsObject().get("Data_From");
                             loadalltegret(iop,wer, ((ProteusRecyclerView) view),0,0,ghh);
                             //   uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, ggg);

                             ProteusView.Manager.ActionEventView Act = new ProteusView.Manager.ActionEventView() {
                                 @Override
                                 public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

                                 }

                                 @Override
                                 public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {
                                     String[] fdc = new String[]{anotherdata};
                                     char k = '"';
                                     if (typ == 1) {//التحديث
                                         String uiopp = "{}";
                                         uiopp = uiopp.replace('#', k);
                                         ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(view.getContext());
                                         Gson gsonn = new GsonBuilder()
                                                 .registerTypeAdapterFactory(adapter)
                                                 .create();
                                         Type type = new TypeToken<Value>() {

                                         }.getType();
                                         Value tempp = gsonn.fromJson(uiopp, type);
                                         ObjectValue zz = new ObjectValue();
                                         // zz.add(keyy, tempp.getAsObject().get("s1"));

                                         ((ProteusRecyclerView) view).getViewManager().update(tempp.getAsObject());


                                         // uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, fdc);
                                     }

                                     if (typ == 2) {//التحديث
                                         //   Log.i("0x0x","999999999999999999999");
                                         // uuip.triggerAdapter(53, false, "0", anotherdata, null, (ProteusView) view, uuip, fdc);


                                     }

                                 }

                                 @Override
                                 public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {
                                     FlexibleAdapter hv = (FlexibleAdapter) ((ProteusRecyclerView) view).getAdapter();
//إرجاع قيمة البحث
                                     if (typ == 1) {

                                         hv.AhasFilter(true);
                                         // hv.updateDataSet(data);
                                     }
                                     if (typ == 2) {
                                         hv.AhasFilter(false);
                                         // hv.updateDataSet(data);
                                     }
                                     if (typ == 3) {
                                         hv.clear();
                                         //hv.updateDataSet(data);
                                     }
                                     if (typ == 4) {
                                         //hv.clear();
                                         hv.updateDataSet(data);
                                     }
                                 }

                                 @Override
                                 public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                                 }
                             };


                             //((ProteusRecyclerView) view).setViewManager().getViewManager().setActionEventView(Act);
                             if (((ProteusRecyclerView) view).manager.getActionEventView() == null) {
                                 ((ProteusRecyclerView) view).manager.setActionEventView(Act);
                                 //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

                             }


                             final FlexibleAdapter.EndlessScrollListener ddf = new FlexibleAdapter.EndlessScrollListener() {
                                 @Override
                                 public void noMoreLoad(int newItemsSize) {

                                 }

                                 @Override
                                 public void onLoadMore(final int lastPosition, int currentPage) {

                                     final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                                     if (hv.hasFilter()) {
                                         hv.onLoadMoreComplete(null);
                                         return;
                                     } else if (hv.AhasFilter()) {
                                         hv.onLoadMoreComplete(null);
                                         return;
                                     }
                                     new Handler().postDelayed(new Runnable() {
                                         @SuppressWarnings("unchecked")
                                         @Override
                                         public void run() {
                                             final List<AbstractFlexibleItem> newItems = new ArrayList<>(3);
                                             boolean check = true;
                                             String[] anoth = new String[]{"0"};
                                             // Simulating success/failure
                                             //   int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
                                             // Log.i("666","ddddddvvvvvvvvvxxxx");
                                             loadalltegret(iop,wer, ((ProteusRecyclerView) view),0,0,ghh);

                                             // uuip.triggerAdapter(50, false, String.valueOf(lastPosition), String.valueOf(numberload), null, (ProteusView) view, uuip, anoth);

                                             // hv.onLoadMoreComplete(null);
                                             //FlexibleAdapter h = (FlexibleAdapter) view.getAdapter();
                                             // h.removeAllScrollableFooters();
                                              /*  for (int i = 1; i <= 3; i++) {

                                                   mnbb.addItem( mItemss.get(i));
                                                   // mnbb.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
                                                }*/


                                             // h.notifyDataSetChanged();

                                             // Log.i("555",mmArr.size()+"####");//g.toJson(((ProteusRecyclerView) view).getViewManager().getDataContext().getData().get("items").getAsArray()));

                                             //  mnbb.(mItemss);
                                             //   mnbb.notifyDataSetChanged();

//mnbb.addScrollableFooter(new ProgressItem());

                                         }
                                     }, 3000);


                                 }
                             };


                             //.setAnimationOnReverseScrolling(true);

                             //.setEndlessScrollThreshold(1); //Default=1

                             //SwipeRefreshLayout swipeRefreshLayout =view.getContext().findViewById(R.id.swipeRefreshLayout);
                             // swipeRefreshLayout.setEnabled(true);
                             // mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);

                             try {
                                 String typet = value.getAsObject().getAsString("tlayout");

                                 if (typet.equals("1")) {
                                     String co = value.getAsObject().getAsString("tlayoutcount");

                                     GridLayoutManager ff = new GridLayoutManager(view.getContext(), Integer.parseInt(co));
                                     view.setLayoutManager(ff);
                                 }

                             } catch (Exception ex) {
                                 Log.i("666", "dddddd");
                             }

                             // mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
                             // mRecyclerView.setAdapter(mAdapter);
                               /* view.setHasFixedSize(true); //Size of RV will not change
                                FlexibleItemDecoration mItemDecoration;
                                mItemDecoration = new FlexibleItemDecoration(view.getContext())

                                        .withOffset(8) // This helps when top items are removed!!
                                        .withEdge(true);
                                view.addItemDecoration(mItemDecoration);*/

                             // After Adapter is attached to RecyclerView
                             //   mnbb.setLongPressDragEnabled(      anima.getAsBoolean("a_drage"));


                              /*  ScrollableLayoutItem scrollHeader = new ScrollableLayoutItem("SLI");
                                scrollHeader.setTitle("Endless Scrolling");
                                scrollHeader.setSubtitle("...with ScrollableHeaderItem");
                              mnbb.addScrollableHeader(scrollHeader);*/

//mnbb.onLoadMoreComplete();
/*mnbb.setNotifyMoveOfFilteredItems(true);
mnbb.setNotifyChangeOfUnfilteredItems(true);
mnbb.setFilter("الاصول الثابتة");*/





                             flexad(((ProteusRecyclerView) view),ddf,mnbb,anima);




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
public void flexad(ProteusRecyclerView v,FlexibleAdapter.EndlessScrollListener ddf,FlexibleAdapter mnbb,ObjectValue anima){
    long INITIAL_DELAY_300 = 300L;
    mnbb.setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
            .setAnimationInterpolator(new DecelerateInterpolator())
            .setAnimationInitialDelay(INITIAL_DELAY_300);

    mnbb.setAutoCollapseOnExpand(anima.getAsBoolean("a_expand_out"))
            .setAutoScrollOnExpand(anima.getAsBoolean("a_expand"))
            .setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
            .setAnimationEntryStep(
                    anima.getAsBoolean("a_enter_step")
            ) //In Overall, watch the effect at initial loading when Grid Layout is set
            .setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling)
            .setAnimationOnReverseScrolling(anima.getAsBoolean("a_anim_rev"))
            .setAnimationInterpolator(new DecelerateInterpolator())


            .setAnimationDuration(300L);
    v.setItemAnimator(new FlexibleItemAnimator());
    mnbb.setEndlessTargetCount(anima.getAsInteger("a_endless_count")).setEndlessPageSize(anima.getAsInteger("a_endless_page"));
    // mnbb.setLoadingMoreAtStartUp(true)


    // mnbb.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
    //  .setStickyHeaders(true) //Make headers sticky
    // Endless scroll with 1 item threshold

    if (anima.getAsBoolean("a_use_endless")) {

        mnbb.setEndlessScrollListener(ddf, new ProgressItem());
    }

    mnbb.setLoadingMoreAtStartUp(anima.getAsBoolean("a_load_start")).setLongPressDragEnabled(anima.getAsBoolean("a_drage"))
            //.setEndlessScrollListener(this, new ProgressItem())
            .setEndlessScrollThreshold(1).setNotifyMoveOfFilteredItems(false) //When true, filtering on big list is very slow, not in this case!
            .setNotifyChangeOfUnfilteredItems(true); //true by default

    if (anima.getAsBoolean("a_anim_for")) {
        mnbb.setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling);
    }

}


                 public void loadalltegret(IValuesData vc , ProteusView.Manager.ActionEventViewForUto dd, ProteusView infl, int numberreload, int counrtnumber,Value v){

                     Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

                     Value getval=v;//this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.toJson(ttrt);*/
                     try {
                         Value countt=new Primitive(numberreload);
                         Value tot=new Primitive(counrtnumber);

                         infl.getViewManager().getContext().getAllEven("Data_From").callToRecycleview(infl.getAsView().getContext(),

                                 infl.getViewManager().getContext().getActvityAllt(), getval, 0, infl, vc, dd,countt,tot);


                         // this.infl.getViewManager().getContext().getCallback().onEventAdapter(15550, datv, String.valueOf(numberreload),null , infl);

                         // this.infl.getViewManager().getContext().getCallback().onEventAdapter(3550, true, String.valueOf(0), String.valueOf(numberreload),null, null,null);
                     }catch (Exception ex){

                     }
                 }


             });
        addAttributeProcessor(ATTRIBUTE_ADAPTER, new AttributeProcessor<V>() {

            public   TreeNode rreddv(Node no,TreeNode n){

                // TreeNode tt=new TreeNode<>(new Dir(no.Source.objectName));
                //  TreeNode childnot=null; //= new TreeNode<>(new Dir(no.Source.objectName));
                for(int c=0;c<no.Children.size();c++){

                    TreeNode ttv=new TreeNode<>( new Dir(no.Children.get(c).Source.objectName));//:new Dir(no.Children.get(c).Source.objectName));
                    // tt.addChild(ttv);
                    TreeNode nb=   rreddv(no.Children.get(c),ttv);
                    n.addChild(nb);
                    // n.addChild(tt);
                    //   String vvv=no.Children.get(c).Source.objectName;
                    // System.out.println("Given URL666 is : "+vvv+"@@@@@"+parr);
/*if(childnot==null) {
     childnot=tt;


}else {
*/
                    // n.addChild(tt);
//}



                    //  app.addChild(new )
                    // parr.addChild(  new TreeNode<>(new Dir(vvv)));

                }

                return  n;
//return  app;

            }
            public void addtree(  List<TreeNode>  nodes,List<MyObject> mm){



          /*  List<MyObject> mm=new ArrayList<>();
            Long.valueOf(1);
            MyObject kk=new MyObject(1L,"A",1L);
            MyObject kk1=new MyObject(2L,"A-1",1L);
            MyObject kk2=new MyObject(3L,"A-2",1L);
            MyObject kk3=new MyObject(4L,"A-1-1",2L);
            MyObject kk5=new MyObject(5L,"A-1-2",2L);
            MyObject kk55=new MyObject(6L,"A-2-1",5L);

            MyObject kk556=new MyObject(7L,"A-3-2",6L);
            mm.add(kk);
            mm.add(kk1);
            mm.add(kk2);
            mm.add(kk3);
            mm.add(kk5);
            mm.add(kk55);
            mm.add(kk556);
*/


                List<Node> ffg=  BuildTreeAndGetRoots(mm);
                Gson bb=new Gson();

                // jsondat.setText(bb.toJson(ffg));
                //  nodes = new ArrayList<>();
                for(int c=0;c<ffg.size();c++){
                    try {
                        // Trying to access element at index 8
                        // which will throw an Exception
                        Node element = ffg.get(c);
                        //   TreeNode<Dir> app = new TreeNode<>(new Dir(element.Source.objectName));


                        TreeNode tt=new TreeNode<>(new Dir(element.Source.objectName));
                        rreddv(element,tt);

                        nodes.add(tt);
                        //String vvv = element.getSourceObject().toString();
                        //      TreeNode<Dir> rr=   rredd(element);
                        // nodes.add(rr);

             /*   System.out.println("Given URL666 is : " + "hh");


                System.out.println("Given URL666 is : " + element.Children.size());
                element.Children.size();*/

                    }catch (Exception ex){
                    }
                }








            }
            @Override
            public void handleValue(final V view, final Value value) {
                if (value.isObject()) {
                    String type = value.getAsObject().getAsString(ATTRIBUTE_TYPE);
                    String typp="0";
                    try {
                        typp = ((ProteusRecyclerView) view).getTag(R.id.istree).toString();
                    }catch (Exception ex){

                    }
                    // String typp = value.getAsObject().getAsString("isTree");
                    // String typp="1";
                    if (type != null) {

                        if(typp.equals("1")){
                            List<MyObject> mda=new ArrayList<>();
                            TreeViewAdapter adapter;
                            List<TreeNode> nodes = new ArrayList<>();
                            ProteusContext context = (ProteusContext) view.getContext();
                            value.getAsObject();
                            ObjectValue data = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData();

                            Iterator<Map.Entry<String, Value>> vv = data.entrySet().iterator();
                            while (vv.hasNext()) {

                                Map.Entry<String, Value> ddert = vv.next();

                                Iterator<Value> vvx =ddert.getValue().getAsArray().iterator();
                                while (vvx.hasNext()) {

                                    Value ddertt = vvx.next();
                                    ObjectValue keynammm = ddertt.getAsObject();//.getKey();
                                    Gson ggff = new Gson();
                                    String kk=   keynammm.get("name").toString();
                                    String mm=   keynammm.get("child").toString();
                                    String parent=   keynammm.get("parent").toString();

                                    MyObject op=new MyObject(Long.valueOf(mm),kk,Long.valueOf(parent));
                                    mda.add(op);
                                    //  String ccn = ggff.toJson(keynammm);
                                    Log.i("lll", kk+" "+mm );
                                }
                            }

                            //("datamk");

                            Gson bb=new Gson();
                            Log.i("lll",     bb.toJson(data));
                            addtree(nodes,mda);

                            Layout layout = value.getAsObject().getAsObject().getAsLayout("item-layout");

                            adapter = new TreeViewAdapter(nodes, Arrays.asList(new FileNodeBinder(context.getInflater(),layout), new DirectoryNodeBinder(context.getInflater(),layout)));
                            // whether collapse child nodes when their parent node was close.
//        adapter.ifCollapseChildWhileCollapseParent(true);
                            adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
                                @Override
                                public boolean onClick(TreeNode node, RecyclerView.ViewHolder holder) {



                                    if (!node.isLeaf()) {
                                        //Update and toggle the node.
                                        onToggle(!node.isExpand(), holder);
//                    if (!node.isExpand())
//                        adapter.collapseBrotherNode(node);
                                    }
                                    return false;
                                }

                                @Override
                                public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                         /* DirectoryNodeBinder.ViewHolder dirViewHolder = (DirectoryNodeBinder.ViewHolder) holder;
                          //final ImageView ivArrow = dirViewHolder.getIvArrow();
                          int rotateDegree = isExpand ? 90 : -90;
                          ivArrow.animate().rotationBy(rotateDegree)
                                  .start();*/
                                }
                            });
                            view.setAdapter(adapter);
                            adapter.collapseAll();
                        }else {
                            typAdapter = type;

                            Gson gg = new Gson();
                            // String typev = value.getAsObject().getAsString("or");//oritation
                            //  Log.i("hhhhhhhhhh", gg.toJson(value.getAsObject().));//.getAsObject().toString());

                            if (type.equals("Adapter3")) {
                                ItemAdapter itemAdapter;
                                ArrayList<MenuItem> menuItems = new ArrayList<>();
                                int icon_width = 60;
                                int icon_height = 60;
                                int backgroundMenuColor = Color.parseColor("#FFFFFF");
                                int backgroundNotifications = Color.parseColor("#FF0000");
                                int item_textColor = Color.parseColor("#000000");
                                int item_backgroundColor = Color.parseColor("#FFFFFF");
                                int item_marginTop = 0;
                                int item_marginBottom = 0;
                                int item_marginLeft = 0;
                                int item_marginRight = 0;
                                int item_colorSelected = Color.parseColor("#0099cc");
                                int item_textSize = 12;
                             /*   MenuItem r=new MenuItem(R.drawable.addbtn,"hhh");
                                MenuItem rr=new MenuItem(R.drawable.btn_save_w,"hhhklj");
                                menuItems.add(r);
                                menuItems.add(rr);*/
                                itemAdapter = new ItemAdapter(view.getContext(), menuItems, icon_width, icon_height, item_textColor,
                                        item_backgroundColor, item_marginTop, item_marginBottom, item_marginLeft,
                                        item_marginRight, item_colorSelected, item_textSize, backgroundNotifications);

                                itemAdapter.setOnHSItemClickListener(new ItemAdapter.OnHSItemClickListener() {
                                    @Override
                                    public void onHSClick(MenuItem menuItem, int position) {
                                        // onHSMenuClickListener.onHSMClick(menuItem, position);
                                    }
                                });
                                view.setAdapter(itemAdapter);
                            }else{

                            if (!type.equals("Adapter2")) {

                                ProteusRecyclerViewAdapter adapter = adapterFactory.create(type, (ProteusRecyclerView) view, value.getAsObject());

                                List<myArrayAuto> uuio = new ArrayList<>();
                                final ObjectValue data = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData();

                                String nam = ((ProteusRecyclerView) view).getTag(R.id.tag3).toString();
                                myArrayAuto iioo = new myArrayAuto(nam, data);
                                try {
                                    // ((AutoCompleteTextViewB) view).setThreshold(1);

                                    boolean sech = false;
                                    int delett = 0;
                                  /*  if (GlobalClass.datsorce != null) {

                                        for (int xxc = 0; xxc < GlobalClass.datsorce.size(); xxc++) {
                                            if (GlobalClass.datsorce.get(xxc).getTagname().equals(nam)) {
                                                sech = true;
                                                delett = xxc;
                                            } else {
                                                myArrayAuto iioobb = new myArrayAuto(GlobalClass.datsorce.get(xxc).getTagname(), GlobalClass.datsorce.get(xxc).getDatasorsce());
                                                uuio.add(iioobb);
                                            }
                                        }
                                        if (sech) {
                                            uuio.remove(delett);

                                        }
                                    }*/

                                } catch (Exception e) {
                                    // Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+e.getMessage());
                                }

                                uuio.add(iioo);
                                int cc = 0;
                                for (int xxc = 0; xxc < uuio.size(); xxc++) {
                                    if (uuio.get(xxc).getTagname().equals(nam)) {
                                        cc = xxc;
                                    }
                                }
                                ((ProteusRecyclerView) view).setTag(R.id.indexIDtage, String.valueOf(cc));
                            //   GlobalClass.datsorce = uuio;
                                try {
                                    String typet = value.getAsObject().getAsString("tlayout");

                                    if (typet.equals("1")) {
                                        String co = value.getAsObject().getAsString("tlayoutcount");

                                        GridLayoutManager ff = new GridLayoutManager(view.getContext(), Integer.parseInt(co));
                                        view.setLayoutManager(ff);
                                    }

                                } catch (Exception ex) {

                                }

                                view.setAdapter(adapter);

                                Layout layout = value.getAsObject().getAsLayout("Prograss-layout");
                                ProteusContext context = (ProteusContext) view.getContext();
                                // context.getInflater();
                               /* paginate = Paginate.with(((ProteusRecyclerView) view), adapter)
                                        .setLoadingTriggerThreshold(5)
                                        .addLoadingListItem(true)
                                        .setLoadingListItemCreator(new CustomLoadingListItemCreator(context.getInflater(), layout))
                                        .setLoadingListItemSpanSizeLookup(new LoadingListItemSpanLookup() {
                                            @Override
                                            public int getSpanSize() {
                                                return 3;
                                            }
                                        })
                                        .build();*/
                            } else {


                                //  Gson gg = new Gson();
                                // String typev = value.getAsObject().getAsString("or");//oritation
                                //  Log.i("hhhhhhhhhh", gg.toJson(value.getAsObject().));//.getAsObject().toString());
                                final String typex = "kk"; //value.getAsObject().getAsString("tname");
                                boolean useMultiple = false;
                                boolean useOfline = false;
                                List<modeltypeview> temppxm = new ArrayList<>();
                                String valuu = "[]";


                                ObjectValue anima = value.getAsObject().getAsObject("animation");
                                try {
                                    Gson gsonn = new Gson();

                                    useOfline = anima.getAsBoolean("a_use_offline");
                                    ObjectValue usemultiple = value.getAsObject().getAsObject("UseMultiple");


                                    useMultiple = usemultiple.getAsBoolean("a_enable");
                                    valuu = usemultiple.getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                                    //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                                    ;

                                    //  Log.i("9988xx",gsonn.toJson(jkm));
                                    Type typez = new TypeToken<List<modeltypeview>>() {

                                    }.getType();
                                    temppxm = gsonn.fromJson(valuu, typez);

                                } catch (Exception ex) {
                                    //  Log.i("9988",ex.getMessage());
                                }
                                Gson gsonnx = new Gson();
                                // Log.i("9988",gsonnx.toJson(temppxm));
                                view.setTag(R.id.useMultipl, temppxm);
                                view.setTag(R.id.useMultiplenb, useMultiple);
                                final boolean useMultiplex = useMultiple;
                                final boolean useof = useOfline;
                                final List<modeltypeview> temppxmx = temppxm;
                                final Integer numberload = anima.getAsInteger("CountItem");


                                //   Log.i("6666", ((ProteusRecyclerView) view).manager.findViewById("bandar").getId()+"gg");
                                //  ObjectValue data = ;
                                String nametypData = "no";
                                ObjectValue data = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData();
                                Iterator<Map.Entry<String, Value>> vvk = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData().entrySet().iterator();
                                while (vvk.hasNext()) {
                                    Map.Entry<String, Value> ddert = vvk.next();
                                    nametypData = ddert.getKey();
                                }


                                final List<OOverIttem> mItemss = new ArrayList<OOverIttem>();
                                // final List< OOverIttem> mItemss = new ArrayList<OOverIttem>();
                                //   anotherAdapter iiop=new anotherAdapter(value.getAsObject());


                                try {


                                    ProteusContext contextv = (ProteusContext) view.getContext();

                                    // ObjectValue datax = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData();
                                    // data.entrySet().clear();
                                    Iterator<Map.Entry<String, Value>> vv = data.entrySet().iterator();
                                    while (vv.hasNext()) {

                                        Map.Entry<String, Value> ddert = vv.next();

                                        // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                                        for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {

                                            OOverIttem ioppp = new OOverIttem(temppxm, useMultiple, cx, typex, value.getAsObject(), contextv.getInflater(), ddert.getValue().getAsArray().get(cx));

                                            mItemss.add(ioppp);

                                            //   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

                                        }
                                    }
                                    Gson g = new Gson();


                                } catch (Exception ex) {


                                }


                                view.setTag(R.id.Objectlayout, value.getAsObject());
                                final String keyy = view.getTag(R.id.tagfirstload).toString();
                                final Integer IDrecycleview = view.getId();

                                final Value mVal = value;
                             //   GlobalClass.datttt = mItemss;
                                //  FlexibleAdapter.useTag("OverallAdapter");
                                FlexibleAdapter mnbb = new FlexibleAdapter(mItemss);//getdataIt(((ProteusRecyclerView) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);
                                //fdd.add(adapterFactory.create(type, (ProteusRecyclerView) view, value.getAsObject()));

                                long INITIAL_DELAY_300 = 300L;
                                mnbb.setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                                        .setAnimationInterpolator(new DecelerateInterpolator())
                                        .setAnimationInitialDelay(INITIAL_DELAY_300);


                                //mRecyclerView = getView().findViewById(R.id.recycler_view);
                                view.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout


                                view.setAdapter(mnbb);


                                final String finalNametypData = nametypData;
                                final EventProcessor uuip = new EventProcessor() {


                                    @Override
                                    public void setOnEventListener(View view, Value value) {

                                    }

                                    @Override
                                    public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view, EventProcessor proces, String[] somedsta) {
                                        super.triggerAdapter(typ, withtage, Tagv, event, value, view, proces, somedsta);

                                        if (typ == 51) {

                                            if (view.getAsView().getId() == IDrecycleview) {
                                                Gson hncv = new Gson();
                                                Type typex = new TypeToken<String[]>() {

                                                }.getType();
                                                String[] mnb = hncv.fromJson(Tagv, typex);
                                                new AsyncTaskRunnerv(view, "0", proces, withtage, somedsta, useof).execute(mnb[0], mnb[1], mnb[2], mnb[3], mnb[4], mnb[5], mnb[6], mnb[7], mnb[8], mnb[9], mnb[10], mnb[11]);

                                                // Log.i("999", mnb[0]);
                                                //Log.i("999", Tagv);
                                            }
                                            // }

                                        } else if (typ == 52) {


                                            if (withtage) {

                                                if (view.getAsView().getId() == IDrecycleview) {
                                                    Gson gg = new Gson();

                                                    //  Log.i("6666","88888888888888"+gg.toJson(value));

                                                    //  Log.i("0x0x","999999999999999999999101010"+gg.toJson(view.getViewManager().getDataContext().getData().get(finalNametypData)));
                                                    ObjectValue zz = new ObjectValue();
                                                    zz.add(keyy, value.get("s1"));
                                                    //  Log.i("6666", "88888888888888" + gg.toJson(view.getViewManager().getDataContext().getData().get("items")));
                                                    if (gg.toJson(view.getViewManager().getDataContext().getData().get(finalNametypData)).equals("{}")) {

                                                        // Log.i("0x0x","999999999999999999999101010xxxxx");
                                                        view.getViewManager().update(zz);
                                                        FlexibleAdapter hv = (FlexibleAdapter) ((ProteusRecyclerView) view).getAdapter();
                                                        hv.notifyDataSetChanged();
                                                        hv.onLoadMoreComplete(null);
                                                        hv.notifyDataSetChanged();


                                                        //(keyy);//.getDataContext().setData(zz);
                                                        // Log.i("6666", "88888888888888" + gg.toJson(view.getViewManager().getDataContext().getData().get("items")));

                                                        // hv.AhasFilter(true);
                                                    }
         /*  hv.notifyDataSetChanged();
        hv.onLoadMoreComplete(null);*/
                                                }

                                            } else {
                                                // Log.i("0x0x","999999999999999999999101010");
                                                if (view.getAsView().getId() == IDrecycleview) {
                                                    FlexibleAdapter hvk = (FlexibleAdapter) ((ProteusRecyclerView) view).getAdapter();
                                                    Log.i("000", "$$$");
                                                    List<OOverIttem> mItemssk = new ArrayList<OOverIttem>();
                                                    ObjectValue zz = new ObjectValue();
                                                    zz.add(keyy, value.get("s1"));
                                                    //  ObjectValue data = zz;//((ProteusRecyclerView) view).getViewManager().getDataContext().getData();

                                                    Gson x = new Gson();
                                                    // Log.i("000", "$$$" + x.toJson(data));
                                                    ProteusContext contextv = (ProteusContext) view.getViewManager().getContext();
                                                    int counnnt = 0;
                                                    Array uu = new Array();

                                                    Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
                                                    while (vv.hasNext()) {
                                                        Map.Entry<String, Value> ddert = vv.next();
                                                        counnnt = ddert.getValue().getAsArray().size();
                                                        Gson gg = new Gson();
                                                        //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                                                        // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                                                        for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {

                                                            // Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                                                            // uu.add(ddert.getValue().getAsArray().get(cx));

                                                            //   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

                                                            Integer iom = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData().get(finalNametypData).getAsArray().size();//.add(ddert.getValue().getAsArray().size();
                                                            OOverIttem ioppp = new OOverIttem(temppxmx, useMultiplex, iom + 1, "no", mVal.getAsObject(), contextv.getInflater(), ddert.getValue().getAsArray().get(cx));
                                                            assert hvk != null;
                                                            // hvk.addItem(ioppp);
                                                            ((ProteusRecyclerView) view).getViewManager().getDataContext().getData().get(finalNametypData).getAsArray().add(ddert.getValue().getAsArray().get(cx));
                                                            mItemssk.add(ioppp);
                                                            // mmArr.add();

                                                        }
                                                        if (counnnt == 0) {
                                                            assert hvk != null;
                                                            hvk.notifyDataSetChanged();

  /*  AutoCompleteTextViewB hh=(AutoCompleteTextViewB)view;
    hh.setAdapter(hvk);*/
                                                            // hvk.removeAllScrollableFooters();
                                                            hvk.setEndlessProgressItem(null);
                                                            hvk.notifyDataSetChanged();
                                                        } else {
                                                            // FlexibleAdapter hv = (FlexibleAdapter) ((ProteusRecyclerView) view).getAdapter();
                                                            assert hvk != null;
                                                            hvk.notifyDataSetChanged();
                                                            hvk.removeAllScrollableFooters();
                                                            hvk.onLoadMoreComplete(mItemssk);
                                                            hvk.notifyDataSetChanged();
                                                        }
                                                        //


                                                    }
                                                }
                                            }


                                               /*  }else{
                                                     check=false;
                                                 }*/


                                  /*   for (int cx = 0; cx < mItemssk.size(); cx++) {


                                         //   mmArr.add(mItemssk.get(cx).getdataa());
                                     }
*/
                                            // h.notifyDataSetChanged();
                                            // if(check) {

                                            //  h.onLoadMoreComplete(null);
                                            //  }


                                            //  Log.i("999", Tagv);
                                        }
                                    }

                                    @Override
                                    public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
                                        super.triggerAdapter(typ, withtage, Tagv, event, value, view);


                                    }


                                };
                                final String[] ggg = new String[]{"0"};

                                //  Log.i("iioopp","uuuuuuuu");
                                uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, ggg);

                                ProteusView.Manager.ActionEventView Act = new ProteusView.Manager.ActionEventView() {
                                    @Override
                                    public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

                                    }

                                    @Override
                                    public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {
                                        String[] fdc = new String[]{anotherdata};
                                        char k = '"';
                                        if (typ == 1) {//التحديث
                                            String uiopp = "{}";
                                            uiopp = uiopp.replace('#', k);
                                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(view.getContext());
                                            Gson gsonn = new GsonBuilder()
                                                    .registerTypeAdapterFactory(adapter)
                                                    .create();
                                            Type type = new TypeToken<Value>() {

                                            }.getType();
                                            Value tempp = gsonn.fromJson(uiopp, type);
                                            ObjectValue zz = new ObjectValue();
                                            // zz.add(keyy, tempp.getAsObject().get("s1"));

                                            ((ProteusRecyclerView) view).getViewManager().update(tempp.getAsObject());


                                            uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, fdc);
                                        }

                                        if (typ == 2) {//التحديث
                                            //   Log.i("0x0x","999999999999999999999");
                                            uuip.triggerAdapter(53, false, "0", anotherdata, null, (ProteusView) view, uuip, fdc);


                                        }

                                    }

                                    @Override
                                    public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {
                                        FlexibleAdapter hv = (FlexibleAdapter) ((ProteusRecyclerView) view).getAdapter();
//إرجاع قيمة البحث
                                        if (typ == 1) {

                                            hv.AhasFilter(true);
                                            // hv.updateDataSet(data);
                                        }
                                        if (typ == 2) {
                                            hv.AhasFilter(false);
                                            // hv.updateDataSet(data);
                                        }
                                        if (typ == 3) {
                                            hv.clear();
                                            //hv.updateDataSet(data);
                                        }
                                        if (typ == 4) {
                                            //hv.clear();
                                            hv.updateDataSet(data);
                                        }
                                    }

                                    @Override
                                    public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                                    }
                                };


                                //((ProteusRecyclerView) view).setViewManager().getViewManager().setActionEventView(Act);
                                if (((ProteusRecyclerView) view).manager.getActionEventView() == null) {
                                    ((ProteusRecyclerView) view).manager.setActionEventView(Act);
                                    //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

                                }


                                final FlexibleAdapter.EndlessScrollListener ddf = new FlexibleAdapter.EndlessScrollListener() {
                                    @Override
                                    public void noMoreLoad(int newItemsSize) {

                                    }

                                    @Override
                                    public void onLoadMore(final int lastPosition, int currentPage) {

                                        final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                                        if (hv.hasFilter()) {
                                            hv.onLoadMoreComplete(null);
                                            return;
                                        } else if (hv.AhasFilter()) {
                                            hv.onLoadMoreComplete(null);
                                            return;
                                        }
                                        new Handler().postDelayed(new Runnable() {
                                            @SuppressWarnings("unchecked")
                                            @Override
                                            public void run() {
                                                final List<AbstractFlexibleItem> newItems = new ArrayList<>(3);
                                                boolean check = true;
                                                String[] anoth = new String[]{"0"};
                                                // Simulating success/failure
                                                //   int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
                                                // Log.i("666","ddddddvvvvvvvvvxxxx");
                                                uuip.triggerAdapter(50, false, String.valueOf(lastPosition), String.valueOf(numberload), null, (ProteusView) view, uuip, anoth);

                                                // hv.onLoadMoreComplete(null);
                                                //FlexibleAdapter h = (FlexibleAdapter) view.getAdapter();
                                                // h.removeAllScrollableFooters();
                                              /*  for (int i = 1; i <= 3; i++) {

                                                   mnbb.addItem( mItemss.get(i));
                                                   // mnbb.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
                                                }*/


                                                // h.notifyDataSetChanged();

                                                // Log.i("555",mmArr.size()+"####");//g.toJson(((ProteusRecyclerView) view).getViewManager().getDataContext().getData().get("items").getAsArray()));

                                                //  mnbb.(mItemss);
                                                //   mnbb.notifyDataSetChanged();

//mnbb.addScrollableFooter(new ProgressItem());

                                            }
                                        }, 3000);


                                    }
                                };

                                mnbb.setAutoCollapseOnExpand(anima.getAsBoolean("a_expand_out"))
                                        .setAutoScrollOnExpand(anima.getAsBoolean("a_expand"))
                                        .setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                                        .setAnimationEntryStep(
                                                anima.getAsBoolean("a_enter_step")
                                        ) //In Overall, watch the effect at initial loading when Grid Layout is set
                                        .setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling)
                                        .setAnimationOnReverseScrolling(anima.getAsBoolean("a_anim_rev"))
                                        .setAnimationInterpolator(new DecelerateInterpolator())


                                        .setAnimationDuration(300L);
                                view.setItemAnimator(new FlexibleItemAnimator());
                                mnbb.setEndlessTargetCount(anima.getAsInteger("a_endless_count")).setEndlessPageSize(anima.getAsInteger("a_endless_page"));
                                // mnbb.setLoadingMoreAtStartUp(true)


                                // mnbb.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
                                //  .setStickyHeaders(true) //Make headers sticky
                                // Endless scroll with 1 item threshold

                                if (anima.getAsBoolean("a_use_endless")) {

                                    mnbb.setEndlessScrollListener(ddf, new ProgressItem());
                                }

                                mnbb.setLoadingMoreAtStartUp(anima.getAsBoolean("a_load_start")).setLongPressDragEnabled(anima.getAsBoolean("a_drage"))
                                        //.setEndlessScrollListener(this, new ProgressItem())
                                        .setEndlessScrollThreshold(1).setNotifyMoveOfFilteredItems(false) //When true, filtering on big list is very slow, not in this case!
                                        .setNotifyChangeOfUnfilteredItems(true); //true by default

                                if (anima.getAsBoolean("a_anim_for")) {
                                    mnbb.setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling);
                                }
                                //.setAnimationOnReverseScrolling(true);

                                //.setEndlessScrollThreshold(1); //Default=1

                                //SwipeRefreshLayout swipeRefreshLayout =view.getContext().findViewById(R.id.swipeRefreshLayout);
                                // swipeRefreshLayout.setEnabled(true);
                                // mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);

                                try {
                                    String typet = value.getAsObject().getAsString("tlayout");

                                    if (typet.equals("1")) {
                                        String co = value.getAsObject().getAsString("tlayoutcount");

                                        GridLayoutManager ff = new GridLayoutManager(view.getContext(), Integer.parseInt(co));
                                        view.setLayoutManager(ff);
                                    }

                                } catch (Exception ex) {
                                    Log.i("666", "dddddd");
                                }

                                // mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
                                // mRecyclerView.setAdapter(mAdapter);
                               /* view.setHasFixedSize(true); //Size of RV will not change
                                FlexibleItemDecoration mItemDecoration;
                                mItemDecoration = new FlexibleItemDecoration(view.getContext())

                                        .withOffset(8) // This helps when top items are removed!!
                                        .withEdge(true);
                                view.addItemDecoration(mItemDecoration);*/

                                // After Adapter is attached to RecyclerView
                                //   mnbb.setLongPressDragEnabled(      anima.getAsBoolean("a_drage"));


                              /*  ScrollableLayoutItem scrollHeader = new ScrollableLayoutItem("SLI");
                                scrollHeader.setTitle("Endless Scrolling");
                                scrollHeader.setSubtitle("...with ScrollableHeaderItem");
                              mnbb.addScrollableHeader(scrollHeader);*/

//mnbb.onLoadMoreComplete();
/*mnbb.setNotifyMoveOfFilteredItems(true);
mnbb.setNotifyChangeOfUnfilteredItems(true);
mnbb.setFilter("الاصول الثابتة");*/

                            }

                        }
                        }
                    }
                }



            }


            private  List<HeaderItem> createList(int size, int headers) {

                List<HeaderItem> vvc=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    HeaderItem ffedd=new HeaderItem(String.valueOf(i));
                    ffedd.setTitle("item"+String.valueOf(i));
                    ffedd.setSubtitle(String.valueOf(i));
                   // SimpleItem gg=new SimpleItem(String.valueOf(i),ffedd);
                    vvc.add(ffedd);
                }


                return vvc;
            }
            class AsyncTaskRunnerv extends AsyncTask<String, String, String> {

                private String resp;
                boolean tt=false;

                // ProgressDialog progressDialog;
                String bbaa="0";
                String bbaat="0";
                public ProteusView protvv;
                public   String prograssnn;
                public EventProcessor uuip;
                public  boolean checkk;
                public  String[] anoth;
                public boolean useoffline;
                AsyncTaskRunnerv(ProteusView myview, String prograssnnm, EventProcessor uuipp,boolean checkkm,String[] anothh,boolean useofflinee) {
                    this.protvv = myview;
                    this.prograssnn=prograssnnm;
                    this.uuip=uuipp;
                    this.checkk=checkkm;
                    this.anoth=anothh;
this.useoffline=useofflinee;

                }

                @Override
                protected String doInBackground(final String... params) {
                    // publishProgress("Sleeping..."); // Calls onProgressUpdate()
                    try {
                        //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                        //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);

                        String URL=params[0];
                        String Postmethod=params[1];
                        String requestbody=params[2];
                        final String refresh=params[3];
                        final String without=params[4];

                        Map<String,Object> hedermap=new HashMap<>();//Map<String, Object>();
                        HashMap<String,String> quarymap=new HashMap<>();//HashMap<String, String>();
                        try {
                            String heder=params[8];
                            String quary=params[9];
                            //  Log.i("4444444",heder);
                            Gson hnb = new Gson();
                            Type type = new TypeToken<List<hedaerOrQuary>>() {

                            }.getType();
                            List<hedaerOrQuary> hedde = hnb.fromJson(heder, type);
                            for (int cx = 0; cx < hedde.size(); cx++) {
                                hedermap.put(hedde.get(cx).getKeyName(),hedde.get(cx).getKeyValue());
                                //  Log.i("44444446555",hedde.get(cx).getKeyName());
                            }
                            List<hedaerOrQuary> qur = hnb.fromJson(quary, type);
                            for (int cx = 0; cx < qur.size(); cx++) {
                                quarymap.put(qur.get(cx).getKeyName(),qur.get(cx).getKeyValue());

                            }

                            //  dd.put()
                        }catch (Exception ex){
//Log.i("4444444vvv",ex.getMessage());

                        }

                        String contettyp="application/json; charset=UTF-8";
                        String userAgentt="fromandroid";
                        final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);
                        RequestBody requestBodyBinary = null;

                        requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                        // sendreq(params[0],params[1],params[2]);
                        Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary,hedermap,quarymap):Retrofitapi.GetMethod(URL,hedermap,quarymap);
                        call.enqueue(new Callback<ResponseBody>() {


                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                try {
                                    assert response.body() != null;

                                 //   showResult(response.body().string(),protvv.getAsView());
                                    String x="mydesin";

                                    if(response.isSuccessful()) {

                                        String kk= response.body().string();
                                       // assert response.errorBody() != null;
                                        try {
                                            String responseKey = params[11];

                                            if(!responseKey.equals("0")) {
                                                JSONObject js = new JSONObject(kk);
                                               kk = js.get(responseKey).toString();
                                            }
                                        }catch (Exception ex){

                                        }
                                        String k="{s1:"+kk+"}";
                                        if(refresh.equals("1")) {
try {

    if(useoffline) {
        String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
        ScriptModel g = new ScriptModel(0, k, mng);
        DatabaseHelper db_operations;
        db_operations = new DatabaseHelper(((ProteusRecyclerView) protvv).getContext());
        db_operations.insert(g);
    }
}catch (Exception ex){

}

                                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                            Gson gsonn = new GsonBuilder()
                                                    .registerTypeAdapterFactory(adapter)
                                                    .create();
                                            Type type = new TypeToken<Value>() {

                                            }.getType();
                                            Value tempp = gsonn.fromJson(k, type);
                                            uuip.triggerAdapter(52, checkk, k, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv),uuip,anoth);


                                            //  loadrefd();
                                            // aooldder(without,container, tempp.getAsObject());
                                        }else {
                                            //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                            // loadrefd();

                                            // masss.showmessage(k);

                                        }
                                     String   prograssnam="0";
                                        try {
                                           prograssnam =anoth[0];//enabprograss
                                        }catch (Exception ex){

                                        }
                                            if(!prograssnam.equals("0")) {
                                               // JSONObject js = new JSONObject(kk);
                                                ((ProteusRecyclerView) protvv).manager.getActionEventView().sendEvent(null,2,prograssnam);
                                            }

                                    }else{
                                        try {
                                            assert response.errorBody() != null;


                                            String kk= response.errorBody().string();
                                            // assert response.errorBody() != null;
                                            try {
                                                String responseKey = params[11];

                                                if(!responseKey.equals("0")) {
                                                    JSONObject js = new JSONObject(kk);
                                                    kk = js.get(responseKey).toString();
                                                }
                                            }catch (Exception ex){

                                            }


                                            String k="{s1:"+kk+"}";
                                            if(refresh.equals("1")) {
                                                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                                Gson gsonn = new GsonBuilder()
                                                        .registerTypeAdapterFactory(adapter)
                                                        .create();
                                                Type type = new TypeToken<Value>() {

                                                }.getType();
                                                Value tempp = gsonn.fromJson(k, type);
                                                uuip.triggerAdapter(52, checkk, k, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv),uuip,anoth);


                                              //  loadrefd();
                                                // aooldder(without,container, tempp.getAsObject());
                                            }else {
                                                //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                               // loadrefd();

                                                // masss.showmessage(k);

                                            }
                                            // masss.showmessage(ex.getMessage());

                                            String   prograssnam="0";
                                            try {
                                                prograssnam =anoth[0];//enabprograss
                                            }catch (Exception ex){

                                            }
                                            if(!prograssnam.equals("0")) {
                                               // JSONObject js = new JSONObject(kk);
                                                ((ProteusRecyclerView) protvv).manager.getActionEventView().sendEvent(null,2,prograssnam);
                                            }

                                            //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                            // savetoref(x, response.errorBody().string());
                                            //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                        }catch (IOException ex){

                                            //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));

                                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                            Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                        }
                                    }


                                } catch (Exception ex) {

                                    //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                    Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                   // loadrefd();
                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                //  stoptimertask();

                                // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
if(t.getMessage().startsWith("Unable to resolve host")){
    try {

        if(useoffline) {
            String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
            FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
          if(uk.getItemCount()==0) {

              ScriptModel g = new ScriptModel(0, "no", mng);
              DatabaseHelper db_operations;
              db_operations = new DatabaseHelper(((ProteusRecyclerView) protvv).getContext());
              List<ScriptModel> x = db_operations.getAllNotes(g);
              String val = x.get(0).getContent();
              ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
              Gson gsonn = new GsonBuilder()
                      .registerTypeAdapterFactory(adapter)
                      .create();
              Type type = new TypeToken<Value>() {

              }.getType();
              Value tempp = gsonn.fromJson(val, type);
              uuip.triggerAdapter(52, checkk, val, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv), uuip, anoth);
          }else{

              uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
              //uuip.triggerAdapter(52, checkk, val, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv), uuip, anoth);
          }
        }else {
            uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
        }
    }catch (Exception ex){

    }

}else {
    uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
}
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                               // loadrefd();
                                // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                                //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                            }
                        });


                    } catch (Exception ex) {

                        Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                      //  loadrefd();
                        // masss.showmessage(ex.getMessage());
                        // ex.getMessage();

                    }
                    return bbaa;
                }
                private void showResult(String result,View c) {
                    new AlertDialog.Builder(c.getContext())
                            .setMessage(result)
                            .setCancelable(true)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create()
                            .show();
                }

                @Override
                protected void onPostExecute(String result) {
                    try {

                    }catch (Exception e){

                        e.printStackTrace();
                    }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

                    // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
                }


                @Override
                protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
                }


                @Override
                protected void onProgressUpdate(String... text) {
                    // finalResult.setText(text[0]);

                }
            }


            class VH extends RecyclerView.ViewHolder {
                // TextView tvLoading;

                public VH(View itemView) {
                    super(itemView);
                    // tvLoading = (TextView) itemView.findViewById(R.id.tv_loading_text);
                }
            }
            @Override
            public void handleResource(V view, Resource resource) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }
        });

        addAttributeProcessor(ATTRIBUTE_LAYOUT_MANAGER, new AttributeProcessor<V>() {

            @Override
            public void handleValue(final V view, Value value) {
                if (value.isObject()) {
                    String type = value.getAsObject().getAsString(ATTRIBUTE_TYPE);
                    String usere = value.getAsObject().getAsString(Attributes.View.Recyle_use_reload);
                    RecyclerView.LayoutManager layoutManager = layoutManagerFactory.create(type, (ProteusRecyclerView) view, value.getAsObject());

                    assert usere != null;
                    if(usere.equals("1")){
                        if (type != null) {


                            if (layoutManager instanceof LinearLayoutManager) {
                                // Log.i("ProteusEventWithTag", "vvvvvvvvvvvvvvvmmmmm تحميلللللللللللللللل");
                                LinearLayoutManager g = (LinearLayoutManager) layoutManager;

              }
                        }

                    }
                    view.setLayoutManager(layoutManager);
                }
            }

            public  void showprograssbarr(ProteusView view,String countItem,String prograssnam,EventProcessor uuipx) throws MalformedURLException {



                String useapi =String.valueOf(view.getAsView().getTag(R.id.Recleapi_use));
                if(useapi.equals("1")) {

                    String urldat = String.valueOf(view.getAsView().getTag(R.id.Recleapi_url));
                    String resul[] = GlobalClass.getBaseURL(urldat);

                    GlobalClass.BseUrl2 = resul[0];
                    String methodtap = String.valueOf(view.getAsView().getTag(R.id.Recleapi_Method));
                    String requestbody = String.valueOf(view.getAsView().getTag(R.id.Recleapi_body));
                    String mmn = "'";
                    char d = mmn.charAt(0);
                    String mmnd = "@";
                    char dd = mmnd.charAt(0);
                    requestbody = requestbody.replace('#', '"').replace(dd, d);
                    String bbb = "[]";
                    try {
                        bbb = String.valueOf(view.getAsView().getTag(R.id.tag2));

                        CharSequence oopp=countItem;

                        bbb = bbb.replace('#', '"').replace(dd, d).replace("$",oopp);



                        new AsyncTaskRunner(view,prograssnam,uuipx).execute(resul[1],methodtap,bbb,"1","0");

                        // JSONObject js=new JSONObject(datab);
                        // Gson hnn = new Gson();
                        // bbb=hnn.toJson(datab);
                    } catch (Exception ex) {


                    }
                    // checknull = false;
                    // Log.i("ProteusEventWithTag", bbb);
      /*  Gson hn = new Gson();
        Type type = new TypeToken<List<DataValueSelect>>() {

        }.getType();
        List<DataValueSelect> kmn = hn.fromJson(bbb, type);
*/
                    //   String typad = kmn.get(0).getUnitName();
        /*allunit = null;
        allunit = new ArrayList<resultData>();
        serchhview(container, kmn);
        for (int cxx = 0; cxx < allunit.size(); cxx++) {

            Log.i("ProteusEventWithTag", allunit.get(cxx).getDataGet());
            Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
            requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }*/
                    Log.i("ProteusEventWithTag", requestbody);
                }


            }

            class AsyncTaskRunner extends AsyncTask<String, String, String> {

                private String resp;
                boolean tt=false;

                // ProgressDialog progressDialog;
                String bbaa="0";
                String bbaat="0";
                public ProteusView protvv;
                public   String prograssnn;
                public EventProcessor uuip;
                AsyncTaskRunner(ProteusView myview, String prograssnnm, EventProcessor uuipp) {
                    this.protvv = myview;
                    this.prograssnn=prograssnnm;
                    this.uuip=uuipp;


                }

                @Override
                protected String doInBackground(final String... params) {
                    // publishProgress("Sleeping..."); // Calls onProgressUpdate()
                    try {
                        //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                        Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                        // uuip.triggerAdapter(5, false, "1", this.prograssnn, null, ((ProteusRecyclerView) protvv));


                        //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");
                        String URL=params[0];
                        String Postmethod=params[1];
                        String requestbody=params[2];
                        final String refresh=params[3];
                        final String without=params[4];
                        String contettyp="application/json; charset=UTF-8";
                        String userAgentt="fromandroid";
                        final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);
                        RequestBody requestBodyBinary = null;

                        requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                        // sendreq(params[0],params[1],params[2]);
                        Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary):Retrofitapi.GetMethod(URL,requestBodyBinary);

                        call.enqueue(new Callback<ResponseBody>() {


                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                try {

                                    assert response.body() != null;
                                    // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");
                                    String x="mydesin";

                                    if(response.isSuccessful()) {

                                        String jm= "{s1:"+response.body().string()+"}";

                                        if(refresh.equals("1")) {
                                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                            Gson gsonn = new GsonBuilder()
                                                    .registerTypeAdapterFactory(adapter)
                                                    .create();
                                            Type type = new TypeToken<Value>() {

                                            }.getType();
                                            Value tempp = gsonn.fromJson(jm, type);

                                         //   Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+jm);

                                            //  uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv));

                                            // aooldder(without,container, tempp.getAsObject());
                                        }else{

                                            //  uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                            //  masss.showmessage(jm);
                                        }


                                    }else{
                                        try {
                                            assert response.errorBody() != null;
                                            String k="{s1:"+response.errorBody().string()+"}";
                                            if(refresh.equals("1")) {
                                                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                                Gson gsonn = new GsonBuilder()
                                                        .registerTypeAdapterFactory(adapter)
                                                        .create();
                                                Type type = new TypeToken<Value>() {

                                                }.getType();
                                                Value tempp = gsonn.fromJson(k, type);

                                               // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+k);


                                              //    uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv));

                                                // aooldder(without,container, tempp.getAsObject());
                                            }else {
                                                //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));


                                                // masss.showmessage(k);

                                            }
                                            // masss.showmessage(ex.getMessage());



                                            //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                            // savetoref(x, response.errorBody().string());
                                            //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                        }catch (IOException ex){
                                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                            // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                        }
                                    }


                                } catch (Exception ex) {
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                //  stoptimertask();
                                //  uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                                //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                            }
                        });


                    } catch (Exception ex) {
                        //   uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                        // masss.showmessage(ex.getMessage());
                        // ex.getMessage();

                    }
                    return bbaa;
                }


                @Override
                protected void onPostExecute(String result) {
                    try {

                    }catch (Exception e){

                        e.printStackTrace();
                    }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

                    // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
                }


                @Override
                protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
                }


                @Override
                protected void onProgressUpdate(String... text) {
                    // finalResult.setText(text[0]);

                }
            }
            @Override
            public void handleResource(V view, Resource resource) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }
        });

    }




}
