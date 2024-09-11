package org.hyperskill.aquarium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import org.hyperskill.aquarium.databinding.FragmentMainBinding
import org.hyperskill.aquarium.models.Models
import org.hyperskill.aquarium.models.descriptions
import org.hyperskill.aquarium.models.images
import org.hyperskill.aquarium.models.names

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.tabLayout
        val intent = (view.context as FragmentActivity).intent
        val models = Models(
            names = intent.extras?.getSerializable("nameAnimals") as? List<String>
                ?: names,
            description = intent.extras?.getSerializable("descriptionAnimals") as? List<String>
                ?: descriptions,
            images = intent.extras?.getSerializable("imageAnimals") as? List<String>
                ?: images
        )
        val viewPager2 = binding.viewpager2
        val pagerAdapter = PagerAdapter(models)
        viewPager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = models.names[position]
        }.attach()


    }
}