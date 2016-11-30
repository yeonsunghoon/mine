package com.nnm.team91.mine.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nnm.team91.mine.R;
import com.nnm.team91.mine.adapter.DiaryAdapater;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDiaryListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiaryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiaryListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public DiaryAdapater getAdapter() {
        return adapter;
    }

    private DiaryAdapater adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnDiaryListFragmentInteractionListener mListener;

    public DiaryListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiaryListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiaryListFragment newInstance(String param1, String param2) {
        DiaryListFragment fragment = new DiaryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_diary_list, container, false);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, LIST_MENU);
//
//        ListView listview = (ListView) view.findViewById(R.id.listview_diary);
//        listview.setAdapter(adapter);
//
//        return view;

        View view = inflater.inflate(R.layout.fragment_diary_list, container, false);
        ListView listview = (ListView) view.findViewById(R.id.listview_diary);

        adapter = new DiaryAdapater();

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
//                DiaryItem item = (DiaryItem) parent.getItemAtPosition(position) ;
//
//                String titleStr = item.getTitle() ;
//                String descStr = item.getDesc() ;
//                Drawable iconDrawable = item.getIcon() ;

                // TODO : use item data.
            }
        }) ;

        mListener.updateDiaryData();

//        Toast toast = Toast.makeText(getContext(),"diary refresh", Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();

        return view;
    }

    public void addDummy() {
//        ArrayList<String> hashtags = new ArrayList<String>();
//        hashtags.add("Happy");
//        hashtags.add("Halloween");
//        hashtags.add("October");
//        Date datetime = Calendar.getInstance().getTime();
//        for (int i=0; i<20; i++) {
//            adapter.addItem(datetime, i + "일기 내용의 첫부분이 여기에 들어간다....", hashtags, i%3);
//        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDiaryListFragmentInteractionListener) {
            mListener = (OnDiaryListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDiaryListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDiaryListFragmentInteractionListener {
        // TODO: Update argument type and name
        // TODO : study and fill this part
        public void onFragmentInteraction(Uri uri);
        public void onDiaryItemSelected(int position);
        public void updateDiaryData();
    }
}