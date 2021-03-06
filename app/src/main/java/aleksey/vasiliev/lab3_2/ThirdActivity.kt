package aleksey.vasiliev.lab3_2

import aleksey.vasiliev.lab3_2.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_2.ui.theme.Lab3_2Theme
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    Lab3_2Theme {
                        Scaffold(
                            topBar = { TopAppBar(title = { Text("Third") }) },
                            bottomBar = { BottomNavigationBar(this@ThirdActivity) },
                            content = { Layout() })
                    }
                }
                id = R.id.activity_third
            }
        )
    }

    @Composable
    fun Layout() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
                this@ThirdActivity.setResult(1, intent)
                finish()
            }) {
                Text("First")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { finish() }) {
                Text("Second")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Lab3_2Theme {
            BottomNavigationBar(this)
        }
    }
}

