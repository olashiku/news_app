package com.olashiku.newsapp.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.olashiku.newsapp.R
import com.olashiku.newsapp.databinding.FragmentHomeBinding
import com.olashiku.newsapp.model.news_response.Article
import com.olashiku.newsapp.utils.loadImage
import com.olashiku.newsapp.viewmodel.NewsViewModel
import com.olashiku.newsapp.views.adapter.DashboardAdapter
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class HomeFragment : BaseFragment() {

    private lateinit var binding:FragmentHomeBinding
    private val viewModel: NewsViewModel by activityViewModel()
    var articles: List<Article> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBottomNavigationView(true)
        viewModel.getCurrentNews()
        setupObserver()
    }

     private fun setupObserver(){
         viewModel.newsResponse.observe(viewLifecycleOwner){
             setupView(it?.articles?.first()?:Article())
             setupAdapter(it?.articles?: emptyList())
         }
     }

    private fun setupView(article:Article){
        binding.titleTextView.text = article.title
        binding.authorTextView.text = article.author
        binding.headerImageView.loadImage(article.urlToImage?:"")
    }

     private fun setupAdapter(articles:List<Article>){
         val newArticles = articles.drop(1).filter {  it.content!= null  }.filter { !it.content!!.contains(getString(R.string.removed)) }
         this.articles = newArticles
         val adapter = DashboardAdapter(newArticles,requireContext()) { article ->
             viewModel.saveArticle(article)
             findNavController().navigate(R.id.action_homeFragment_to_newsDetailsFragment)

         }
         binding.homeRecycler.layoutManager = LinearLayoutManager(requireContext())
         binding.homeRecycler.adapter = adapter
     }



}