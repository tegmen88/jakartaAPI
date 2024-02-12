
    create table t_book (
        year integer not null,
        id bigserial not null,
        user_id bigint,
        isbn uuid,
        author varchar(255),
        comment varchar(255),
        description varchar(255),
        genre varchar(255),
        title varchar(255),
        primary key (id)
    );

    create table t_comment (
        book_id bigint,
        id bigserial not null,
        user_id bigint,
        text varchar(255),
        primary key (id)
    );

    create table t_user (
        id bigserial not null,
        apiKey uuid,
        password varchar(255),
        userName varchar(255),
        primary key (id)
    );

    alter table if exists t_book 
       add constraint FKqo20ku8ut6rn3g6x0e8oeur30 
       foreign key (user_id) 
       references t_user;

    alter table if exists t_comment 
       add constraint FKo96wuai2oga7hdy2yqv11iv45 
       foreign key (book_id) 
       references t_book;

    alter table if exists t_comment 
       add constraint FKtamaoacctq4qpko6bvtv0ke1p 
       foreign key (user_id) 
       references t_user;
insert into t_user (apiKey, userName, password) values ('765a794f-6810-41fa-8a8c-edbcabebccd8', 'mmeldrum0', 'zU8&B0dQ');
insert into t_user (apiKey, userName, password) values ('7dde9fba-9105-422b-93ca-d34fb926423e', 'relmes1', 'hJ4iI<N?Ay');
insert into t_user (apiKey, userName, password) values ('5d1671f2-5174-4e72-b797-17090e6c4741', 'lmackessock2', 'zT3~0RQ<1eCG4');
insert into t_user (apiKey, userName, password) values ('e83bec68-5972-415b-bef4-70ebe78daae5', 'cdusting3', 'cJ8_HW$SRT');
insert into t_user (apiKey, userName, password) values ('de45e1fd-fcab-41f6-8f58-51d9df0f83a3', 'spresswell4', 'uM7!tJ!#&zGM');
insert into t_user (apiKey, userName, password) values ('7eef0099-db96-4840-ba65-8a2870151c7d', 'hdillestone5', 'cP3%?L2z0z3S7lF');
insert into t_user (apiKey, userName, password) values ('8e32ed2a-639f-4e71-87b2-a678e90d8b17', 'aminney6', 'wT6&hIx?');
insert into t_user (apiKey, userName, password) values ('46d69285-0ce9-459f-9f8b-fdf752c8b811', 'tgwilym7', 'yU2"!bHu');
insert into t_user (apiKey, userName, password) values ('ad391bf9-be6e-4a67-b9ae-260b0e0f8ab5', 'cjobbings8', 'wC8&v5n&w');
insert into t_user (apiKey, userName, password) values ('bdbb5449-1284-455c-aa6d-760f64882630', 'sgullberg9', 'nD6HSMJT_#G');
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Swen McDavitt', 'The Catcher in the Rye', '7be2fc25-56a1-4a26-9a29-8dd372ed2fe5', 'action', 'Consectetur adipiscing elit', 'Well done!', 1938);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Mayer Muslim', 'To Kill a Mockingbird', '9bf512d3-1c04-4479-a602-dfef57154a7c', 'romance', 'Sed do eiusmod tempor incididunt', 'Keep up the good work!', 1945);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Abie Colvine', '1984', '8e6a930c-2d41-496b-b85d-1988da862c16', 'comedy', 'Ut labore et dolore magna aliqua', 'Impressive!', 2019);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Christos Buckoke', 'The Catcher in the Rye', '73f782c2-4068-4b82-a7a2-7717956519d5', 'horror', 'Ut enim ad minim veniam', 'Well done!', 1958);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Nikki Abbitt', 'Pride and Prejudice', '45e85a0b-bbf1-42d9-b5bd-e0499ade8406', 'comedy', 'Ut enim ad minim veniam', 'Impressive!', 2010);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Lonnard Haldane', 'Pride and Prejudice', '2dabf1bf-5836-4e12-a93a-9bd314e71376', 'action', 'Lorem ipsum dolor sit amet', 'Nice job!', 2015);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Loni Fines', 'The Catcher in the Rye', '960de544-2a35-477f-a462-3990c738e2b2', 'romance', 'Ut enim ad minim veniam', 'Nice job!', 1961);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Kassey Beswetherick', 'Pride and Prejudice', '58322e77-085d-4aac-810f-02916096b0f7', 'action', 'Sed do eiusmod tempor incididunt', 'Well done!', 1959);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Willabella Moyes', '1984', '1eea8898-2c01-44e4-8dc8-c7790fe1cd2a', 'comedy', 'Consectetur adipiscing elit', 'Impressive!', 2019);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Paolina Vaugham', 'To Kill a Mockingbird', '0123ac20-dfac-4b5b-b7ef-602f1dd27b11', 'drama', 'Consectetur adipiscing elit', 'Nice job!', 2005);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Pen Renault', 'The Catcher in the Rye', '94ab9539-42c9-4e31-8de2-022e979c9435', 'drama', 'Ut labore et dolore magna aliqua', 'Well done!', 1918);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Claiborn Pietruschka', 'Pride and Prejudice', 'd56f2905-ea78-49ea-8385-64fac26fc708', 'drama', 'Ut enim ad minim veniam', 'Keep up the good work!', 1922);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Rosalind Durgan', '1984', 'eec9b5dc-11c2-480b-8e93-83ec1d933076', 'sci-fi', 'Sed do eiusmod tempor incididunt', 'Impressive!', 1994);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Kellen Paroni', 'The Great Gatsby', '64497d5e-86e0-46bf-ba19-7d2845c813d5', 'romance', 'Ut enim ad minim veniam', 'Impressive!', 1922);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Callida Dikelin', 'To Kill a Mockingbird', 'da555042-ce9b-46f7-8a49-6634e1b735a6', 'comedy', 'Ut labore et dolore magna aliqua', 'Nice job!', 1961);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Ruth Genny', 'To Kill a Mockingbird', '8ef1d929-3683-419f-8a98-bcd5531f8b38', 'action', 'Consectetur adipiscing elit', 'Nice job!', 1959);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Boycie Donne', 'The Catcher in the Rye', '120c5fbe-6614-4019-86e7-192d442a6d17', 'drama', 'Ut enim ad minim veniam', 'Keep up the good work!', 2001);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Franklyn Carabine', 'Pride and Prejudice', 'ae0afcbd-de94-4bb5-94d4-1b7c7f34032c', 'horror', 'Consectetur adipiscing elit', 'Well done!', 1909);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Issiah Gransden', 'The Great Gatsby', '3991c251-2e33-4a65-9bde-3c08e51c1ba1', 'comedy', 'Ut enim ad minim veniam', 'Keep up the good work!', 1951);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Nell Flewin', '1984', '61368f43-d35e-4b09-a958-1e776f6eb7bf', 'sci-fi', 'Ut labore et dolore magna aliqua', 'Well done!', 1928);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Alfy Tomaszewski', 'The Catcher in the Rye', '2af2d17c-13a7-40a8-b6a3-960448ede6f0', 'romance', 'Sed do eiusmod tempor incididunt', 'Keep up the good work!', 1995);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Juliet Geikie', 'To Kill a Mockingbird', '04862eb7-5e70-46b6-a920-5d424f6fb5a1', 'romance', 'Ut labore et dolore magna aliqua', 'Nice job!', 1960);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Kele Bach', '1984', 'b1fa7c20-b57b-46f5-8479-99b25c724529', 'thriller', 'Lorem ipsum dolor sit amet', 'Great comment!', 1907);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Phillipe Coal', 'To Kill a Mockingbird', 'd59be610-50a2-4741-8a82-d442fa1fa494', 'horror', 'Consectetur adipiscing elit', 'Well done!', 1924);
insert into t_book (author, title, isbn, genre, description, comment, year) values ('Ellswerth Riddick', 'The Great Gatsby', 'd059d4ef-8b9d-4953-ae5e-75c1b7ec4b95', 'romance', 'Ut labore et dolore magna aliqua', 'Impressive!', 1967);
