package fi.joonas.week1tasks.domain

import fi.joonas.week1tasks.model.Task
import java.time.LocalDate

val mockTasks = listOf(
    Task(1, "Siivoa keittiö", "Pyyhi tasot ja moppi", 2, LocalDate.now().plusDays(1), false),
    Task(2, "Kauppareissu", "Osta maitoa ja leipää", 1, LocalDate.now().plusDays(2), true),
    Task(3, "Koodaa tehtävä", "Viikkotehtävä 1 valmiiksi", 3, LocalDate.now().plusDays(3), false),
    Task(4, "Treenit", "Kuntosali klo 18", 2, LocalDate.now().plusDays(1), true),
    Task(5, "Soita mummolle", "Kysy kuulumiset", 1, LocalDate.now().plusDays(4), false),
    Task(6, "Lue kirjaa", "20 sivua ennen nukkumaanmenoa", 1, LocalDate.now().plusDays(5), false)
)
