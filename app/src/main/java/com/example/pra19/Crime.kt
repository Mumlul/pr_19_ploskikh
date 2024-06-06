package com.example.pra19

import java.util.Date
import java.util.UUID

class Crime() {
    var id: UUID=UUID.randomUUID()
    var date: Date? =null
    var status: Boolean? =null
    var title:String?=null

    constructor(_date:Date,_st:Boolean,_t:String) : this() {
        date=_date
        status=_st
        title=_t
    }

}