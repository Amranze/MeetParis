package fr.amrane.amranetest.common.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appeaser.sublimepickerlibrary.SublimePicker;
import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.datepicker.SublimeDatePicker;
import com.appeaser.sublimepickerlibrary.helpers.SublimeListenerAdapter;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import fr.amrane.amranetest.common.utils.DateUtils;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class DateTimePickerFragment extends DialogFragment {
    /*private final static int OLD_YEAR = 1900;

    // Date & Time formatter used for formatting
    // text on the switcher button
    DateFormat mDateFormatter, mTimeFormatter;

    // Picker
    SublimePicker mSublimePicker;

    // Callback to activity
    Callback mCallback;
    private boolean showToday = false;
    private Calendar customCalendar = null;
    private Fragment time_header; //header container (10:09 AM/PM)

    private boolean onlyDatePicker = false;
    private boolean onlyTimePicker = false;
    private boolean use12hFormat = false;
    private boolean use24hFormat = false;

    private Date rangeDateMin; //default getMinDate()
    private Date rangeDateMax; //default getMaxDate()

    private String title = null;
    private int headerBackgroundColor = -1;
    private int moduleColor = R.color.sublime_bar_color;

    SublimeListenerAdapter mListener = new SublimeListenerAdapter() {
        @Override
        public void onDateTimeRecurrenceSet(SublimePicker sublimeMaterialPicker, SelectedDate selectedDate,
                                            int hourOfDay, int minute, SublimeRecurrencePicker.RecurrenceOption recurrenceOption, String recurrenceRule) {
            if (mCallback != null) {
                Calendar pickedDate = Calendar.getInstance();
                pickedDate.set(selectedDate.getStartDate()., hourOfDay, minute);
                if (DateUtils.isToday(pickedDate.getTime())) {
                    Calendar now = Calendar.getInstance();
                    if (pickedDate.compareTo(now) == 1) {
                        // picked date is in the future
                        showFutureMeasurementToast(getActivity());
                        mCallback.onFutureTimeSet();
                    } else {
                        mCallback.onDateTimeRecurrenceSet(year, monthOfYear, dayOfMonth,
                                hourOfDay, minute, recurrenceOption, recurrenceRule);
                    }
                } else {
                    mCallback.onDateTimeRecurrenceSet(year, monthOfYear, dayOfMonth,
                            hourOfDay, minute, recurrenceOption, recurrenceRule);
                }
            }
            // Should actually be called by activity inside `Callback.onCancelled()`
            dismiss();
        }

        @Override
        public void onCancelled() {
            if (mCallback != null) {
                mCallback.onCancelled();
            }

            // Should actually be called by activity inside `Callback.onCancelled()`
            dismiss();
        }

        @Override
        public void onDateTimeRecurrenceSet(SublimePicker sublimePicker, int year, int monthOfYear, int dayOfMonth, int hourOfDay,
                                            int minute, SublimeRecurrencePicker.RecurrenceOption recurrenceOption, String recurrenceRule) {

        }

        // You can also override 'formatDate(Date)' & 'formatTime(Date)'to supply custom formatters.
    };

    public DateTimePickerFragment() {
        // Initialize formatters
        mDateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
        mTimeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
        mTimeFormatter.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        setDateTimeOptions();
    }

    // Set activity callback
    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final boolean useWrapperWithTitle = (title!=null);
        final int layoutId = useWrapperWithTitle? R.layout.date_time_picker_wrapper_with_title: R.layout.sublime_picker;
        View view = getActivity().getLayoutInflater().inflate(layoutId, container);
        mSublimePicker = (SublimePicker)  view.findViewById(R.id.sublime_picker);

        //apply customisations if needed
        if(useWrapperWithTitle){
            TextView txt_date_picker_wrapper_title = (TextView) view.findViewById(R.id.txt_date_picker_wrapper_title);
            txt_date_picker_wrapper_title.setText(title);
            FrameLayout time_header = (FrameLayout) mSublimePicker.findViewById(R.id.time_header);
            time_header.setBackgroundColor(view.getContext().getResources().getColor(headerBackgroundColor));
            txt_date_picker_wrapper_title.setBackgroundColor(view.getContext().getResources().getColor(headerBackgroundColor));
        }

        // Retrieve SublimeOptions
        Bundle arguments = getArguments();
        SublimeOptions options = null;

        // Options can be null, in which case, default
        // options are used.
        if (arguments != null) {
            options = arguments.getParcelable("SUBLIME_OPTIONS");
        }

        mSublimePicker.initializePicker(options, mListener);

        if (showToday) {
            addTodayButton(getActivity());
        }
        Button cancelButton = (Button) mSublimePicker.findViewById(com.appeaser.sublimepickerlibrary.R.id.buttonNegative);
        cancelButton.setTextColor(getActivity().getResources().getColor(R.color.black));

        setModuleColor();

        return view;
    }

    private void setModuleColor() {
        int backgroundColor = ContextCompat.getColor(mSublimePicker.getContext(), this.moduleColor);
        if (mSublimePicker.findViewById(R.id.date_picker_header) != null) {
            mSublimePicker.findViewById(R.id.date_picker_header).setBackgroundColor(backgroundColor);
        }

        if (mSublimePicker.findViewById(R.id.day_picker_selector_layout) != null) {
            mSublimePicker.findViewById(R.id.day_picker_selector_layout).setBackgroundColor(backgroundColor);
        }

        if (mSublimePicker.findViewById(R.id.date_picker_month_and_day_layout) != null) {
            mSublimePicker.findViewById(R.id.date_picker_month_and_day_layout).setBackgroundColor(backgroundColor);
        }

        if (mSublimePicker.findViewById(R.id.date_picker_year) != null) {
            mSublimePicker.findViewById(R.id.date_picker_year).setBackgroundColor(backgroundColor);
        }

        if (mSublimePicker.findViewById(R.id.time_header) != null) {
            mSublimePicker.findViewById(R.id.time_header).setBackgroundColor(backgroundColor);
        }
    }

    public void setModuleColor(int moduleColor) {
        this.moduleColor = moduleColor;
    }

    public void setDateRanges(Date min, Date max) {
        this.rangeDateMin = min;
        this.rangeDateMax = max;
    }

    public void addTodayButton(Context context) {
        Button todayBtn = new Button(context);
        todayBtn.setTextColor(Color.WHITE);
        todayBtn.setBackgroundColor(ContextCompat.getColor(context, this.moduleColor));
        todayBtn.setText(R.string.today);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        todayBtn.setLayoutParams(params);
        todayBtn.setPadding(40, 20, 20, 20);
        ((LinearLayout) mSublimePicker.getChildAt(mSublimePicker.getChildCount() - 1)).addView(todayBtn, 0);

        todayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SublimeDatePicker datePicer = (SublimeDatePicker) mSublimePicker.findViewById(com.appeaser.sublimepickerlibrary.R.id.datePicker);
                Calendar cal = Calendar.getInstance();
                datePicer.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
            }
        });
    }

    // For communicating with the activity
    public interface Callback {
        void onCancelled();

        void onDateTimeRecurrenceSet(int year, int monthOfYear, int dayOfMonth,
                                     int hourOfDay, int minute,
                                     SublimeRecurrencePicker.RecurrenceOption recurrenceOption,
                                     String recurrenceRule);

        void onFutureTimeSet();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    public void activateOnlyDatePicker() {
        this.onlyDatePicker = true;
        this.onlyTimePicker = false;
        this.setDateTimeOptions();
    }

    public void activateOnlyTimePicker() {
        this.onlyDatePicker = false;
        this.onlyTimePicker = true;
        this.setDateTimeOptions();
    }

    public void useLocaleFormat(){
        if(android.text.format.DateFormat.is24HourFormat(BWCApp.getAppContext())) {
            this.use12hFormat = false;
            this.use24hFormat = true;
        } else {
            this.use12hFormat = true;
            this.use24hFormat = false;
        }
        this.setDateTimeOptions();
    }

    public void setTitleAndHeaderBgColor(@NonNull String title, @ColorRes int color) {
        this.title = title;
        this.headerBackgroundColor = color;
    }

    private void setDateTimeOptions() {
        SublimeOptions options = new SublimeOptions();
        int displayOptions = 0;

        displayOptions |= SublimeOptions.ACTIVATE_DATE_PICKER;
        displayOptions |= SublimeOptions.ACTIVATE_TIME_PICKER;

        options.setPickerToShow(SublimeOptions.Picker.DATE_PICKER);
        //      options.setPickerToShow(SublimeOptions.Picker.TIME_PICKER);
        options.setDisplayOptions(displayOptions);

        long minDate = getMinDate().getTime();
        long maxDate = getMaxDate().getTime();

        if(this.rangeDateMin!=null)
            minDate = this.rangeDateMin.getTime();
        if(this.rangeDateMax!=null)
            maxDate = this.rangeDateMax.getTime();
        options.setDateRange(minDate, maxDate);

        if (this.onlyTimePicker) {
            displayOptions = SublimeOptions.ACTIVATE_TIME_PICKER;
            options.setPickerToShow(SublimeOptions.Picker.TIME_PICKER);
            options.setDisplayOptions(displayOptions);
        } else if (this.onlyDatePicker) {
            displayOptions = SublimeOptions.ACTIVATE_DATE_PICKER;
            options.setPickerToShow(SublimeOptions.Picker.DATE_PICKER);
            options.setDisplayOptions(displayOptions);
        }

        boolean is24HourFormat = true;
        Context context = BWCApp.getAppContext();
        if (context != null) {
            is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        }

        if(this.use12hFormat)
            is24HourFormat = false;
        else if(this.use24hFormat)
            is24HourFormat = true;

        Calendar calendar;
        if (customCalendar != null) {
            calendar = customCalendar;
            options.setDateParams(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            calendar = Calendar.getInstance();
        }
        options.setTimeParams(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24HourFormat);

        Pair<Boolean, SublimeOptions> optionsPair = new Pair<>(displayOptions != 0 ? Boolean.TRUE : Boolean.FALSE, options);
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUBLIME_OPTIONS", optionsPair.second);
        this.setArguments(bundle);
    }

    public static void showFutureMeasurementToast(Context context) {
        Toast.makeText(context, R.string.future_measurement_time_toast, Toast.LENGTH_SHORT).show();
    }

    public SublimePicker getSublimePicker() {
        return mSublimePicker;
    }

    public static Date getMinDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -100);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getMaxDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, +100);
        return new Date(calendar.getTimeInMillis());
    }

    public void showTodayButton() {
        this.showToday = true;
    }

    public void showCustomDate(Calendar calendar) {
        customCalendar = calendar;
        this.setDateTimeOptions();
    }
*/
}
