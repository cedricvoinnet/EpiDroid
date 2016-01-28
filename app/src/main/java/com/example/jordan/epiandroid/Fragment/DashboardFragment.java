package com.example.jordan.epiandroid.Fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Activity.LoginActivity;
import com.example.jordan.epiandroid.Adapter.NotifcationArrayAdapter;
import com.example.jordan.epiandroid.Model.Current;
import com.example.jordan.epiandroid.Model.DashInfos;
import com.example.jordan.epiandroid.Model.History;
import com.example.jordan.epiandroid.R;

import java.io.InputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    private View view;
    private ListView notificationList;
    private TextView logTime;
    private ImageView userPicture;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DashBoardFragment.
     */
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment() {
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
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        notificationList = (ListView) view.findViewById(R.id.lv_notif);
        logTime = (TextView) view.findViewById(R.id.tv_log_time);
        userPicture = (ImageView) view.findViewById(R.id.iv_profile);

        //ACTIVER PROGRESSBAR
        initMembers();
        return view;
    }

    private void initMembers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIRequest request = retrofit.create(APIRequest.class);
        Call<DashInfos> call = request.getInfos(LoginActivity.sessionToken);
        call.enqueue(new Callback<DashInfos>() {
            @Override
            public void onResponse(Response<DashInfos> response) {
                Log.d("DashBoard", "Success");
                if (response.code() == 200) {
                    new DownloadImageTask(userPicture).execute(LoginActivity.PICTURES_URL + LoginActivity.login + ".bmp");

                    DashInfos infos = response.body();

                    setNotif(infos.getHistory());
                    setLogTime(infos.getCurrent().get(0));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                //DESACTIVER PROGRESSBAR
                Log.d("DashBoard", "Fail");
            }
        });
    }

    public void setNotif(List<History> notifs) {
        NotifcationArrayAdapter adapter;

        notificationList = (ListView) view.findViewById(R.id.lv_notif);
        adapter = new NotifcationArrayAdapter(getContext(), R.layout.row_notification, notifs);
        notificationList.setAdapter(adapter);
    }


    public void setLogTime(Current current) {
        logTime.setText(current.getActiveLog());
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
        void onFragmentInteraction(Uri uri);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null)
                bmImage.setImageBitmap(result);
            //DESACTIVER LA PROGRESSBAR
        }
    }
}
