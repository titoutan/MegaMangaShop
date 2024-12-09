
package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import montaine.guillaume.Commande
import montaine.guillaume.LigneCommande
class MontaineGuillaumeTest: BehaviorSpec({

    context("je veux vérifier les reductions par état et selon les montants") {
        given("<150 mangas") {
            val ligneCommande = LigneCommande()
            ligneCommande.setQuantite(100)
            ligneCommande.setPrix(5.0)
            val commande= Commande()
            commande.ajouterLigne(ligneCommande)
            val tiquetDeCaisse= TiquetDeCaisse()
            tiquetDeCaisse.calculer(commande)
            tiquetDeCaisse.getPrix() shouldBe 500
        }
    }})