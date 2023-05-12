package gpixel.prog.note.data.db_model

import io.realm.kotlin.types.RealmObject

class CheckItem : RealmObject {
    var text: String = ""
    var checked: Boolean = false
}