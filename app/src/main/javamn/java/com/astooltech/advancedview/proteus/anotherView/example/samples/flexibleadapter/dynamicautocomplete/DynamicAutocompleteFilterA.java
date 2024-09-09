package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete;

import android.widget.Filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class DynamicAutocompleteFilterA<T> extends Filter implements Serializable {

    private static final String TAG = "DynamicAutocompleteFilter";
    private DynamicAutocompleteProvider<T> mDynamicAutocompleteProvider;
    private OnDynamicAutocompleteFilterListener<T> mOnDynamicAutocompleteFilterListener;
   // private DynamicAutoCompleteTextView mDynamicAutoCompleteTextView;
    private FilterCache mFilterCache;
    private boolean mIsUseCache;

    /**
     * The constructor.
     *
     * @param dynamicAutocompleteProvider for fetching data for the filter.
     * @param onDynamicAutocompleteFilterListener for notifying an adapter.
     */
    public DynamicAutocompleteFilterA(
            DynamicAutocompleteProvider<T> dynamicAutocompleteProvider,
            OnDynamicAutocompleteFilterListener<T> onDynamicAutocompleteFilterListener) {
        super();
        this.mDynamicAutocompleteProvider = dynamicAutocompleteProvider;
        this.mOnDynamicAutocompleteFilterListener = onDynamicAutocompleteFilterListener;
        this.mFilterCache = new FilterCache();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = null;

        if (constraint != null) {
            if (mIsUseCache) {
                filterResults = provideCacheData(constraint);
            }

            if (filterResults == null) {
                filterResults = provideData(constraint);
            }
        }

        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results != null) {
            Collection<T> filterResult = (Collection<T>) results.values;
            publishFilterResult(new ArrayList<T>());
          //  publishFilterResult(filterResult);
           /* if (mDynamicAutoCompleteTextView != null && mDynamicAutoCompleteTextView.getText() != null) {
                if (mDynamicAutoCompleteTextView.getText().toString().equals(constraint)) {
                    publishFilterResult(filterResult);
                } else {
                    publishFilterResult(new ArrayList<T>());
                }
            }*/
        }
    }

    /**
     * Set instance of {@link DynamicAutoCompleteTextView}. Used to get a text which is compare
     * with a constraint of filtering.
     *
     * @param dynamicAutoCompleteTextView instance of DynamicAutoCompleteTextView.
     */
   /* protected void setDynamicAutoCompleteTextView(DynamicAutoCompleteTextView dynamicAutoCompleteTextView) {
        this.mDynamicAutoCompleteTextView = dynamicAutoCompleteTextView;
    }*/

    /**
     * Get true/false if use cache.
     *
     * @return true/false if use cache.
     */
    public boolean isUseCache() {
        return mIsUseCache;
    }

    /**
     * Enables or disables cache mechanism of filter.
     *
     * @param useCache true/false if use cache.
     */
    public void useCache(boolean useCache) {
        this.mIsUseCache = useCache;
    }

    /**
     * Propagate result of filtering.
     *
     * @param result of filtering.
     */
    private void publishFilterResult(Collection<T> result) {
        if (mOnDynamicAutocompleteFilterListener != null && result != null) {
            mOnDynamicAutocompleteFilterListener
                    .onDynamicAutocompleteFilterResult(result);
        }
    }

    /**
     * Invoke {@link DynamicAutocompleteProvider#provideDynamicAutocompleteItems} which
     * provides data for filtering.
     *
     * @param constraint used to filter the data.
     * @return result of filtering operation.
     */
    private FilterResults provideData(CharSequence constraint) {
        FilterResults filterResults = null;
        Collection<T> providerResult = mDynamicAutocompleteProvider
                .provideDynamicAutocompleteItems(constraint.toString());

        if (providerResult != null) {
            filterResults = new FilterResults();
            filterResults.values = providerResult;

            if (mIsUseCache) {
                // Log.i(TAG, "Put in cache: " + constraint);
                mFilterCache.getLruCache().put(constraint.toString(), providerResult);
            }
        }

        return filterResults;
    }

    /**
     * Provides data from internal cache mechanism based on {@link FilterCache}
     *
     * @param constraint used to filter the data.
     * @return result of filtering operation.
     */
    private FilterResults provideCacheData(CharSequence constraint) {
        FilterResults filterResults = null;
        Object cacheResult = mFilterCache.getLruCache().get(constraint.toString());

        if (cacheResult != null) {
            //  Log.i(TAG, "Get from cache: " + constraint);
            filterResults = new FilterResults();
            filterResults.values = cacheResult;
        }

        return filterResults;
    }
}