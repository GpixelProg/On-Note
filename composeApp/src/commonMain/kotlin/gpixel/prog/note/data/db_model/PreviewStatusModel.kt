package gpixel.prog.note.data.db_model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PreviewStatusModel(): RealmObject {
    @PrimaryKey
    var id: String = "isPreview"
    var isPreview: Boolean = false
}