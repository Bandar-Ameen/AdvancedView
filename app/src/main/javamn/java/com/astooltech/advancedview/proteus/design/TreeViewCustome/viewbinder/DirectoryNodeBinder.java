package com.astooltech.advancedview.proteus.design.TreeViewCustome.viewbinder;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeNode;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.TreeViewBinder;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.bean.Dir;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusTextView;


/**
 * Created by tlh on 2016/10/1 :)
 */

public class DirectoryNodeBinder extends TreeViewBinder<DirectoryNodeBinder.ViewHolder> {





        public ProteusLayoutInflater inflater;
        public Layout layout;
    ProteusView viewm;
        public  DirectoryNodeBinder(ProteusLayoutInflater inflater, Layout layout){

            this.inflater=inflater;
            this.layout=layout;
            this.viewm= inflater.inflate(layout ,new ObjectValue());

        }


        public ProteusView getvieww(){


            return  this.viewm;
        }
    @Override
    public ViewHolder provideViewHolder(View itemView) {
        //itemView.ge.addView(viewm.getAsView());
      //  ProteusView vv=(ProteusView)itemView;
        return new ViewHolder(itemView,inflater,viewm);
    }

    public  void  Refreshdata(ViewGroup v, String namerecycle, int isroot) {
        String nam = " ";
        for (int cx = 0; cx < v.getChildCount(); cx++) {
            if (v.getChildAt(cx) instanceof ViewGroup) {

                ViewGroup bb=(ViewGroup)v.getChildAt(cx);
               /* if(isroot==0){
bb.setBackgroundColor(R.color.green);
                }else{
                    bb.setBackgroundColor(R.color.white);
                }*/
                Refreshdata(bb,namerecycle,isroot);

            }else {
                if (v.getChildAt(cx) instanceof ProteusTextView) {
                    ProteusTextView bb=(ProteusTextView)v.getChildAt(cx);
                    bb.setText(namerecycle);

                }
            }
        }
    }
    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {



      //  ProteusLayoutInflater  vvc=   new inflate(layout ,new ObjectValue());

      //  Log.i("kkkkoooooooooo",     holder.getClass().getName());
     /*   holder.ivArrow.setRotation(0);
        holder.ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_right_black_18dp);
        int rotateDegree = node.isExpand() ? 90 : 0;
        holder.ivArrow.setRotation(rotateDegree);

       holder.tvName.setText(dirNode.dirName);
*/
        Dir dirNode = (Dir) node.getContent();
        if(holder.conte.getAsView() instanceof ViewGroup){

            ViewGroup bb=(ViewGroup)holder.conte.getAsView();
int xc= node.getChildList().size();
            Refreshdata(bb,dirNode.dirName,xc);
            Log.i("kkkkoooooooooo",     holder.getClass().getName());

        }
      /*  if (node.isLeaf())
            holder.ivArrow.setVisibility(View.INVISIBLE);
        else holder.ivArrow.setVisibility(View.VISIBLE);*/
    }

    @Override
    public int getLayoutId() {
        return  R.layout.item_dir;
    }

    public static class ViewHolder extends TreeViewBinder.ViewHolder {

private com.astooltech.advancedview.proteus.view.ProteusLinearLayout conte;
        public ViewHolder(View rootView,ProteusLayoutInflater inflater,ProteusView viewm) {
            super(rootView);
          //  this.ivArrow = (ImageView) rootView.findViewById(R.id.iv_arrow);
           // this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
            this.conte=(ProteusLinearLayout)rootView.findViewById(R.id.content);
            ProteusView view = inflater.inflate(viewm.getViewManager().getLayout(),viewm.getViewManager().getDataContext().getData());

            conte.addView(view.getAsView());
        }


    }


/*
    @Override
    public ViewHolder provideViewHolder(View itemView) {

       ProteusView view =(ProteusView)itemView; //inflater.inflate(layout ,new ObjectValue());
        Log.i("kkkk",     itemView.getClass().getName());

        return new ViewHolder(view);
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {

        Log.i("kkkkooooooooooooooo",     holder.view.getAsView().getClass().getName());
    }

    /*  @Override
      public void bindView(ViewHolder holder, int position, TreeNode node) {

          Log.i("kkkk",     holder.view.getAsView().getClass().getName());
              //   Dir dirNode = (Dir) node.getContent();
       /*   holder.ivArrow.setRotation(0);
          holder.ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_right_black_18dp);
          int rotateDegree = node.isExpand() ? 90 : 0;
          holder.ivArrow.setRotation(rotateDegree);
          Dir dirNode = (Dir) node.getContent();
          holder.tvName.setText(dirNode.dirName);
          if (node.isLeaf())
              holder.ivArrow.setVisibility(View.INVISIBLE);
          else holder.ivArrow.setVisibility(View.VISIBLE);
      }

    @Override
    public int getLayoutId() {
           //  ProteusView view = inflater.inflate(layout ,new ObjectValue());

             return  viewm.getAsView().getId();
        //R.layout.item_dir;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {


        @NonNull
        final ProteusContext context;

        @NonNull
        public final ProteusView view;

        ViewHolder(@NonNull ProteusView view) {

            super(view.getAsView());
            Log.i("kkkk",     view.getClass().getName());

            this.view = view;
            this.context = view.getViewManager().getContext();

    com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(this.view.getAsView())
            .rippleOverlay(true).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(true).create();

        }


        /* public TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }

   */
    }


    /*@Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {
        holder.ivArrow.setRotation(0);
        holder.ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_right_black_18dp);
        int rotateDegree = node.isExpand() ? 90 : 0;
        holder.ivArrow.setRotation(rotateDegree);
        Dir dirNode = (Dir) node.getContent();
        holder.tvName.setText(dirNode.dirName);
        if (node.isLeaf())
            holder.ivArrow.setVisibility(View.INVISIBLE);
        else holder.ivArrow.setVisibility(View.VISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_dir;
    }

    public static class ViewHolder extends TreeViewBinder.ViewHolder {
        private ImageView ivArrow;
        private TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.ivArrow = (ImageView) rootView.findViewById(R.id.iv_arrow);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }

        public ImageView getIvArrow() {
            return ivArrow;
        }

        public TextView getTvName() {
            return tvName;
        }
    }*/

