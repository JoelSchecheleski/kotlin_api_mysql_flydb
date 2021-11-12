alter table customers add column password varchar(255);

# Atualiza os passwords
update customers set password = '$2a$10$lm6lPuZ.geyN2IBhs1aCBeIusMy1VY80To.KGFRT4VOYD31njYFTi';