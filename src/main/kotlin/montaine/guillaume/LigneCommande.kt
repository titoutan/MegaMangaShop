package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class LigneCommande(val Id: String = ULID().nextULID() ) {

    var quantite: Int = 0
    var prix: Double = 0.0

    fun setQuantite(i: Int) {
        if (i<1) {
            Log.d("ERROR", "La quantité doit être positive")
        }
        quantite = i;
    }

    fun setPrix(d: Double) {
        if (i<=0) {
            Log.d("ERROR", "Le prix unitaire doit être positif")
        }
        if (chiffreApresVirgule(i)){
            Log.d("ERROR", "Le prix unitaire doit avoir maximum deux chiffres après la virgule")
        }
        prix = d
    }
    fun chiffreApresVirgule(value: Double): Boolean {
        val formatted = "%.2f".format(value)
        return formatted.toDouble() == value
    }
}