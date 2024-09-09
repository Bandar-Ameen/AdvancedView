package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.autoimageslider.SliderViewAdapter;


public class ProtousSliderHolder extends SliderViewAdapter.ViewHolder   {

@NonNull
final ProteusContext context;

@NonNull
public final ProteusView view;

  public   ProtousSliderHolder(@NonNull ProteusView view) {

        super(view.getAsView());


        this.view = view;
        this.context = view.getViewManager().getContext();

   /* com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(this.view.getAsView())
            .rippleOverlay(true).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(true).create();
*/
        }


        }
