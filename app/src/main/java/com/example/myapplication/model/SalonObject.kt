package com.example.myapplication.model

import com.example.myapplication.R

object SalonObject {
    val salons  = listOf(
        Salons(1, 1,R.drawable.salon,"Desert Spring","3.6","Rustem-pašina 23, II sprat, 71000 Sarajevo",
            listOf(
                Service(1, "Haircut", "20"),
                Service(2, "Manicure", "15"),
                Service(2, "Pedicure", "15")

            ) ),
        Salons(2,2,R.drawable.salon,"Orhideja","4.5","Rustem-pašina 23, II sprat, 71000 Sarajevo",
            listOf(
                Service(3, "Haircut", "22"),
                Service(4, "Pedicure", "18")
            )),
        Salons(3,3,R.drawable.salon,"Art","4.9","Rustem-pašina 23, II sprat, 71000 Sarajevo",
            listOf(
                Service(5, "Haircut", "25"),
                Service(6, "Facial", "30")
            )),
        Salons(4,4,R.drawable.salon,"Supreme Queen","5.0","Rustem-pašina 23, II sprat, 71000 Sarajevo",
            listOf(
                Service(7, "Haircut", "28"),
                Service(8, "Massage", "35")
            )),
        Salons(5,5,R.drawable.salon,"King","5.0","Rustem-pašina 23, II sprat, 71000 Sarajevo",
            listOf(
                Service(9, "Haircut", "30"),
                Service(10, "Shaving", "10")
            ))
    )
}