package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static ca.ualberta.cs.lonelytwitter.R.id.clear;

/**
 * The type Lonely twitter activity.
 * this class is the main view class of the project. <br> In this class user interaction and
 * file manipulation is performed
 * All files here are in the form of "json" files that are stored in the emulators acceibble from
 * android device manager
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> data -> ca.ualberta.cs.lonelyTwitter ->files -> file.sav
 * </pre>
 * <code>
 *     some pretend code <br>
 * end </code>
 * the file name is indiccated by the FILENAME constant
 * @author Chris
 * @version 1.0
 * @see Tweet
 * @since 0.6
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved there. The format is JSON
	 */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdring {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING}
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Calls this method on creation,
	 * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/**
		 * Sets up the clear and save buttons
		 */
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * When the clear button is pressed the data is cleared, and the empty file is saved.
		 * @param v the view being used
		 */
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();

				adapter.notifyDataSetChanged();
				saveInFile();


				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

		/**
		 * When the save button is clicked it gets the messages from the tweets and saves them to
		 * a JSON file
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();
				saveInFile();


				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
	}

	/**
	 * When the program starts it loads the JSON file
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Trims extra spaes using regex
	 * @param inputString string that needs to be cleared of extra spaces
	 * @return resulting string
     */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;

	}

	/**
	 * this method items in the tweet list
	 * Not currently implemented
	 * @param ordering the ordering to be used
	 */
	private void sortTweetListItems(TweetListOrdring ordering){


	}

	/**
	 * Loads tweets from specified file
	 * @Throws TweetToLongException
	 */

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
			//Taken from http://stackoverflow.com/questions/20773850/gson-typetoken-with-dynamic-arraylist-item-type
			// On 02/24/17

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
			//throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Saves tweets to a specified file in JSON format
	 * @throws FileNotFoundException if the file cannot be found
	 *
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
//			fos.write(new String(date.toString() + " | " + text)
//					.getBytes());
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Handle the exception BETTER HAHAHAHAHAH
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO
			throw new RuntimeException();
		}
	}

}