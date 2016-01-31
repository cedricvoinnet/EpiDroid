package com.example.jordan.epiandroid.Fragment;

import android.app.Activity;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Activity.MainActivity;
import com.example.jordan.epiandroid.Adapter.ModuleArrayAdapter;
import com.example.jordan.epiandroid.Models.ModulesMarks.AllModules;
import com.example.jordan.epiandroid.Models.ModulesMarks.Items;
import com.example.jordan.epiandroid.Models.ModulesMarks.Modules;
import com.example.jordan.epiandroid.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ModuleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ModuleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModuleFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private View view;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModuleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModuleFragment newInstance(String param1, String param2) {
        return new ModuleFragment();
    }

    public ModuleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_module, container, false);
        getModules();
        return view;
    }

    private void getModules() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.API_URL)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();

        final APIRequest request = retrofit.create(APIRequest.class);

        Call<Modules> call = request.getModules(MainActivity.sessionToken);
        call.enqueue(new Callback<Modules>() {
            @Override
            public void onResponse(Response<Modules> response) {
                if (response.code() == 200) {
                    Modules modules = response.body();
                    setModules(modules);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Module", t.toString());
                Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Modules", "Can't access to network");
            }
        });
    }

    private void setModules(Modules modules){
        ListView lvModule = (ListView) view.findViewById(R.id.lv_module);
        lvModule.setAdapter(null);

        ModuleArrayAdapter adapter = new ModuleArrayAdapter(getContext(), R.layout.fragment_module, modules.getModules());
        lvModule.setAdapter(adapter);
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
