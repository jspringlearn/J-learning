alter table T_ADIMIN_GARAGE
	drop foreign key FKf2bb8fmjdlgy8d7nu7s7u1vjk;

alter table T_ADMIN_BOSS
	drop foreign key FKhyw9q0m3luis7wr09kjvlu4fu;

alter table T_ADMIN_CAR
	drop foreign key FKjqqo7giylaltyyvdph68rl85q;

alter table T_ADMIN_GROUP
	drop foreign key FKb2p0eo4g64vjc1nrnixmv2tdb;

alter table T_ADMIN_STAFF
	drop foreign key FKlb20decv705x9jar40hd3wujl;

alter table T_ADMIN_USER
	drop foreign key FK2q682guad28b1t6w3jg06ejyh;

alter table T_GOOODS
	drop foreign key FKf8fealk0fwui6vjf6rqcjtdib;

alter table T_STORE
	drop foreign key FKlpnap860d9plx695qa2l384xj;

drop table if exists hibernate_sequence;

drop table if exists T_ADIMIN_GARAGE;

drop table if exists T_ADMIN_BOSS;

drop table if exists T_ADMIN_CAR;

drop table if exists T_ADMIN_GROUP;

drop table if exists T_ADMIN_ROLE;

drop table if exists T_ADMIN_STAFF;

drop table if exists T_ADMIN_USER;

drop table if exists T_GOOODS;

drop table if exists T_STORE;

