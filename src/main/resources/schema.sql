DROP TABLE IF EXISTS orders;
create table orders (
	id varchar(255) not null,
	also_includes varchar(255),
	code varchar(255),
	description varchar(255),
	excludes varchar(255),
	isic_reference varchar(255),
	items_includes varchar(255),
	level varchar(255),
	order_id varchar(255),
	parent varchar(255),
	rulings varchar(255),
	primary key (id));