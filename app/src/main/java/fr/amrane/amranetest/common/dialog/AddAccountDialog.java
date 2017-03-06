package fr.amrane.amranetest.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.utils.DateFormatter;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class AddAccountDialog extends DialogFragment implements View.OnClickListener {

    private EditText etName, etEmail, etBirthday;
    private Date date;
    private Button btAdd;

    private OnAddAccountClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AlertDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_student, container);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        etBirthday = (EditText) view.findViewById(R.id.et_birthday);
        btAdd = (Button) view.findViewById(R.id.bt_add);
        etName.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        btAdd.setOnClickListener(this);
        etBirthday.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add: {
                if (isUserInfoValidate()) {
                    Account account = new Account();
                    account.setFirstname(etName.getText().toString());
                    account.setMail(etEmail.getText().toString());
                    account.setBirthdate(date);
                    listener.OnAddAccountClickListener(account);
                }
                break;
            }
            case R.id.et_birthday: {
                Calendar now = Calendar.getInstance();
                final DatePickerDialog d = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
                                Calendar checkedCalendar = Calendar.getInstance();
                                checkedCalendar.set(year, monthOfYear, dayOfMonth);
                                date = checkedCalendar.getTime();
                                etBirthday.setText(DateFormatter.convertDateToString(date));
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                d.setMaxDate(now);
                d.show((getActivity()).getFragmentManager(), this.getClass().getName());
                break;
            }
        }
    }

    private boolean isUserInfoValidate() {
        return !etName.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty() &&
                !etBirthday.getText().toString().isEmpty();
    }

    public void setListener(OnAddAccountClickListener listener) {
        this.listener = listener;
    }

    public interface OnAddAccountClickListener {
        void OnAddAccountClickListener(Account account);
    }
}