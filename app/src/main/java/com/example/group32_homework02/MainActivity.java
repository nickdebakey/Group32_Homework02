package com.example.group32_homework02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.Toast;

import java.sql.RowId;

public class MainActivity extends AppCompatActivity {

    String[] toppings;
    Button button_addTopping;
    Button button_clearPizza;
    ProgressBar progressBar;
    TableRow row1;
    TableRow row2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        button_addTopping = findViewById(R.id.button_addTopping);
        button_clearPizza = findViewById(R.id.button_clearPizza);
        progressBar = findViewById(R.id.progressBar);
        row1 = findViewById(R.id.row1);
        row2 = findViewById(R.id.row2);

        button_addTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set progress bar max value
                progressBar.setMax(10);

                // create list of items and adapter
                toppings = new String[] {"Bacon", "Cheese", "Garlic", "Green Pepper", "Mushroom", "Olives", "Onions", "Red Pepper"};
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, toppings);

                // create the alert dialog
                AlertDialog.Builder toppingsBuilder = new AlertDialog.Builder(MainActivity.this);

                // instantiate the images outside of method so they can be called on later
                final ImageView bacon = new ImageView(MainActivity.this);
                bacon.setImageResource(R.drawable.bacon);
                final ImageView cheese = new ImageView(MainActivity.this);
                cheese.setImageResource(R.drawable.cheese);
                final ImageView garlic = new ImageView(MainActivity.this);
                garlic.setImageResource(R.drawable.garlic);
                final ImageView greenPepper = new ImageView(MainActivity.this);
                greenPepper.setImageResource(R.drawable.green_pepper);
                final ImageView mushroom = new ImageView(MainActivity.this);
                mushroom.setImageResource(R.drawable.mashroom);
                final ImageView olives = new ImageView(MainActivity.this);
                olives.setImageResource(R.drawable.olive);
                final ImageView onions = new ImageView(MainActivity.this);
                onions.setImageResource(R.drawable.onion);
                final ImageView redPepper = new ImageView(MainActivity.this);
                redPepper.setImageResource(R.drawable.red_pepper);

                // set title of Alert Dialog
                toppingsBuilder.setTitle("Choose A Topping");

                // add the items to the list
                toppingsBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            // if statement for if row 1 is still empty
                            if (row1.getChildAt(4) == null) {
                                switch (i) {
                                    case 0:
                                        row1.addView(bacon);
                                        break;
                                    case 1:
                                        row1.addView(cheese);
                                        break;
                                    case 2:
                                        row1.addView(garlic);
                                        break;
                                    case 3:
                                        row1.addView(greenPepper);
                                        break;
                                    case 4:
                                        row1.addView(mushroom);
                                        break;
                                    case 5:
                                        row1.addView(olives);
                                        break;
                                    case 6:
                                        row1.addView(onions);
                                        break;
                                    case 7:
                                        row1.addView(redPepper);
                                        break;
                                }
                                progressBar.setProgress(row1.getChildCount());
                                dialogInterface.dismiss();
                            } else if (row2.getChildAt(4) == null) {
                                switch (i) {
                                    case 0:
                                        row2.addView(bacon);
                                        break;
                                    case 1:
                                        row2.addView(cheese);
                                        break;
                                    case 2:
                                        row2.addView(garlic);
                                        break;
                                    case 3:
                                        row2.addView(greenPepper);
                                        break;
                                    case 4:
                                        row2.addView(mushroom);
                                        break;
                                    case 5:
                                        row2.addView(olives);
                                        break;
                                    case 6:
                                        row2.addView(onions);
                                        break;
                                    case 7:
                                        row2.addView(redPepper);
                                        break;
                                }
                                progressBar.setProgress(row1.getChildCount() + row2.getChildCount());
                                dialogInterface.dismiss();
                            } else {
                                Toast toast = Toast.makeText(MainActivity.this,
                                        "Maximum Topping Capacity Reached!",
                                        Toast.LENGTH_SHORT);
                                toast.show();
                            }
                    }
                });
                // can click out of it
                toppingsBuilder.setCancelable(true);
                // show Alert Dialog
                AlertDialog toppingsDialog = toppingsBuilder.create();
                toppingsDialog.show();
            }
        });

        button_clearPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row1.removeAllViews();
                row2.removeAllViews();
                progressBar.setProgress(0);
            }
        });
    }
}
