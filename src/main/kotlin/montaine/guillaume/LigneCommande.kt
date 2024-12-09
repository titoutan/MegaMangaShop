package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class LigneCommande(val Id: String = ULID().nextULID() ) {

    var quantite: Int = 0
    var prix: Double = 0.0

    fun chiffreApresVirgule(value: Double): Boolean {
        val formatted = "%.2f".format(value)
        return formatted.toDouble() == value
    }
}