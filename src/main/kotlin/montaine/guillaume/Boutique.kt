package montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Pays
import java.util.*

data class Boutique(var pays: String) {

    fun getPays(): Pays {
        return Pays.valueOf(this.pays.uppercase(Locale.getDefault()))
    }

}