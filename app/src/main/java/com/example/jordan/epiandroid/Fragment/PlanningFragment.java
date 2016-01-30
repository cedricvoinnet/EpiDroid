package com.example.jordan.epiandroid.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Activity.LoginActivity;
import com.example.jordan.epiandroid.Adapter.PlanningArrayAdapter;
import com.example.jordan.epiandroid.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlanningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlanningFragment extends Fragment {

    @Bind(R.id.btn_prev_day)
    Button btnPrevDay;
    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.btn_next_day)
    Button btnNextDay;
    @Bind(R.id.lv_planning)
    ListView lvPlanning;
    private View view;

    private SimpleDateFormat APIDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PlanningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlanningFragment newInstance(String param1, String param2) {
        return new PlanningFragment();
    }

    public PlanningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_planning, container, false);
        date = (TextView) view.findViewById(R.id.date);

        Calendar c = Calendar.getInstance();
        date.setText(APIDateFormat.format(c.getTime()));

        initMembers();
        ButterKnife.bind(this, view);
        return view;
    }

    private void initMembers() {
        ListView lvPlanning = (ListView) view.findViewById(R.id.lv_planning);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIRequest request = retrofit.create(APIRequest.class);

        Call<List<com.example.jordan.epiandroid.Models.Planning.Activity>> call = request.getPlannng(LoginActivity.sessionToken, date.getText().toString(), date.getText().toString());
        call.enqueue(new Callback<List<com.example.jordan.epiandroid.Models.Planning.Activity>>() {
            @Override
            public void onResponse(Response<List<com.example.jordan.epiandroid.Models.Planning.Activity>> response) {
                Log.d("Planning", "Success");
                if (response.code() == 200) {
                    List<com.example.jordan.epiandroid.Models.Planning.Activity> tmp = response.body();
                    List<com.example.jordan.epiandroid.Models.Planning.Activity> Activities = new ArrayList<>();
                    for (com.example.jordan.epiandroid.Models.Planning.Activity act : tmp) {
                        if (act.getModuleRegistered())
                            Activities.add(act);
                    }
                    setPlanningList(Activities);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Planning", "Can't access to network");
            }
        });
    }

    private void setPlanningList(List<com.example.jordan.epiandroid.Models.Planning.Activity> Activities){
        final PlanningArrayAdapter adapter = new PlanningArrayAdapter(getContext(), R.layout.row_planning, Activities);
        if (lvPlanning != null) {
            lvPlanning.setAdapter(adapter);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
