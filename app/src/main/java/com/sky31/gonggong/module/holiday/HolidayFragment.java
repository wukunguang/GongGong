package com.sky31.gonggong.module.holiday;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky31.gonggong.R;
import com.sky31.gonggong.model.HolidayAllModel;
import com.sky31.gonggong.model.HolidayNextModel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HolidayFragment extends Fragment implements HolidayView {


    @Bind(R.id.rv_holiday)
    RecyclerView rvHoliday;

    public HolidayFragment() {
        // Required empty public constructor
    }

    public static HolidayFragment newInstance(String param1, String param2) {
        HolidayFragment fragment = new HolidayFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        getHoliday();
    }

    private void init() {

    }

    private void getHoliday() {
        HolidayPresenter holidayPresenter = new HolidayPresenter(this);
        holidayPresenter.getHolidayAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onGetHolidayNext() {

    }

    @Override
    public void finishGetHolidayNext(HolidayNextModel holidayNextModel) {

    }

    @Override
    public void onGetHolidayAll() {

    }

    @Override
    public void finishGetHolidayAll(HolidayAllModel holidayAllModel) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}