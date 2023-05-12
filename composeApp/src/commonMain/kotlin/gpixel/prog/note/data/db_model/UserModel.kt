package gpixel.prog.note.data.db_model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class UserModel() : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var email: String = ""
    var pwd: String = ""
}