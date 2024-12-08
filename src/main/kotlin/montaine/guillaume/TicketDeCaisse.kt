
package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    val TotalTtc: Double = 0.0
    val Taxe: Double = 0.0
    val Remise: Double = 0.0
}