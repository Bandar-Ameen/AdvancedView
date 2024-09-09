package com.astooltech.advancedview.proteus.parser.custom;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.tableview.filter.Filter;
import com.astooltech.advancedview.proteus.tableview.listener.ITableViewListener;
import com.astooltech.advancedview.proteus.tableview.pagination.Pagination;
import com.astooltech.advancedview.proteus.tableview.tableviewsample.tableview.TableViewAdapter;
import com.astooltech.advancedview.proteus.tableview.tableviewsample.tableview.TableViewModel;
import com.astooltech.advancedview.proteus.tableview.tableviewsample.tableview.model.Cell;
import com.astooltech.advancedview.proteus.tableview.tableviewsample.tableview.model.ColumnHeader;
import com.astooltech.advancedview.proteus.tableview.tableviewsample.tableview.model.RowHeader;
import com.astooltech.advancedview.proteus.view.ProteusButton;
import com.google.gson.Gson;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.tableview.TableView;

import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
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
import com.astooltech.advancedview.proteus.view.custom.PrototuseTableView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrototuseTableViewParser <T extends TableView> extends ViewTypeParser<T> {
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout  parent, int dataIndex) {
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
    public String getType() {
        return "TableViews";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {
        return new PrototuseTableView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof PrototuseTableView){
            SetGetFindTextInputLayoutEditTextB((PrototuseTableView )view,data,typoper);
        }
    }
    private Value getvaluefromdat(String keyna, ObjectValue erx){
        Value val=null;
        Iterator<Map.Entry<String, Value>> uuo = erx.getAsObject().entrySet().iterator();
        while (uuo.hasNext()) {
            Map.Entry<String, Value> qqe = uuo.next();
            try {
                if (qqe.getKey().toLowerCase().equals(keyna.toLowerCase())) {
                    val=qqe.getValue();
                }
            }catch (Exception ex){

            }
        }
        return val;
    }

    private  void getwithanotheroper(PrototuseTableView dt, DataValueSelect datb, int typoper){
        PrototuseTableView   ccc = dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();



                        val.add("GetData", new Primitive("0"));//.getText().toString()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiop",ex.getMessage());
                    }



                } else if (datb.getTypselect().equals("1") ||datb.getTypselect().toLowerCase().equals("getvisibility")) {
                    try {
                        ObjectValue val = datb.getAnotherDatat();
                        val.add("GetData", new Primitive(dt.getVisibility()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                } else {


                    try {
                        ObjectValue val = datb.getAnotherDatat();
                        val.add("GetData", new Primitive(dt.isEnabled()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }
                }

            }


        }else   if (typoper == 3) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            Value typ=  getvaluefromdat("Type",datb.getAnotherDatat());

            if (IDDdat.equals(datb.getIDUnit())) {
                if (typ.getAsString().equals("0")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());

                        nextTablePage(dt);

                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }
                else if (typ.getAsString().equals("6")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());

                        previousTablePage(dt);

                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }
                else if (typ.getAsString().equals("7")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());

                        goToTablePage(Integer.parseInt(va.getAsString()),dt);

                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }
                else if (typ.getAsString().equals("8")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());

                        setTableItemsPerPage(Integer.parseInt(va.getAsString()),dt);

                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }

                else if (typ.getAsString().equals("1")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.startsWith("true")){
                            dt.setVisibility(View.VISIBLE);
                        }
                        else if(s.startsWith("1")){
                            dt.setVisibility(View.VISIBLE);
                        }else{
                            dt.setVisibility(View.GONE);
                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                }

                else if (typ.getAsString().equals("2")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.toLowerCase().equals("true")){
                            dt.setEnabled(true);
                        }
                        else if(s.equals("1")){
                            dt.setEnabled(true);
                        }else{
                            dt.setEnabled(false);
                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                }

            }


        }
    }

    private  void SetGetFindTextInputLayoutEditTextB( PrototuseTableView dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                        }else   if(datb.getTypselect().equals("1")) {
                            dt.setVisibility(View.VISIBLE);
                        }
                        else   if(datb.getTypselect().equals("2")) {
                            dt.setVisibility(View.GONE);
                        }
                        else   if(datb.getTypselect().equals("3")) {
                            dt.setEnabled(false);
                        }

                        else   if(datb.getTypselect().equals("4")) {
                            dt.setEnabled(true);
                        }
                        else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();


                        }
                    }
                }

            }

        }else{

            getwithanotheroper(dt,datb,typoper);

        }
    }

    public void nextTablePage(PrototuseTableView b) {
        if (b.getMpganation() != null) {
            b.getMpganation().nextPage();
        }
    }

    public void previousTablePage(PrototuseTableView b) {
        if (b.getMpganation() != null) {
            b.getMpganation().previousPage();
        }
    }

    public void goToTablePage(int page,PrototuseTableView b) {
        if (b.getMpganation() != null) {
            b.getMpganation().goToPage(page);
        }
    }

    public void setTableItemsPerPage(int itemsPerPage,PrototuseTableView b) {
        if (b.getMpganation() != null) {
            b.getMpganation().setItemsPerPage(itemsPerPage);
        }
    }
    private void addlisiner(PrototuseTableView b){
try {
    Filter mTableFilter = new Filter(b);
    final Pagination mPagination = new Pagination(b);
    b.setMpganation(mPagination);
    b.setMfilter(mTableFilter);

    Pagination.OnTableViewPageTurnedListener onTableViewPageTurnedListener = new
            Pagination.OnTableViewPageTurnedListener() {
                @Override
                public void onPageTurned(int numItems, int itemsStart, int itemsEnd) {
                    int currentPage = mPagination.getCurrentPage();
                    int pageCount = mPagination.getPageCount();
                    //  previousButton.setVisibility(View.VISIBLE);
                    // nextButton.setVisibility(View.VISIBLE);

                    if (currentPage == 1 && pageCount == 1) {
                        //  previousButton.setVisibility(View.INVISIBLE);
                        //  nextButton.setVisibility(View.INVISIBLE);
                    }

                    if (currentPage == 1) {
                        // previousButton.setVisibility(View.INVISIBLE);
                    }

                    if (currentPage == pageCount) {
                        //nextButton.setVisibility(View.INVISIBLE);
                    }

                    // tablePaginationDetails.setText(getString(R.string.table_pagination_details, String
                    // .valueOf(currentPage), String.valueOf(itemsStart), String.valueOf(itemsEnd)));

                }
            };

    // Sets the pagination listener of the TableView pagination to handle
    // pagination actions. See onTableViewPageTurnedListener variable declaration below.
    mPagination.setOnTableViewPageTurnedListener(onTableViewPageTurnedListener);
    b.setTableViewListener(new ITableViewListener() {
        @Override
        public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

        }

        @Override
        public void onCellDoubleClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

        }

        @Override
        public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

        }

        @Override
        public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

        }

        @Override
        public void onColumnHeaderDoubleClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

        }

        @Override
        public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

        }

        @Override
        public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

        }

        @Override
        public void onRowHeaderDoubleClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

        }

        @Override
        public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

        }
    });
}catch (Exception ex){

    Log.e("ddd",ex.getMessage());
}
    }
    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("Table_data", new AttributeProcessor<T>() {


            @Override
            public void handleValue(final T view, Value value) {
              try {
                  addlisiner((PrototuseTableView)view);
                    Value ghh=  value.getAsObject().get("Data_From");
                    List<ColumnHeader> hedcol=new ArrayList<>();
                    List<List<Cell>> celldat=new ArrayList<>();
                    List<RowHeader> reo=new ArrayList<>();
                   final Array columnnheader=value.getAsObject().getAsArray("Column_Header");
                   Iterator<Value> ttt=columnnheader.iterator();
                   while (ttt.hasNext()){

                       ObjectValue ob=ttt.next().getAsObject();
                    String hedername="no";
                    Iterator<Map.Entry<String, Value>> tttr=  ob.entrySet().iterator();
                       while (tttr.hasNext()){
                           Map.Entry<String, Value> uuuu=tttr.next();
                           if(uuuu.getKey().equals("Header_Title")){
                               hedername=uuuu.getValue().getAsString();
                           }
                       }
                       ColumnHeader hed=new ColumnHeader(hedername,hedername);
                       hedcol.add(hed);


                   }
                   int countt=0;
                    Array columnnheaderv=value.getAsObject().getAsArray("Column_Data");
                    Iterator<Value> tttv=columnnheaderv.iterator();
                    while (tttv.hasNext()){

                        ObjectValue ob=tttv.next().getAsObject();

                        RowHeader  hgg=new RowHeader(String.valueOf(countt),String.valueOf(countt));
                        reo.add(hgg);
                        countt=countt+1;
                        List<Cell> cell=new ArrayList<>();
                        Iterator<Map.Entry<String, Value>> tttr=  ob.entrySet().iterator();
                        while (tttr.hasNext()){
                            Map.Entry<String, Value> uuuu=tttr.next();
                          String  hedername=uuuu.getValue().getAsString();
                          Cell oll=new Cell(hedername,hedername);
                             cell.add(oll);

                        }

                        celldat.add(cell);


                    }

                   /* TableViewAdapter tableViewAdapter = new TableViewAdapter();

                    ((PrototuseTableView) view).setAdapter(tableViewAdapter);
                    ((PrototuseTableView) view).setTableViewListener(new TableViewListener(view));
*/
                  //  hedarcolf(ddert.getValue(),tableViewAdapter);
                    // Create an instance of a Filter and pass the TableView.
                    //mTableFilter = new Filter(mTableView);

                    // Load the dummy data to the TableView
                //   tableViewAdapter.setAllItems( hedcol, reo, celldat);


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
                                    OOverIttem cc=(OOverIttem)ddert.getValue().get(0);
                                    if(((PrototuseTableView) view).getAdapter()==null) {
                                        TableViewModel tableViewModel = new TableViewModel();
                                        TableViewAdapter tableViewAdapter = new TableViewAdapter(tableViewModel);

                                        ((PrototuseTableView) view).setAdapter(tableViewAdapter);
                                       // ((PrototuseTableView) view).setTableViewListener(new TableViewListener(view));

                                       new AsyncTaskRunnerv(ddert.getValue(),tableViewAdapter,columnnheader).execute();
                                        //  FlexibleAdapter.useTag("OverallAdapter");
                                       // flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(),android.R.layout.simple_list_item_1,ddert.getValue(),((SpainnerViewB) view).getViewManager().getContext().getInflater(),((SpainnerViewB) view),cc.getWith(), cc.Usemul(),false);
                                        //  flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(), android.R.layout.simple_list_item_1, ddert.getValue(), ((SpainnerViewB) view).getViewManager().getContext().getInflater(), ((SpainnerViewB) view), cc.getWith(), cc.Usemul());//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);


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
                 //  new Pagination(((PrototuseTableView) view));
                   loadalltegret(iop,wer, ((PrototuseTableView) view),0,0,ghh);
                  //  Cell bbv=new Cell(,);

String ffre="116";//view.getTag(R.id.columnn).toString();

                    // ProteusView viewmk =  context.getInflater().inflate(, proteusManager.getData());
                    // Create TableView Adapter
                 /*   TableViewAdapter tableViewAdapter = new TableViewAdapter(tableViewModel,viewm,rowcol,corner,namecolum);

                    view.setAdapter(tableViewAdapter);
                    view.setTableViewListener(new TableViewListener(view));*/
/*view.setSelected(true);
TableView vvc=(TableView)view;
vvc.setShowCornerView(true);*/
view.setSelected(true);


//  view.Setclick(true,true,clickchedIn,clickcell,clickched,false,false);
                    // Create an instance of a Filter and pass the TableView.
                    //mTableFilter = new Filter(mTableView);

                    // Load the dummy data to the TableView
                   /* tableViewAdapter.setAllItems(tableViewModel.getColumnHeaderList(vxx), tableViewModel
                            .getRowHeaderList(rowcount), tableViewModel.getCellList(data));*/

                  //  view.setHasFixedWidth(true);
                 //   view.isRowVisible(View.GONE);
                    //.getAsString(ATTRIBUTE_TYPE);

                  //  ParseHelper.parseBoolean(type);
                }catch(Exception ex){

                }
            }

            @Override
            public void handleResource(T view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(T view, StyleResource style) {

            }
public void sethedar(Array columnnheader,String colname){

   // Array columnnheader=value.getAsObject().getAsArray("Column_Header");
    Iterator<Value> ttt=columnnheader.iterator();
    while (ttt.hasNext()){

        ObjectValue ob=ttt.next().getAsObject();
        String hedername="no";
        boolean ttru=false;
        Iterator<Map.Entry<String, Value>> tttr=  ob.entrySet().iterator();
        while (tttr.hasNext()){
            Map.Entry<String, Value> uuuu=tttr.next();
            if(uuuu.getKey().equals("Header_Name")) {
                if (colname.equals(uuuu.getValue().getAsString())) {
                    ttru = true;
                }
            }
            if(uuuu.getKey().equals("Header_Title")){
                hedername=uuuu.getValue().getAsString();
            }
        }

if(ttru){
    colname= hedername;
    ttru=false;
}

    }
}
          public  List<ColumnHeader> hedarcol(ObjectValue obj){
              List<ColumnHeader> datro=new ArrayList<>();
              Iterator<Map.Entry<String, Value>> tttr=  obj.entrySet().iterator();
              while (tttr.hasNext()){
                  Map.Entry<String, Value> uuuu=tttr.next();
                 // if(uuuu.getKey().equals("Header_Title")){
                  ColumnHeader hed=new ColumnHeader(uuuu.getKey(),uuuu.getKey());
                  datro.add(hed);
                  }

             return datro;

          }

            class AsyncTaskRunnerv extends AsyncTask<String, String, String> {
               private List<AbstractFlexibleItem> obj;
              private TableViewAdapter ad;
              private Array ar;
public AsyncTaskRunnerv(List<AbstractFlexibleItem> obj,TableViewAdapter ad, Array ar){
    this.obj=obj;
    this.ad=ad;
    this.ar=ar;
}
                @Override
                protected String doInBackground(String... strings) {

                    hedarcolf(obj,ad, ar);
                    return "0";
                }
            }
            public  void hedarcolf(List<AbstractFlexibleItem> obj,TableViewAdapter ad,Array hedrnam){
                List<ColumnHeader> datro=new ArrayList<>();
                List<RowHeader> reo=new ArrayList<>();
                List<List<Cell>> celldat=new ArrayList<>();
                int countser=0;
                for (int ii = 0; ii < obj.size(); ii++) {
                    OOverIttem cc=(OOverIttem)obj.get(ii);//.getValue().get(0);
                    List<Cell> retu=new ArrayList<>();
                    RowHeader hgg=new RowHeader(String.valueOf(countser),String.valueOf(countser));
                    reo.add(hgg);
            countser=countser+1;
                    Iterator<Map.Entry<String, Value>> tttr = cc.getdataa().getAsObject().entrySet().iterator();
                    while (tttr.hasNext()) {
                        Map.Entry<String, Value> uuuu = tttr.next();
                        if(countser==1){
                            String jkeyname=uuuu.getKey();

                            sethedar(hedrnam,jkeyname);

                            ColumnHeader hed=new ColumnHeader(jkeyname,jkeyname);
                            datro.add(hed);


                        }
                        // if(uuuu.getKey().equals("Header_Title")){
                       Cell hed = new Cell (uuuu.getValue().getAsString(), uuuu.getValue().getAsString());
                        retu.add(hed);
                    }
                    celldat.add(retu);
                }

                Log.e("566","gggg"+celldat.size());
                Log.e("566","gggg"+datro.size());
                Log.e("566","ggggf"+celldat.get(0).size());
                ad.setAllItems( datro, reo, celldat);

            }
            //
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

        });
        addAttributeProcessor(Attributes.View.filter, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {







                  /*  @SuppressLint("SimpleDateFormat")
                    SimpleDateFormat g=new SimpleDateFormat(value);
                    Calendar v=Calendar.getInstance();
                    String ggh=g.format(v.getTime());
                    int yerr,month,day;
                    month=v.get(Calendar.MINUTE);
                    yerr=v.get(Calendar.YEAR);
                    day=v.get(Calendar.DAY_OF_MONTH);*/
                   // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }


}
