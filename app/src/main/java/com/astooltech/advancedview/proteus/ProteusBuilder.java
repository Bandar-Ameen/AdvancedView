/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.astooltech.advancedview.finaldemo.opengraphview.OpenGraphViewProtouseParser;
import com.astooltech.advancedview.proteus.chatview.widget.PrtouseChatViewParaser;
import com.astooltech.advancedview.proteus.demo.CircleViewParser;
import com.astooltech.advancedview.proteus.design.DesignModule;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.IncludeParser;
import com.astooltech.advancedview.proteus.parser.ProtouseConstraintLayoutParser;
import com.astooltech.advancedview.proteus.parser.ViewParser;
import com.astooltech.advancedview.proteus.parser.custom.ButtonParser;
import com.astooltech.advancedview.proteus.parser.custom.CheckBoxParser;
import com.astooltech.advancedview.proteus.parser.custom.CircleImageViewParser;
import com.astooltech.advancedview.proteus.parser.custom.EditTextParser;
import com.astooltech.advancedview.proteus.parser.custom.FragmentOverallParser;
import com.astooltech.advancedview.proteus.parser.custom.FrameLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.HorizontalProgressBarParser;
import com.astooltech.advancedview.proteus.parser.custom.HorizontalScrollViewParser;
import com.astooltech.advancedview.proteus.parser.custom.ImageButtonParser;
import com.astooltech.advancedview.proteus.parser.custom.ImageViewParser;
import com.astooltech.advancedview.proteus.parser.custom.LinearLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.NestedScrollViewParser;
import com.astooltech.advancedview.proteus.parser.custom.ProgressBarParser;
import com.astooltech.advancedview.proteus.parser.custom.ProtoExpandableLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.PrototoseSwiperViewParser;
import com.astooltech.advancedview.proteus.parser.custom.PrototuseTableViewParser;
import com.astooltech.advancedview.proteus.parser.custom.ProtouseFlowLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.ProtouseSkeletonViewAParser;
import com.astooltech.advancedview.proteus.parser.custom.ProtouseSkeletonViewGroupParser;
import com.astooltech.advancedview.proteus.parser.custom.RadioButtonGroup;
import com.astooltech.advancedview.proteus.parser.custom.RadioButtonParser;
import com.astooltech.advancedview.proteus.parser.custom.RappleLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.RatingBarParser;
import com.astooltech.advancedview.proteus.parser.custom.RelativeLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.ScrollViewParser;
import com.astooltech.advancedview.proteus.parser.custom.TextInputEditTextBParser;
import com.astooltech.advancedview.proteus.parser.custom.TextInputLayoutBParser;
import com.astooltech.advancedview.proteus.parser.custom.TextViewParser;
import com.astooltech.advancedview.proteus.parser.custom.ViewGroupParser;
import com.astooltech.advancedview.proteus.parser.custom.WatingLayoputParser;
import com.astooltech.advancedview.proteus.parser.custom.WebViewParser;
import com.astooltech.advancedview.proteus.parser.custom.finalTableLayoutParser;
import com.astooltech.advancedview.proteus.parser.custom.mRecyleviw2;
import com.astooltech.advancedview.proteus.parser.custom.protouseFastScrollerParser;
import com.astooltech.advancedview.proteus.parser.fab_bottom.protouseFloatingActionsMenuParser;
import com.astooltech.advancedview.proteus.parser.fab_bottom.protuseFloatinggActionButtoParser;
import com.astooltech.advancedview.proteus.parser.shapeofview.shapes.ProtoShapViewParser;
import com.astooltech.advancedview.proteus.parser.shapeofview.shapes.StarViewparse;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.CustomeWebParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.v4.SupportV4Module;
import com.astooltech.advancedview.proteus.v4.view.ProtouseLinnerLayoutPager;
import com.astooltech.advancedview.proteus.v4.view.protouseJPagerSlidingTabStripParser;
import com.astooltech.advancedview.proteus.v7.AutoCompleteTextViewModel;
import com.astooltech.advancedview.proteus.v7.CardViewModule;
import com.astooltech.advancedview.proteus.v7.ProtouseRecyclerViewVlayoutParser;
import com.astooltech.advancedview.proteus.v7.RecyclerViewModule;
import com.astooltech.advancedview.proteus.v7.SliderViewModel;
import com.astooltech.advancedview.proteus.v7.SppinerViewBModel;
import com.astooltech.advancedview.proteus.v7.widget.ATreeView;
import com.astooltech.advancedview.proteus.v7.widget.myRecycleView;
import com.astooltech.advancedview.proteus.vector.ProtouseVectorMasterViewParser;
import com.astooltech.advancedview.proteus.view.custom.ProtoDrawerLayoutViewParser;
import com.astooltech.advancedview.proteus.view.custom.ProtoNavgationViewParser;
import com.astooltech.advancedview.proteus.view.custom.PrototousShadowLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.PrototuseShoppingViewParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseCommonTabLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseExpandIconViewParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseHorizontalScrollMenuViewParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseMaskableFrameLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSegementLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSlidingTabLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.ProtouseVideoLayoutParser;
import com.astooltech.advancedview.proteus.view.custom.badge.ProtouseBadgeView;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.PrototuseReadMoreTextViewParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.ProtouseSwitchButtonParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget.inboxlayout.protouseInboxBackgroundScrollViewParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget.protouseInboxLayoutScrollViewParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.marqueen.ProtouseMarqueeViewParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.protusePasswordEditTexParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.shinebutton.PrototuseShineButtonParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.ProtouseMultipleStatusViewParser;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.status.ProtousStatusViewParser;
import com.astooltech.advancedview.proteus.view.protuseTestParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ProteusBuilder
 *
 * @author aditya.sharat
 */

public class ProteusBuilder {

    /**
     * The Default Module of Proteus.
     */
    public static final Module DEFAULT_MODULE = new Module() {

        @Override
        public void registerWith(ProteusBuilder builder) {

            // register the default parsers
            builder.register(new ViewParser());
            builder.register(new IncludeParser());
            builder.register(new ViewGroupParser());
            builder.register(new WatingLayoputParser());

            builder.register(new PrototuseTableViewParser());
            builder.register(new RelativeLayoutParser());
            builder.register(new ProtouseSkeletonViewGroupParser());
            builder.register(new ProtouseSkeletonViewAParser());
            builder.register(new ProtouseFlowLayoutParser());
            builder.register(new ProtouseConstraintLayoutParser());

            builder.register(new CustomeWebParser());

            builder.register(new LinearLayoutParser());

            builder.register(new PrtouseChatViewParaser());
            builder.register(new OpenGraphViewProtouseParser());

            builder.register(new mRecyleviw2());
            builder.register(new myRecycleView());

            builder.register(new protouseFastScrollerParser());

            builder.register(new finalTableLayoutParser());
            builder.register(new StarViewparse());
            builder.register(new ProtoShapViewParser());
     /* builder.register(SupportV4Module.create())
              .register(RecyclerViewModule.create())
              .register(SliderViewModel.create())
              .register(AutoCompleteTextViewModel.create())
              .register(SppinerViewBModel.create())
              .register(CardViewModule.create())
              .register(DesignModule.create())
              .register(new CircleViewParser());*/
            builder.register(new ProtoExpandableLayoutParser());

            builder.register(new ProtoDrawerLayoutViewParser());
            builder.register(new ProtouseHorizontalScrollMenuViewParser());

            builder.register(new NestedScrollViewParser());
            builder.register(new ProtoNavgationViewParser());

            builder.register(new PrototoseSwiperViewParser());
            builder.register(new FrameLayoutParser());
            builder.register(new ProtouseBadgeView());

            builder.register(new ScrollViewParser());
            builder.register(new HorizontalScrollViewParser());
            builder.register(new ImageViewParser());

            builder.register(new PrototuseShoppingViewParser());

            builder.register(new CircleImageViewParser());
            builder.register(new TextViewParser());
            builder.register(new EditTextParser());
            builder.register(new TextInputEditTextBParser());
            builder.register(new ProtouseVideoLayoutParser());
            builder.register(new PrototousShadowLayoutParser());
            builder.register(new ProtouseRecyclerViewVlayoutParser());
            builder.register(new ATreeView());

            builder.register(new ProtouseVectorMasterViewParser());

            builder.register(new TextInputLayoutBParser());
            builder.register(new ProtouseMaskableFrameLayoutParser());
            //<

            builder.register(new FragmentOverallParser());

            builder.register(new protuseTestParser());
            builder.register(new ButtonParser());
            builder.register(new ProtouseSwitchButtonParser());
            builder.register(new ProtouseMultipleStatusViewParser());
            builder.register(new PrototuseReadMoreTextViewParser());
            builder.register(new ProtouseMarqueeViewParser());
            builder.register(new protouseInboxLayoutScrollViewParser());
            builder.register(new protouseInboxBackgroundScrollViewParser());
            builder.register(new ProtousStatusViewParser());
            builder.register(new PrototuseShineButtonParser());
            builder.register(new protusePasswordEditTexParser());


            builder.register(new RadioButtonGroup());
            builder.register(new RadioButtonParser());
            builder.register(new ImageButtonParser());
            builder.register(new ProtouseExpandIconViewParser());
            builder.register(ALLEvent.Allevtshitk);
            builder.register(ALLEvent.OpenActivityyx);

            builder.register(new com.astooltech.advancedview.finaldemo.fragments.WebViewParser());
            builder.register(new WebViewParser());
            builder.register(new RatingBarParser());
            builder.register(new CheckBoxParser());
            builder.register(new ProgressBarParser());
            builder.register(new HorizontalProgressBarParser());
            builder.register(new protouseJPagerSlidingTabStripParser());
            builder.register(new protuseFloatinggActionButtoParser());

            builder.register(new protouseFloatingActionsMenuParser());

            builder.register(new ProtouseSegementLayoutParser());

            builder.register(new ProtouseLinnerLayoutPager());


            builder.register(new ProtouseSlidingTabLayoutParser());

            builder.register(new ProtouseCommonTabLayoutParser());


            builder.register(new RappleLayoutParser());
            // register the default functions
            builder.register(Function.DATE);
            builder.register(Function.IsNULLMTfromlogin);

            builder.register(Function.FORMAT);
            builder.register(Function.JOIN);
            builder.register(Function.NUMBER);

            builder.register(Function.scrip);

            builder.register(Function.ADD);
            builder.register(Function.SUBTRACT);
            builder.register(Function.MULTIPLY);
            builder.register(Function.DIVIDE);
            builder.register(Function.MODULO);

            builder.register(Function.AND);
            builder.register(Function.OR);

            builder.register(Function.NOT);

            builder.register(Function.EQUALS);
            builder.register(Function.LESS_THAN);
            builder.register(Function.GREATER_THAN);
            builder.register(Function.LESS_THAN_OR_EQUALS);
            builder.register(Function.GREATER_THAN_OR_EQUALS);

            builder.register(Function.TERNARY);
            builder.register(Function.IsNULL);
            builder.register(Function.IsNULLM);

            builder.register(Function.CHAR_AT);
            builder.register(Function.CONTAINS);
            builder.register(Function.IS_EMPTY);
            builder.register(Function.LENGTH);
            builder.register(Function.TRIM);
            builder.register(Function.IsNULLMvalu);
            builder.register(Function.IsNULLMvaluStart);
            builder.register(Function.IsNULLMvaluStartt);
            builder.register(Function.MAX);
            builder.register(Function.MIN);

            builder.register(Function.SLICE);
            builder.register(ALLEvent.Allev);
            builder.register(ALLEvent.Alleev);
            builder.register(ALLEvent.Update);
            builder.register(ALLEvent.Allevt);
            builder.register(ALLEvent.Allevtclos);
            builder.register(ALLEvent.AllevtclosOk);

            builder.register(ALLEvent.Checknull);
            builder.register(ALLEvent.ChecknullT);

            builder.register(ALLEvent.SendAll);

            builder.register(ALLEvent.findViewByID);
            builder.register(ALLEvent.snakbar);

            builder.register(ALLEvent.Alleevv);
            builder.register(ALLEvent.ResponFromURL);
            builder.register(ALLEvent.BeforProcess);
            builder.register(ALLEvent.AffterProcess);
            builder.register(ALLEvent.AllevtShowCokies);
            builder.register(ALLEvent.ShowMessageOnly);
            builder.register(ALLEvent.AllevtWithSetDatatwoshit);
            builder.register(ALLEvent.OpenShittyFromUrl);
            builder.register(ALLEvent.AllevtWithSetDatatwoshitstringfragmentname);

            builder.register(ALLEvent.AllevtWithSetDatatwoshitstring);
            builder.register(Function.IsNULLMT);


            builder.register(ALLEvent.Updatekmm);
            builder.register(ALLEvent.OpenActivityyx);
            builder.register(ALLEvent.OpenActivityym);
            builder.register(new com.astooltech.advancedview.finaldemo.protuseTestParser());
            builder.register(ALLEvent.OpenActivityhidlibbx );
            builder.register(ALLEvent.SetDataToview);
            builder.register(ALLEvent.AllevtWithSetData);
            builder.register(ALLEvent.AllevtWithSetDatatwo);

            builder.register(ALLEvent.DataFrom);
            builder.register(ALLEvent.OpenFragment);
            builder.register(ALLEvent.AllevtWithSetDatab);
            builder.register(ALLEvent.AllevtWithSetDatac);
            builder.register(ALLEvent.AllevtWithSetrData);
            builder.register(ALLEvent.Allevtshit);
            builder.register(ALLEvent.AllevtshitWithdat);
            builder.register(ALLEvent.AllevtshitWithdatfromString);

            builder.register(ALLEvent.OpenDrawer);
            builder.register(ALLEvent.OpenActivity);
            builder.register(ALLEvent.OpenActivityFromUrl);
            builder.register(ALLEvent.OpenActivityFromString);
            builder.register(ALLEvent.OpenActivityFromStringOpen);
            builder.register(ALLEvent.DownloadFile);




        }
    };

    private static final int ID = -1;
    private Map<String, Map<String, AttributeProcessor>> processors = new LinkedHashMap<>();
    private Map<String, ViewTypeParser> parsers = new LinkedHashMap<>();
    private HashMap<String, Function> functions = new HashMap<>();
    private HashMap<String, ALLEvent> ALLEvents = new HashMap<>();

    public ProteusBuilder() {
        DEFAULT_MODULE.registerWith(this);
    }

    public ProteusBuilder register(@NonNull String type, @NonNull Map<String, AttributeProcessor> processors) {
        Map<String, AttributeProcessor> map = getExtraAttributeProcessors(type);
        map.putAll(processors);
        return this;
    }

    public ProteusBuilder register(@NonNull String type, @NonNull String name, @NonNull AttributeProcessor processor) {
        Map<String, AttributeProcessor> map = getExtraAttributeProcessors(type);
        map.put(name, processor);
        return this;
    }

    public ProteusBuilder register(@NonNull ViewTypeParser parser) {
        String parentType = parser.getParentType();
        if (parentType != null && !parsers.containsKey(parentType)) {
            throw new IllegalStateException(parentType + " is not a registered type parser");
        }
        parsers.put(parser.getType(), parser);
        return this;
    }

    public ProteusBuilder register(@NonNull Function function) {
        functions.put(function.getName(), function);
        return this;
    }
    public ProteusBuilder register(@NonNull ALLEvent aevent) {
        ALLEvents.put(aevent.getName(), aevent);
        return this;
    }
    public ProteusBuilder register(@NonNull Module module) {
        module.registerWith(this);
        return this;
    }

    @Nullable
    public ViewTypeParser get(@NonNull String type) {

        return parsers.get(type);
    }

    /* public Proteus build(boolean a) {

       this.register(SupportV4Module.create())
               .register(RecyclerViewModule.create())
               .register(SliderViewModel.create())
               .register(AutoCompleteTextViewModel.create())
               .register(SppinerViewBModel.create())
               .register(CardViewModule.create())
               .register(DesignModule.create())
               .register(new CircleViewParser());
       Map<String, Proteus.Type> types = new HashMap<>();
       for (Map.Entry<String, ViewTypeParser> entry : parsers.entrySet()) {
         types.put(entry.getKey(), prepare(entry.getValue()));
       }
      Proteus k= new Proteus(types, functions,  ALLEvents);
       ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(k);

       return  k;
     }*/
    public Proteus build() {

        this.register(SupportV4Module.create())
                .register(RecyclerViewModule.create())
                .register(SliderViewModel.create())
                .register(AutoCompleteTextViewModel.create())
                .register(SppinerViewBModel.create())
                .register(CardViewModule.create())
                .register(DesignModule.create())
                .register(new CircleViewParser());
        Map<String, Proteus.Type> types = new HashMap<>();
        for (Map.Entry<String, ViewTypeParser> entry : parsers.entrySet()) {
            types.put(entry.getKey(), prepare(entry.getValue()));
        }
        Proteus k= new Proteus(types, functions,  ALLEvents);
        ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(k);

        return  k;
//return new Proteus(types, functions,  ALLEvents);
        // ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(k);

        //return  k;
    }
    protected Proteus.Type prepare(ViewTypeParser parser) {
        String name = parser.getType();
        ViewTypeParser parent = parsers.get(parser.getParentType());
        Map<String, AttributeProcessor> extras = this.processors.get(name);

        //noinspection unchecked
        return new Proteus.Type(ID, name, parser, parser.prepare(parent, extras));
    }

    protected Map<String, AttributeProcessor> getExtraAttributeProcessors(String type) {
        Map<String, AttributeProcessor> map = this.processors.get(type);
        if (map == null) {
            map = new LinkedHashMap<>();
            this.processors.put(type, map);
        }
        return map;
    }

    public interface Module {

        /**
         * @param builder
         */
        void registerWith(ProteusBuilder builder);

    }
}
