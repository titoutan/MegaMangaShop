
package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import montaine.guillaume.Boutique
import montaine.guillaume.Commande
import montaine.guillaume.LigneCommande
import montaine.guillaume.TicketDeCaisse

class MontaineGuillaumeTest: BehaviorSpec({

    context("je veux vérifier les reductions par état et selon les montants") {
        given("boutique en France") {
            val boutique = Boutique("France")
            When("Test 1") {
                val ligneCommande = LigneCommande()
                ligneCommande.quantite = 19
                ligneCommande.prix = 3.99
                val commande = Commande(boutique = boutique)
                commande.ajouterLigne(ligneCommande)
                val ticketDeCaisse = TicketDeCaisse()
                ticketDeCaisse.calculer(commande)
                Then("Le prix est juste") {
                    ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 90.98
                }
            }
            When("Test 2") {
                val ligneCommande1 = LigneCommande()
                ligneCommande1.quantite = 42
                ligneCommande1.prix = 3.92
                val ligneCommande2 = LigneCommande()
                ligneCommande2.quantite = 82
                ligneCommande2.prix = 4.10
                val commande = Commande(boutique = boutique)
                commande.ajouterLigne(ligneCommande1)
                commande.ajouterLigne(ligneCommande2)
                val ticketDeCaisse = TicketDeCaisse()
                ticketDeCaisse.calculer(commande)
                Then("Le prix est juste") {
                    ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 601.01
                }
            }
            When("Test 4") {
                val ligneCommande1 = LigneCommande()
                ligneCommande1.quantite = 42
                ligneCommande1.prix = 3.92
                val ligneCommande2 = LigneCommande()
                ligneCommande2.quantite = 82
                ligneCommande2.prix = 4.10
                val ligneCommande3 = LigneCommande()
                ligneCommande3.quantite = 12
                ligneCommande3.prix = 18.95
                val commande= Commande(boutique = boutique)
                commande.ajouterLigne(ligneCommande1)
                commande.ajouterLigne(ligneCommande2)
                commande.ajouterLigne(ligneCommande3)
                val ticketDeCaisse= TicketDeCaisse()
                ticketDeCaisse.calculer(commande)
                Then("Le prix est juste"){
                    ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 873.89
                }
            }
        }
    given("boutique en Espagne") {
        val boutique = Boutique("Espagne")
        When("Test 3") {
            val ligneCommande = LigneCommande()
            ligneCommande.quantite = 19
            ligneCommande.prix = 3.99
            val commande= Commande(boutique = boutique)
            commande.ajouterLigne(ligneCommande)
            val ticketDeCaisse= TicketDeCaisse()
            ticketDeCaisse.calculer(commande)
            Then("Le prix est juste"){
                ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 89.61
            }
        }
    }
    }})