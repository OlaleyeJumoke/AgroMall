package com.agro.agromall;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.Bindable;
import androidx.fragment.app.Fragment;

import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class ImagePicker {

    Fragment fragment;


    private final int GALLERY_REQUEST= 24;
    private final int CAMERA_REQUEST= 25;
    private final int PIC_CROP = 4;
    private CameraPhoto cameraphoto;
    GalleryPhoto galleryphoto;
    private Uri picUri;
    Context context;
    private String path1;
    private Bitmap bitmap;

    public void pickImage(View view){

        //uploads the image or video to server
        context = view.getContext();
        final CharSequence[] items = { "Take Photo", "Choose from Gallery",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add Picture")
        .setItems(items, new DialogInterface.OnClickListener() {
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
        }).show();
    }

    //starting camera intent
    private void cameraInt(){
        try{
            fragment.startActivityForResult(cameraphoto.takePhotoIntent(), CAMERA_REQUEST);
            cameraphoto.addToGallery();
        }
        catch(IOException e){
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
    //opening the gallery
    private void galleryInt(){
        //startActivityForResult(galleryPhoto.openGalleryIntent(), GALLERY_REQUEST);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        fragment.startActivityForResult(intent, GALLERY_REQUEST);
        //onActivityResult()
    }

    //@Override
    private void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.
                onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null){
            path1 = null;
            if (requestCode == CAMERA_REQUEST){
                picUri = data.getData();
                path1 = cameraphoto.getPhotoPath();
                //performImageCrop();
                try{
                    // performImageCrop();
                    bitmap = ImageLoader.init().from(path1).requestSize(512, 512).getBitmap();
                    setBitmapImage(bitmap1);
                    //return bitmap;

                }
                catch(FileNotFoundException e){
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
            else if(requestCode == PIC_CROP){
                //get the returned data
                Bundle extras = data.getExtras();
                //get the cropped bitmap
                 bitmap = extras.getParcelable("data");
                //display the returned cropped image
                //dp.setImageBitmap(thePic);
                //return bitmap;
                setBitmapImage(bitmap);
            }
            else if(requestCode == GALLERY_REQUEST){
                picUri = data.getData();
                // galleryphoto.setPhotoUri(picUri);
                //performImageCrop();
                //path1 = galleryphoto.getPath();

                try{
                    //Bitmap bitmap = ImageLoader.init().from(path1).requestSize(512, 512).getBitmap();
                    bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(),picUri);
                    //dp.setImageBitmap(bitmap);
                    setBitmapImage(bitmap);
                    //return bitmap;
                }
                catch(FileNotFoundException e){
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //return bitmap;
    }

    //@Bindable
    private Bitmap bitmap1 = null;

    public Bitmap getBitmapImage() {
        return bitmap1;
    }
    private void setBitmapImage(Bitmap bt) {

        this.bitmap1 = bt;

        //notifyPropertyChanged(BR.toastMessage);
    }

}
