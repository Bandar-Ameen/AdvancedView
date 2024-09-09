package com.astooltech.advancedview.proteus.parser.adapterskit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.AAadpterme;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.custom.protouseFastScroller;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SectionedListFragment extends Fragment {

	String nam;
	private ProteusView infl;
	private String layoutname;
	private  String keynames;
	//SkeletonView tg=null;
	public SectionedListFragment(ProteusView infii,String layoutnamee){
		this.infl=infii;
		//this.nam=namm;
		this.layoutname=layoutnamee;
		//this.keynames=keyname;
		//SkeletonModel gr=new SkeletonModel();

		//gr.setColorBackgroundViews(R.co);
	//	tg.setSkeletonModel();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.list_fragment, container, false);

		getAllvalue eerr=new getAllvalue(infl,this.nam);
		Layout gg=infl.getViewManager().getContext().getLayout(this.layoutname);
		List<modeltypeview> f=new ArrayList<>();
		final List<AbstractFlexibleItem> eet=	eerr.getDataAll(gg);
		List<AbstractFlexibleItem> ui=new ArrayList<>();
		RecyclerView bookListView = (RecyclerView) view.findViewById(R.id.listre);
		TextInputLayoutB serr=eerr.getSearchtext();
		final AAadpterme mnbb = new AAadpterme(ui,eerr,eerr.getProgras());//view.getContext(),android.R.layout.simple_list_item_1,mItemss,((AutoCompleteTextViewB) view).getViewManager().getContext().getInflater(),temppxm,false);//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);
		//eerr.loadalltegret(0);
//mnbb.setLoadingMoreAtStartUp(true);
		bookListView.setLayoutManager(new LinearLayoutManager(view.getContext()));
		bookListView.setAdapter(mnbb);


		protouseFastScroller uto=	eerr.getFastscroll();
		if(uto!=null){
			uto.addOnScrollStateChangeListener(new FastScroller.OnScrollStateChangeListener() {
				@Override
				public void onFastScrollerStateChange(boolean scrolling) {

				}
			});
			mnbb.setFastScroller(uto);
		}


		/*ScrollableLayoutItem scrollHeader = new ScrollableLayoutItem("SLI");
		scrollHeader.setTitle("Endless Scrolling");
		scrollHeader.setSubtitle("...with ScrollableHeaderItem");
		mnbb.addScrollableHeader(scrollHeader);*/
mnbb.setTopEndless(true);
mnbb.setLoadingMoreAtStartUp(true);
		ViewGroup edd=(ViewGroup) view.findViewById(R.id.serr);

		if(serr!=null) {
			serr.getEditText().addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

					//DynamicAutocompleteFilterA tu=	mnbb.getFilter(DynamicAutocompleteFilterA.class);

					//	mnbb.fflt(charSequence.toString());
					mnbb.SearchText(charSequence.toString());
				/*if (mnbb.hasNewFilter(charSequence.toString())) {
					mnbb.setFilter(charSequence.toString());

					// Fill and Filter mItems with your custom list and automatically animate the changes
					// - Option A: Use the internal list as original list
					mnbb.filterItems(eet,DatabaseConfiguration.delay);

					// - Option B: Provide any new list to filter
					//mAdapter.filterItems(DatabaseService.getInstance().getDatabaseList(), DatabaseConfiguration.delay);
				}*/
					;


					//uuip.triggerAdapter(6, false, charSequence.toString(), charSequence.toString(), null, ((ProteusEditText) view));


					//((ProteusEditText) view).getViewManager().getDataContext()

					// Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+charSequence);
				}

				@Override
				public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
			edd.addView(serr);
		}
		//Log.i("ffffdddd",eet.size()+"hhhhhhhhhhggggggvvv999999999999hhhhhh");
		/*Value r=	eerr.GetVAluee().getAsObject().get("s1");

		Array re=r.getAsArray();
		for (int cx = 0; cx < re.size(); cx++) {

		}*/
	/*	Iterator<Map.Entry<String, Value>> vv = .entrySet().iterator();
		while (vv.hasNext()) {
			Map.Entry<String, Value> ddert = vv.next();
			//counnnt = ddert.getValue().getAsArray().size();
			Gson gg = new Gson();

			//  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
			// Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
			for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
				Log.i("ffffdddd","gggggggggg");
			}
		}*/

		/*		ArrayList<Book> books = new ArrayList<Book>(BooksDAO.getAllBooks());
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book lhs, Book rhs) {
				return lhs.getBookCategory().compareTo(rhs.getBookCategory());
			}
		});

		InstantAdapter<Book> bookListAdapter = new InstantAdapter<Book>(
				this.getActivity(), R.layout.a_notification_item, Book.class, books);

		/*SimpleSectionAdapter<Book> sectionedAdapter = new SimpleSectionAdapter<Book>(
				getActivity(), bookListAdapter, R.layout.section_header,
				R.id.section_text, new Sectionizer<Book>() {

					@Override
					public String getSectionTitleForItem(Book instance) {
						return instance.getBookCategory();
					}
				});
*/

		//DatabaseService.getInstance().cre(20); //N. of items
		//DatabaseService.getInstance().createHeadersSectionsDatabase(50, 1); //N. of items
		/*List<modeltypeview> temppxm = new ArrayList<>();
		final List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
		ScriptModel g = new ScriptModel(0, "no", nam);
		DatabaseHelper db_operations;
		db_operations = new DatabaseHelper(this.getContext());
		List<ScriptModel> x = db_operations.getAllNotes(g);
		String val = x.get(0).getContent();

		Value ey=	createList("h");
	Value eert=ey.getAsObject().get("s1");
		final String typex = "kk";
		for (int cx = 0; cx < eert.getAsArray().size(); cx++) {

			OOverIttem ioppp = new OOverIttem(temppxm, false, cx, typex, eert.getAsObject(), infl, eert.getAsArray().get(cx));

			mItemss.add(ioppp);

			//   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

		}
		//FlexibleAdapter<AbstractFlexibleItem> re=new FlexibleAdapter<>(mItemss);
		AAadpterme mnbb = new AAadpterme(mItemss);//view.getContext(),android.R.layout.simple_list_item_1,mItemss,((AutoCompleteTextViewB) view).getViewManager().getContext().getInflater(),temppxm,false);//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);



		RecyclerView bookListView = (RecyclerView) view.findViewById(R.id.listre);
		bookListView.setLayoutManager(new LinearLayoutManager(view.getContext()));
		bookListView.setAdapter(mnbb);*/
	//	bookListView.getAdapter().notifyDataSetChanged();
		return view;
	}

	private  Value createList(String dat) {

		String k="{s1:"+dat+"}";

			ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(this.getContext());
			Gson gsonn = new GsonBuilder()
					.registerTypeAdapterFactory(adapter)
					.create();
			Type type = new TypeToken<Value>() {

			}.getType();
			Value tempp = gsonn.fromJson(k, type);


		return tempp;
	}
}
