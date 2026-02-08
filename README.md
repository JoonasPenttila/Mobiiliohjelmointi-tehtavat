# Viikkotehtävä 1

Sovelluksessa käytetään Task-data classia (id, title, description, priority, dueDate, done).
Mock-data sisältää 6 tehtävää.

Kotlin-funktiot:
- addTask: lisää uuden tehtävän listaan
- toggleDone: vaihtaa tehtävän done-tilan
- filterByDone: suodattaa tehtävät tilan mukaan
- sortByDueDate: järjestää tehtävät eräpäivän mukaan

HomeScreen näyttää mock-listan ja napit käyttävät funktioita.


# Viikkotehtävä 2

Lista siirrettiin ViewModeliin (TaskViewModel), jossa sitä hallitaan mutableStateOf‑tilalla.
HomeScreen käyttää viewModel() ja UI päivittyy automaattisesti.

Uudet toiminnot ViewModelissa:
addTask, toggleDone, removeTask, filterByDone, sortByDueDate, clearFilter.

HomeScreen näyttää tehtävät LazyColumnissa ja sisältää Add‑kentän.
ViewModel on parempi kuin remember, koska tila säilyy rotaation yli.

# Viikkotehtävä 3

Tässä viikossa siirsin sovelluksen MVVM‑rakenteeseen ja otin StateFlowin käyttöön tilanhallintaan. Lisäksi tein uuden DetailDialogin, jossa käyttäjä voi muokata ja poistaa tehtäviä. Suurin näkyvä muutos käyttäjälle on siis tehtävän editointi dialogissa.

# Viikkotehtävä 4

Navigointi tarkoittaa eri näkymien välillä siirtymistä. Compose hoitaa tämän NavControllerin avulla.
NavController ohjaa, mihin ruutuun siirrytään.
NavHost listaa kaikki ruudut ja näyttää niistä kulloinkin aktiivisen.
Alavalikosta voi siirtyä Home ↔ Calendar ↔ Settings. Navigointi on toteutettu NavHostin sisällä, ja jokainen ruutu on oma composable.

Sovelluksessa on yksi yhteinen TaskViewModel, jota Home ja Calendar käyttävät.
ViewModelin StateFlow‑tila jaetaan molemmille ruuduille, joten muutokset näkyvät heti kaikkialla.

CalendarScreen ryhmittelee tehtävät dueDate‑arvon mukaan ja näyttää ne päivämääräotsikoiden alla.

AddTaskDialog lisää uuden tehtävän ViewModeliin.
EditTaskDialog avautuu tehtävää klikatessa ja mahdollistaa muokkauksen tai poistamisen.