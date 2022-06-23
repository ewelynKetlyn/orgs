package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import androidx.appcompat.app.AlertDialog


class FormularioImagemDialog(private val context: Context) {
    fun mostra(
        urlPadrao: String? = null,
        quandoImagemCarregada: (imagem: String) -> Unit
    ){
        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {

                urlPadrao?.let {
                    formularioImagemImageView.tentaCarregarImagem(it)
                    formularioImagemUrl.setText(it)
                }
                formularioImagemBotaoCarregar.setOnClickListener {
                    val url = formularioImagemUrl.text.toString()
                    formularioImagemImageView.tentaCarregarImagem(url)
                }
                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar"){ _, _ ->
                        val url = formularioImagemUrl.text.toString()
                        Log.i("FormularioImagemDialog", "mostra: $url")
                        quandoImagemCarregada(url)
                    }
                    .setNegativeButton("Cancelar"){ _, _->

                    }
                    .show()
            }

    }
}
