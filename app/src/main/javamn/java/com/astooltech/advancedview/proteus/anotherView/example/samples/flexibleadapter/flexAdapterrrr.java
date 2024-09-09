package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteFilter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteProvider;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.OnDynamicAutocompleteFilterListener;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class flexAdapterrrr  extends ArrayAdapter<AbstractFlexibleItem> implements
        OnDynamicAutocompleteFilterListener<AbstractFlexibleItem> {

private List<AbstractFlexibleItem> mListItems;
private ExtendedDictionaryAutocompleteProvider mExtendedDictionaryAutocompleteProvider;
private ExtendedDictionaryAutocompleteFilter mDictionaryAutocompleteFilter;
private LayoutInflater mLayoutInflater;
private  boolean usemultiple;
private int mLayoutId;
private ProteusLayoutInflater layoutInflaterrr;
private  boolean AuroOrnot=true;
public flexAdapterrrr(Context context, int textViewResourceId, List<AbstractFlexibleItem> g, ProteusLayoutInflater layoutInflaterr, ProteusView ck,List<modeltypeview> datatyp,boolean usemultiple,boolean Autoornot) {
        super(context, textViewResourceId);
    AuroOrnot=Autoornot;
        mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProvider(g,ck,datatyp,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilter(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);
this.usemultiple=usemultiple;
    layoutInflaterrr=layoutInflaterr;
        mListItems = g;//new ArrayList<>();
        mLayoutId = 0;
       /* mLayoutInflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
        }
    public flexAdapterrrr(Context context, int textViewResourceId, List<AbstractFlexibleItem> g, ProteusLayoutInflater layoutInflaterr, ProteusView ck,List<modeltypeview> datatyp,boolean usemultiple) {
        super(context, textViewResourceId);

        mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProvider(g,ck,datatyp,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilter(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);
        this.usemultiple=usemultiple;
        layoutInflaterrr=layoutInflaterr;
        mListItems = new ArrayList<>();
        mLayoutId = 0;
       /* mLayoutInflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }
    public flexAdapterrrr(Context context, int textViewResourceId, List<AbstractFlexibleItem> g, ProteusLayoutInflater layoutInflaterr,List<modeltypeview> datatyp,boolean usemultiple) {
        super(context, textViewResourceId);

        mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProvider(g,null,datatyp,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilter(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);
        this.usemultiple=usemultiple;
        layoutInflaterrr=layoutInflaterr;
        mListItems = new ArrayList<>();
        mLayoutId = 0;
       /* mLayoutInflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }

@Override
public Filter getFilter() {
        return mDictionaryAutocompleteFilter;
        }

@Override
public int getCount() {
        return mListItems.size();
        }

@Override
public void clear() {
        mListItems.clear();
        }
public  int getallItemPostionByname(String queytext){
int postions=0;
int resultpostion=0;
    for (AbstractFlexibleItem v:mListItems){
        postions=postions+1;
        OOverIttem ov=(OOverIttem)v;
        ov.setEqilOrnot(true);
        if(ov.filter(queytext)){
            resultpostion=postions;
        }
    }
    return resultpostion==0?0:resultpostion-1;
}
@Override
public AbstractFlexibleItem getItem(int position) {
        return mListItems.get(position);
        }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AbstractFlexibleItem countryModel = getItem(position);

        OOverIttem t= ((OOverIttem) countryModel);

        if(usemultiple) {
            String inflatename = "0";
            for (int cx = 0; cx < t.getWith().size(); cx++) {
                modeltypeview k = t.getWith().get(cx);
                // String datget = data.getAsObject().get(k.getV_ColumnName()).toString();
                if (Integer.parseInt(k.getV_id()) == t.getItemViewType()) {

                    inflatename = k.getV_Name();
                }
                // data.getAsObject().get()
            }

            if (inflatename.equals("0")) {
                ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

                return viewx.getAsView();
            } else {

                ProteusView viewx = layoutInflaterrr.inflate(inflatename, t.getdataa().getAsObject());

                return viewx.getAsView();
            }
        }else {
            ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

            return viewx.getAsView();
        }
    }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    AbstractFlexibleItem countryModel = getItem(position);

    OOverIttem t= ((OOverIttem) countryModel);

if(usemultiple) {
    String inflatename = "0";
    for (int cx = 0; cx < t.getWith().size(); cx++) {
        modeltypeview k = t.getWith().get(cx);
        // String datget = data.getAsObject().get(k.getV_ColumnName()).toString();
        if (Integer.parseInt(k.getV_id()) == t.getItemViewType()) {

            inflatename = k.getV_Name();
        }
        // data.getAsObject().get()
    }

    if (inflatename.equals("0")) {
        ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

        return viewx.getAsView();
    } else {

        ProteusView viewx = layoutInflaterrr.inflate(inflatename, t.getdataa().getAsObject());

        return viewx.getAsView();
    }
}else {
    ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

    return viewx.getAsView();
}
  // ProteusView v = layoutInflaterrr.inflate(.getDescription(), null);
      /*  if (convertView == null) {

        viewHolder = new ViewHolder();
        viewHolder.flag = (ImageView) convertView.findViewById(R.id.flagImage);
        viewHolder.name = (TextView) convertView.findViewById(R.id.countryNameText);
        viewHolder.code = (TextView) convertView.findViewById(R.id.countryCodeText);
        convertView.setTag(viewHolder);
        } else {
        viewHolder = (ViewHolder) convertView.getTag();
        }
*/

       /* Picasso.with(getContext()).load(countryModel.getFlagUrl()).into(viewHolder.flag);
        viewHolder.name.setText(countryModel.getName());
        viewHolder.code.setText(countryModel.getCode());
*/
       // return v.getAsView();
        }

    @Override
    public void onDynamicAutocompleteFilterResult(Collection<AbstractFlexibleItem> result) {
        mListItems.clear();
        mListItems.addAll(result);
        notifyDataSetChanged();
    }

/**
 * Holder for list item.
 */



}
