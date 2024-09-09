package com.astooltech.advancedview.proteus.v7;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.v7.adapter.AutoCompleteTextViewBparserAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.AutoCompleteTextViewFactory;
import com.astooltech.advancedview.proteus.v7.adapter.ProteusRecyclerViewAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.SimpleListAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.SimpleListAdapter3;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerBuilder;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerFactory;
import com.astooltech.advancedview.proteus.v7.layoutmanager.ProteusLinearLayoutManager;
import com.astooltech.advancedview.proteus.v7.widget.AutoCompleteTextViewBparser;


public class AutoCompleteTextViewModel implements ProteusBuilder.Module {

    static final String ADAPTER_SIMPLE_LIST = "SimpleListAdapter";

    static final String LAYOUT_MANAGER_LINEAR = "LinearLayoutManager";

    @NonNull
    private final AutoCompleteTextViewFactory adapterFactory;

    @NonNull
    private final LayoutManagerFactory layoutManagerFactory;


    AutoCompleteTextViewModel(@NonNull AutoCompleteTextViewFactory adapterFactory, @NonNull LayoutManagerFactory layoutManagerFactory) {
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
    public static AutoCompleteTextViewModel create() {
        return new Builder().build();
    }

    @Override
    public void registerWith(ProteusBuilder builder) {
        builder.register(new AutoCompleteTextViewBparser(adapterFactory, layoutManagerFactory));
    }

    @SuppressWarnings("WeakerAccess")
    public static class Builder {

        @NonNull
        private final  AutoCompleteTextViewFactory adapterFactory = new  AutoCompleteTextViewFactory();

        @NonNull
        private LayoutManagerFactory layoutManagerFactory = new LayoutManagerFactory();

        private boolean includeDefaultAdapters = true;

        private boolean includeDefaultLayoutManagers = true;


        public Builder register(@NonNull String type, @NonNull AutoCompleteTextViewBparserAdapter.Builder builder) {
            adapterFactory.register(type, builder);
            return this;
        }


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
         * Returns a new instance of {@link SppinerViewBModel }.
         * </p>
         *
         * @return a new instance of {@link SppinerViewBModel }.
         */
        public AutoCompleteTextViewModel  build() {

            if (includeDefaultAdapters) {
                registerDefaultAdapters();
            }

            if (includeDefaultLayoutManagers) {
                registerDefaultLayoutManagers();
            }

            return new AutoCompleteTextViewModel (adapterFactory, layoutManagerFactory);
        }

        private void registerDefaultAdapters() {
            register(ADAPTER_SIMPLE_LIST, SimpleListAdapter3.BUILDER);
            // register(ADAPTER_SIMPLE_LIST, (SpainnerViewParserAdapter.Builder) SimpleListAdapter2.BUILDER);
        }

        private void registerDefaultLayoutManagers() {
            register(LAYOUT_MANAGER_LINEAR, ProteusLinearLayoutManager.BUILDER);
        }
    }
}

