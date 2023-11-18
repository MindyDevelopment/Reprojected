package re.type

import mindustry.type.*

open class Spirit(name: String) : UnitType(name){
    
    /** The max level this spirit can reach. */
    var maxLevel = 1
    /** The upgrade map for this spirit. */
    var upgradeMap = UpgradeMap.emptyArray(maxLevel)
    
    
    fun upgrade(vararg values: Any){
        upgradeMap = UpgradeMap.with(values)
    }
}

open class UpgradeMap(){

    /** Mana added to this user's base mana when reached. */
    var extendedMana = 1f
    /** The XP requirement to reach this upgrade map. */
    var requiredXP = 1f
    /** Extra stuff ran when reaching this upgrade map. */
    var onReach: (Spirit) -> Unit = {}

    constructor(extendedMana: Float, requiredXP: Float, onReach: (Spirit) -> Unit) : this(){
        this.extendedMana =  extendedMana
        this.requiredXP = requiredXP
        this.onReach = onReach
    }
    
    companion object {

        fun with(vararg values: Any): Array<UpgradeMap>{
            if(values.size % 3 == 0) throw ArrayIndexOutOfBoundsException("${values.size} not multiple of 3")

            val arr = arrayOfNulls<UpgradeMap>(values.size / 3)
            var i = 0

            for(b in 0..arr.size-1) {
                arr[b] = UpgradeMap(values[b + i] as Float, values[b + i++] as Float, values[b + i++] as (Spirit) -> Unit)
                i++
            }

            return arr as Array<UpgradeMap>
        }

        fun emptyArray(size: Int): Array<UpgradeMap>{
            val arr = arrayOfNulls<UpgradeMap>(size)

            for(i in 0..arr.size-1) arr[i] = UpgradeMap()

            return arr as Array<UpgradeMap>
        }

    }
}
