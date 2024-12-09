package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class LigneCommande(val Id: String = ULID().nextULID() ) {

    val Quantite: Double = 0.0
    val Prix: Double = 0.0
}