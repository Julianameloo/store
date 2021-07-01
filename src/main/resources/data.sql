insert into categorias(nome) values('eletronicos');
insert into categorias(nome) values('video-games');
insert into categorias(nome) values('eletrodomesticos');

insert into estoques(quantidade) values('20');
insert into produtos(nome, preco, categoria_id, estoque_id) values('TV', '2000',1,1);

insert into clientes(nome, sobrenome, genero) values('John', 'Doe','MASCULINO');
insert into clientes(nome, sobrenome, genero) values('Jane', 'Doe', 'FEMININO');