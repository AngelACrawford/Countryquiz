package edu.uga.cs.countryquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Locale;

public class Results extends ArrayAdapter<Record>{
    private final Context context;
    private final Record[] quizRecords;

    public Results(Context context, Record[] quizRecords) {
        super(context, R.layout.result, quizRecords);
        this.context = context;
        this.quizRecords = quizRecords;
    } // ResultsAdapter Constructor

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.result, parent, false);

            holder = new ViewHolder();
            holder.dateTextView = convertView.findViewById(R.id.dateTextView);
            holder.gradeTextView = convertView.findViewById(R.id.gradeTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        } // if / else

        Record quizRecord = quizRecords[position];
        holder.dateTextView.setText(quizRecord.getDate());
        holder.gradeTextView.setText(quizRecord.getResult());

        return convertView;
    } // getView()

    private static class ViewHolder {
        TextView dateTextView;
        TextView gradeTextView;
    } // ViewHolder Class
}
