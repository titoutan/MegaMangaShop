package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;

import kotlin.math.ceil


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    var totalTtc: Double = 0.0
    var taxe: Double = 0.0
    var remise: Double = 0.0

    fun calculer(commande : Commande) {
        var totalHT : Double = 0.0
        var totalQt : Int = 0

        for(ligne in commande.lignes) {
            totalHT += ligne.quantite * ligne.prix
        }

        for(ligne in commande.lignes) {
            totalQt += ligne.quantite
        }

        if(totalQt in 150..200) {
            this.remise = 0.02
        }

        if(totalQt in 200..300) {
            this.remise = 0.03
        }

        if(totalQt in 300..500) {
            this.remise = 0.05
        }

        if(totalQt in 500..1000) {
            this.remise = 0.07
        }

        if(totalQt>1000) {
            this.remise = 0.1
        }

        this.taxe = commande.boutique.getPays().tva

        this.totalTtc = totalHT * (1-this.remise) * (1 + (this.taxe /100))
    }

    fun arrondirLePrix(prix: Double): Double {
        return ceil(prix * 100) / 100
    }


}