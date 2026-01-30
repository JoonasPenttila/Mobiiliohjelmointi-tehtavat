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