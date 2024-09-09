package com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder;

import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeNode;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeViewBinder;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

//import com.astooltech.advancedview.proteus.v7.adapter.ProteusViewHolder;


/**
 * Created by tlh on 2016/10/1 :)
 */

public class FileNodeBinder extends TreeViewBinder<FileNodeBinder.ViewHolder> {


    private ProteusLayoutInflater inflater;
    private Layout layout;
    public  FileNodeBinder(ProteusLayoutInflater inflater, Layout layout){

        this.inflater=inflater;
        this.layout=layout;
    }

    @Override
    public ViewHolder provideViewHolder(View itemView) {

        ProteusView view = inflater.inflate(layout ,new ObjectValue());


        return new ViewHolder(view);

      //  return new ViewHolder(itemView);
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {
       /* final DataContext context = DataContext.create(holder.context, data, position, scope);

        holder.view.getViewManager().update(context.getData());
          File fileNode = (File) node.getContent();

        holder.tvName.setText(fileNode.fileName);*/
    }
    @Override
    public  int  getLayoutId() {

        return R.layout.item_file;// return getID;//R.layout.item_dir;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {


        @NonNull
        final ProteusContext context;

        @NonNull
        public final ProteusView view;

        ViewHolder(@NonNull ProteusView view) {

            super(view.getAsView());


            this.view = view;
            this.context = view.getViewManager().getContext();

   /* com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(this.view.getAsView())
            .rippleOverlay(true).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(true).create();
*/
        }


        /* public TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }
*/
    }
}
