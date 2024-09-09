package com.astooltech.advancedview.proteus.design.TreeViewCustome.bean;



import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.LayoutItemType;

/**
 * Created by tlh on 2016/10/1 :)
 */

public class Dir implements LayoutItemType {
    public String dirName;

    public Dir(String dirName) {

        this.dirName = dirName;
    }

    @Override
    public int getLayoutId() {

        return R.layout.item_dir;
    }
}
