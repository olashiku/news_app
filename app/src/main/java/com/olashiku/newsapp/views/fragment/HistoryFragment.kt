package com.olashiku.newsapp.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.olashiku.newsapp.R
import com.olashiku.newsapp.databinding.FragmentHistoryBinding
import com.olashiku.newsapp.model.news_response.Article
import com.olashiku.newsapp.model.news_response.toArticle
import com.olashiku.newsapp.viewmodel.NewsViewModel
import com.olashiku.newsapp.views.adapter.DashboardAdapter
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class HistoryFragment : BaseFragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: NewsViewModel by activityViewModel()
     var article: List<Article> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBottomNavigationView(true)
        setupView()
        setupSearch()
    }

    fun setupSearch() {
        binding.searchInputTextView.doAfterTextChanged { searchTerm ->
            val filteredSearch = article.filter {
                it.title.lowercase()
                    .contains(searchTerm.toString().lowercase()) || it.content!!.lowercase()
                    .contains(searchTerm.toString().lowercase()) || it.description.lowercase()
                    .contains(searchTerm.toString().lowercase())
            }
            setupRecycler(filteredSearch)
        }
    }

    private fun setupView() {
        viewModel.getArticles().observe(viewLifecycleOwner) {
            article = it.map { it.toArticle() }
            setupRecycler(article)
        }
    }

    private fun setupRecycler(articles: List<Article>) {
        val newArticles = articles.drop(1).filter { it.content != null }.filter {
            !it.content!!.contains(
                getString(
                    R.string.removed
                )
            )
        }
        val adapter = DashboardAdapter(newArticles, requireContext()) { article ->
            viewModel.selectedArticle = article
            findNavController().navigate(R.id.action_historyFragment_to_newsDetailsFragment)

        }
        binding.historyRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecycler.adapter = adapter
    }

}