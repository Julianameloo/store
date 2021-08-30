insert into categorias(nome) values('eletronicos');
insert into categorias(nome) values('video-games');
insert into categorias(nome) values('eletrodomesticos');

insert into estoques(quantidade) values('20');
insert into produtos(nome, preco, categoria_id, estoque_id) values('TV', '2000',1,1);

insert into clientes(nome, sobrenome, genero, email, senha) values('John', 'Doe','MASCULINO', 'john@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
insert into clientes(nome, sobrenome, genero, email, senha) values('Jane', 'Doe', 'FEMININO', 'jane@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

insert into perfis(id, nome) values(1, 'ADM');
insert into perfis(id, nome) values(2, 'CLIENT');

insert into clientes_perfis(cliente_id, perfis_id) values (1,1);
insert into clientes_perfis(cliente_id, perfis_id) values (2,2);

insert into pedidos(data_pedido, preco, cliente_id) values('2019-08-07', 4000, 1);
insert into itens(preco_total, quantidade, produto_id, pedido_id) values (4000, 2, 1, 1);