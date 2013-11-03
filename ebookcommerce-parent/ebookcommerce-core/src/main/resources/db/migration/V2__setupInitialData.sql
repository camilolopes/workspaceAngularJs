INSERT INTO `category_ebook` (`id`, `description`) VALUES
(1, '.NET'),
(2, 'Agile'),
(3, 'Java'),
(4, 'JEE'),
(5, 'Mobile'),
(6, 'Ruby');


INSERT INTO `type_ebook` (`id`, `description`) VALUES
(1, 'Normal'),
(2, 'Promoção'),
(3, 'Grátis'),
(4, 'Lançamento');


INSERT INTO `ebook` (`id`, `status`, `title`, `summary_file`, `description`, `price`, `cover`, `year_publish`, `sale_url`, `ISBN`, `category_ebook_id`, `totalPage`, `editionNumber`) VALUES
(2, 'Active', 'iReport para Netbeans IDE', 'summary-sample.pdf', 'Desenvolvendo Relatórios Profissionais com iReport™ para NetBeans IDE é um livro que conduz o leitor na elaboração de relatórios, dos mais simples aos mais complexos, ensinando a trabalhar diretamente com o banco de dados, através do uso de instruções SQL, assim como também com consagrados programas de mapeamento objeto/relacional, como o Hibernate.', 10.00, 'capaireport.jpg', 2009, 'http://www.hotmart.com.br', ' 9788573938210', 2, 352, 1),
(3, 'Active', 'Guia do Exame SCJP', 'summary-sample.pdf', 'Este guia de bolso foi escrito com o objetivo de explicar de forma objetiva, através de códigos Java, os assuntos para a certificação SCJP. Não tem como objetivo ensinar a tecnologia Java e seus derivados.', 11.00, 'SCJP.JPG', 2010, 'http://www.hotmart.com.br', NULL, 3, 200, 1),
(4, 'Active', 'TDD na Prática', 'summary-sample.pdf', 'O livro vem com um objetivo simples: “Descomplicar o que parece ser complicado”. Em outras palavras, o objetivo é ensinar como praticar TDD usando a linguagem de programação Java.', 12.00, 'tdd.jpg', 2012, 'http:/www.hotmart.com.br', NULL, 2, 170, 1);

INSERT INTO `ebook_has_type_ebook` (`ebook_id`, `type_ebook_id`) VALUES
(2, 1),
(3, 1),
(4, 1),
(2, 2),
(4, 4);