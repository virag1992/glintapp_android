package app.glintcarwash.com.glintapp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ChatBubbleActivity extends Activity implements OnClickListener {
	private static final String TAG = "ChatActivity";

	private ChatArrayAdapter chatArrayAdapter;
	private ListView listView;
	private EditText chatText;
	private Button buttonSend;
//	ByteArrayOutputStream bytes;
//	private static final int PICK_FROM_CAMERA = 1;
//	private static final int CROP_FROM_CAMERA = 2;
//	private static final int PICK_FROM_FILE = 3;
//	protected static final int GALLERY_KITKAT_INTENT_CALLED = 0;
//	private static final int GET_VIDEO_FROM_GALLARY = 4;
//	Bitmap photo;
//	String filepath;
//	Intent intent;
	List<ChatMessage> c_obj = new ArrayList<ChatMessage>();
//	private Uri mImageCaptureUri;
	private boolean side = false;
//	boolean noImg = false;
//	boolean img = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		setContentView(R.layout.activity_chat);

		buttonSend = (Button) findViewById(R.id.buttonSend);
		listView = (ListView) findViewById(R.id.listView1);

		chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(),
				R.layout.activity_chat_singlemessage);
		listView.setAdapter(chatArrayAdapter);

		chatText = (EditText) findViewById(R.id.chatText);
		chatText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
					return sendChatMessage();
				}
				return false;
			}
		});
		buttonSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				sendChatMessage();
			}
		});

		listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listView.setAdapter(chatArrayAdapter);

		// to scroll the list view to bottom on data change
		chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
			@Override
			public void onChanged() {
				super.onChanged();
				listView.setSelection(chatArrayAdapter.getCount() - 1);
			}
		});

	}

	private boolean sendChatMessage() {
		chatArrayAdapter.add(new ChatMessage(side, chatText.getText()
				.toString()));
		chatText.setText("");
		side = !side;
		return true;
	}

	@Override
	public void onClick(View v) {
//		if (v == buttonImage) {
//			showDialogForImage();
//
//		}
	}



}