package nl.visser.joram.mathapp.fragments.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import nl.visser.joram.mathapp.activities.AnswerQuestionActivity;
import nl.visser.joram.mathapp.Difficulty;
import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.Score;
import nl.visser.joram.mathapp.fragments.CategoriesFragment;
import nl.visser.joram.mathapp.bundles.Category;

import static nl.visser.joram.mathapp.bundles.CategoriesBundle.addCategoriesBundle;

public class CategoriesFragmentImpl extends Fragment implements CategoriesFragment {

    private static final String LOG_TAG = CategoriesFragmentImpl.class.getSimpleName();

    private ArrayList<Category> categories = new ArrayList<>();
    private SeekBar difficultyControl;
    private TextView difficultyTextView;
    private int difficultySetByBar;

    public CategoriesFragmentImpl() {
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
        switch (view.getId()) {
            case R.id.checkbox_additions:
                reflectChangeInCategories(view, Category.ADDITIONS);
                break;
            case R.id.checkbox_subtractions:
                reflectChangeInCategories(view, Category.SUBTRACTIONS);
                break;
            case R.id.checkbox_multiplications:
                reflectChangeInCategories(view, Category.MULTIPLICATIONS);
                break;
            case R.id.checkbox_divisions:
                reflectChangeInCategories(view, Category.DIVISIONS);
                break;
        }
    }

    private void reflectChangeInCategories(View view, Category category) {
        if (isCheckBoxInTheViewChecked(view)) {
            categories.add(category);
        } else {
            categories.remove(category);
        }
    }

    private boolean isCheckBoxInTheViewChecked(View view) {
        return ((CheckBox) view).isChecked();
    }

    public void go(View view) {
        Score.INSTANCE.resetScoreSingleton();
        startActivity(createAnswerQuestionActivityIntent());
    }

    private Intent createAnswerQuestionActivityIntent() {
        Intent intent = new Intent(getActivity(), AnswerQuestionActivity.class);
        intent.putExtras(addCategoriesBundle(categories));
        intent.putExtras(getModeBundle());
        return intent;
    }

    private Bundle getModeBundle() {
        return this.getArguments();
    }

}
