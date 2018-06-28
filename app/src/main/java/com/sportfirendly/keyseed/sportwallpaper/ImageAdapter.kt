package com.sportfirendly.keyseed.sportwallpaper

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.support.v4.content.FileProvider
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image.view.*
import java.io.File

/**
 * Created by Denero on 02.06.2018.
 */
class ImageAdapter(var data:Array<String>): RecyclerView.Adapter<ImageAdapter.ImViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImViewHolder  = ImViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.fragment_image,parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ImViewHolder?, position: Int) {

        Picasso.with(holder!!.v.context)
                .load(data[position])
                .fit()
                .into(holder.imgContent)

        holder.btnSet.setOnClickListener {
            var wallPaperManager = WallpaperManager.getInstance(holder.v.context)
            try {
                val bitmap = (holder.imgContent.getDrawable() as BitmapDrawable).bitmap
                wallPaperManager.setBitmap(bitmap)
                Toast.makeText(holder.v.context,"Completed!", Toast.LENGTH_SHORT)
                        .show()
            }catch(e:Exception){
                Toast.makeText(holder.v.context,"Wait loading", Toast.LENGTH_SHORT)
                        .show()
            }
        }

        holder.btnLive.setOnClickListener {
            instalLifeWallpapers(holder.v.context)
        }
    }

    class ImViewHolder(var v: View):RecyclerView.ViewHolder(v){
        var btnSet: Button = v.btn_set
        var imgContent: ImageView = v.fragment_img
        var btnLive: Button = v.btn_install_live_photo
    }

    fun instalLifeWallpapers(c: Context){
        try{
            var fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapersNew"+".apk")
            if(fileLifeWallpaper.exists()){
                var uri: Uri
                if (c.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.N) {
                    uri = FileProvider.getUriForFile(c, c.getPackageName() + ".my.package.name.provider", fileLifeWallpaper)
                    var intent = Intent(Intent.ACTION_INSTALL_PACKAGE)
                    intent.setData(uri)
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    c.startActivity(intent)
                } else {
                    uri = Uri.parse("file://"+fileLifeWallpaper)
                    var intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(uri, "application/vnd.android.package-archive")
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    c.startActivity(intent)
                }
            }else{
                Toast.makeText(c,"Wait,Downloads", Toast.LENGTH_SHORT).show()
            }
        }catch (E:Exception){
            Log.d("EXCEPTION:",E.toString())
            Toast.makeText(c,"Loading", Toast.LENGTH_SHORT).show()
        }


    }
}