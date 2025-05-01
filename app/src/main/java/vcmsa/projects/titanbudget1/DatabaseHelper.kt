package vcmsa.projects.titanbudget1

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "TitanBudgetDB.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_ICON = "ICON"
        private const val TABLE_CATEGORY = "Category"
        private const val COLUMN_ICONID = "IconID"
        private const val COLUMN_ICONNAME = "IconName"
        private const val COLUMN_ICONURL = "IconUrl"
        private const val COLUMN_CATEGORYID = "CategoryID"
        private const val COLUMN_CATEGORYNAME = "CategoryName"
        private const val COLUMN_CATEGORYTYPE = "CategoryType"
        private const val COLUMN_ICONIDFK = "IconID"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLEICON = "CREATE TABLE $TABLE_ICON (" +
                "$COLUMN_ICONID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ICONNAME TEXT, " +
                "$COLUMN_ICONURL TEXT)"
        db.execSQL(CREATE_TABLEICON)

        val CREATE_TABLECATEGORY = "CREATE TABLE $TABLE_CATEGORY (" +
                "$COLUMN_CATEGORYID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_CATEGORYNAME TEXT, " +
                "$COLUMN_CATEGORYTYPE TEXT," +
                "$COLUMN_ICONIDFK INTEGER, " +
                "FOREIGN KEY($COLUMN_ICONIDFK) REFERENCES $TABLE_ICON($COLUMN_ICONID))"
        db.execSQL(CREATE_TABLECATEGORY)

        val icons = listOf(
            "Exercise" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/running.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL3J1bm5pbmcucG5nIiwiaWF0IjoxNzQ1NTIwMDc0LCJleHAiOjE3NzcwNTYwNzR9.p6fcr_uqXG1AjQLb06O30VvWtG1BSATAxpRpXDvgpLk",
            "Bitcoin" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/bitcoin.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2JpdGNvaW4ucG5nIiwiaWF0IjoxNzQ1NTIxMjQ4LCJleHAiOjE3NzcwNTcyNDh9.TLxbR2e6HITiYwtTT9VFR4oiupTghpmTjywIySw7oH8",
            "Vacation" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/beach-chair.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2JlYWNoLWNoYWlyLnBuZyIsImlhdCI6MTc0NTUyMDQzMCwiZXhwIjoxNzc3MDU2NDMwfQ.SBtKCObtVoixxj4ee9wGKoXzKk2F_z5ThtoOY2a7bZg",
            "Cash" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/cash.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2Nhc2gucG5nIiwiaWF0IjoxNzQ1NTIwOTY2LCJleHAiOjE3NzcwNTY5NjZ9.7hanfTwqat1ejp56CL_-i-TJ0c2IPrlEfN0ySjPpeGw",
            "Investment" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/investment.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2ludmVzdG1lbnQucG5nIiwiaWF0IjoxNzQ1NTIxMTczLCJleHAiOjE3NzcwNTcxNzN9.hOsT04UIoQPErEa6bJORN7Wj_zqg4azmbtlqcJu4RRA",
            "Dining" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/cutlery.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2N1dGxlcnkucG5nIiwiaWF0IjoxNzQ1NTIxMDE0LCJleHAiOjE3NzcwNTcwMTR9.CwzAdCbwNQmdS7rx4GozZwhPxTOsDiQRccBYO23p-qU",
            "Education" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/scholarship.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL3NjaG9sYXJzaGlwLnBuZyIsImlhdCI6MTc0NTUyMTIxMiwiZXhwIjoxNzc3MDU3MjEyfQ.a_3fbX3q0q6gMlXqZzPlPfQFWu3pGF2tGjWqdyXy6rc",
            "Cosmetics" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/cosmetics.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2Nvc21ldGljcy5wbmciLCJpYXQiOjE3NDU1MjA5OTEsImV4cCI6MTc3NzA1Njk5MX0.uGQ7Rdm9cFaJgGghr_i2LXbW2G4ePMOgSCkfafdDmts",
            "Shopping" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/bag.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2JhZy5wbmciLCJpYXQiOjE3NDU1MjE1MDIsImV4cCI6MTc3NzA1NzUwMn0.8iFz-3tueoDl1GUnabG2M4MnmJGX6BylSiyH7Zq4wg8",
            "Alcohol" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/cocktail-glass.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2NvY2t0YWlsLWdsYXNzLnBuZyIsImlhdCI6MTc0NTUyMTU2MSwiZXhwIjoxNzc3MDU3NTYxfQ.-HWYdayn1ObTx22aRcgUDB2rxj9gwyFDR5IJWmVEvFg",
            "House" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/icons8-home-100.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2ljb25zOC1ob21lLTEwMC5wbmciLCJpYXQiOjE3NDU1MjEzODYsImV4cCI6MTc3NzA1NzM4Nn0.kPYqFMT2Foow9KDugXig0Vg1vI8DDWv7UfB9y6pbXuo",
            "Debit" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/debit-card.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2RlYml0LWNhcmQucG5nIiwiaWF0IjoxNzQ1NTIxMDU5LCJleHAiOjE3NzcwNTcwNTl9.-958p9w_QANzciWN67z_dFIxyu46YY20A-Mz3n7SiIk",
            "Savings" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/piggy-bank.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL3BpZ2d5LWJhbmsucG5nIiwiaWF0IjoxNzQ1NTIxNDY2LCJleHAiOjE3NzcwNTc0NjZ9.10sw-pGSECfI27SJD3myc_hlKVL0Cav_m5BZ0nTbGVA",
            "Hospital" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/heartbeat.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL2hlYXJ0YmVhdC5wbmciLCJpYXQiOjE3NDU1MjEzMjEsImV4cCI6MTc3NzA1NzMyMX0.WAurAWEFGWbKsB4qr9WcFvbGvIMyUF4gDyLA6X4SW90",
            "Entertainment" to "https://xoelotumrinspbbparpy.supabase.co/storage/v1/object/sign/storage-icons/Icons/theater.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InN0b3JhZ2UtdXJsLXNpZ25pbmcta2V5XzZhODRmMzJhLTBhMWEtNDMwNC05YzZlLWZiNDRjMmJmNzgxNCJ9.eyJ1cmwiOiJzdG9yYWdlLWljb25zL0ljb25zL3RoZWF0ZXIucG5nIiwiaWF0IjoxNzQ1NTIxMTMyLCJleHAiOjE3NzcwNTcxMzJ9.y-1RCDtpyrAlJUCdvQQGJtRWv8r3_iMOE3wdFiEWIWI"
        )

        val iconIdMap = mutableMapOf<String, Long>()

        for ((name, url) in icons) {
            val insertIconSQL = """
            INSERT INTO $TABLE_ICON ($COLUMN_ICONNAME, $COLUMN_ICONURL) 
            VALUES (?, ?)
        """.trimIndent()
            db.execSQL(insertIconSQL, arrayOf(name, url))
        }

        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Exercise', 'Expense', 1)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Crypto', 'Income', 2)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Vacation', 'Expense', 3)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Cash', 'Income', 4)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Investment', 'Income', 5)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Dining', 'Expense', 6)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Education', 'Expense', 7)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Cosmetics', 'Expense', 8)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Shopping', 'Expense', 9)")
        db?.execSQL("INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONIDFK) VALUES ('Drinks', 'Expense', 10)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ICON")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CATEGORY")
        onCreate(db)
    }

    // Insert icon
    fun insertIcon(iconName: String, iconUrl: String) {
        val db = writableDatabase
        val query = "INSERT INTO $TABLE_ICON ($COLUMN_ICONNAME, $COLUMN_ICONURL) VALUES (?, ?)"
        db.execSQL(query, arrayOf(iconName, iconUrl))
        db.close()
    }

    // Insert category
    fun insertCategory(categoryName: String, categoryType: String, iconID: Int) {
        val db = writableDatabase
        val query = "INSERT INTO $TABLE_CATEGORY ($COLUMN_CATEGORYNAME, $COLUMN_CATEGORYTYPE, $COLUMN_ICONID) VALUES (?, ?,?)"
        db.execSQL(query, arrayOf(categoryName, categoryType, iconID))
        db.close()
    }

    // Get all icons
    @SuppressLint("Range")
    fun getAllIcons(): List<Icon> {
        val db = readableDatabase
        val icons = mutableListOf<Icon>()
        val cursor = db.rawQuery("SELECT * FROM $TABLE_ICON", null)

        if (cursor.moveToFirst()) {
            do {
                val iconID = cursor.getInt(cursor.getColumnIndex(COLUMN_ICONID))
                val iconUrl = cursor.getString(cursor.getColumnIndex(COLUMN_ICONURL))
                icons.add(Icon(iconID,iconUrl))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return icons
    }


    // Get all categories
    @SuppressLint("Range")
    fun getAllCategories(): List<Category> {
        val db = readableDatabase
        val categories = mutableListOf<Category>()
        val cursor = db.rawQuery("SELECT * FROM $TABLE_CATEGORY " +
                "JOIN $TABLE_ICON on Category.IconID = ICON.IconID", null)

        if (cursor.moveToFirst()) {
            do {
                val categoryID = cursor.getInt(cursor.getColumnIndex(COLUMN_CATEGORYID))
                val categoryName = cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORYNAME))
                val categoryType = cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORYTYPE))
                val iconUrl = cursor.getString(cursor.getColumnIndex(COLUMN_ICONURL))
                categories.add(Category(categoryID, categoryName, categoryType, iconUrl))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return categories
    }

    // Get count of all icons
    fun getIconCount(): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT COUNT(*) FROM $TABLE_ICON", null)
        var count = 0

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0)
        }

        cursor.close()
        return count
    }

    // Get count of all categories
    fun getCategoriesCount(): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT COUNT(*) FROM $TABLE_CATEGORY", null)
        var count = 0

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0)
        }

        cursor.close()
        return count
    }


}