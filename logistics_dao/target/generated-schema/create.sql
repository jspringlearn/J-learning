create table hibernate_sequence (
	next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

create table T_ADMIN_BOSS (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	BOSS_AGE varchar(255),
	BOSS_NAME varchar(255),
	BOSS_NUM varchar(255),
	BOSS_SEX varchar(255),
	BOSS_TEL varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ADMIN_GROUP (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	NAME varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ADMIN_ROLE (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	NAME varchar(255),
	primary key (ID)
) engine=InnoDB;

create table T_ADMIN_STAFF (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	STAFF_AGE varchar(255),
	STAFF_NAME varchar(255),
	STAFF_NUM varchar(255),
	STAFF_SEX varchar(255),
	STAFF_TEL varchar(255),
	BOSS_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ADMIN_USER (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	EMAIL varchar(255),
	PASSWORD varchar(255),
	USERNAME varchar(255),
	GROUP_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_GOOODS (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	GOODS_NAME varchar(255),
	GOODS_NUMBER varchar(255),
	GOODS_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_STORE (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	NAME varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

alter table T_ADMIN_BOSS
	add constraint FKhyw9q0m3luis7wr09kjvlu4fu foreign key (PARENT_ID)
	references T_ADMIN_BOSS (ID);

alter table T_ADMIN_GROUP
	add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (PARENT_ID)
	references T_ADMIN_GROUP (ID);

alter table T_ADMIN_STAFF
	add constraint FKlb20decv705x9jar40hd3wujl foreign key (BOSS_ID)
	references T_ADMIN_BOSS (ID);

alter table T_ADMIN_USER
	add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (GROUP_ID)
	references T_ADMIN_GROUP (ID);

alter table T_GOOODS
	add constraint FKf8fealk0fwui6vjf6rqcjtdib foreign key (GOODS_ID)
	references T_STORE (ID);

alter table T_STORE
	add constraint FKlpnap860d9plx695qa2l384xj foreign key (PARENT_ID)
	references T_STORE (ID);

