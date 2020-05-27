package com.agro.agromall.views;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import com.agro.agromall.R;
import com.agro.agromall.SQLiteHandler;
import com.agro.agromall.databinding.ActivityRegisterFarmer2Binding;
import com.agro.agromall.viewmodels.VMRegisterFarmer2;
import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class RegisterFarmer2 extends Activity {
    ImageView imageView;
    ImageButton imageButton;
    Button submit;

    SQLiteHandler db;

    final int GALLERY_REQUEST = 24;
    final int CAMERA_REQUEST = 25;
    final int PIC_CROP = 4;
    CameraPhoto cameraphoto;
    GalleryPhoto galleryphoto;
    Uri picUri;
    private String path1, uid;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_farmer2);
        imageButton = (ImageButton) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.dp);
        submit = (Button) findViewById(R.id.submit);
        db = new SQLiteHandler(getApplicationContext());

        cameraphoto = new CameraPhoto(getApplicationContext());
        galleryphoto = new GalleryPhoto(getApplicationContext());
        Intent intent = getIntent();
        uid = intent.toString();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage_or_video();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!path1.isEmpty() && !uid.isEmpty()){
                    db.UpdateFarmer2(path1,uid, new Date().toString());
                    Context context = view.getContext();
                    Intent intent = new Intent(context, RegisterFarmer3.class);
                    intent.putExtra("uid", uid);
                    context.startActivity(intent);
                }
            }
        });
    }

    private void pickImage_or_video() {
        //uploads the image or video to server
        final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterFarmer2.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                //boolean result=Utility.checkPermission(AddEvent.this);
                if (items[item].equals("Take Photo")) {
                    cameraInt();
                } else if (items[item].equals("Choose from Gallery")) {
                    galleryInt();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    //starting camera intent
    private void cameraInt() {
        try {
            startActivityForResult(cameraphoto.takePhotoIntent(), CAMERA_REQUEST);
            cameraphoto.addToGallery();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    //opening the gallery
    private void galleryInt() {
        //startActivityForResult(galleryphoto.openGalleryIntent(), GALLERY_REQUEST);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            path1 = null;
            if (requestCode == CAMERA_REQUEST) {
                picUri = data.getData();
                path1 = cameraphoto.getPhotoPath();
                Toast.makeText(getApplicationContext(), path1, Toast.LENGTH_SHORT).show();
                //performImageCrop();
                try {
                    // performImageCrop();
                    Bitmap bitmap = ImageLoader.init().from(path1).requestSize(512, 512).getBitmap();
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == PIC_CROP) {
                //get the returned data
                Bundle extras = data.getExtras();
                //get the cropped bitmap
                Bitmap thePic = extras.getParcelable("data");
                //display the returned cropped image
                imageView.setImageBitmap(thePic);
            } else if (requestCode == GALLERY_REQUEST) {
                picUri = data.getData();
                // galleryphoto.setPhotoUri(picUri);
                //performImageCrop();
                //path1 = galleryphoto.getPath();

                try {
                    //Bitmap bitmap = ImageLoader.init().from(path1).requestSize(512, 512).getBitmap();
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), picUri);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
