package nl.visser.joram.mathapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import nl.visser.joram.mathapp.Activities.AnswerQuestionActivity;
import nl.visser.joram.mathapp.Difficulty;
import nl.visser.joram.mathapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements Categories {

    private static final String LOG_TAG = CategoriesFragment.class.getSimpleName();

    private Mode mode;
    private ArrayList<Category> categories = new ArrayList<>();
    private SeekBar difficultyControl;
    private TextView difficultyTextView;
    private int difficultySetByBar;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        mode = (Mode) bundle.get("MODE");
        Log.v(LOG_TAG, "Modes = " + mode);
        difficultySetByBar = 1;
        Difficulty.INSTANCE.setDifficulty(difficultySetByBar);
        difficultyControl = (SeekBar) getView().findViewById(R.id.difficulty_bar);
        difficultyTextView = (TextView) getView().findViewById(R.id.difficulty_textview);
        setIntensityControlListener();
    }

    private void setIntensityControlListener() {
        difficultyControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                difficultySetByBar = progress + 1;
                difficultyTextView.setText(Integer.toString(difficultySetByBar));
                Difficulty.INSTANCE.setDifficulty(difficultySetByBar);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_additions:
                if (checked) {
                    Log.v(LOG_TAG, "Checked additions");
                    categories.add(Category.ADDITIONS);
                } else {
                    Log.v(LOG_TAG, "Unchecked additions");
                }
                break;
            case R.id.checkbox_subtractions:
                if (checked) {
                    Log.v(LOG_TAG, "Checked subtractions");
                    categories.add(Category.SUBTRACTIONS);
                } else {
                    Log.v(LOG_TAG, "Unchecked subtractions");
                }
                break;
            case R.id.checkbox_multiplications:
                if (checked) {
                    Log.v(LOG_TAG, "Checked multiplications");
                    categories.add(Category.MULTIPLICATIONS);
                } else {
                    Log.v(LOG_TAG, "Unchecked multiplications");
                }
                break;
            case R.id.checkbox_divisions:
                if (checked) {
                    Log.v(LOG_TAG, "Checked divisions");
                    categories.add(Category.DIVISIONS);
                } else {
                    Log.v(LOG_TAG, "Unchecked divisions");
                }
                break;
        }
    }

    public void go(View view) {
        Intent intent = new Intent(getActivity(), AnswerQuestionActivity.class);
        Bundle bundleCategory = new Bundle();
        bundleCategory.putSerializable("CATEGORY", categories);
        intent.putExtras(bundleCategory);
        if (mode == Mode.NORMAL && intent != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("MODE", Mode.NORMAL);
            intent.putExtras(bundle);
        } else if (mode == Mode.TIME_TRIAL && intent != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("MODE", Mode.TIME_TRIAL);
            intent.putExtras(bundle);
        } else if ( mode == Mode.ENDLESS && intent != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("MODE", Mode.ENDLESS);
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
