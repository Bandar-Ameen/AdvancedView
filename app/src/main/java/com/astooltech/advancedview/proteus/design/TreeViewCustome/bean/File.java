package com.astooltech.advancedview.proteus.design.TreeViewCustome.bean;


import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.design.TreeViewCustome.LayoutItemType;

/**
 * Created by tlh on 2016/10/1 :)
 */

public class File implements LayoutItemType {
    public String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_file;
    }
}
