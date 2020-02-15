CREATE TABLE users
(login text PRIMARY KEY,
first_name text not null,
last_name text not null,
city text not null,
email text not null,
is_admin boolean,
pass text not null);
