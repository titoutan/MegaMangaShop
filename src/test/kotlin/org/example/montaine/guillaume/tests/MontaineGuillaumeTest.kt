
package org.example.montaine.guillaume.tests

import de.huxhorn.sulky.ulid.ULID
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
                    ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 558.94
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
                    ticketDeCaisse.arrondirLePrix(ticketDeCaisse.totalTtc) shouldBe 812.72
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
        given("En France") {
            `when`("Une boutique commande < 150e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1

                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc) shouldBe 1.2
                }
            }

            `when`("Une boutique commande entre 150e et 200e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 175
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 205.8
                }
            }

            `when`("Une boutique commande entre 200e et 300e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 250
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 291
                }
            }

            `when`("Une boutique commande entre 300e et 500e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 400
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 456
                }
            }

            `when`("Une boutique commande entre 500e et 1000e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 600
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 669.6
                }
            }

            `when`("Une boutique commande plus de 1000e de livres") {
                val boutique  = Boutique("France")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1500
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 1620
                }
            }
        }

        given("En Espagne") {

            `when`("Une boutique commande plus de 1000e de livres") {
                val boutique  = Boutique("Espagne")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1500
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 1595.7
                }
            }
        }

        given("En Allemagne") {

            `when`("Une boutique commande plus de 1000e de livres") {
                val boutique  = Boutique("Allemagne")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1500
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 1560.6
                }
            }
        }

        given("Au Royaume-Uni") {

            `when`("Une boutique commande plus de 1000e de livres") {
                val boutique  = Boutique("RU")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1500
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 1657.8
                }
            }
        }

        given("En Belgique") {

            `when`("Une boutique commande plus de 1000e de livres") {
                val boutique  = Boutique("Belgique")
                val commande  = Commande(ULID().nextULID(),boutique);

                val lc1  = LigneCommande()
                lc1.prix = 1.0
                lc1.quantite = 1500
                commande.ajouterLigne(lc1)

                val ticket = TicketDeCaisse(ULID().nextULID())
                ticket.calculer(commande)
                Then("Le prix est juste"){
                    ticket.arrondirLePrix(ticket.totalTtc)  shouldBe 1579.5
                }
            }
        }
    }})