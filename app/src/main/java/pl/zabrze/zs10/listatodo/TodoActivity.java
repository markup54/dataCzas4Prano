package pl.zabrze.zs10.listatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Date;

public class TodoActivity extends AppCompatActivity {

    private ArrayList<Todo> todos;
    private ListView listViewTodos;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        todos = new ArrayList<>();
        todos.add(new Todo("Nauczyc się do egzaminu aplikacji webowych",new Date(2024,6,14)));
        todos.add(new Todo("przygotować gazetkę",new Date(2023,10,20)));
        listViewTodos = findViewById(R.id.listViewTodo);
        ArrayAdapter<Todo> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,todos);
        listViewTodos.setAdapter(adapter);
        button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                TodoActivity.this,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                    }
                                },
                                2023,10,5
                        );
                        datePickerDialog.show();
                    }
                }
        );
    }
}