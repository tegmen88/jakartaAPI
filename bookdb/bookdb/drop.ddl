
    alter table if exists Comment 
       drop constraint if exists FKtjtoe4kad7pxlw1ge8kv27jme;

    alter table if exists Comment 
       drop constraint if exists FK8ovt73g0cn7ayj7v7o7brmcg3;

    alter table if exists t_book 
       drop constraint if exists FKqo20ku8ut6rn3g6x0e8oeur30;

    drop table if exists Comment cascade;

    drop table if exists t_book cascade;

    drop table if exists t_user cascade;
