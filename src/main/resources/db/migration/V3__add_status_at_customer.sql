alter table customers add column status varchar(100);

update customers set status = 'ATIVO';