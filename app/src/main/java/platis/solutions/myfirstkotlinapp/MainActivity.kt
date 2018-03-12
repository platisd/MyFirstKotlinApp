package platis.solutions.myfirstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class MainActivity : AppCompatActivity() {

    var ipField: TextView? = null
    internal val SERVER_IP = "https://api.ipify.org"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.ip_button)
        // It would also work like this:
        // var button : Button = findViewById(R.id.ip_button)

        ipField = findViewById(R.id.ip_field)
        button.setOnClickListener {
            //an extension over string (support GET, PUT, POST, DELETE with httpGet(), httpPut(), httpPost(), httpDelete())
            SERVER_IP.httpGet().responseString { request, response, result ->
                //do something with response
                when (result) {
                    is Result.Failure -> {
                        ipField?.text = "Error"
                    }
                    is Result.Success -> {
                        ipField?.setText(result.value)
                    }
                }
            }
        }
    }
}
