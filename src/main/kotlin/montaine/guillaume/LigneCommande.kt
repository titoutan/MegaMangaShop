package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class LigneCommande(val Id: String = ULID().nextULID() ) {

    var quantite: Int = 0
    var prix: Double = 0.0

    fun setQuantite(i: Int) {
        quantite = i;
    }

    fun setPrix(d: Double) {
        prix = d
    }
}