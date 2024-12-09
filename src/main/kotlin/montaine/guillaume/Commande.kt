package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class Commande(val Id: String = ULID().nextULID(),val boutique:Boutique ) {

    var lignes: List<LigneCommande> = ArrayList()
    fun ajouterLigne(ligneCommande: LigneCommande) {
        lignes += ligneCommande
    }
    fun setBoutique(laBoutique:Boutique){
        boutique=laBoutique
    }
    fun getBoutique(){
        return boutique
    }
}