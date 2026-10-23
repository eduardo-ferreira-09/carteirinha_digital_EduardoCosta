package com.rafaelcosta.carteirinhadigital2devest_b.app

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val carteirinhaApplication = application as CarteirinhaApplication
        setContent {
            App(
                container = carteirinhaApplication.container
            )
        }
    }
}