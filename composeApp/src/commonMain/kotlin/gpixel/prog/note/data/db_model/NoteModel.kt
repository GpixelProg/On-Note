package gpixel.prog.note.data.db_model

import io.realm.kotlin.ext.realmSetOf
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmSet
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteModel: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var userId: ObjectId = ObjectId()
    var note: String = ""
    var checklist: RealmSet<CheckItemModel> = realmSetOf()
    var dateInstant: Long = 0
}