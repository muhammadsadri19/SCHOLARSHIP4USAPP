package org.muhammadsadri.scholarship4us.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.muhammadsadri.scholarship4us.R
import org.muhammadsadri.scholarship4us.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}