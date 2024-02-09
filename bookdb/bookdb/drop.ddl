
    alter table if exists t_book 
       drop constraint if exists FKqo20ku8ut6rn3g6x0e8oeur30;

    alter table if exists t_comment 
       drop constraint if exists FKo96wuai2oga7hdy2yqv11iv45;

    alter table if exists t_comment 
       drop constraint if exists FKtamaoacctq4qpko6bvtv0ke1p;

    drop table if exists t_book cascade;

    drop table if exists t_comment cascade;

    drop table if exists t_user cascade;
