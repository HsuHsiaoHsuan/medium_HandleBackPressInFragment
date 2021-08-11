package idv.hsu.handlebackpressinfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import idv.hsu.handlebackpressinfragment.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment(R.layout.fragment_web_view), FragmentWithBackPress {

    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.webview) {
            loadUrl("https://duckduckgo.com/")
        }
    }

    // pass TRUE if you handle this back press, or return FALSE
    override fun onFragmentBackPressed(): Boolean {
        with(binding.webview) {
            return if (canGoBack()) {
                goBack()
                true
            } else {
                false
            }
        }
    }

    companion object {
        fun newInstance() = WebViewFragment()
    }
}