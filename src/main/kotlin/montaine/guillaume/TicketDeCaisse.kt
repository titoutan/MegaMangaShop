package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;

import kotlin.math.ceil


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    var totalTtc: Double = 0.0
    var taxe: Double = 0.0
    var remise: Double = 0.0

    fun calculer(commande : Commande) {
        var totalHT : Double = 0.0

        for(ligne in commande.lignes) {
            totalHT += ligne.quantite * ligne.prix
        }

        if(totalHT in 150.0..200.0) {
            this.remise = 0.02
        }

        if(totalHT in 200.0..300.0) {
            this.remise = 0.03
        }

        if(totalHT in 300.0..500.0) {
            this.remise = 0.05
        }

        if(totalHT in 500.0..1000.0) {
            this.remise = 0.07
        }

        if(totalHT>1000.0) {
            this.remise = 0.1
        }

        this.taxe = commande.boutique.getPays().tva

        this.totalTtc = totalHT * (1-this.remise) * (1 + (this.taxe /100))
    }

    fun arrondirLePrix(prix: Double): Double {
        return ceil(prix * 100) / 100
    }


}