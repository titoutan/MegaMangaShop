package montaine.guillaume

data class Boutique(val Pays: String) {

    fun setPays(pays:String){
        Pays=pays
    }
    fun getPays(){
        return Pays
    }

}

