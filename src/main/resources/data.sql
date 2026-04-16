-- 1. Inserindo as Categorias (IDs 1 a 4)
INSERT INTO tb_categoria (nome) VALUES 
('Premium'), ('Ouro'), ('Prata'), ('Básico');

-- 2. Inserindo os Produtos (IDs 1 a 8)
INSERT INTO tb_produto (nome, preco) VALUES
('Smartphone Galaxy S23', 4500.00),
('Notebook Dell Inspiron', 5200.00),
('Smart TV LG 55"', 3200.00),
('Fone de Ouvido Bluetooth', 250.00),
('Tablet iPad Air', 4100.00),
('Monitor Ultrawide 29"', 1200.00),
('Teclado Mecânico RGB', 350.00),
('Mouse Gamer Sem Fio', 180.00);

-- 3. Inserindo os Endereços (IDs 1 a 20)
INSERT INTO tb_endereco (endereco, cidade, estado, cep) VALUES
('Rua das Flores', 'São Paulo', 'SP', '01000-000'),
('Avenida Brasil', 'Rio de Janeiro', 'RJ', '20000-000'),
('Praça da Liberdade', 'Belo Horizonte', 'MG', '30000-000'),
('Rua das Acácias', 'Curitiba', 'PR', '80000-000'),
('Av. Afonso Pena', 'Porto Alegre', 'RS', '90000-000'),
('Rua do Sol', 'Salvador', 'BA', '40000-000'),
('Boa Viagem', 'Recife', 'PE', '50000-000'),
('Av. Beira Mar', 'Fortaleza', 'CE', '60000-000'),
('Ponta Negra', 'Manaus', 'AM', '69000-000'),
('Esplanada', 'Brasília', 'DF', '70000-000'),
('Rua Augusta', 'São Paulo', 'SP', '01305-000'),
('Copacabana', 'Rio de Janeiro', 'RJ', '22070-000'),
('Savassi', 'Belo Horizonte', 'MG', '30140-000'),
('Batel', 'Curitiba', 'PR', '80420-000'),
('Moinhos de Vento', 'Porto Alegre', 'RS', '90510-000'),
('Pelourinho', 'Salvador', 'BA', '40026-000'),
('Olinda', 'Recife', 'PE', '53000-000'),
('Meireles', 'Fortaleza', 'CE', '60160-000'),
('Centro', 'Manaus', 'AM', '69010-000'),
('Asa Sul', 'Brasília', 'DF', '70200-000');

-- 4. Inserindo os 20 Clientes (Conectando com Address e Category)
INSERT INTO tb_cliente (nome, cpf, salario, data_aniversario, num_filhos, fk_endereco, fk_categoria) VALUES
('João Silva', '123.456.789-01', 2500.00, '1985-05-15 00:00:00', 2, 1, 4),
('Maria Oliveira', '987.654.321-09', 8200.50, '1990-08-22 00:00:00', 1, 2, 1),
('Carlos Souza', '456.789.123-45', 1800.75, '1995-11-30 00:00:00', 0, 3, 4),
('Ana Pereira', '789.123.456-78', 6200.00, '1982-03-10 00:00:00', 3, 4, 2),
('Pedro Costa', '321.654.987-32', 2900.25, '1988-07-18 00:00:00', 1, 5, 3),
('Lucia Santos', '654.321.987-65', 3800.00, '1992-09-25 00:00:00', 2, 6, 3),
('Marcos Rocha', '147.258.369-14', 9100.50, '1980-12-05 00:00:00', 4, 7, 1),
('Fernanda Lima', '258.369.147-25', 2700.75, '1993-04-20 00:00:00', 0, 8, 4),
('Ricardo Alves', '369.147.258-36', 3500.00, '1987-06-12 00:00:00', 1, 9, 3),
('Juliana Castro', '951.753.852-96', 4300.25, '1991-02-28 00:00:00', 2, 10, 2),
('Roberto Dias', '159.753.486-22', 1500.00, '1998-01-15 00:00:00', 0, 11, 4),
('Camila Mendes', '753.159.486-33', 12500.00, '1984-05-10 00:00:00', 1, 12, 1),
('Felipe Barros', '852.963.741-44', 3100.00, '1990-10-22 00:00:00', 2, 13, 3),
('Patrícia Gomes', '963.852.741-55', 7800.00, '1979-11-05 00:00:00', 3, 14, 2),
('Eduardo Nunes', '123.987.456-66', 2200.00, '1996-02-18 00:00:00', 0, 15, 4),
('Sofia Martins', '321.789.654-77', 5400.00, '1989-07-30 00:00:00', 1, 16, 2),
('Thiago Silva', '456.123.789-88', 11200.00, '1981-04-12 00:00:00', 2, 17, 1),
('Larissa Moura', '789.456.123-99', 4100.00, '1994-09-08 00:00:00', 0, 18, 3),
('Bruno Moraes', '147.852.369-10', 2800.00, '1986-12-25 00:00:00', 1, 19, 4),
('Amanda Costa', '258.963.147-20', 6700.00, '1991-03-14 00:00:00', 2, 20, 2);

-- 5. Inserindo na tabela N:N (Muitos para Muitos - Produtos Favoritos)
-- Ex: Cliente 2 (Maria, rica) favoritou Notebook(2), Tablet(5) e Smartphone(1)
INSERT INTO tb_cliente_produto (cliente_id, produto_id) VALUES
(1, 4), (1, 8),
(2, 1), (2, 2), (2, 5),
(4, 3), (4, 4),
(7, 1), (7, 2), (7, 3), (7, 5),
(10, 6), (10, 7),
(12, 1), (12, 2), (12, 5),
(17, 3), (17, 6);