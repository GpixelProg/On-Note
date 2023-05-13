package gpixel.prog.note.data.db_model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class UserSessionModel : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
}