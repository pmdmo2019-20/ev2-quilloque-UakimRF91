package es.iessaladillo.pedrojoya.quilloque.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import es.iessaladillo.pedrojoya.quilloque.data.dao.ContactDao
import es.iessaladillo.pedrojoya.quilloque.data.dao.RecentContactDao
import es.iessaladillo.pedrojoya.quilloque.data.dao.RecentDao
import es.iessaladillo.pedrojoya.quilloque.data.entity.Contact
import es.iessaladillo.pedrojoya.quilloque.data.entity.Recent
import kotlin.concurrent.thread

@Database(
    entities = [Contact::class, Recent::class],
    version = 1,
    exportSchema = true
)
abstract class QuilloQueDatabase : RoomDatabase() {

    abstract val contactDao: ContactDao
    abstract val recentDao: RecentDao
    abstract val recentContactDao: RecentContactDao

    companion object {

        @Volatile
        private var INSTANCE: QuilloQueDatabase? = null

        fun getInstance(context: Context): QuilloQueDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            QuilloQueDatabase::class.java,
                            "quillo_que_database"
                        ).addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                thread {
                                    INSTANCE!!.contactDao.insertContact(
                                        Contact(
                                            0,
                                            "Baldo",
                                            "652233233"
                                        )
                                    )

                                    INSTANCE!!.recentDao.insertRecent(
                                        Recent(
                                            0,
                                            "652233233",
                                            "Entrante",
                                            "04/03/2010",
                                            "21:01"
                                        )
                                    )
                                    INSTANCE!!.recentDao.insertRecent(
                                        Recent(
                                            0,
                                            "666666666",
                                            "Entrante",
                                            "04/03/2010",
                                            "19:21"
                                        )
                                    )
                                    INSTANCE!!.recentDao.insertRecent(
                                        Recent(
                                            0,
                                            "677123123",
                                            "Entrante",
                                            "12/02/2020",
                                            "16:17"
                                        )
                                    )
                                    INSTANCE!!.recentDao.insertRecent(
                                        Recent(
                                            0,
                                            "666666666",
                                            "Entrante",
                                            "12/02/2020",
                                            "16:16"
                                        )
                                    )
                                    INSTANCE!!.recentDao.insertRecent(
                                        Recent(
                                            0,
                                            "666666666",
                                            "Entrante",
                                            "12/02/2020",
                                            "15:45"
                                        )
                                    )

                                }
                            }
                        })
                            .build()
                    }
                }
            }
            return INSTANCE!!

        }
    }

}