insert into categorias(nome) values('eletronicos');
insert into categorias(nome) values('video-games');
insert into categorias(nome) values('eletrodomesticos');

insert into estoques(quantidade) values('20');
insert into produtos(nome, preco, categoria_id, estoque_id) values('TV', '2000',1,1);

insert into clientes(nome, sobrenome, genero) values('John', 'Doe','MASCULINO');
insert into clientes(nome, sobrenome, genero) values('Jane', 'Doe', 'FEMININO');

insert into pedidos(data_pedido, preco, cliente_id) values('2019-08-07', 4000, 1);
insert into itens(preco_total, quantidade, produto_id, pedido_id) values (4000, 2, 1, 1);