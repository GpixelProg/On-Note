package gpixel.prog.note.data.database

import gpixel.prog.note.data.db_model.CheckItemModel
import gpixel.prog.note.data.db_model.NoteModel
import gpixel.prog.note.features.toEpochMilliseconds
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.datetime.LocalDate
import org.mongodb.kbson.ObjectId

object NoteDB {
    private val config = RealmConfiguration.create(schema = setOf(NoteModel::class))
    private val realm: Realm = Realm.open(config)

    fun getNotes(userId: ObjectId) : List<NoteModel> {
        val noteModel: RealmResults<NoteModel> = realm.query<NoteModel>(
            "userId == $userId"
        ).find()

        return noteModel
    }

    fun addNote(
        userId: ObjectId,
        title: String,
        note: String,
        date: LocalDate,
    ) : RealmResults<NoteModel> { // return NoteObject
        val noteId = ObjectId()
        realm.writeBlocking {
            val noteObject = copyToRealm(NoteModel().apply {
                this._id = noteId
                this.userId = userId
                this.title = title
                this.note = note
                this.dateInstant = date.toEpochMilliseconds()
            })

            return@writeBlocking noteObject
        }

        return realm.query<NoteModel>(
            "_id == $noteId"
        ).find()
    }

    fun addCheckItem(noteObject: NoteModel, CheckItem: CheckItemModel) {
        realm.writeBlocking {
            val note = findLatest(noteObject)
            val set = note?.checklist
            set?.add(CheckItem)
        }
    }

    fun deleteCheckItem(noteObject: NoteModel, checkItem: CheckItemModel) {
        realm.writeBlocking {
            val note = findLatest(noteObject)
            val set = note?.checklist
            set?.remove(checkItem)
        }
    }

    fun deleteNote(
        noteObject: NoteModel,
    ) {
        realm.writeBlocking {
            delete(noteObject)
        }
    }
}