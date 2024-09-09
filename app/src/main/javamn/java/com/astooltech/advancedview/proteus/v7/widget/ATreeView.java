package com.astooltech.advancedview.proteus.v7.widget;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.MyObject;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.Node;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeNode;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeViewAdapter;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.bean.Dir;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder.DirectoryNodeBinder;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder.FileNodeBinder;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.astooltech.advancedview.proteus.design.TreeViewCustome.getRootNod_from_List.BuildTreeAndGetRoots;


public class ATreeView<V extends RecyclerView> extends ViewTypeParser<V> {
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
        return "ATreeView";
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



        addAttributeProcessor("mdata", new AttributeProcessor<V>() {

            @Override
            public void handleValue(final V view, final Value value) {
                final Value ghh=  value.getAsObject().get("Data_From");

                ObjectValue child=value.getAsObject().getAsObject("Tree_Data");

                final String childk=child.getAsString("Child_Key");
                final String parentk=child.getAsString("Parent_Key");
                final String Valuekey=child.getAsString("Value_Key");
                // List<AbstractFlexibleItem> itt=new ArrayList<>();
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
                final IValuesData iop= new IValuesData() {
                    @Override
                    public void sendData(String datab, int typdata) {

                    }
                    @Override
                    public void setDataAdvanced(Map<String,List<AbstractFlexibleItem>> datresult, int typ) {

                        Iterator<Map.Entry<String, List<AbstractFlexibleItem>>> ddd=datresult.entrySet().iterator();
                        while (ddd.hasNext()){
                            Map.Entry<String,List<AbstractFlexibleItem>> ddert=ddd.next();
                            if(ddert.getKey().equals("main")){

                               // OOverIttem cc=(OOverIttem)ddert.getValue().get(0);
                                if(((ProteusRecyclerView) view).getAdapter()==null) {
                                    List<MyObject> mda=new ArrayList<>();
                                    TreeViewAdapter adapter;
                                    List<TreeNode> nodes = new ArrayList<>();
                                    //  FlexibleAdapter.useTag("OverallAdapter");
Layout lay=null;  Gson ggg=new Gson();
int count=0;
                                    Iterator<AbstractFlexibleItem> vv = ddert.getValue().iterator();
                                    while (vv.hasNext()) {
                                        AbstractFlexibleItem dderu=vv.next();
                                        count=count+1;
                                        OOverIttem ov=(OOverIttem)dderu;
                                        if(count==1){



                                            lay=ov.WithLayout(); //ghh.getAsObject().getAsLayout("Def_Views");
                                        }

                                        //ov.getdataa().getAsObject().getAsString();
                                        try {
                                            String kk = ov.getdataa().getAsObject().getAsString(Valuekey);
                                            String mm = ov.getdataa().getAsObject().getAsString(childk);
                                            String parent = ov.getdataa().getAsObject().getAsString(parentk);//.toString();
                                            ////Log.e("999",kk+"@"+mm+"@"+parent);
                                          MyObject op = new MyObject(Long.valueOf(mm), kk, Long.valueOf(parent));

                                            mda.add(op);
                                        }catch(Exception ex){
                                           // Log.e("999",ex.getMessage());
                                        }
                                    }
                                  //  Log.e("999","hghghg"+mda.size());
                                    addtree(nodes,mda);
                                    TreeViewAdapter  adapterx = new TreeViewAdapter(nodes, Arrays.asList(new FileNodeBinder(((ProteusRecyclerView) view).getViewManager().getContext().getInflater(),lay), new DirectoryNodeBinder(((ProteusRecyclerView) view).getViewManager().getContext().getInflater(),lay)));

                                    adapterx.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
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
                                   view.setLayoutManager(new LinearLayoutManager(view.getContext()));

                                    view.setAdapter(adapterx);
                                    adapterx.collapseAll();
                                    //  flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(),android.R.layout.simple_list_item_1,ddert.getValue(),((ProteusRecyclerView) view).getViewManager().getContext().getInflater(),((ProteusRecyclerView) view),cc.getWith(), cc.Usemul(),false);
                                    //  flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(), android.R.layout.simple_list_item_1, ddert.getValue(), ((SpainnerViewB) view).getViewManager().getContext().getInflater(), ((SpainnerViewB) view), cc.getWith(), cc.Usemul());//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);

                                  //  ((ProteusRecyclerView) view).setAdapter(mnbb);
                                }
                            }else {
                                       /* if(this.mListItemsSer==null) {
                                            this.mListItemsSer = ddert.getValue();
                                        }else {
                                            this.mListItemsSer.addAll(ddert.getValue());

                                        }*/
                            }

                        }

                        //   final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                        //  hv.onLoadMoreComplete(datresult);

                    }
                };

              //  final  Value v=ghh.getAsObject().getAsLayout("Def_Views");//.get;



                // view.setThreshold(1);
                loadalltegret(iop,wer, ((ProteusRecyclerView) view),0,0,ghh);
                //view.setAdapter(AAadpterme.newInstaince(itt,ghh,((AutoCompleteTextViewB) view)));
            }
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

            public void loadalltegret(IValuesData vc , ProteusView.Manager.ActionEventViewForUto dd, ProteusView infl, int numberreload, int counrtnumber, Value v){

                Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

                Value getval=v;//this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.LogtoJson(ttrt);*/
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



        addAttributeProcessor("Recycle", new AttributeProcessor<V>() {
            @Override
            public void handleValue(V view, Value value) {
                String typp=value.getAsObject().get("typ").toString();

                if(typp.equals("v")) {
                    view.setLayoutManager(new LinearLayoutManager(view.getContext()));
                }else{
                    view.setLayoutManager(new LinearLayoutManager(view.getContext()));
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