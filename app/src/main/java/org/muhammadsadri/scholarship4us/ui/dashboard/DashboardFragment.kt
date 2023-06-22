package org.muhammadsadri.scholarship4us.ui.dashboard

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.muhammadsadri.scholarship4us.R
import org.muhammadsadri.scholarship4us.adapter.PostBerandaAdapter
import org.muhammadsadri.scholarship4us.databinding.FragmentDashboardBinding
import org.muhammadsadri.scholarship4us.network.ApiStatus

class DashboardFragment : Fragment() {

    private lateinit var postBerandaAdapter: PostBerandaAdapter
    private var _binding: FragmentDashboardBinding? = null
    private val dashboardViewModel : DashboardViewModel by lazy {
        ViewModelProvider(this)[DashboardViewModel::class.java]
    }
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Pemanggilan gambar menu
        binding.imgFasilitas.setImageResource(R.drawable.company)
        binding.imgKampus.setImageResource(R.drawable.graduate)
        binding.imgManager.setImageResource(R.drawable.donation)
        binding.imgMember.setImageResource(R.drawable.team)
        binding.imgProgram.setImageResource(R.drawable.schedule)
        binding.imgTestimoni.setImageResource(R.drawable.customerreview)
        binding.imgToelf.setImageResource(R.drawable.bags)
        binding.imgVolunteer.setImageResource(R.drawable.testing)

        postBerandaAdapter = PostBerandaAdapter()
        binding.rvPostingan.adapter = postBerandaAdapter
        val recyclerView: RecyclerView = binding.rvPostingan
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(), RecyclerView.HORIZONTAL
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardViewModel.getData().observe(viewLifecycleOwner) {
            postBerandaAdapter.updateData(it)
        }
    }

}