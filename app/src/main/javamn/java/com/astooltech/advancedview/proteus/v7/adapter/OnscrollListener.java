package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class OnscrollListener  extends RecyclerView.OnScrollListener {


    private LinearLayoutManager laoyt;
    protected OnscrollListener(LinearLayoutManager g){
        this.laoyt=g;

    }
    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visab=laoyt.getChildCount();
        int totacoun=laoyt.getItemCount();
        int first=laoyt.findFirstVisibleItemPosition();
      ///  getallcount(totacoun,visab+first);
       // Log.i("ProteusEventWithTag", String.valueOf(first)+"vvvvvvvvvvvvvvvmmmmm تحميلللللللللللللللل"+String.valueOf(totacoun));

        if(!isloading() && !isListPage()){



            if((visab+first)>=totacoun && first>=0){

                loadMoreItem();
            }

        }
    }
    protected abstract  void loadMoreItem();
    public  abstract  int getTotalPagecount();
    public  abstract  boolean isListPage();
    public abstract  boolean isloading();

}
