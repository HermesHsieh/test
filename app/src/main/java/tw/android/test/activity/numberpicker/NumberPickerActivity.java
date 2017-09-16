package tw.android.test.activity.numberpicker;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.example.hermes.test.R;

import butterknife.BindView;
import butterknife.OnClick;
import tw.android.test.BaseSimpleActivity;
import tw.android.test.ui.form.EditTextItem;

/**
 * Created by hermes.hsieh on 2017/9/14.
 */

public class NumberPickerActivity extends BaseSimpleActivity {

    @BindView(R.id.layout_content)
    LinearLayout layoutContent;

    @BindView(R.id.my_button)
    Button mButton;

    @BindView(R.id.number_picker)
    NumberPicker mNumberPicker;

    @Override
    protected int initContentView() {
        return R.layout.activity_number_picker;
    }

    @Override
    protected void initView() {
        setTitle(this.getClass().getSimpleName());
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(1000);
        mNumberPicker.setValue(10);
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d("NumberPickerActivity", "Value : " + newVal);
            }
        });
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 50; i++) {
            layoutContent.addView(new EditTextItem(this, "[ " + i + " ]", "number:" + i + 1).getView());
        }
    }

    @OnClick(R.id.my_button)
    public void onClickButtonEvent() {
        Log.d("tester", "Child Count : " + layoutContent.getChildCount());
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, NumberPickerActivity.class);
        activity.startActivity(intent);
    }
}
