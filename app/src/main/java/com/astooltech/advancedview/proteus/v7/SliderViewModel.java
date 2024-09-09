package com.astooltech.advancedview.proteus.v7;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.parser.custom.PrototuseSliderViewParser;
import com.astooltech.advancedview.proteus.v7.adapter.ProteusRecyclerViewAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.ProteusSliderAddapter;
import com.astooltech.advancedview.proteus.v7.adapter.SimpleListAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.SliderAdapterExample;
import com.astooltech.advancedview.proteus.v7.adapter.SliderViewAdapterFactory;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerBuilder;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerFactory;
import com.astooltech.advancedview.proteus.v7.layoutmanager.ProteusLinearLayoutManager;
import com.astooltech.advancedview.proteus.v7.widget.RecyclerViewParser;


public class SliderViewModel implements ProteusBuilder.Module {

    static final String ADAPTER_SIMPLE_LIST = "SimpleListAdapter";

    static final String LAYOUT_MANAGER_LINEAR = "LinearLayoutManager";

    @NonNull
    private final SliderViewAdapterFactory adapterFactory;

    @NonNull
    private final LayoutManagerFactory layoutManagerFactory;

    /**
     * <p>
     * Returns a new instance of the Recycler View Module.
     * </p>
     *
     * @param adapterFactory       The adapter factory to be used to evaluate the {@link RecyclerViewParser#ATTRIBUTE_ADAPTER} attribute.
     * @param layoutManagerFactory The layout manager factory to evaluate the {@link RecyclerViewParser#ATTRIBUTE_LAYOUT_MANAGER} attribute.
     */
    SliderViewModel(@NonNull SliderViewAdapterFactory adapterFactory, @NonNull LayoutManagerFactory layoutManagerFactory) {
        this.adapterFactory = adapterFactory;
        this.layoutManagerFactory = layoutManagerFactory;
    }

    /**
     * <p>
     * The default constructor method to create a new instance of this class. This method internally
     * uses the {@link Builder} and registers the default Adapters and Layout Managers of the
     * Recycler View.
     * </p>
     *
     * @return Returns a new instance of the module with default implementations registered.
     * @see SimpleListAdapter
     * @see ProteusLinearLayoutManager
     */
    public static SliderViewModel create() {
        return new Builder().build();
    }

    @Override
    public void registerWith(ProteusBuilder builder) {
        PrototuseSliderViewParser k=new PrototuseSliderViewParser(adapterFactory, layoutManagerFactory);

        builder.register(k);
    }

    /**
     * Use the Recycler View Module Builder to register custom {@link ProteusRecyclerViewAdapter}
     * implementations. A default {@link ProteusRecyclerViewAdapter} and
     * {@link androidx.recyclerview.widget.RecyclerView.LayoutManager} are included by default. To
     * exclude them call {@link #excludeDefaultAdapters()} and {@link #excludeDefaultLayoutManagers()}.
     *
     * @author adityasharat
     * @see ProteusRecyclerViewAdapter
     * @see SliderViewAdapterFactory
     * @see SimpleListAdapter
     * @see LayoutManagerFactory
     * @see ProteusLinearLayoutManager
     */
    @SuppressWarnings("WeakerAccess")
    public static class Builder {

        @NonNull
        private final SliderViewAdapterFactory adapterFactory = new SliderViewAdapterFactory();

        @NonNull
        private LayoutManagerFactory layoutManagerFactory = new LayoutManagerFactory();

        private boolean includeDefaultAdapters = true;

        private boolean includeDefaultLayoutManagers = true;

        /**
         * <p>
         * Registers a new {@link ProteusRecyclerViewAdapter}.
         * </p>
         *
         * @param type    The 'type' of the adapter which will be used in the {@link RecyclerViewParser#ATTRIBUTE_ADAPTER} attribute.
         * @param builder The builder for the adapter.
         * @return this builder.
         */
        public Builder register(@NonNull String type, @NonNull ProteusSliderAddapter.Builder builder) {
            adapterFactory.register(type, builder);
            return this;
        }

        /**
         * <p>
         * Registers a new {@link ProteusRecyclerViewAdapter}.
         * </p>
         *
         * @param type    The {@link RecyclerViewParser#ATTRIBUTE_TYPE} of the layout manager which will be used in the {@link RecyclerViewParser#ATTRIBUTE_LAYOUT_MANAGER} attribute.
         * @param builder The builder for the layout manager.
         * @return this builder.
         */
        public Builder register(@NonNull String type, @NonNull LayoutManagerBuilder builder) {
            layoutManagerFactory.register(type, builder);
            return this;
        }

        /**
         * <p>
         * Will exclude the default {@link ProteusRecyclerViewAdapter} implementations from the module.
         * </p>
         *
         * @return this builder.
         */
        public Builder excludeDefaultAdapters() {
            includeDefaultAdapters = false;
            return this;
        }


        public Builder excludeDefaultLayoutManagers() {
            includeDefaultLayoutManagers = false;
            return this;
        }

        /**
         * <p>
         * Returns a new instance of {@link SliderViewModel}.
         * </p>
         *
         * @return a new instance of {@link SliderViewModel}.
         */
        public SliderViewModel build() {

            if (includeDefaultAdapters) {
                registerDefaultAdapters();
            }

            if (includeDefaultLayoutManagers) {
                registerDefaultLayoutManagers();
            }

            return new SliderViewModel(adapterFactory, layoutManagerFactory);
        }

        private void registerDefaultAdapters() {
            register(ADAPTER_SIMPLE_LIST, SliderAdapterExample.BUILDER);
        }

        private void registerDefaultLayoutManagers() {
            register(LAYOUT_MANAGER_LINEAR, ProteusLinearLayoutManager.BUILDER);
        }
    }
}
