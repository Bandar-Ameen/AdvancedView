package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendedDictionaryAutocompleteProviderA extends AbstractProvider implements DynamicAutocompleteProvider<AbstractFlexibleItem> {

    private static final String REST_URL = "http://sstgadh.wirt09.biznes-host.pl/rest/api/country/%s";
    private List<AbstractFlexibleItem> mlistdat;

    private ProteusView zxbx;
    private List<modeltypeview> datatyp;
    private  boolean usemultiple;
    public  ExtendedDictionaryAutocompleteProviderA(List<AbstractFlexibleItem> cx,ProteusView  zxbb,List<modeltypeview> datatyp,boolean usemultiple){
        this.mlistdat=cx;
        this.zxbx=zxbb;
        this.datatyp=datatyp;
        this.usemultiple=usemultiple;
    }

    @Override
    public Collection<AbstractFlexibleItem> provideDynamicAutocompleteItems(String constraint) {
        boolean checkk=false;

        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        try {
mItemss.add(this.mlistdat.get(0));
            /*if(zxbx instanceof AutoCompleteTextViewB) {
                checkk=true;
                AutoCompleteTextViewB zxb=(AutoCompleteTextViewB)zxbx;
                String[] flterda = null;
                ObjectValue objlayout = (ObjectValue) zxb.getTag(R.id.Objectlayout); //zxb.getViewManager().getLayout().getAsObject();
                try {
                    flterda = zxb.getTag(R.id.filterdata).toString().split("#");
                } catch (Exception ex) {

                }

                ObjectValue data = zxb.getViewManager().getDataContext().getData();
                //  zxb.getViewManager().getActionEventView().getresultsearch(null, 1, "0");
                // mnbb.AhasFilter(true);


                //  mnbb.setFilter(search);
                ProteusContext contextv = (ProteusContext) zxb.getContext();
                // mnbb.clear();
                //  zxb.getViewManager().getActionEventView().getresultsearch(null, 3, "0");
                // ObjectValue datax = ((ProteusRecyclerView) view).getViewManager().getDataContext().getData();

                Iterator<Map.Entry<String, Value>> vv = data.entrySet().iterator();
                while (vv.hasNext()) {

                    Map.Entry<String, Value> ddert = vv.next();

                    // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                    for (int cxk = 0; cxk < ddert.getValue().getAsArray().size(); cxk++) {

                        OOverIttem ioppp = new OOverIttem(datatyp, usemultiple, cxk, "nb", objlayout, contextv.getInflater(), ddert.getValue().getAsArray().get(cxk)).WithMutlip(datatyp);
                        ;
                        if (ddert.getValue().getAsArray().get(cxk).getAsObject().get(flterda[0]).toString().contains(constraint)) {
                            mItemss.add(ioppp);
                        }

                        //   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

                    }
                }


                //    mnbb.notifyDataSetChanged();


                // zxb.getViewManager().getActionEventView().getresultsearch(mItemss,4,"0");

            }
*/

        } catch (Exception ex) {
        }
        Collection<AbstractFlexibleItem> uu = new ArrayList<AbstractFlexibleItem>(checkk?mItemss:mlistdat);
        return uu;
    }
}