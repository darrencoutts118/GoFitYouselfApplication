package com.example.getfityourself;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

import com.example.getfityourself.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScheduleActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        String auth = "UserAuth";

        String [] days = new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};


        ServerSchedule schedule = new ServerSchedule(auth);
        try {
            if (schedule.current()) {
                ArrayList<ServerScheduleResponse> CurrentSchedule = schedule.getCurrent();
                System.out.println(CurrentSchedule);

        List<Item> items = new ArrayList<Item>();
        final List<Object> ex = new ArrayList<Object>();

        for(int i = 0; i < CurrentSchedule.size(); i++) {

            ServerScheduleResponse thisday = (ServerScheduleResponse)CurrentSchedule.get(i);

            items.add(new Header(days[thisday.Day]));
            ex.add(null);

            ServerWorkout workout = new ServerWorkout(auth);
            if(workout.workout(thisday.Workout)) {
                ArrayList<ServerWorkoutResponse> CurrentWorkout = workout.getWorkout();


                for (int j = 0; j < CurrentWorkout.size(); j++){

                    ServerWorkoutResponse thisworkout = (ServerWorkoutResponse)CurrentWorkout.get(j);
                    ServerExercise exercise = new ServerExercise(auth);
                    exercise.exercise(thisworkout.Exercise);
                    ServerExerciseResponse r = exercise.getExercise();

                    items.add(new ListItem(r.Name, thisworkout.Reps));
                    ex.add(thisworkout.Exercise);

                }

            }

        }



        TwoTextArrayAdapter adapter = new TwoTextArrayAdapter(this, items);
        ListView codeLearnLessons = (ListView)findViewById(android.R.id.list);

        codeLearnLessons.setAdapter(adapter);



       // String[] codeLearnChapters = new String[] { "Android Introduction","Android Setup/Installation","Android Hello World","Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android","Android Introduction","Android Setup/Installation","Android Hello World","Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android","Android Introduction","Android Setup/Installation","Android Hello World","Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android","Android Introduction","Android Setup/Installation","Android Hello World","Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android"};
       // ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, codeLearnChapters);

       // ListView codeLearnLessons = (ListView)findViewById(R.id.listView2);
       // codeLearnLessons.setAdapter(codeLearnArrayAdapter);
       codeLearnLessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView,
                                       int position, long id)
            {
                System.out.println(ex.get(position));
            }

            public void onNothingSelected(AdapterView parentView) {

            }
        });



            } else {
                System.out.println(schedule.getError());
            }
        } catch (Exception e) {
            ;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
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



    public interface Item {
    public int getViewType();
    public View getView(LayoutInflater inflater, View convertView);
}

    public class TwoTextArrayAdapter extends ArrayAdapter<Item> {
    private LayoutInflater mInflater;

    public TwoTextArrayAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return 2;

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(mInflater, convertView);
    }
}

    public class Header implements Item {
    private final String name;

    public Header(String name) {
        this.name = name;
    }

    @Override
    public int getViewType() {
        return 1;
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.list_header, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text = (TextView) view.findViewById(R.id.separator);
        text.setText(name);

        return view;
    }

}

    public class ListItem implements Item {
        private final Object str1;
        private final Object str2;

        public ListItem(Object text1, Object text2) {
            this.str1 = text1;
            this.str2 = text2;
        }

        @Override
        public int getViewType() {
            return 0;
        }

        @Override
        public View getView(LayoutInflater inflater, View convertView) {
            View view;
            if (convertView == null) {
                view = (View) inflater.inflate(R.layout.my_list_item, null);
                // Do some initialization
            } else {
                view = convertView;
            }

            TextView text1 = (TextView) view.findViewById(R.id.list_content1);
            TextView text2 = (TextView) view.findViewById(R.id.list_content2);
            text1.setText(str1.toString());
            text2.setText(str2.toString());

            return view;
        }


    }
    }
