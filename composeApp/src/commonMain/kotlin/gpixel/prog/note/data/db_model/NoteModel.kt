package gpixel.prog.note.data.db_model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteModel: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var userId: ObjectId = ObjectId()
    var note: String = ""
    var checklist: List<CheckItem> = listOf()
    var dateInstant: Long = 0
}