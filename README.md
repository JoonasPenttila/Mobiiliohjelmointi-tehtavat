Kirjoita lyhyesti:

mitä Room tekee (Entity–DAO–Database–Repository–ViewModel–UI)
Room tallentaa datan pysyvästi.
Entity = tietomalli, DAO = kyselyt, Database = yhdistää DAO:t, Repository = välittää datan, ViewModel = hallitsee tilaa, UI = näyttää Flow-datan.


projektisi rakenne:
/data/model → Entity
/data/local → DAO + AppDatabase
/data/repository → Repository
/viewmodel → ViewModel
/ui → Compose-näkymät


miten datavirta kulkee:
UI → ViewModel → Repository → DAO → Room
Room → Flow → ViewModel → UI

linkki demovideoon:
https://youtu.be/5Dr3m7UWzTs