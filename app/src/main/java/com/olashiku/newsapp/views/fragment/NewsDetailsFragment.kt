package com.olashiku.newsapp.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.olashiku.newsapp.R
import com.olashiku.newsapp.databinding.FragmentNewsDetailsBinding
import com.olashiku.newsapp.model.news_response.Article
import com.olashiku.newsapp.utils.loadImage
import com.olashiku.newsapp.utils.openBrowser
import com.olashiku.newsapp.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class NewsDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    private val viewModel: NewsViewModel by activityViewModel()
    lateinit var article :Article


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolsBar()
        loadDetails()
        setupClickListener()
        showBottomNavigationView(false)
    }

     private fun setupToolsBar(){
         (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
         (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
         binding.toolbar.setNavigationOnClickListener {
             requireActivity().onBackPressed()
         }
         binding.toolbar.navigationIcon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
     }

    private fun loadDetails(){
        article = viewModel.selectedArticle
        binding.authorTextView.text = article.author
        binding.headerImageView.loadImage(article.urlToImage?:"")
        binding.titleDetailsTextView.text = article.title
        binding.descriptionTextView.text = article.description
        binding.contentTextView.text = article.content
    }

     private fun setupClickListener(){
         binding.readMoreButton.setOnClickListener {
            requireContext().openBrowser(article.url)
         }
     }

}