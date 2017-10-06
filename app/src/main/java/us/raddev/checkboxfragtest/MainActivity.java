package us.raddev.checkboxfragtest;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static boolean isChecked;
    private static boolean isChecked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        CheckBox tab1Checkbox;
        View mainView;
        View frag3View;
        CheckBox firstCheckBox;
        CheckBox frag3CheckBox;
        TextView textView1;
        TextView textView2;
        View rootView;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d("MainActivity", "onResume : " + getArguments().getInt(ARG_SECTION_NUMBER));
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: {

                    tab1Checkbox = (CheckBox)rootView.findViewById(R.id.tab1CheckBox);
                    if (tab1Checkbox != null){
                        Log.d("MainActivity", "onResume - isChecked2 : " + String.valueOf(isChecked2));
                        tab1Checkbox.setChecked(isChecked2);
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    frag3CheckBox = (CheckBox)rootView.findViewById(R.id.frag3CheckBox);
                    if (frag3CheckBox != null) {
                        Log.d("MainActivity", "onResume - isChecked : " + String.valueOf(isChecked));
                        frag3CheckBox.setChecked(isChecked);
                    }
                    break;
                }
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {


            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: {
                    Log.d("MainActivity", "Case 1");
                    rootView = inflater.inflate(R.layout.fragment_main, container, false);

                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    if (textView1 == null) {
                        textView1 = (TextView) rootView.findViewById(R.id.textView1);
                        CharSequence cs = "";
                        textView1.setText(cs);
                    }

                    Button toggleButton = (Button)rootView.findViewById(R.id.toggleButton);
                    Button inflateButton = (Button)rootView.findViewById(R.id.inflateButton);
                    toggleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            firstCheckBox = (CheckBox)view.getRootView().findViewById(R.id.firstCheckBox);
                            isChecked = !isChecked;
                            CharSequence csOut = "isChecked : " + Boolean.valueOf(isChecked) + "\n";
                            textView1.append( csOut);
                            Log.d("MainActivity", csOut.toString() );

                            firstCheckBox.setChecked(isChecked);
                            if (frag3View == null) {
                                frag3View = getActivity().getLayoutInflater().inflate(R.layout.fragment_3, container, false);
                            }
                            frag3CheckBox = (CheckBox)frag3View.findViewById(R.id.frag3CheckBox);
                            csOut = "frag3CheckBox text : " + frag3CheckBox.getText().toString() + "\n";
                            textView1.append( csOut);
                            Log.d("MainActivity",csOut.toString());
                            frag3CheckBox.setChecked(isChecked);
                            csOut = "frag3 Set"+ "\n";
                            textView1.append( csOut);
                            Log.d("MainActivity", csOut.toString());

                        }
                    });
                    inflateButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            for (int i = 1; i < 4;i++) {
                                View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_checkboxes, container, false);
                            }
                        }
                    });
                    break;
                }
                case 2:{
                    Log.d("MainActivity", "Case 2");
                   rootView = inflater.inflate(R.layout.fragment_checkboxes, container, false);
                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    break;
                }
                case 3:{
                    Log.d("MainActivity", "Case 3");
                    rootView = inflater.inflate(R.layout.fragment_3,container, false);
                    if (mainView == null) {
                        mainView = inflater.inflate(R.layout.fragment_main, container, false);
                    }

                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    Button toggleTab1Button = (Button)rootView.findViewById(R.id.toggleTab1Button);
                    if (textView2 == null) {
                        textView2 = (TextView) rootView.findViewById(R.id.textView2);
                        CharSequence cs = "";
                        textView2.setText(cs);
                    }

                    toggleTab1Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            CharSequence csOut = "toggleTab1ButtonCLICK" + "\n";
                            textView2.append(csOut);
                            Log.d("MainActivity", csOut.toString());
                            tab1Checkbox = (CheckBox) mainView.findViewById(R.id.tab1CheckBox);
                            csOut = "tab1Checkbox text : " + tab1Checkbox.getText().toString() + "\n";
                            textView2.append(csOut);
                            Log.d("MainActivity",csOut.toString());
                            tab1Checkbox.setText("altered!");
                            isChecked2 = !isChecked2;
                            csOut = "isChecked2 : " + Boolean.valueOf(isChecked2) + "\n";
                            textView2.append(csOut);
                            Log.d("MainActivity", csOut.toString());
                            tab1Checkbox.setChecked(isChecked2);
                        }
                    });
                    break;
                }

            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

            //fm.beginTransaction().attach(this).commit();
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment f = PlaceholderFragment.newInstance(position + 1);
            return f;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
