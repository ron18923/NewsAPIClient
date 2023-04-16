package com.example.newsapiclient

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapiclient.databinding.FragmentInfoBinding
import com.example.newsapiclient.presentation.viewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        Log.d("MYTAG", "InfoFragment - ")
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        newsViewModel = (activity as MainActivity).newsViewModel

        binding.wvInfo.apply {
            webViewClient = WebViewClient()
            // TODO - Implement better null check:
            if(article.url != null){
                loadUrl(article.url)
            }
        }

        binding.fabSave.setOnClickListener{
            newsViewModel.saveArticle(article)
            Snackbar.make(view, "Saved Successfully!", Snackbar.LENGTH_LONG).show()
        }
    }
}