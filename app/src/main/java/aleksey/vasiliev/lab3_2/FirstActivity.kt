package aleksey.vasiliev.lab3_2

import aleksey.vasiliev.lab3_2.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_2.ui.theme.Lab3_2Theme
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    Lab3_2Theme {
                        Scaffold(
                            topBar = { TopAppBar(title = { Text("First") }) },
                            bottomBar = { BottomNavigationBar(this@FirstActivity) },
                            content = { Layout() })
                    }
                }
                id = R.id.activity_first
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
                startActivity(
                    Intent(
                        this@FirstActivity,
                        SecondActivity::class.java
                    )
                )
            }) {
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

    override fun onBackPressed() {
        finish()
    }
}

