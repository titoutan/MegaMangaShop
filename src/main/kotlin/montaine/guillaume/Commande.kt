package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class LigneCommande(val Id: String = ULID().nextULID() ) {

    val Ligne: List<LigneCommande> = ArrayList<>()

}