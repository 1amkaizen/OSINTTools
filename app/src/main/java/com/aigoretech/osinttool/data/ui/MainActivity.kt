package com.example.osinttool.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.osinttool.R
import com.example.osinttool.data.api.GitHubApi
import com.example.osinttool.data.api.HaveIBeenPwnedApi
import com.example.osinttool.data.api.ShodanApi

class MainActivity : AppCompatActivity() {
    private val githubApi: GitHubApi = GitHubApi.create()
    private val shodanApi: ShodanApi = ShodanApi.create()
    private val haveIBeenPwnedApi: HaveIBeenPwnedApi = HaveIBeenPwnedApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup initial UI and listeners for search functionality
    }
}
