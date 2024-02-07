
    create table t_book (
        year integer not null,
        id bigserial not null,
        isbn uuid,
        author varchar(255),
        comment varchar(255),
        description varchar(255),
        genre varchar(255),
        title varchar(255),
        primary key (id)
    );
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Great Gatsby', '666430989-0', 'sci-fi', 'Sed do eiusmod tempor incididunt', 'Well done!', 1954);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'The Great Gatsby', '159648072-6', 'romance', 'Consectetur adipiscing elit', 'Great comment!', 2010);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '023750785-4', 'drama', 'Ut enim ad minim veniam', 'Impressive!', 1933);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'Pride and Prejudice', '328864088-0', 'sci-fi', 'Ut enim ad minim veniam', 'Nice job!', 2010);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'Pride and Prejudice', '250774242-9', 'sci-fi', 'Consectetur adipiscing elit', 'Nice job!', 1914);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '310511052-6', 'comedy', 'Sed do eiusmod tempor incididunt', 'Impressive!', 1950);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'The Great Gatsby', '787596567-5', 'comedy', 'Ut enim ad minim veniam', 'Well done!', 1909);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Catcher in the Rye', '435642305-4', 'horror', 'Lorem ipsum dolor sit amet', 'Well done!', 2021);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'The Great Gatsby', '795670159-7', 'sci-fi', 'Consectetur adipiscing elit', 'Great comment!', 1927);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Great Gatsby', '872453538-9', 'drama', 'Consectetur adipiscing elit', 'Nice job!', 1965);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'To Kill a Mockingbird', '619856474-6', 'comedy', 'Ut enim ad minim veniam', 'Well done!', 2009);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'The Great Gatsby', '153726039-1', 'romance', 'Ut labore et dolore magna aliqua', 'Keep up the good work!', 1929);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '890827611-4', 'thriller', 'Ut enim ad minim veniam', 'Keep up the good work!', 1992);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'To Kill a Mockingbird', '603252984-3', 'horror', 'Ut enim ad minim veniam', 'Keep up the good work!', 1987);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', '1984', '590926967-4', 'horror', 'Lorem ipsum dolor sit amet', 'Well done!', 1942);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Great Gatsby', '524757613-6', 'horror', 'Ut enim ad minim veniam', 'Well done!', 1996);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', '1984', '908456116-3', 'drama', 'Lorem ipsum dolor sit amet', 'Nice job!', 1960);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'The Great Gatsby', '740636815-1', 'drama', 'Lorem ipsum dolor sit amet', 'Impressive!', 1900);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', '1984', '565627937-5', 'romance', 'Lorem ipsum dolor sit amet', 'Keep up the good work!', 1957);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'Pride and Prejudice', '518555387-1', 'drama', 'Sed do eiusmod tempor incididunt', 'Impressive!', 1993);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'The Catcher in the Rye', '718429594-3', 'thriller', 'Sed do eiusmod tempor incididunt', 'Keep up the good work!', 1940);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'Pride and Prejudice', '598430545-3', 'action', 'Ut labore et dolore magna aliqua', 'Nice job!', 2009);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '286095371-X', 'horror', 'Consectetur adipiscing elit', 'Well done!', 1978);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', '1984', '251267270-0', 'romance', 'Consectetur adipiscing elit', 'Keep up the good work!', 1964);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '547281887-7', 'sci-fi', 'Consectetur adipiscing elit', 'Great comment!', 1935);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'The Catcher in the Rye', '947975768-0', 'action', 'Consectetur adipiscing elit', 'Great comment!', 1937);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'The Catcher in the Rye', '045483804-2', 'thriller', 'Sed do eiusmod tempor incididunt', 'Well done!', 1960);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'The Great Gatsby', '095900512-9', 'thriller', 'Sed do eiusmod tempor incididunt', 'Well done!', 1992);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', '1984', '103045943-6', 'comedy', 'Ut labore et dolore magna aliqua', 'Well done!', 2021);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'The Catcher in the Rye', '385450217-6', 'drama', 'Sed do eiusmod tempor incididunt', 'Well done!', 1902);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Catcher in the Rye', '486666540-8', 'drama', 'Lorem ipsum dolor sit amet', 'Nice job!', 1996);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', '1984', '365845934-4', 'thriller', 'Consectetur adipiscing elit', 'Impressive!', 2023);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '150725099-1', 'action', 'Consectetur adipiscing elit', 'Well done!', 1998);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Great Gatsby', '716410798-X', 'sci-fi', 'Lorem ipsum dolor sit amet', 'Great comment!', 2013);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'The Great Gatsby', '090599075-7', 'horror', 'Sed do eiusmod tempor incididunt', 'Impressive!', 1985);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'To Kill a Mockingbird', '158140862-5', 'drama', 'Ut labore et dolore magna aliqua', 'Well done!', 1913);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'To Kill a Mockingbird', '883294516-9', 'sci-fi', 'Sed do eiusmod tempor incididunt', 'Nice job!', 1971);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', '1984', '343652570-7', 'thriller', 'Sed do eiusmod tempor incididunt', 'Keep up the good work!', 1915);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Sarah Davis', 'To Kill a Mockingbird', '248982959-9', 'thriller', 'Lorem ipsum dolor sit amet', 'Well done!', 1982);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'The Catcher in the Rye', '646484238-2', 'drama', 'Ut enim ad minim veniam', 'Keep up the good work!', 1963);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'The Great Gatsby', '044281899-8', 'action', 'Lorem ipsum dolor sit amet', 'Well done!', 1901);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('John Smith', 'Pride and Prejudice', '349422505-2', 'drama', 'Ut labore et dolore magna aliqua', 'Great comment!', 1965);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'The Catcher in the Rye', '524756173-2', 'drama', 'Consectetur adipiscing elit', 'Great comment!', 1926);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', '1984', '032476521-5', 'drama', 'Ut enim ad minim veniam', 'Impressive!', 1911);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'Pride and Prejudice', '967787804-2', 'comedy', 'Lorem ipsum dolor sit amet', 'Great comment!', 1911);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', '1984', '832941190-7', 'comedy', 'Ut enim ad minim veniam', 'Keep up the good work!', 1976);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'To Kill a Mockingbird', '293258939-3', 'romance', 'Sed do eiusmod tempor incididunt', 'Nice job!', 1915);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('David Wilson', 'Pride and Prejudice', '429304700-X', 'drama', 'Ut labore et dolore magna aliqua', 'Well done!', 1938);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Michael Brown', 'To Kill a Mockingbird', '947452184-0', 'sci-fi', 'Ut labore et dolore magna aliqua', 'Impressive!', 1950);
insert into t_book (author, title, isbn, genre, description, comments, year) values ('Emily Johnson', 'The Great Gatsby', '688856048-1', 'sci-fi', 'Sed do eiusmod tempor incididunt', 'Well done!', 1945);
