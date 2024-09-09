package com.astooltech.advancedview.proteus.vector;

import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.vector.models.ClipPathModel;
import com.astooltech.advancedview.proteus.vector.models.GroupModel;
import com.astooltech.advancedview.proteus.vector.models.PathModel;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;

public class ProtouseVectorMasterViewParser<T extends VectorMasterView> extends ViewTypeParser<T> {

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @NonNull
    @Override
    public String getType() {
        return "DrawblePath";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {
        return new ProtouseVectorMasterView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("datam", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
              //  VectorModel gg=new VectorModel();
ObjectValue clippath=value.getAsObject().getAsObject("Clip_Path");

              Array GroupModel=value.getAsObject().getAsArray("Group_Mod");

                GroupModel mk=new GroupModel();
              Iterator<Value> itt=GroupModel.iterator();
              while (itt.hasNext()){

                  Value bb=itt.next();
                  String gettyp=bb.getAsObject().getAsString("Group_Type");

                  ClipPathModel m=new ClipPathModel();
                  m.setPathData(bb.getAsObject().getAsString("Path_data"));
                  GroupModel g=new GroupModel();
                  g.addClipPathModel(m);
                  m.setPathData(bb.getAsObject().getAsString("Path_data"));
                  PathModel p=new PathModel();
                  Array gettypfdd=bb.getAsObject().getAsArray("Path_Model");
                  Iterator<Value> ittd=gettypfdd.iterator();
                  while (ittd.hasNext()) {

                      Value bbx = ittd.next();
                      String dta1=bbx.getAsObject().getAsString("Path_data");
                      p.setPathData(dta1);
                  }
                 g.addPathModel(p);

                  mk.addGroupModel(g);
              }
                ClipPathModel m=new ClipPathModel();
                m.setPathData(clippath.getAsObject().getAsString("Path_data"));


              //  p.set
                //m.setPath();
               // m.set
                view.vectorModel.addGroupModel(mk);
                view.vectorModel.addClipPathModel(m);
            }

            @Override
            public void handleResource(T view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(T view, StyleResource style) {

            }
            });
        }
}
