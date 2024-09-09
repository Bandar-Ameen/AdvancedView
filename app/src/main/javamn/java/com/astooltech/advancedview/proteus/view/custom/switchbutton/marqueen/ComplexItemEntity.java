package com.astooltech.advancedview.proteus.view.custom.switchbutton.marqueen;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.value.Layout;

/**
 * 复合字幕条目对象
 *
 * @author xuexiang
 * @since 2019/1/14 下午10:08
 */
public class ComplexItemEntity {

    /**
     * 主标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 时间
     */
    private String time;

    public Layout getMlay() {
        return mlay;
    }

    public void setMlay(Layout mlay) {
        this.mlay = mlay;
    }

    private Layout mlay;

    public ComplexItemEntity(String title, String subTitle, String time,Layout b) {
        this.title = title;
        this.subTitle = subTitle;
        this.time = time;
        this.mlay=b;
    }

    public String getTitle() {
        return title;
    }

    public ComplexItemEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public ComplexItemEntity setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ComplexItemEntity setTime(String time) {
        this.time = time;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return "主标题:" + title + ", 副标题:" + subTitle + ", 时间:" + time;
    }
}
