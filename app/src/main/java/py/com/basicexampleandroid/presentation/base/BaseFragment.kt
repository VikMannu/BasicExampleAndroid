package py.com.basicexampleandroid.presentation.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import py.com.basicexampleandroid.data.helper.APIError

open class BaseFragment: Fragment() {

    lateinit var baseBinding: ViewBinding
    lateinit var baseViewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewEvents()
    }

    private fun observeViewEvents() {
        baseViewModel.isLoading.observe(viewLifecycleOwner) {
            handleLoading(it)
        }

        baseViewModel.error.observe(viewLifecycleOwner) {
            showError(it)
        }
    }

    private fun handleLoading(isLoading: Boolean) {

    }

    private fun showError(error: APIError) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage(error.message)

        // Botón positivo
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.dismiss() // Cierra el diálogo
        }

        // Botón negativo (opcional)
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }

        // Crear y mostrar el diálogo
        val dialog = builder.create()
        dialog.show()
    }
}