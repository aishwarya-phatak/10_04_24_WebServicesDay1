package com.bitcode.a10_04_24_webservicesday1

import android.util.Log
import java.net.URL

class WebThread : Thread() {
    override fun run() {
        super.run()

        var url = URL("https://jsonplaceholder.typicode.com/posts")           //string to URL Format conversion
        var httpURLConnection = url.openConnection()
        httpURLConnection.connect()

        Log.e("tag", "${httpURLConnection.contentEncoding}")
        Log.e("tag","${httpURLConnection.contentType}")
        Log.e("tag","${httpURLConnection.contentLength}")

        val inStream = httpURLConnection.getInputStream()
        val responseBuffer = StringBuffer()
        val data = ByteArray(1024 * 1)
        var count = 0

        count = inStream.read(data)
        while (count != -1){
            responseBuffer.append(String(data,0,count))
            count = inStream.read(data)
        }
        inStream.close()

        Log.e("tag",responseBuffer.toString())
    }
}