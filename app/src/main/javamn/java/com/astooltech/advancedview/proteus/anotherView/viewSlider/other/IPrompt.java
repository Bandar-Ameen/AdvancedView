package com.astooltech.advancedview.proteus.anotherView.viewSlider.other;

import androidx.annotation.Keep;

import com.astooltech.advancedview.proteus.anotherView.viewSlider.widget.SuperPrompt;


/**
 * @another 江祖赟
 * @date 2017/9/25 0025.
 */
@Keep
public interface IPrompt {

    public SuperPrompt getPromptHelper();

    public IPrompt setPromptMsg(String promptMsg);

    public IPrompt showNotify();

    public IPrompt forcePromptCircle();

    public IPrompt setPromptOffset(int offset);

    public IPrompt forceCenterVertical();

    public IPrompt configPrompt(int promptBgColor, int promptColor);

    public IPrompt asOnlyNum();

}
