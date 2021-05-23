# DB Operations Backend Komponente

Hierbei handelt es sich um die Backend Spring Boot Komponente für die [DB Betriebsstelle Frontend Komponente](https://github.com/klaudialeo/DBOperations_React).

## API Endpunkte

Methode | Pfad | Beschreibung
-------|-----|-------------
GET|`/betriebsstelle`|Gib die Liste aller Abkürzungen der Betriebsstelle zurück
GET|`/betriebsstelle/{code}`|Gib den entsprechenden Namen, Kurznamen, und Typ der Betriebsstelle mit der Abkürzung `code` zurück
