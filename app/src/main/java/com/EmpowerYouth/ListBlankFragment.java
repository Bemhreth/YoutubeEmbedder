package com.EmpowerYouth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.EmpowerYouth.adapter.YoutubeListAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class ListBlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String youtubeVideoLink;

    private OnFragmentInteractionListener mListener;

    private RecyclerView youtubeVideosRV;
    private YoutubeListAdapter youtubeVideosAdapter;

    public ListBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ListBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListBlankFragment newInstance(String param1) {
        ListBlankFragment fragment = new ListBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            youtubeVideoLink = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_blank, container, false);
        Control control = new Control(getActivity());
        ArrayList<Model> list;

////         list=control.maincontrol();
//        final LinkedList<String> videoLinkList = new LinkedList<>();
//        for (int i = 0; i < 6; i++) {
//            //          Log.d("this_is_me",list.get(i).getVideo_title());
//            videoLinkList.addLast("Word " + i);
//        }

//        TextView textView = view.findViewById(R.id.youtube_link);
//        textView.setText(youtubeVideoLink);
        youtubeVideosRV = view.findViewById(R.id.youtube_list);
//        youtubeVideosAdapter = new YoutubeListAdapter(getContext(), videoLinkList);


        youtubeVideosRV.setLayoutManager(new LinearLayoutManager(getContext()));
        youtubeVideosRV.setAdapter(youtubeVideosAdapter);
        final Control control1 = new Control(getActivity());
        control1.vid_list(new VolleyCallback() {
            @Override
            public void onSuccess() {
                YoutubeListAdapter list = new YoutubeListAdapter(getContext(), control1.list);
                youtubeVideosRV.setAdapter(list);
                list.notifyDataSetChanged();
            }

            @Override
            public void onError(TYPE type, Map<String, String> errorList) {

            }
        });
        return view;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


//public void displayFragment(){
//        ListBlankFragment listBlankFragment = ListBlankFragment.newInstance("alskdfjakl");
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.youtubeListContainer, listBlankFragment)
//                .addToBackStack(null)
//                .commit();
//
//    }