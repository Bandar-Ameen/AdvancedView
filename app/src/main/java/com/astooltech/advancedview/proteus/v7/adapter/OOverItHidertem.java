package com.astooltech.advancedview.proteus.v7.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.StaggeredHeaderItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.StaggeredItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractSectionableItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OOverItHidertem extends AbstractSectionableItem<ProtoisVH, OOverItHidertemheaderOnly> implements IFilterable<String> {

    private int id;
    private String title;
    private String description;
    private Drawable icon;
    private Value data;
    private Value objectValuee;
    private ProteusLayoutInflater layoutInflaterrr;
    private static final String ATTRIBUTE_ITEM_LAYOUT = "item-layout";

    private Layout layout;
    //  private  Layout mlayout;
    private Map<String, Value> scope;
    private  int typdata;
    private boolean usetyp;
    private ProteusView mvue;
    private List<modeltypeview> viewtypData;
    private String[] filterdata;
    public OOverItHidertem(List<modeltypeview> viewtypData, boolean usetyp, int id, String title, ObjectValue objectValue, ProteusLayoutInflater layoutInflaterr, Value data,OOverItHidertemheaderOnly header) {
        super(header);
        Layout cx = objectValue.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
        this.viewtypData=viewtypData;
        this.usetyp=usetyp;

        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
        this.scope = layout.data;
        this.data = data;
        this.id = id;
        this.title = title;
        this.objectValuee=objectValue;
        this.layoutInflaterrr=layoutInflaterr;
       /* if(id==3){

            Gson tt=new Gson();

            Log.i("6666",tt.toJson(this.layout)+"jjjh");
        }*/
        setSelectable(false);
        //Allow dragging
        setDraggable(true);
    }
    public OOverItHidertem(List<modeltypeview> viewtypData,boolean usetyp,int id, String title, ObjectValue objectValue, ProteusLayoutInflater layoutInflaterr,Value data, String[] filterdataax,OOverItHidertemheaderOnly header) {
        super(header);
        Layout cx = objectValue.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
        this.viewtypData=viewtypData;
        this.usetyp=usetyp;
        this.filterdata=filterdataax;
        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
        this.scope = layout.data;
        this.data = data;
        this.id = id;
        this.title = title;
        this.objectValuee=objectValue;
        this.layoutInflaterrr=layoutInflaterr;
       /* if(id==3){

            Gson tt=new Gson();

            Log.i("6666",tt.toJson(this.layout)+"jjjh");
        }*/
        setSelectable(false);
        //Allow dragging
        setDraggable(true);
    }
    public OOverItHidertem(List<modeltypeview> viewtypData,boolean usetyp,int id, String title, Layout objectValue, ProteusLayoutInflater layoutInflaterr,Value data,OOverItHidertemheaderOnly header) {
        super(header);
        Layout cx = objectValue;
        this.viewtypData=viewtypData;
        this.usetyp=usetyp;

        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
        this.scope = layout.data;
        this.data = data;
        this.id = id;
        this.title = title;
        this.objectValuee=objectValue;
        this.layoutInflaterrr=layoutInflaterr;

        setSelectable(false);
        //Allow dragging
        setDraggable(true);

       /* if(id==3){

            Gson tt=new Gson();

            Log.i("6666",tt.toJson(this.layout));
        }*/
    }
    private List<OOverItHidertem> mergedItems;
    public OOverItHidertem(List<modeltypeview> viewtypData,boolean usetyp,int id, String title, Layout objectValue, ProteusLayoutInflater layoutInflaterr,Value data,String[] filterdataax,OOverItHidertemheaderOnly header) {
        super(header);
        Layout cx = objectValue;
        this.viewtypData=viewtypData;
        this.usetyp=usetyp;
        this.filterdata=filterdataax;
        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
        this.scope = layout.data;
        this.data = data;
        this.id = id;
        this.title = title;
        this.objectValuee=objectValue;
        this.layoutInflaterrr=layoutInflaterr;

        setSelectable(false);
        //Allow dragging
        setDraggable(true);

       /* if(id==3){

            Gson tt=new Gson();

            Log.i("6666",tt.toJson(this.layout));
        }*/
    }

    public boolean hasMergedItems() {
        return mergedItems != null;
    }



    public int countMergedItems() {
        return hasMergedItems() ? mergedItems.size() : 0;
    }

    public List<OOverItHidertem> getMergedItems() {
        return mergedItems;
    }

    public void setMergedItems(List<OOverItHidertem> mergedItems) {
        this.mergedItems = mergedItems;
    }

    public void mergeItem(OOverItHidertem staggeredItem) {
        if (mergedItems == null) {
            mergedItems = new ArrayList<>(1);
        }
        mergedItems.add(staggeredItem);
    }

    public void splitItem(OOverItHidertem staggeredItem) {
        if (mergedItems != null) {
            mergedItems.remove(staggeredItem);
            if (mergedItems.isEmpty()) mergedItems = null;
        }
    }


    public List<OOverItHidertem> splitAllItems() {
        List<OOverItHidertem> newItems = new ArrayList<>();
        if (mergedItems != null) {
            newItems = new ArrayList<>(mergedItems);
            mergedItems = null;
        }
        return newItems;
    }
    public OOverItHidertem layoutt(String description) {
        this.description = description;
        return this;
    }
    public OOverItHidertem withDescription(String description) {
        this.description = description;
        return this;
    }
    public OOverItHidertem WithMutlip(List<modeltypeview> viewtypData) {
        this.viewtypData =viewtypData;
        return this;
    }
    public Layout WithLayout() {

        return layout;
    }
    public OOverItHidertem withIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public OOverItHidertem withEnabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    public Value getdataa(){

        return  data;

    }
    public ProteusView Getview(){

        return  mvue;

    }
    public boolean Usemul(){

        return  usetyp;

    }
    public void remove(){

        objectValuee=null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OOverItHidertem that = (OOverItHidertem) o;
        return id == that.id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_overall_item;
    }



    @Override
    public int getItemViewType() {
        if(usetyp) {

            int typx=0;
            for (int cx = 0; cx < viewtypData.size(); cx++) {
                modeltypeview k=viewtypData.get(cx);
                String datget = data.getAsObject().get(k.getV_ColumnName()).toString();
                if(datget.equals(k.getV_EqualValue())){

                    typx=Integer.parseInt(k.getV_id());
                }
                // data.getAsObject().get()
            }

            return  typx;
        }else {
            return super.getItemViewType();
        }
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, ProtoisVH holder, int position, List<Object> payloads) {

        try {










            Setview(holder.view);
            // if (!adapter.hasFilter()) {


            holder.view.getViewManager().update(data.getAsObject());
            //    }
//holder.view.getViewManager().getContext().getInflater().inflate(title,objectValuee);
            //  final DataContext context = DataContext.create(holder.context, objectValuee, position, objectValuee);
//holder.view.getViewManager()..update(objectValuee);
//holder.view.getViewManager()
            //  Log.i("io", "jjjjjjjjjj");
            //  eerrt.removeAllViews();
            //  ObjectValue ccf = data; //data.entrySet().iterator().next().getValue().getAsArray().get(position).getAsObject();//, contextv.getInflater()
            //  ProteusView viewx = layoutInflaterrr.inflate(title, objectValuee);
            //eer(viewx.getAsView());
        }catch (Exception ex){

        }

      /*  if (getTitle() != null) {
            holder.mTitle.setText(getTitle());
            holder.mTitle.setEnabled(isEnabled());
        }
        if (getDescription() != null) {
            holder.mSubtitle.setText(Utils.fromHtmlCompat(getDescription()));
            holder.mSubtitle.setEnabled(isEnabled());
        }
        if (getIcon() != null) {
            holder.mIcon.setImageDrawable(getIcon());
        }*/
    }

    @Override
    public ProtoisVH createViewHolder(View view, FlexibleAdapter adapter, int viewType) {


        //   Log.i("yyy","uuuu"+adapter.getCurrentItems().size());
        if(usetyp) {

            String inflatename="0";
            for (int cx = 0; cx < viewtypData.size(); cx++) {
                modeltypeview k=viewtypData.get(cx);
                // String datget = data.getAsObject().get(k.getV_ColumnName()).toString();
                if(Integer.parseInt(k.getV_id())==viewType){

                    inflatename=k.getV_Name();
                }
                // data.getAsObject().get()
            }

            if(inflatename.equals("0")) {
                ProteusView viewx = layoutInflaterrr.inflate(layout, new ObjectValue());
                Setview(viewx);
                return new ProtoisVH(viewx, adapter);
            }else{

                ProteusView viewx = layoutInflaterrr.inflate(inflatename, new ObjectValue());
                Setview(viewx);
                return new ProtoisVH(viewx, adapter);
            }
        }else {

            ProteusView viewx = layoutInflaterrr.inflate(layout, new ObjectValue());
            Setview(viewx);
            return new ProtoisVH(viewx, adapter);
        }

    }



    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void Setview(ProteusView v) {
        this.mvue = v;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }
    public List<modeltypeview> getWith() {
        return viewtypData;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public boolean isEqilOrnot() {

        return eqilOrnot;
    }

    public void setEqilOrnot(boolean eqilOrnot) {
        this.eqilOrnot = eqilOrnot;
    }

    private boolean eqilOrnot;
    @Override
    public boolean filter(String constraint) {
        boolean trueif;
        List<Boolean> datar=new ArrayList<>();
        if(this.filterdata!=null){
            for (int cx = 0; cx <this.filterdata.length; cx++) {
                if(isEqilOrnot()) {
                    boolean re = data.getAsObject() != null && data.getAsObject().get(this.filterdata[cx]).toString().equals(constraint);
                    datar.add(re);
                }else{
                    boolean re = data.getAsObject() != null && data.getAsObject().get(this.filterdata[cx]).toString().contains(constraint);
                    datar.add(re);
                }
            }

        }
        int trr=0;
        int faa=0;
        for (int cx = 0; cx <datar.size(); cx++) {
            if(datar.get(cx)){

                trr=trr+1;
            }else {
                faa=faa+1;
            }

        }
        if(trr==0){
            return false;
        }else {
            return true;
        }
        // return data.getAsObject() != null && data.getAsObject().get("drugName_ar").toString().contains(constraint);
    }


}