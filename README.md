# jakartaAPI

Projektbeskrivning: 

Syftet med projektet är att i princip kunna kommentera böcker med hjälp av API-nyckel, 

I projektet framgår det att utveckla ett eget API med hjälp av olika entiteter som Book, Comment och User. Dessa entiteter ska ha Serviceklasser
och Resourceklasser med olika metoder för att skapa nya böcker, kommentarer och användare, hämta, ta bort och ändra befintliga data av kommentarer.

Att se användare och skapa användare kräver ingen authorization. För att kunna använda anropen I API-et så behövs API-nyckeln som genererades vid skapandet av användare. Lägg till "Authorization" som key och api-nyckel som value under "Headers" i Postman.

API-nycklar finns i import.sql som mockdata eller så går det även skapa en egen användare, och det kommer att generera en slumpad API-nyckel.

Använd gärna de angivna endpunkterna för att kunna hämta, lägga till, ta bort och ändra data med id.

I säkerhetsaspekten framgår en autentisering klass som grundar sig på att det är en utvald användare med specifik API-nyckel som får möjlighet att utöva metodförfrågningarna som GET, POST, DELETE och PATCH.

-----------------
BOOK:
GET: http://localhost:8080/api/book
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

GET: http://localhost:8080/api/book/{id}
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

GET: http://localhost:8080/api/book/count
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

POST: http://localhost:8080/api/book
Headers: Content-type - application/json
Body: {
    "title": "Mannen i gula byxor",
    "author": "Lars test",
    "isbn": "1237456-456",
    "description": "beskrivnign fgyuhijmkl,",
    "comment": "Kommenterf drfgyuhjiok fvygbuhjnmk",
    "genre": "trhriller",
    "year": 2024
}

ingen id, den genereras per automatik

DELETE:  http://localhost:8080/api/book/{id}
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e

PATCH: http://localhost:8080/api/book/{id}
Headers: Content-type - application/json
Body: {
    "title": "Mannen i gula byxor",
    "author": "Lars test",
    "isbn": "1237456-456",
    "description": "beskrivnign fgyuhijmkl,",
    "comment": "Kommenterf drfgyuhjiok fvygbuhjnmk",
    "genre": "KOMEDI",
    "year": 2024
}

-----------------
COMMENT
GET: http://localhost:8080/api/comment
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

GET: http://localhost:8080/api/comment/{id}
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

POST: http://localhost:8080/api/book
Headers: Content-type - application/json
         Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: { 
    "text": "This is not a great book 3!", 
    "book": { 
        "id": 9 },      
    "user": {
         "id": 4 
         }
}

Kommentaren får en egen genererad id.

DELETE: http://localhost:8080/api/comment/{id}
Headers: Content-type - application/json
         Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

PATCH: http://localhost:8080/api/book/{id}
Headers: Content-type - application/json
Body: Tomt

GET: http://localhost:8080/api/comment/book/{bookid}

-----------------

USER
GET: http://localhost:8080/api/user
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

GET: http://localhost:8080/api/user/{id}
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: Tomt

POST: http://localhost:8080/api/comment
Headers: Content-type - application/json
Body: {
    "userName": "test",
    "password": "123456"
}

DELETE: http://localhost:8080/api/user/{id}
Headers: Authorization - 7dde9fba-9105-422b-93ca-d34fb926423e
Body: {
    "userName": "nytest",
    "password": "ny123456"
}

(OBS! På alla get och post för user kräver ingen autentisering)