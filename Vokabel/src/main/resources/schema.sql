
create table vocab
(
    id int AUTO_INCREMENT,
    name varchar(30),
    category varchar(30),
    primary key (id)
);

create table translation
(
    id int AUTO_INCREMENT,
    name varchar(30),
    vocab_id int,
    primary key (id),
    constraint vocab
        foreign key (vocab_id) references vocab(id)
)
