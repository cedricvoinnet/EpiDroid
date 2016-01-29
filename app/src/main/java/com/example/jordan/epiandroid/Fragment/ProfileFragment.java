package com.example.jordan.epiandroid.Fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordan.epiandroid.APIIntra.APIRequest;
import com.example.jordan.epiandroid.Activity.LoginActivity;
import com.example.jordan.epiandroid.Model.Profile.UserProfile;
import com.example.jordan.epiandroid.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.et_search_login)
    EditText etSearchLogin;
    @Bind(R.id.b_search)
    Button bSearch;
    @Bind(R.id.ll_search)
    LinearLayout llSearch;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_year)
    TextView tvYear;
    @Bind(R.id.iv_profile_picture)
    ImageView ivProfilePicture;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.tv_promo_title)
    TextView tvPromoTitle;
    @Bind(R.id.tv_promo)
    TextView tvPromo;
    @Bind(R.id.tv_credits_title)
    TextView tvCreditsTitle;
    @Bind(R.id.tv_credits)
    TextView tvCredits;
    @Bind(R.id.tv_gpa_title)
    TextView tvGpaTitle;
    @Bind(R.id.tv_gpa)
    TextView tvGpa;
    @Bind(R.id.tv_mail)
    TextView tvMail;
    @Bind(R.id.tv_netsoul_title)
    TextView tvNetsoulTitle;
    @Bind(R.id.tv_netsoul)
    TextView tvNetsoul;
    @Bind(R.id.tv_phone_number)
    TextView tvPhoneNumber;

    private OnFragmentInteractionListener mListener;

    @OnClick(R.id.tv_mail)
    public void sendEMail() {
        /*Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, tvMail.getText());
        startActivity(emailIntent);*/
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, tvMail.getText());
        intent.setData(Uri.parse("mailto:" + tvMail.getText()));
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
        try {

            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Log.d("Email error:", e.toString());
        }
    }

    @OnClick(R.id.tv_phone_number)
    public void MessageOrCall() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + tvPhoneNumber.getText()));
        startActivity(intent);
    }

    @OnClick(R.id.b_search)
    public void search() {
        View view = getActivity().getCurrentFocus();

        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        String userToSearch = etSearchLogin.getText().toString();
        if (!userToSearch.isEmpty())
            refresh(userToSearch);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    public ProfileFragment() {
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        refresh(LoginActivity.login);

        ButterKnife.bind(this, view);
        return view;
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

    public void refresh(String user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginActivity.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIRequest request = retrofit.create(APIRequest.class);
        Call<UserProfile> call = request.getUser(LoginActivity.sessionToken, user);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Response<UserProfile> response) {
                Log.d("User", "Success");
                if (response.code() == 200) {
                    UserProfile user = response.body();

                    if (!user.hasError()) {
                        Picasso.with(getContext())
                                .load(user.getPicture())
                                .placeholder(R.drawable.progress_animation)
                                .into(ivProfilePicture);

                        tvName.setText(user.getFullName());
                        tvYear.setText(user.getStudentYear());
                        tvLogin.setText(user.getLogin());
                        tvPromo.setText(user.getPromo());
                        tvCredits.setText(user.getCredits());
                        tvGpa.setText(user.getGpa().get(0).getGpa());
                        tvMail.setText(user.getEmail());
                        tvNetsoul.setText(user.getNetStat().getActive());
                    } else
                        Toast.makeText(getContext(), user.getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("User", "Fail: " + t.getMessage());
                Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
