# SAMPLE DB DDL

## DB
graphql_test

### User
```sql
create table graphql_test.user
(
id      varchar(255)                        not null
primary key,
age     int                                 not null,
email   varchar(255)                        not null,
name    varchar(255)                        not null,
updated timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
engine = InnoDB;
```
### Item
```sql
create table graphql_test.item
(
    id       bigint auto_increment
        primary key,
    name     varchar(50) not null,
    price    int         not null,
    category varchar(50) null
)
    engine = InnoDB;
```
### Order
```sql
create table graphql_test.item_order
(
    id               bigint auto_increment
        primary key,
    user_id          varchar(50)                        not null,
    item_id          bigint                             not null,
    amount           int                                not null,
    update_timestamp datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    engine = InnoDB;
```
